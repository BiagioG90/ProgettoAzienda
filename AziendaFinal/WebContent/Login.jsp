<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<jsp:useBean id="message" class="util.MessageBean" scope="request"></jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="Stylesheet" type="text/css" href="css/stat.css">

<title>Login Page</title>
</head>
<body>

	<div id="Container">

		<div id="header">
			<h1>Login page</h1>

		</div>


		<div class="menu"></div>
		<div id="content">
			<h1>Login page</h1>

			<%=message.getMessage()%>

			<form action="DoLogin.jsp" method="post">
				Username: <input type="text" name="username" /> <br> Password:
				<input type="password" name="password" /> <br> <input
					type="submit" value="Login" />

			</form>
		</div>
		<div id="footer"></div>


	</div>
	<!--  end of container -->
</body>
</html>