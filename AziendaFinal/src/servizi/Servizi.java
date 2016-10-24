package servizi;

import java.util.List;
import rubrica.Rubrica;
import rubrica.Voce;
import bean.ClienteBean;
import bean.DipendenteBean;
import bean.UtenteBean;
import dao.ClienteDao;
import dao.DipendenteDao;
import dao.RubricaDao;
import dao.UtenteDao;
import dao.VoceDao;
import util.CodificaPassword;;

public class Servizi {

	UtenteDao utenteDao=new UtenteDao();
	ClienteDao clienteDao=new ClienteDao();
	DipendenteDao dipendenteDao=new DipendenteDao();
	RubricaDao rubricaDao= new RubricaDao();
	VoceDao voceDao= new VoceDao();

	// 1a registrazione utenti
	public boolean registraUtente(UtenteBean u) {
		
		boolean res = false;
		
		res = utenteDao.creaUtente(u);

		return res;
	}

	// 1b registrazione Clienti
	public boolean registraCliente(ClienteBean c) {
		
		boolean res = false;
		res = clienteDao.creaCliente(c);

		return res;
	}

	// 1c registrazione Dipendenti
	public boolean registraDipendente(DipendenteBean d) {
		
		boolean res = false;
		res = dipendenteDao.creaDipendente(d);

		return res;
	}

	//2a recupera elenco clienti
	public List<ClienteBean> getClienti(){
		
		return clienteDao.getTuttiClienti();
	}
	
	
	//2b recupera elenco dipendenti
	public List<DipendenteBean> getDipendenti(){
		
		return dipendenteDao.getTuttiDipendenti();
	}
	
	//3 trova utente con username
	public UtenteBean getUtente(String username) {
		
		UtenteBean utenteBean =utenteDao.trovaUtenteConUsername(username);
		return utenteBean;
	}
	
	//4 verifica esistenza username
	public boolean cercaUsername(String username) {
		
		boolean res = false;
		
		UtenteBean utenteBean =utenteDao.trovaUtenteConUsername(username);
		if(utenteBean!=null) 
		{
			res = true;
		}
		return res;
	}
	
	// 5 crea rubrica
	public boolean creaRubrica(String username){
		
		Rubrica rubrica= new Rubrica(username);
		boolean res = rubricaDao.creaRubrica(rubrica);
		return res;
	}
	
	// 6 aggiungi voce in rubrica
	public boolean aggiungiVoce(Rubrica rubrica,Voce voce) {
		
		boolean res = false;
		voce.setRubrica(rubrica);
		rubrica.addVoce(voce);
		
		boolean res1 = voceDao.aggiungiVoce(voce);
		rubricaDao.modificaRubrica(rubrica);

		if(res1==true)
		{
			res =true;
		}

		return res;
}

	//7 trova rubrica utente con username
	public Rubrica trovaRubrica(String username) {

		Rubrica rubrica = rubricaDao.trovaRubricaConNome(username);

		return rubrica;
	}

	//8 trova elenco voci
	public List<Voce> getVoci(Rubrica rubrica) {
		List<Voce> elencoVoci = voceDao.getVociRubrica(rubrica);

		return elencoVoci;
	}


	//9 elimina voce
	public boolean eliminaVoce(Rubrica rubrica, String nome, String cognome){
		
		Voce voce = voceDao.trovaVoce(nome, cognome, rubrica.getId_Rubrica());
		
		boolean res = voceDao.eliminaVoce(voce);
		
		return res;
	}
	
	//  10 codifica password
		public String codificaPassword(String pass){

			return CodificaPassword.codificaPassword(pass);	
		}
		
	// 11 elimina utente
		public boolean eliminaUtente(UtenteBean utenteBean) {
			if(utenteBean.getRuolo()=='a')
			{
				return false;
			}
			else {
				Rubrica rubrica = rubricaDao.trovaRubricaConNome(utenteBean.getUsername());
				if(rubrica!=null) {
				rubricaDao.eliminaRubrica(rubrica);
				}
				return utenteDao.eliminaUtente(utenteBean);
			}
		}
}