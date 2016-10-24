<%@page import="bean.DipendenteBean"%>
<%@page import="servizi.Servizi"%>
<%@page import="util.IsValid"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<jsp:useBean id="utente" class="bean.UtenteBean" scope="session"></jsp:useBean>
<jsp:useBean id="dipendente" class="bean.DipendenteBean" scope="request"></jsp:useBean>
<jsp:setProperty property="*" name="dipendente" />
<jsp:useBean id="message" class="util.MessageBean" scope="request"></jsp:useBean>

<%
	dipendente.setRuolo('d');
	Servizi serv = new Servizi();

	if (dipendente.isValid()
			&& !serv.cercaUsername(dipendente.getUsername())) {
		String password = serv.codificaPassword(dipendente
				.getPassword());
		dipendente.setPassword(password);
		serv.registraDipendente(dipendente);
		serv.creaRubrica(dipendente.getUsername());
		message.setMessage("Dipendente registrato!");
%>
<jsp:forward page="HomePageAdmin.jsp" />
<%
	} else {
		message.setMessage("dati non validi");
%>
<jsp:forward page="RegistrazioneNuovoDipendente.jsp" />
<%
	}
%>