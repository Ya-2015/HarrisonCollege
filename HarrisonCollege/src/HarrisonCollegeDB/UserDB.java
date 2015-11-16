package HarrisonCollegeDB;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import model.Hcourse;
import model.Hdepartment;
import DBUtil.DBUtil;

public class UserDB {
	//******************************************
	//course
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
	
	//*****************************************
	//department
	public boolean addNewDepartment(Hdepartment department){
		boolean isSuccess = false;
		
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		
		trans.begin();
		
		try{
			em.persist(department);
			trans.commit();
			isSuccess = true;
		}catch(Exception e){
			System.out.println(e);
			trans.rollback();
		}finally{
			em.close();
		}
		
		return isSuccess;
	}

}
