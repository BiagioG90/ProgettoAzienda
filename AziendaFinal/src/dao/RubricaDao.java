package dao;

import rubrica.Rubrica;
import util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class RubricaDao {
	
	// 1 crea rubrica
	public boolean creaRubrica(Rubrica r){

		boolean res = false;
		
		Session session =HibernateUtil.openSession();
		Transaction tx=null;

		try{
		tx=session.getTransaction();
		tx.begin();

		session.persist(r);
		res = true;
		 tx.commit();
		}catch(Exception ex){
			tx.rollback();
		}finally{
			session.close();
		}
		
		return res;
	}
	
	public boolean creaRubrica(String nome){
		
		boolean res = false;
		Rubrica r =new Rubrica();
		r.setNomeRubrica(nome);
		
		Session session =HibernateUtil.openSession();
		Transaction tx=null;

		try{
		tx=session.getTransaction();
		tx.begin();

		session.persist(r);
		res = true;
		 tx.commit();
		}catch(Exception ex){
			tx.rollback();
		}finally{
			session.close();
		}
		
		return res;
	}

	//2a trova rubrica con id
	
	public Rubrica trovaRubricaConId(long idRubrica){
		
		Rubrica r=null;
		
		Session session =HibernateUtil.openSession();
		Transaction tx=null;

		try{
		tx=session.getTransaction();
		tx.begin();

		r=session.get(Rubrica.class, idRubrica);
		
		 tx.commit();
		}catch(Exception ex){
			tx.rollback();
		}finally{
			session.close();
		}
		return r;
	}
	
	// 2b trova rubrica con nome
	public Rubrica trovaRubricaConNome(String nome){
		
		Rubrica r=null;
		Session session =HibernateUtil.openSession();
		Transaction tx=null;

		try{
		tx=session.getTransaction();
		tx.begin();

		Query query= session.createQuery("from Rubrica where nomeRubrica=:nome");
		query.setString("nome", nome);
		r=(Rubrica) query.uniqueResult();
		
		 tx.commit();
		}catch(Exception ex){
			tx.rollback();
		}finally{
			session.close();
		}
		return r;
		
	}
	
	//3 modifica rubrica
	public boolean modificaRubrica(Rubrica r){
		
		boolean res = false;
		Session session =HibernateUtil.openSession();
		Transaction tx=null;

		try{
		tx=session.getTransaction();
		tx.begin();

		session.update(r);
		res = true;
		
		 tx.commit();
		}catch(Exception ex){
			tx.rollback();
		}finally{
			session.close();
		}
		return res;
		
	}
	
	//4 elimina Rubrica
	public boolean eliminaRubrica (Rubrica r){
		
		boolean res = false;
		Session session =HibernateUtil.openSession();
		Transaction tx=null;

		try{
		tx=session.getTransaction();
		tx.begin();
		
		session.delete(r);
		
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