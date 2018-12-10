<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Account History</title>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<link rel="stylesheet" type="text/css" href="./Styles/styles.css">
</head>
<header><a class="header" href="index.jsp">
<img src="C:\Users\Jesse\Pictures\Saved Pictures\DragonsDenLogo.png" alt="Dragon's Den Bank" height="36px" width="42px">
</a>
<a class="header" href="index.jsp">
<span class="header">Dragon's Den Bank</span>
</a>	
</header>
<body>
	<h1>Account Transaction History</h1>
	<c:if test="${recentTransactions != null}">
		<table class="table table-striped">
			<tr>
				<th>Date</th>
				<th>Amount</th>
			</tr>
			<c:forEach var="transaction" items="${recentTransactions}">
				<tr>
					<td><c:out value="${transaction.date}" /></td>
					<td><c:out value="${transaction.amount}" /></td>
					<td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	<a href="account.jsp">Return to Account page</a>
</body>
</html>