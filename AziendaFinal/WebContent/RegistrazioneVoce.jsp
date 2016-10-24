<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
            <%@ taglib prefix="c" 
uri="http://java.sun.com/jsp/jstl/core" %>
    
<jsp:useBean id="utente" class="bean.UtenteBean"
	scope="session"></jsp:useBean>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <link rel="Stylesheet" type="text/css" href="css/stat.css">

<title>Insert title here</title>
</head>
<body>

<div id="Container">
  
  <div id="header">

<h1>
  <c:out value="${utente.nome}"/>
  <c:out value="${utente.cognome}"/>
</h1>
  
  </div>
  
  <div  class="menu">
 
  <jsp:include page="MenuLateraleCliente.jsp"></jsp:include>
  
  </div>
    <div id="content">
<h1>Registra voce in rubrica</h1>

<form action="DoRegistrazioneVoce.jsp" method="post">
Nome: <input type="text" name="nome" /> <br>
Cognome: <input type="text" name="cognome"/> <br>
Telefono: <input type="text" name="telefono"/> <br>

<input type="submit" value ="Registra"/>

</form>
 </div>
    <div id="footer">
 <h1>Footer</h1>
 
  </div>
  
  
  </div> <!--  end of container -->
</body>
</html>
