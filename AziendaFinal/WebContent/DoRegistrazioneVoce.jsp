<%@page import="rubrica.Voce"%>
<%@page import="rubrica.Rubrica"%>
<%@page import="servizi.Servizi"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:useBean id="utente" class="bean.UtenteBean" scope="session"></jsp:useBean>
<jsp:useBean id="message" class="util.MessageBean" scope="request"></jsp:useBean>

<%
	String nome = request.getParameter("nome");
	String cognome = request.getParameter("cognome");
	String telefono = request.getParameter("telefono");

	Servizi serv = new Servizi();

	String username = utente.getUsername();
	char ruolo = utente.getRuolo();
	Rubrica r = serv.trovaRubrica(username);
	Voce v = new Voce(nome, cognome, telefono);
	if (v.isValid()) {
		serv.aggiungiVoce(r, v);
		switch (ruolo) {

		case 'c':
			message.setMessage("Voce aggiunta alla tua rubrica!");
%>
<jsp:forward page="HomePageCliente.jsp" />
<%
	break;

		case 'd':
%>
message.setMessage("Voce aggiunta alla tua rubrica!");
<jsp:forward page="HomePageDipendente.jsp" />
<%
	break;

		}
	}
%>