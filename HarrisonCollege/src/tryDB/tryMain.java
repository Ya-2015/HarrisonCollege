package tryDB;

import java.math.BigDecimal;
import java.util.ArrayList;

import model.Hclass;
import model.Hcourse;
import model.Hdepartment;
import model.Henrollment;
import model.Hinstructor;
import model.Hschedule;
import model.Hstudent;
import model.Huser;
import HarrisonCollegeDB.CollegeDB;



public class tryMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CollegeDB uDB = new CollegeDB();
		
		//get all courses
		ArrayList<Hcourse> courses = uDB.getAllCourses();
		
		for (Hcourse c : courses){
			System.out.println(c.getCoursecode() + " " + c.getSubjectcode() + " " + c.getCoursename() + " " + c.getDescription() +" "+ c.getCredits() + " "+c.getHdepartment().getCode()+" "+c.getStatuscode());
		}
		
		//get unique subjects
		System.out.println();
		ArrayList<String> subject = uDB.getAllUniqueSubjests();
		
		for (String b : subject){
			System.out.println(b);
		}
		
		
		//add department
//		uDB.addNewDepartment("art");
		
		
		//get all departments
		System.out.println();
		ArrayList<Hdepartment> depar = uDB.getAllDepartments();
		for (Hdepartment d : depar){
			System.out.println(d.getDepartname());
		}
		
		//get all instructors
		System.out.println();
		ArrayList<Hinstructor> ins = uDB.getAllInstructors();
		for (Hinstructor i : ins){
			System.out.println(i.getInstructorname());
		}
		
		//get all schedules
		System.out.println();
		ArrayList<Hschedule> sch = uDB.getAllSchedule();
		for (Hschedule s : sch){
			System.out.println(s.getDow1().toUpperCase() + " "+((s.getDow2()!=null)?s.getDow2().toUpperCase():"")+" " + s.getHour12() + ":"+s.getMinutes60()+s.getAmpm().toUpperCase());
		}
		
		//get all students
		System.out.println();
		ArrayList<Hstudent> stu = uDB.getAllStudents();
		for (Hstudent s : stu){
			System.out.println(s.getStudentname().toUpperCase()+" "+s.getStudentnum());
		}
		
		//enroll class 
		System.out.println();
		Hstudent stuu = uDB.getStudentProfileByStuNum(1);
		Hclass clas = uDB.getClassById(2);
//		System.out.println("Enroll "+stuu.getStudentname().toUpperCase() + " to "+clas.getClassnum() + " with course: "+clas.getHcourse().getCoursename());
//		uDB.enrollClass(1, 1);
		
		//get class by student by semester
		System.out.println();
		
		System.out.println(stuu.getStudentname().toUpperCase() + " current semester classes");
		ArrayList<Hclass> cls = uDB.getClassByStudentBySemester(1, 1);
		for (Hclass c : cls){
			System.out.println("Course: "+ c.getHcourse().getCoursename() + " Class Num:" + c.getClassnum());
		}
		
		
		
		//get class by semester
		System.out.println();
		System.out.println("Current Classes");
		ArrayList<Hclass> clss = uDB.getClassBySemester(1);
		for (Hclass c : clss){
			System.out.println("Course: "+ c.getHcourse().getCoursename() + " Class Num:" + c.getClassnum());
		}
		
		//check enrollment
//		Henrollment enr = uDB.getEnrollmentByStudentByClass(1, 1);
//		System.out.println("unenroll class for: "+enr.getHstudent().getStudentname());
		//drop class
		System.out.println(uDB.unenrollClass(1, 1));
		
		//get user profile
		System.out.println();
		Huser user = uDB.getUserProfile("yaliu001", "111");
		if(user == null){
			System.out.println("incorrent");
		}else{
			System.out.println("NetId: "+user.getNetid() + " \tUser Type:" + user.getUsertype());
		}
		
		//get student profile by netid
		System.out.println("\nget student profile by netid");
		Hstudent s1 = uDB.getStudentProfileByNetId("yaliu001");
		if(s1 == null){
			System.out.println("incorrent");
		}else{
			System.out.println("Stu Name: "+s1.getStudentname()+" "+"Stu Num: "+ s1.getStudentnum());
		}
	
		//get all users
		System.out.println("\nAll User Info");
		ArrayList<Huser> allU = uDB.getAllUsers();
		for(Huser u: allU){
			System.out.println(u.getNetid()+" " + u.getUsertype());
		}
	}

}
