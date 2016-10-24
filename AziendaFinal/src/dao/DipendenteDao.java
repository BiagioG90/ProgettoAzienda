package dao;

import java.util.ArrayList;
import java.util.List;
import util.HibernateUtil;
import bean.DipendenteBean;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class DipendenteDao {

	public boolean creaDipendente(DipendenteBean d){
		
		boolean res = false;
		
		Session session =HibernateUtil.openSession();
		Transaction tx=null;

		try{
		tx=session.getTransaction();
		tx.begin();
		
		session.persist(d);
		
		 res = true;
		 tx.commit();
		}catch(Exception ex){
			tx.rollback();
		}finally{
			session.close();
		}
		
		return res;	
	}
	
	public List<DipendenteBean> getTuttiDipendenti() {
		List<DipendenteBean> elencoDipendenti= new ArrayList<DipendenteBean>();
		
		Session session =HibernateUtil.openSession();
		Transaction tx=null;

		try{
		tx=session.getTransaction();
		tx.begin();
		
		Query query=session.createQuery("from DipendenteBean");
		elencoDipendenti=query.list();
		
		 tx.commit();
		}catch(Exception ex){
			tx.rollback();
		}finally{
			session.close();
		}
		return elencoDipendenti;
	}
}