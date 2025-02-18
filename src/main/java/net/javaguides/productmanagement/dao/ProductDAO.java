package net.javaguides.productmanagement.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.javaguides.productmanagement.model.product;


public class ProductDAO {
	
	private String jdbcURL = "jdbc:mysql://localhost:3306/stockmaster";
    private String jdbcUsername = "root";
    private String jdbcPassword = "admin";

    private static final String INSERT_product_SQL = "INSERT INTO product" + "  (nom, description, quantite, prix) VALUES " +
        " (?, ?, ?, ?);";

    private static final String SELECT_product_BY_ID = "select id,nom,description,quantite, prix from product where id =?";
    private static final String SELECT_ALL_product = "select * from product";
    private static final String DELETE_product_SQL = "delete from product where id = ?;";
    private static final String UPDATE_product_SQL = "update product set nom = ?,description= ?, quantite =?, prix =? where id = ?;";

    private Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/stockmaster", "root", "admin");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }


    public void insertProduct(product product) throws SQLException {
        System.out.println(INSERT_product_SQL);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_product_SQL)) {
            preparedStatement.setString(1, product.getNom());
            preparedStatement.setString(2, product.getDescription());
            preparedStatement.setInt(3, product.getQuantite());
            preparedStatement.setDouble(4, product.getPrix());

            
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    public product selectUser(int id) {
        product product = null;
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_product_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                String nom = rs.getString("nom");
                String description = rs.getString("description");
                int quantite = rs.getInt("quantite");
                int prix = rs.getInt("prix");
                product = new product(id, nom, description, quantite, prix);
        
            }
        } catch (SQLException e) {
            printSQLException(e);
        }                                                                                   
        return product;
    }

    public List<product> selectAllproduct() {
        List<product> product = new ArrayList<>();
        String SELECT_ALL_SQL = "SELECT * FROM products";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_SQL);
             ResultSet rs = preparedStatement.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String nom = rs.getString("nom");
                String description = rs.getString("description");
                int quantite = rs.getInt("quantite");
                double prix = rs.getDouble("prix");

                product.add(new product(id, nom, description, quantite, prix));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }


    public boolean deleteProduct(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_product_SQL);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    public boolean updateProduct(product product) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_product_SQL);) {
            statement.setString(1, product.getNom());
            statement.setString(2, product.getDescription());
            statement.setDouble(3, product.getPrix());
            statement.setInt(4, product.getQuantite());
            statement.setInt(5, product.getId());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}