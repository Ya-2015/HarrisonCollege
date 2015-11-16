package tryDB;

import java.math.BigDecimal;
import java.util.ArrayList;

import model.Hcourse;
import model.Hdepartment;
import HarrisonCollegeDB.UserDB;

public class tryMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserDB uDB = new UserDB();
		
		
		ArrayList<Hcourse> courses = uDB.getAllCourses();
		
		for (Hcourse c : courses){
			System.out.println(c.getCoursecode() + " " + c.getSubjectcode() + " " + c.getCoursename() + " " + c.getDescription() +" "+ c.getCredits() + " "+c.getHdepartment().getCode()+" "+c.getStatuscode());
		}
		
		Hdepartment department = new Hdepartment();
		department.setDepartname("art");
		department.setStatuscode(1);
		
		uDB.addNewDepartment(department);
		
	}

}
