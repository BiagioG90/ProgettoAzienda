<%@page import="util.MessageBean"%>
<%@page import="bean.UtenteBean"%>
<%@page import="servizi.Servizi"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<jsp:useBean id="utente" class="bean.UtenteBean"
	scope="session"></jsp:useBean>
<jsp:useBean id="message" class="util.MessageBean" scope="request"></jsp:useBean>

<jsp:setProperty property="*" name="utente" />

<%
    Servizi s= new Servizi();
    
	String username = request.getParameter("username");
    UtenteBean uBean = s.getUtente(username);
    String password = request.getParameter("password");
    
    password = s.codificaPassword(password);
    
    if(uBean!=null && uBean.getPassword().equals(password))
    {
    	char ruolo= uBean.getRuolo();
    	utente.setNome(uBean.getNome());
    	utente.setCognome(uBean.getCognome());
    	utente.setRuolo(ruolo);
    		
    		switch(ruolo) {
 				
    		case 'a' :   
    			%>
			<jsp:forward page="HomePageAdmin.jsp" />
			<%
			break;
    		case 'c' :
    	
    	    	%>
    		<jsp:forward page="HomePageCliente.jsp" />
    		<%
    		break;
    		
    		case 'd' :
    	    	%>
    		<jsp:forward page="HomePageDipendente.jsp" />
    		<%
    		break;
    		}
    }
    else{
    	message.setMessage("Username o password non corretti");
    			%>
			<jsp:forward page="Login.jsp" />
			<%
    }
    
    %>