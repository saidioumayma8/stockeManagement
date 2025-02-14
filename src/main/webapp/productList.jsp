<%@ page import="java.util.List" %>
<%@ page import="net.javaguides.productmanagement.model.product" %>
<%@ page import="net.javaguides.productmanagement.dao.ProductDAO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
    ProductDAO productDAO = new ProductDAO();
    List<product> products = productDAO.selectAllproduct();
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Product List</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<header>
     <nav class="navbar navbar-expand-md navbar-dark" style="background-color: danger">
         <div>
             <a href="https://www.javaguides.net" class="navbar-brand"> product Management App </a>
         </div>

         <ul class="navbar-nav">
             <li><a href="<%=request.getContextPath()%>/list" class="nav-link">Product</a></li>
         </ul>
     </nav>
 </header>
<div class="container mt-4">
    <h2 class="mb-3">Product List</h2>
    <table class="table table-bordered">
        <thead class="thead-dark">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Description</th>
                <th>Quantity</th>
                <th>Price</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <% for (product p : products) { %>
                <tr>
                    <td><%= p.getId() %></td>
                    <td><%= p.getNom() %></td>
                    <td><%= p.getDescription() %></td>
                    <td><%= p.getQuantite() %></td>
                    <td><%= p.getPrix() %></td>
                    <td>
                        <a href="edit.jsp?id=<%= p.getId() %>" class="btn btn-warning">Edit</a>
                        <a href="delete.jsp?id=<%= p.getId() %>" class="btn btn-danger" onclick="return confirm('Are you sure?')">Delete</a>
                    </td>
                </tr>
            <% } %>
        </tbody>
    </table>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>
</html>
