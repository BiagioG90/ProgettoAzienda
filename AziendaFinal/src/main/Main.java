package main;

import servizi.Servizi;
import bean.AdminBean;
import dao.AdminDao;

public class Main {

	public static void main(String[] args) {
		
		Servizi serv = new Servizi();
		AdminDao adminDao = new AdminDao();
		AdminBean adminBean = new AdminBean("Biagio", "Gallucci", "TrafalgarLaw", "marchisio90", 'a', "amministratore");
		adminBean.setPassword(serv.codificaPassword("marchisio90"));
		
		adminDao.creaAdmin(adminBean);

	}

}
