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
import model.Huser;
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
	
	public ArrayList<Hcourse> getCoursesByDepartment(int departmentCode){
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		List<Hcourse> fd = null;
		
		try {
			String sql = "select c from Hcourse c where c.hdepartment.code = ?1";
			TypedQuery<Hcourse> q = em.createQuery(sql, Hcourse.class);
			q.setParameter(1, departmentCode);
			
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
	
	public Hinstructor getInstructorProfileByNetId(String netid) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		Hinstructor fd = null;
		
		try {
			String sql = "select s from Hinstructor s where s.netid = ?1";
			TypedQuery<Hinstructor> q = em.createQuery(sql, Hinstructor.class);
			q.setParameter(1, netid);
			
			fd = q.getSingleResult();
			
		} catch (Exception e){
			System.out.println(e);
		} finally {
			em.close();
		}
		
		return fd;
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
	
	public Hstudent getStudentProfileByStuNum(int stuNum){
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		Hstudent fd = null;
		
		try {
			String sql = "select s from Hstudent s where s.studentnum = ?1";
			TypedQuery<Hstudent> q = em.createQuery(sql, Hstudent.class);
			q.setParameter(1, stuNum);
			
			fd = q.getSingleResult();
			
		} catch (Exception e){
			System.out.println(e);
		} finally {
			em.close();
		}
		
		return fd;
	}
	
	
	public Hstudent getStudentProfileByNetId(String netId){
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		Hstudent fd = null;
		
		try {
			String sql = "select s from Hstudent s where s.netid = ?1";
			TypedQuery<Hstudent> q = em.createQuery(sql, Hstudent.class);
			q.setParameter(1, netId);
			
			fd = q.getSingleResult();
			
		} catch (Exception e){
			System.out.println(e);
		} finally {
			em.close();
		}
		
		return fd;
	}
	//******************************************
	//Class Related*****************************
	//******************************************
	//all classes
	public ArrayList<Hclass> getAllClasses(){
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		List<Hclass> fd = null;
		
		try {
			String sql = "select c from Hclass c";
			TypedQuery<Hclass> q = em.createQuery(sql, Hclass.class);
			
			fd = q.getResultList();
			
		} catch (Exception e){
			System.out.println(e);
		} finally {
			em.close();
		}
		
		return new ArrayList<Hclass>(fd);
	}
		
	public Hclass getClassById(int classNum){
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		Hclass fd = null;
		
		try {
			String sql = "select c from Hclass c where c.classnum = ?1";
			TypedQuery<Hclass> q = em.createQuery(sql, Hclass.class);
			q.setParameter(1, classNum);
			
			fd = q.getSingleResult();
			
		} catch (Exception e){
			System.out.println(e);
		} finally {
			em.close();
		}
		
		return fd;
	}
	
	public ArrayList<Hclass> getClassBySemester(int semesterCode){
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		List<Hclass> fd = null;
		
		try {
			String sql = "select c from Hclass c where c.hsemester.semestercode = ?1";
			TypedQuery<Hclass> q = em.createQuery(sql, Hclass.class);
			q.setParameter(1, semesterCode);
			
			fd = q.getResultList();
			
		} catch (Exception e){
			System.out.println(e);
		} finally {
			em.close();
		}
		
		return new ArrayList<Hclass>(fd);
	}
	
	public ArrayList<Hclass> getClassBySubjectBySemester(String subject, int semesterCode){
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		List<Hclass> fd = null;
		
		try {
			String sql = "select c from Hclass c where c.hsemester.semestercode = ?1 and c.hcourse.subjectcode = ?2";
			TypedQuery<Hclass> q = em.createQuery(sql, Hclass.class);
			q.setParameter(1, semesterCode);
			q.setParameter(2, subject);
			
			fd = q.getResultList();
			
		} catch (Exception e){
			System.out.println(e);
		} finally {
			em.close();
		}
		
		return new ArrayList<Hclass>(fd);
	}
	
	public ArrayList<Hclass> getClassByInstructorBySemester(int instructorNum, int semesterCode){
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		List<Hclass> fd = null;
		
		try {
			String sql = "select c from Hclass c where c.hsemester.semestercode = ?1 and c.hinstructor.instructornum = ?2";
			TypedQuery<Hclass> q = em.createQuery(sql, Hclass.class);
			q.setParameter(1, semesterCode);
			q.setParameter(2, instructorNum);
			
			fd = q.getResultList();
			
		} catch (Exception e){
			System.out.println(e);
		} finally {
			em.close();
		}
		
		return new ArrayList<Hclass>(fd);
	}
	
	public ArrayList<Hclass> getClassByCertainTimeBySemester(int hr, int semesterCode){
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		List<Hclass> fd = null;
		
		try {
			String sql = "select c from Hclass c where c.hsemester.semestercode = ?1 and c.hschedule.hour12 = ?2";
			TypedQuery<Hclass> q = em.createQuery(sql, Hclass.class);
			q.setParameter(1, semesterCode);
			q.setParameter(2, hr);
			
			fd = q.getResultList();
			
		} catch (Exception e){
			System.out.println(e);
		} finally {
			em.close();
		}
		
		return new ArrayList<Hclass>(fd);
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
	//******************************************
	//(Un)Enrollment Related********************
	//******************************************
	public boolean enrollClass(int clsNum, int stuNum){
		boolean isSuccess = false;
		
		//check whether student already enrolled in the class
		if(getEnrollmentByStudentByClass(clsNum,stuNum)!=null){
			return false;
		}
		
		//get student
		Hstudent stu = getStudentProfileByStuNum(stuNum);
		
		//get class
		Hclass cls = getClassById(clsNum);
		
		if(stu == null || cls == null){
			return false;
		}
		
		//enroll a student to a class
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		
		Henrollment enrollment = new Henrollment();
		enrollment.setHclass(cls);
		enrollment.setHstudent(stu);

		trans.begin();
		
		try{
			em.persist(enrollment);
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
	
	public boolean unenrollClass(int clsNum, int stuNum){
		boolean isSuccess = false;
		
		//get enrollment
		Henrollment enroll = getEnrollmentByStudentByClass(clsNum, stuNum);
		if(enroll == null){
			return false;
		}
		
		//unenroll a student to a class
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();

		trans.begin();
		
		try{
			em.remove(em.merge(enroll));
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
	
	public Henrollment getEnrollmentByStudentByClass(int classNum, int stuNum){
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		Henrollment fd = null;
		
		try {
			String sql = "select en from Henrollment en where en.hclass.classnum = ?1 and en.hstudent.studentnum = ?2";
			TypedQuery<Henrollment> q = em.createQuery(sql, Henrollment.class);
			q.setParameter(1, classNum);
			q.setParameter(2, stuNum);
			
			fd = q.getSingleResult();
			
		} catch (Exception e){
			System.out.println(e);
		} finally {
			em.close();
		}
		
		return fd;
	}
	
	//******************************************
	//User Profile Related**********************
	//******************************************
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

	public Huser getUserProfile(String username){
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		Huser fd = null;
		
		try {
			String sql = "select u from Huser u where u.netid = ?1";
			TypedQuery<Huser> q = em.createQuery(sql, Huser.class);
			q.setParameter(1, username);
			
			fd = q.getSingleResult();
			
		} catch (Exception e){
			System.out.println(e);
		} finally {
			em.close();
		}
		
		return fd;
	}
	
	public boolean signUpNewUser(String netid, String pwd){
		boolean isSuccess = false;
		
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		
		Huser user = null;
		user = getUserProfile(netid);
		if(user != null){
			return false;
		}
		
		user = new Huser();
		user.setNetid(netid);
		user.setUserpwd(pwd);
		user.setUsertype(1);
		
		trans.begin();
		
		try{
			em.persist(user);
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
	
	public boolean updateUserType(String username, int type){
		boolean isSuccess = false;
		Huser user = null;
		
		//check user
		user = getUserProfile(username);
		if(user==null){
			return false;
		}
		
		//check type
		if(type<1 || type>4){
			return false;
		}
		
		//
		if(user.getUsertype() == type){
			isSuccess = true;
		}else{
			//update type
			user.setUsertype(type);
			
			EntityManager em = DBUtil.getEmFactory().createEntityManager();
			EntityTransaction trans = em.getTransaction();
			
			trans.begin();
			try{
				em.merge(user);
				trans.commit();
				isSuccess = true;
			}catch(Exception e){
				System.out.println(e);
				trans.rollback();
				isSuccess = false;
			}finally{
				em.close();
			}
		}
		
		return isSuccess;
	}
	
	public ArrayList<Huser> getAllUsers(){
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		List<Huser> fd = null;
		
		try {
			String sql = "select u from Huser u";
			TypedQuery<Huser> q = em.createQuery(sql, Huser.class);
			
			fd = q.getResultList();
			
		} catch (Exception e){
			System.out.println(e);
		} finally {
			em.close();
		}
		
		return new ArrayList<Huser>(fd);
	}
	

	

}
