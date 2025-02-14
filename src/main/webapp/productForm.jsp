<%@ page import="java.util.List" %>
<%@ page import="net.javaguides.productmanagement.model.product" %>
<%@ page import="net.javaguides.productmanagement.dao.ProductDAO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
    <h2>Add New Product</h2>
    <form action="ProductServlet" method="post">
        <div class="mb-3">
            <label for="name" class="form-label">Product Name</label>
            <input type="text" class="form-control" id="name" name="nom" required>
        </div>
        <div class="mb-3">
            <label for="description" class="form-label">Description</label>
            <textarea class="form-control" id="description" name="description" rows="3" required></textarea>
        </div>
        <div class="mb-3">
            <label for="qualiet" class="form-label">qualite</label>
            <textarea class="form-control" id="description" name="description" rows="3" required></textarea>
        </div>
        
        <button type="submit" class="btn btn-primary">Add Product</button>
    </form>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>
</html>