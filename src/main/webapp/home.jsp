<%@ page isELIgnored="false" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Servlet, JSP Operations Session</title>

<style type="text/css">
	body{
		text-align: center;
	}
	table {
		margin-left: 15%;
		min-width: 70%; 
		border: 1px solid #CCC;
		border-collapse: collapse; 
	}
	table tr{line-height: 30px;}
	table tr th { background: #000033; color: #FFF;}
	table tr td { border:1px solid #CCC; margin: 5px;}
	input[type=text], input[type=email], input[type=tel]{
		min-width: 60%;
	}
	input[type=submit], a{
		background: green;
		padding: 5px;
		margin: 5px;
		color: #FFF;
	}
	a{
		text-decoration: none;
	}
</style>
</head>
<body>
	<h1>Servlet, JSP CRUD Operations Session</h1>
	<c:url value="/customer/register" var="registerUrl" />
	<form action="${registerUrl}" method="post">
		<table>
			<tr>
				<td>First Name:</td>
				<td><input type="text" name="firstName" value="${customer.firstName}" required></td>
			</tr>
			<tr>
				<td>Last Name:</td>
				<td><input type="text" name="lastName" value="${customer.lastName}" required></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><input type="email" name="email" value="${customer.email}" required></td>
			</tr>
			<tr>
				<td>Introduce:</td>
				<td><input type="text"  name="intro" value="${customer.intro}" required></td>
			</tr>
			<tr>
				<td>Gender:</td>
				<td> <input type="radio" name="gender" value ="M"> Male
                <input type="radio" name="gender" value="F"> Female</td>
             </tr>
			<tr>
				<td>Hobby:</td>
				
				<td><select name="hobby" multiple name="hobby" value="${customer.hobby}">
					  <option value="mua">Mua</option>
					  <option value="ve">Ve</option>
					  <option value="hat">Hat</option>
					  <option value="nhay">Nhay</option>
					</select>
				</td>
			</tr>

			<c:if test="${customer.id ne null}">
				<tr>
					<td colspan="2"><input type="submit" value="Update"></td>
				</tr>
			</c:if>
			<c:if test="${customer.id eq null}">
				<tr>
					<td colspan="2"><input type="submit" value="Save"></td>
				</tr>
			</c:if>
		</table>
	</form>
	<br>
	<h1>List of Customers</h1>
	<table>
		<tr>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Email</th>
			<th>Introduce</th>
			<th>Gender</th>
			<th>Hobby</th>
			<th>Update</th>
			<th>Delete</th>
		</tr>
		<c:forEach items="${customerList}" var="customer">
			<tr>
				<td>${customer.firstName}</td>
				<td>${customer.lastName}</td>
				<td>${customer.email}</td>
				<td>${customer.intro}</td>
				<td>${customer.gender}</td>
				<td>
				<c:forEach items="${customer.hobby}" var="ho">
					${ho} <br>
				</c:forEach>
				</td>
				
				<td>
					<form action="<c:url value="/customer/update"/>" method="post">
						<input type="hidden" name="custId" value="${customer.id}">
						<input type="submit" value="Update">
					</form>
				<td>
					<form action="<c:url value="/customer/delete"/>" method="post">
						<input type="hidden" name="custId" value="${customer.id}">
						<input style="background: #F00;" type="submit" value="Delete">
					</form>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>