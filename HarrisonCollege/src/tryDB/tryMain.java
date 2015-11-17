package tryDB;

import java.math.BigDecimal;
import java.util.ArrayList;

import model.Hclass;
import model.Hcourse;
import model.Hdepartment;
import model.Hinstructor;
import model.Hschedule;
import model.Hstudent;
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
		Hstudent stuu = uDB.getStudentById(1);
		Hclass clas = uDB.getClassById(2);
		System.out.println("Enroll "+stuu.getStudentname().toUpperCase() + " to "+clas.getClassnum() + " with course: "+clas.getHcourse().getCoursename());
		uDB.enrollClass(2, 1);
		
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
		
	}

}
