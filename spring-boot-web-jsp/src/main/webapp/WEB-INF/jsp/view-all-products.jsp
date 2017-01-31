<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
body {
	margin: 70px;
}
</style>
<body>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
		<%@ include file="header.jsp"%>
	<a href="/add-product"> Add Product</a>
	<a href="/view-all-products"> View all products</a>
	<table class="table table-striped">>
  		<thead class="thead-inverse">

			<th>Product name</th>
			<th>Category</th>
			<th>Description</th>
			<th>Price</th>
			<th>Quantity</th>
	
		</thead>
		<c:forEach var="p" items="${pList}">
			<tr>
				<td>${p.productName}</td>
				<td>${p.category}</td>
				<td>${p.description}</td>
				<td>${p.price}</td>
				<td>${p.quantity}</td>
				<td><a class="btn btn-primary" role="button"
					href="update-product/<c:out value="${p.productId}"/>">Update</a></td>
				<td><a class="btn btn-primary"
					id="delete-product/${p.productId}" role="button"
					href="delete-product/<c:out value="${p.productId}"/>">Delete</a></td>
				

			</tr>
		</c:forEach>
	</table>
		<%@ include file="footer.jsp"%>
</body>
</html>