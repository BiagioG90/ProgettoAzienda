<%@page import="bean.ClienteBean"%>
<%@page import="servizi.Servizi"%>
<%@page import="util.IsValid"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<jsp:useBean id="utente" class="bean.UtenteBean" scope="session"></jsp:useBean>
<jsp:useBean id="cliente" class="bean.ClienteBean" scope="request"></jsp:useBean>
<jsp:setProperty property="*" name="cliente" />
<jsp:useBean id="message" class="util.MessageBean" scope="request"></jsp:useBean>

<%
	cliente.setRuolo('c');
	Servizi serv = new Servizi();

	if (cliente.isValid() && !serv.cercaUsername(cliente.getUsername())) {
		String password = serv.codificaPassword(cliente.getPassword());
		cliente.setPassword(password);
		serv.registraCliente(cliente);
		serv.creaRubrica(cliente.getUsername());
		message.setMessage("Cliente registrato!");
%>
<jsp:forward page="HomePageAdmin.jsp" />
<%
	} else {
		message.setMessage("dati non validi");
%>
<jsp:forward page="RegistrazioneNuovoCliente.jsp" />
<%
	}
%>