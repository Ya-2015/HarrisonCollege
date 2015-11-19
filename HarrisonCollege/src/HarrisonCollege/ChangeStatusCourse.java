package HarrisonCollege;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Hcourse;
import model.Hdepartment;
import HarrisonCollegeDB.CollegeDB;

/**
 * Servlet implementation class ChangeStatusCourse
 */
@WebServlet("/ChangeStatusCourse")
public class ChangeStatusCourse extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public ChangeStatusCourse() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processChangeStatusCourse(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processChangeStatusCourse(request,response);
	}
	
protected void processChangeStatusCourse(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 String strcoursecode = request.getParameter("Coursecode");
	 int courseNUM =Integer.parseInt(strcoursecode);
	   String strstatus=request.getParameter("status");
	   int status =Integer.parseInt(strstatus);
	   
	   String strcoursename=request.getParameter("coursename");
	   String strdescription=request.getParameter("description");
	   String strcredits=request.getParameter("credits");
	   int Credits=Integer.parseInt(strcredits);
	   String strsubjectcode=request.getParameter("subjectcode");
	   CollegeDB  db= new CollegeDB();
	   Hcourse course=db.getCoursesById(courseNUM);
	  
	   
	   course.setSubjectcode(strsubjectcode);
	   course.setCoursename(strcoursename);
	 
	   course.setDescription(strdescription);
	   course.setCredits(Credits);
	   course.setStatuscode(status);
	   
	   boolean updateCourseFlag= db.updateCourse (course);
		
	
		
		request.setAttribute("CourseStatusFlag",updateCourseFlag);
		getServletContext().getRequestDispatcher("/CourseStatusConfirmation.jsp").forward(request, response);
		
	}

}
