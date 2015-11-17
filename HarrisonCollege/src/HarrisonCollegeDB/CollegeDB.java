package HarrisonCollegeDB;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import model.Hclass;
import model.Hcourse;
import model.Hdepartment;
import model.Henrollment;
import model.Hinstructor;
import model.Hschedule;
import model.Hstudent;
import DBUtil.DBUtil;

public class CollegeDB {
	//******************************************
	//Course Related****************************
	//******************************************
	//all courses
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
	
	//all unique subjects
	public ArrayList<String> getAllUniqueSubjests(){
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		List<String> fd = null;
		
		try {
			String sql = "select DISTINCT c.subjectcode from Hcourse c";
			TypedQuery<String> q = em.createQuery(sql, String.class);
			
			fd = q.getResultList();
			
		} catch (Exception e){
			System.out.println(e);
		} finally {
			em.close();
		}
		
		return new ArrayList<String>(fd);
	}
	
	//******************************************
	//Department Related************************
	//******************************************
	//department
	public boolean addNewDepartment(String departmentName){
		boolean isSuccess = false;
		
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		
		Hdepartment department = new Hdepartment();
		department.setDepartname(departmentName);
		department.setStatuscode(1);
		
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

	public ArrayList<Hdepartment> getAllDepartments(){
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		List<Hdepartment> fd = null;
		
		try {
			String sql = "select d from Hdepartment d";
			TypedQuery<Hdepartment> q = em.createQuery(sql, Hdepartment.class);
			
			fd = q.getResultList();
			
		} catch (Exception e){
			System.out.println(e);
		} finally {
			em.close();
		}
		
		return new ArrayList<Hdepartment>(fd);
	}
	
	//******************************************
	//Instructor Related************************
	//******************************************
	public ArrayList<Hinstructor> getAllInstructors(){
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		List<Hinstructor> fd = null;
		
		try {
			String sql = "select i from Hinstructor i";
			TypedQuery<Hinstructor> q = em.createQuery(sql, Hinstructor.class);
			
			fd = q.getResultList();
			
		} catch (Exception e){
			System.out.println(e);
		} finally {
			em.close();
		}
		
		return new ArrayList<Hinstructor>(fd);
	}
	
	//******************************************
	//Schedule Related**************************
	//******************************************
	public ArrayList<Hschedule> getAllSchedule(){
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		List<Hschedule> fd = null;
		
		try {
			String sql = "select s from Hschedule s";
			TypedQuery<Hschedule> q = em.createQuery(sql, Hschedule.class);
			
			fd = q.getResultList();
			
		} catch (Exception e){
			System.out.println(e);
		} finally {
			em.close();
		}
		
		return new ArrayList<Hschedule>(fd);
	}
	
	//******************************************
	//Student Related**************************
	//******************************************
	public ArrayList<Hstudent> getAllStudents(){
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		List<Hstudent> fd = null;
		
		try {
			String sql = "select s from Hstudent s";
			TypedQuery<Hstudent> q = em.createQuery(sql, Hstudent.class);
			
			fd = q.getResultList();
			
		} catch (Exception e){
			System.out.println(e);
		} finally {
			em.close();
		}
		
		return new ArrayList<Hstudent>(fd);
	}
	
	public ArrayList<Hclass> getClassByStudentBySemester(int stuNum, int semesterCode){
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		List<Hclass> fd = null;
		
		try {
			String sql = "select e.hclass from Henrollment e where e.hstudent.studentnum = ?1 and e.hclass.hsemester.semestercode = ?2";
			TypedQuery<Hclass> q = em.createQuery(sql, Hclass.class);
			q.setParameter(1, stuNum);
			q.setParameter(2, semesterCode);
			
			fd = q.getResultList();
			
		} catch (Exception e){
			System.out.println(e);
		} finally {
			em.close();
		}
		
		return new ArrayList<Hclass>(fd);
	}
}
