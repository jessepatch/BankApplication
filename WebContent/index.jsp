<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dragon's Den Bank</title>
<link rel="stylesheet" type="text/css" href=".\Styles\styles.css">
</head>
<header><a class="header" href="index.jsp">
<img src="https://imgur.com/Kf5PM6H.png" alt="Dragon's Den Bank" height="36px" width="42px">
</a>
<a class="header" href="index.jsp">
<span class="header">Dragon's Den Bank</span>
</a>	
</header>
<body>
	<div class="welcome">
		<h1>Welcome to Dragon's Den Bank</h1>
		<p class="welcome">Returning user? Please sign in</p>
		<form class="form-control" action="SigninServlet" method="post">
			<label for="email">Email Address</label> 
			<input type="email"
				class="signin" name="signinEmail" id="signinEmail"
				placeholder="Email" required autofocus> <br>
			<label for="password">Password</label> 
			<input type="password"
				class="signin" name="signinPassword" id="signinPassword"
				placeholder="Password" required> <br> 
				<input
				type="submit" class="signin" id="signinButton" value="Sign In">
		</form>


		<h2>Or start banking the right way today by creating a new
			account!</h2>
		<div class="signup">
			<a class="welcome" href="signup.jsp">Sign Up</a>
		</div>
	</div>

</body>
</html>