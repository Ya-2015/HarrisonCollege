package HarrisonCollegeDB;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import model.Hcourse;
import DBUtil.DBUtil;

public class UserDB {
	public ArrayList<Hcourse> getAllCourses(){
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		List<Hcourse> fd = null;
		
		try {
			String sql = "select c from Hcourse c";
			TypedQuery<Hcourse> q = em.createQuery(sql, Hcourse.class);
			
			fd = q.getResultList();
			
		} catch (Exception e){
			System.out.println(e);
		} finally {
			em.close();
		}
		
		return new ArrayList<Hcourse>(fd);
	}

}
