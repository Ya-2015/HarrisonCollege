package HarrisonCollegeDB;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import model.Huser;
import DBUtil.DBUtil;

public class UserDB {
	public Huser getUserProfile(String username, String userpwd){
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		Huser fd = null;
		
		try {
			String sql = "select u from Huser u where u.netid = ?1 and u.userpwd = ?2";
			TypedQuery<Huser> q = em.createQuery(sql, Huser.class);
			q.setParameter(1, username);
			q.setParameter(2, userpwd);
			
			fd = q.getSingleResult();
			
		} catch (Exception e){
			System.out.println(e);
		} finally {
			em.close();
		}
		
		return fd;
	}

}
