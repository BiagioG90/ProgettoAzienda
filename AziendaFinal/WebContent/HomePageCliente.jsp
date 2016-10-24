<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib prefix="c" 
uri="http://java.sun.com/jsp/jstl/core" %>
    
<jsp:useBean id="utente" class="bean.UtenteBean"
	scope="session"></jsp:useBean>
<jsp:useBean id="message" class="util.MessageBean" scope="request"></jsp:useBean>    
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
<h2>Home page Cliente</h2>
<h1>
  <c:out value="${utente.nome}"/>
  <c:out value="${utente.cognome}"/>
</h1>
  
  </div>
  
  
    <div  class="menu">
 
  <jsp:include page="MenuLateraleCliente.jsp"></jsp:include>
  
  </div>
    <div id="content">
   <h1>Benvenuto
   <%=utente.getNome() %> !
   </h1>
      <%=message.getMessage()%>
  </div>
    <div id="footer">
 <h1>Footer</h1>
 
  </div>
  
  
  </div> <!--  end of container -->
</body>
</html>