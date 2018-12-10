<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign Up</title>
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
<h1>Please fill out the information below to begin your banking profile:</h1>
<form class="signupForm" action="RegistrationServlet" method="post">
<p class="signup">
    <label class="signinLabel" for="firstName">First Name</label>
    <input type="text" class="signupInput" name="firstName" id="firstName" placeholder="First Name">
  </p>
  <p class="signup">
    <label class="signinLabel" for="lastName">Last Name</label>
    <input type="text" class="signupInput" name="lastName" id="lastName" placeholder="Last Name">
  </p>
  <p class="signup">
    <label class="signinLabel" for="email">Email address</label>
    <input type="text" class="signupInput" name="email" id="exampleInputEmail1" placeholder="Email">
  </p>
  <p class="signup">
    <label class="signinLabel" for="password">Password</label>
    <input type="password" class="signupInput" name="password" id="password" placeholder="Password">
  </p>
    <p class="signup">
    <label class="signinLabel" for="password">Re-type Password</label>
    <input type="password" class="signupInput" name="password2" id="password2" placeholder="Re-type Password">
  </p>
   <p class="signup">
    <label class="signinLabel" for="street">Street</label>
    <input type="text" class="signupInput" name="street" id="street" placeholder="Street">
  </p>
   <p class="signup">
    <label class="signinLabel" for="city">City</label>
    <input type="text" class="signupInput" name="city" id="city" placeholder="City">
  </p>
   <p class="signup">
    <label class="signinLabel" for="state">State</label>
    <input type="text" class="signupInput" name="state" id="state" placeholder="State">
  </p>
 <p class="signup">
    <label class="signinLabel" for="zipCode">Zipcode</label>
    <input type="text" class="signupInput" name="zipcode" id="zipcode" placeholder="ZIP Code">
  </p>
  <p class="signup">
  <label class="signinLabel" for="initialDeposit">Initial Deposit</label>
  <input type="number" class="signupInput" name="initialDeposit" id="initialDeposit" placeholder="Initial Deposit" step="0.01">
  </p>
  <button type="submit" class="btn signup">Create Account</button>
</form>
</body>
</html>