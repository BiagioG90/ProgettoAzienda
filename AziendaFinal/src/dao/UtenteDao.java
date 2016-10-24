package dao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;
import bean.UtenteBean;

public class UtenteDao {
	
	public boolean creaUtente(UtenteBean u){
		
		boolean res = false;
		
		Session session =HibernateUtil.openSession();
		Transaction tx=null;

		try{
		tx=session.getTransaction();
		tx.begin();
		
		session.persist(u);
		
		 res = true;
		 tx.commit();
		}catch(Exception ex){
			tx.rollback();
		}finally{
			session.close();
		}
		
		return res;	
	}
	
	public UtenteBean trovaUtenteConUsername(String username) {
		
		UtenteBean utenteBean = null;
		Session session =HibernateUtil.openSession();
		Transaction tx=null;

		try{
		tx=session.getTransaction();
		tx.begin();
		
		Query query=session.createQuery("from UtenteBean where username=:user");
		query.setString("user", username);
		
		utenteBean = (UtenteBean) query.uniqueResult();

		 tx.commit();
		}catch(Exception ex){
			tx.rollback();
		}finally{
			session.close();
		}
		return utenteBean;
		
	}
	
	public List<UtenteBean> getTuttiUtenti() {
		List<UtenteBean> elencoUtenti= new ArrayList<UtenteBean>();
		Session session =HibernateUtil.openSession();
		Transaction tx=null;

		try{
		tx=session.getTransaction();
		tx.begin();
		
		Query query=session.createQuery("from UtenteBean");
		elencoUtenti = query.list();
		
		 tx.commit();
		}catch(Exception ex){
			tx.rollback();
		}finally{
			session.close();
		}
		return elencoUtenti;
	}
	
	public boolean aggiornaUtente(UtenteBean u) {
		
		boolean res = false;
		Session session =HibernateUtil.openSession();
		Transaction tx=null;

		try{
		tx=session.getTransaction();
		tx.begin();
		
		session.update(u);
		res = true;

		 tx.commit();
		}catch(Exception ex){
			tx.rollback();
		}finally{
			session.close();
		}
		
		return res;
		
	}
	
	public boolean eliminaUtente(UtenteBean u){
		
		boolean res = false;
		Session session =HibernateUtil.openSession();
		Transaction tx=null;

		try{
		tx=session.getTransaction();
		tx.begin();
		
		session.delete(u);
		
		res = true;
		
		 tx.commit();
		}catch(Exception ex){
			tx.rollback();
		}finally{
			session.close();
		}
		return res;
	}
}