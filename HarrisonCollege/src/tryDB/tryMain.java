package tryDB;

import java.util.ArrayList;

import model.Hcourse;
import HarrisonCollegeDB.UserDB;

public class tryMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserDB uDB = new UserDB();
		
		
		ArrayList<Hcourse> courses = uDB.getAllCourses();
		
		for (Hcourse c : courses){
			System.out.println(c.getCoursecode() + " " + c.getSubjectcode() + " " + c.getCoursename() + " " + c.getDescription() +" "+ c.getCredits() + " "+c.getHdepartment().getDepartmentname()+" "+c.getStatuscode());
		}
		
		
	}

}
