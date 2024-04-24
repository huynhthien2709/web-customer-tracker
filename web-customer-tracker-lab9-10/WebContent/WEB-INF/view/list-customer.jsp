<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List Customer</title>
	<link type="text/css" rel="stylesheet"
		   href="${pageContext.request.contextPath}/resources/css/style.css"/>
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>

	<div id="container">
		<div id="content">
			<div class="col-12">
			<!-- Lab 10.1 --> 
			<input type="button" value="Add Customer"
					onclick="window.location.href='showFormForAdd'; return false;" 
					class="add-button"
			/>
			<br></br>

				<table class="table">
					<tr>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Email</th>
					</tr>

					<!-- lab 9.8 -->
					<c:forEach var="tempCustomer" items="${customers}">
						<tr>
							<td>${tempCustomer.firstName}</td>
							<td>${tempCustomer.lastName}</td>
							<td>${tempCustomer.email}</td>
						</tr>

					</c:forEach>
				</table>
			</div>
		</div>
	</div>



</body>
</html>