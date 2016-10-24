package dao;

import java.util.ArrayList;
import java.util.List;
import util.HibernateUtil;
import bean.ClienteBean;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ClienteDao {
	
	public boolean creaCliente(ClienteBean c){
		
		boolean res = false;
		
		Session session =HibernateUtil.openSession();
		Transaction tx=null;

		try{
		tx=session.getTransaction();
		tx.begin();
		
		session.persist(c);
		
		 res = true;
		 tx.commit();
		}catch(Exception ex){
			tx.rollback();
		}finally{
			session.close();
		}
		
		return res;	
	}

	public List<ClienteBean> getTuttiClienti() {
		List<ClienteBean> elencoClienti= new ArrayList<ClienteBean>();
		Session session =HibernateUtil.openSession();
		Transaction tx=null;

		try{
		tx=session.getTransaction();
		tx.begin();
		
		Query query=session.createQuery("from ClienteBean");
		elencoClienti=query.list();
		
		 tx.commit();
		}catch(Exception ex){
			tx.rollback();
		}finally{
			session.close();
		}
		return elencoClienti;
	}
}