<%@page import="bean.UtenteBean"%>
<%@page import="servizi.Servizi"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <jsp:setProperty property="*" name="dipendente"/>
    
        <jsp:useBean id="utente" class="bean.UtenteBean"
	scope="session"></jsp:useBean>
	 <jsp:useBean id="message" class="util.MessageBean" scope="request"></jsp:useBean>

	 <%
	 
	 Servizi s = new Servizi();
	 String username = request.getParameter("username");
	 String nome = request.getParameter("nome");
	 String cognome = request.getParameter("cognome");
	 String password = request.getParameter("password");
	 password = s.codificaPassword(password);
	 
	 UtenteBean utenteBean= s.getUtente(username);
	 
	 if(utenteBean!=null && utenteBean.getNome()==nome && utenteBean.getCognome()==cognome && utenteBean.getPassword()==password) {
		boolean res =s.eliminaUtente(utenteBean);
		if(res==true)
		{
			message.setMessage("Utente eliminato");
	        %>
	    	<jsp:forward page="HomePageAdmin.jsp"/>
	    <%
		}
		else
		{
			message.setMessage("Impossibile eliminare questo utente");
	        %>
	    	<jsp:forward page="EliminaUtente.jsp"/>
	    <%
		}
	 }
	 else {
		 message.setMessage("Dati non corretti");
	        %>
	    	<jsp:forward page="EliminaUtente.jsp"/>
	    <%
	 }
	 
	 
	 %>