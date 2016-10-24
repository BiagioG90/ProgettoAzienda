package dao;

import util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import rubrica.Rubrica;
import rubrica.Voce;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class VoceDao {
	
	public boolean aggiungiVoce(Voce voce){
		boolean res = false;
		
		Session session =HibernateUtil.openSession();
		Transaction tx=null;

		try{
		tx=session.getTransaction();
		tx.begin();
		
		session.persist(voce);
		
		 res = true;
		 
		 tx.commit();
		}catch(Exception ex){
			tx.rollback();
		}finally{
			session.close();
		}
		
		return res;
	}
	
	public Voce trovaVoce(String nome, String cognome, long idRubrica){
		
		Voce voce=null;
		Session session =HibernateUtil.openSession();
		Transaction tx=null;

		try{
		tx=session.getTransaction();
		tx.begin();

		Query query=session.createQuery("from Voce where Rubrica_id_Rubrica=:id and nome=:nome and cognome=:cognome");
		query.setLong("id", idRubrica);
		query.setString("nome", nome);
		query.setString("cognome", cognome);
		
		voce = (Voce) query.uniqueResult();
		 
		 tx.commit();
		}catch(Exception ex){
			tx.rollback();
		}finally{
			session.close();
		}
		
		return voce;
	}
	
	public List<Voce> getVociRubrica(Rubrica rubrica){
		
		List<Voce> elencoVoci= new ArrayList<Voce>();
		long id=rubrica.getId_Rubrica();
		Session session =HibernateUtil.openSession();
		Transaction tx=null;

		try{
		tx=session.getTransaction();
		tx.begin();

		Query query= session.createQuery("from Voce where Rubrica_Id_Rubrica=:id");
		query.setLong("id", id);
		 elencoVoci=query.list();
		
		 tx.commit();
		}catch(Exception ex){
			tx.rollback();
		}finally{
			session.close();
		}
		return elencoVoci;
	}
	
	public boolean modificaVoce(Voce voce){
		
		boolean res = false;
		Session session =HibernateUtil.openSession();
		Transaction tx=null;

		try{
		tx=session.getTransaction();
		tx.begin();
		
		session.update(voce);
		res = true;
		 
		 tx.commit();
		}catch(Exception ex){
			tx.rollback();
		}finally{
			session.close();
		}
		
		return res;
	}
	
	public boolean eliminaVoce(Voce voce){
		
		boolean res = false;
		Session session =HibernateUtil.openSession();
		Transaction tx=null;

		try{
		tx=session.getTransaction();
		tx.begin();
		
		session.delete(voce);
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