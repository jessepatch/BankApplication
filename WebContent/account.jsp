<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.user.Customer"%>
<%
	Customer customer = (Customer) session.getAttribute("customer");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Your Account</title>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<link rel="stylesheet" type="text/css" href="./Styles/styles.css">
</head>
<header><a class="header" href="index.jsp">
<img src="https://imgur.com/Kf5PM6H.png" alt="Dragon's Den Bank" height="36px" width="42px">
</a>
<a class="header" href="index.jsp">
<span class="header">Dragon's Den Bank</span>
</a>	
</header>
<body>
	<h1>Welcome to your online Dragon's Den banking Headquarters</h1>
	<h2>What would you like to do today?</h2>
	<h3>Your Balance</h3>
	<p class="account">
		<c:out value="${customer.checkingAccount.balance}" />
	</p>
	<h4>Make a Withdrawal</h4>
	<form class="account" action="WithdrawalServlet" method="post">
		<div class="form-group">
			<label for="amount">Amount $</label> <input type="number"
				class="form-control" id="withdrawalAmount" name="withdrawalAmount"
				placeholder="Withdrawal" step="0.01" min="0.00">
		</div>
		<input type="submit" value="Make a Withdrawal" name="withdawalAmount"
			id="withdrawalAmount">
	</form>
	<h4>Make a Deposit</h4>
	<form class="account" action="DepositServlet" method="post">
		<div class="form-group">
			<label for="amount">Amount $</label> <input type="number"
				class="form-control" id="depositAmount" name="depositAmount"
				placeholder="Deposit" step="0.01" min="0.00">
		</div>
		<input type="submit" value="Make a Deposit" name="depositAmount"
			id="depositAmount">
	</form>
	<h4>View your transaction history</h4>
	<form class="account" action="TransactionHistoryServlet"
		method="post">
		<input class="form-control" type="submit"
			value="View Entire Account History">
	</form>
	<form class="account" action="TransactionHistoryMonthServlet" method="post">
	<input class="form-control" type="submit" value="View this Month's Statement">
	</form>
	<p class="text">Or enter the number of your most recent transactions you would
		like to view</p>
	<form class="account" action="TransactionHistoryNServlet"
		method="post">
		<input class="form-control" type="number" name="numberTransactions"
			id="numberTransactions"> <input class="form-control"
			type="submit" value="View Recent Transactions">
	</form>
	<h4>Transfer Funds to Another Account</h4>
	<form class="account" action="FundsTransferServlet" method="post">
		<label for="transferEmail">Email Address of the Account to
			Transfer to</label> 
			<input class="form-control" type="email"
			name="transferEmail" id="transferEmail" required>
			<br> 
			<label for="transferAmount">Transfer Amount $</label> 
			<input class="form-control" type="number" name="transferAmount"
			id="transferAmount" step="0.01" required>
			<input class="form-control" type="submit" value="Transfer Funds">
	</form>
	<h4>Order Checks</h4>
	<form class="account" action="OrderChecksServlet" method="post">
		<input class="form-control" type="submit"
			value="Order Additional Checks">
	</form>
	<c:if test="${orderedChecksRecently}">
		<p class="text">Your checks have been ordered and should arrive in 5 to 8
			business days</p>
	</c:if>
	<h4>Close your Account</h4>
	<div class="form-control">
		<form class="account" action="CloseAccountServlet" method="post">
			<input class="form-control" type="submit" value="Close Account">
		</form>
	</div>
	<form class="account" action="LogOutServlet" method="post">
		<input type="submit" value="Log Out">
	</form>
</body>
</html>