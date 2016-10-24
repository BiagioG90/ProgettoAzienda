package dao;

import util.HibernateUtil;
import bean.AdminBean;
import org.hibernate.Session;
import org.hibernate.Transaction;

	public class AdminDao {
		
		public boolean creaAdmin(AdminBean a){
			
			boolean res = false;
			
			Session session =HibernateUtil.openSession();
			Transaction tx=null;

			try{
			tx=session.getTransaction();
			tx.begin();
			
			session.persist(a);
			
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