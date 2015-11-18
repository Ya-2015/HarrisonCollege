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
		
		//get user profile by netid
		System.out.println("\nUser Profile by NetId");
		Huser uu = uDB.getUserProfile("yaliu001");
		if(uu!=null){
			System.out.println(uu.getNetid()+" " + uu.getUsertype());
		}
		
		//update user type
		System.out.println("\nUpdate User Type");
		boolean updateType = uDB.updateUserType("yaliu001", 1);
		if(updateType){
			System.out.println("updated");
		}else{
			System.out.println("failed");
		}
		
		//sign up new user
		System.out.println("\nSignup new user");
		boolean useruser = uDB.signUpNewUser("yaliu002", "111");
		if(useruser){
			System.out.println("Success");
		}else{
			System.out.println("failed");
		}
		
		//get class by subject by semester
		System.out.println("\nGet class by subject by semester");
		ArrayList<Hclass> cls1 = uDB.getClassBySubjectBySemester("ds", 1);
		for (Hclass c : cls1){
			System.out.println(c.getHcourse().getSubjectcode()+" " + c.getHsemester().getSemestercode()+" "+c.getHsemester().getHyear());
		}
		
		//get class by instructor by semester
		System.out.println("\nGet class by instructor by semester");
		ArrayList<Hclass> cls2 = uDB.getClassByInstructorBySemester(1, 1);
		for (Hclass c : cls2){
			System.out.println(c.getHcourse().getSubjectcode()+" " + c.getHsemester().getSemestercode()+" "+c.getHsemester().getHyear());
		}
		
		//get class by certain time by semester
		System.out.println("\nGet class by certain time by semester");
		ArrayList<Hclass> cls3 = uDB.getClassByCertainTimeBySemester(8, 2);
		for (Hclass c : cls3){
			System.out.println(c.getHcourse().getSubjectcode()+" " + c.getHsemester().getSemestercode()+" "+c.getHsemester().getHyear());
		}
		
		//get courses by department
		System.out.println("\nGet courses by department");
		ArrayList<Hcourse> crs = uDB.getCoursesByDepartment(1);
		for (Hcourse c : crs){
			System.out.println(c.getSubjectcode()+" "+c.getCoursename());
		}
		
		//view transcript
		System.out.println("\nview student transcript");
		ArrayList<Henrollment> enr = uDB.getTranscriptByStudentNum(3);
		for (Henrollment c : enr){
			System.out.println(c.getGrade()+" "+c.getHclass().getHcourse().getCoursename());
		}
		
		//get class by department by semester
		System.out.println("\nview classed by department by semester");
		ArrayList<Hclass> cls4 = uDB.getClassByDepartmentBySemester(3, 1);
		for (Hclass c : cls4){
			System.out.println(c.getHcourse().getHdepartment().getDepartname()+c.getHcourse().getSubjectcode()+" " + c.getHsemester().getSemestercode()+" "+c.getHsemester().getHyear());
		}
	}

}
