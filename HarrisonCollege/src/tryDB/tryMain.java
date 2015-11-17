package tryDB;

import java.math.BigDecimal;
import java.util.ArrayList;

import model.Hcourse;
import model.Hdepartment;
import model.Hinstructor;
import model.Hschedule;
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
	}

}
