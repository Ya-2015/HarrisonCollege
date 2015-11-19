package HarrisonCollege;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import HarrisonCollegeDB.CollegeDB;

/**
 * Servlet implementation class ChangeCourse
 */
@WebServlet("/ChangeCourse")
public class ChangeCourse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ChangeCourse() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processChangeCourse(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processChangeCourse(request,response);
	}

     protected void processChangeCourse(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	 CollegeDB  db= new CollegeDB();
 		String strdepartmentcode = request.getParameter("departmentcode");
 		int departmentCode =Integer.parseInt(strdepartmentcode);
 		String strcoursename = request.getParameter("coursename");
 		String strsubjectcode = request.getParameter("subjectcode");
 		String strdescription = request.getParameter("description");
 		String strcredits = request.getParameter("credits");
 		int Credits =Integer.parseInt(strcredits);
 	    
 		boolean createCourseFlag=db.addNewCourse(strsubjectcode, strcoursename, strdescription, Credits, departmentCode);
 		request.setAttribute("CourseFlag", createCourseFlag);
 		
 		try {
 			getServletContext().getRequestDispatcher("/CreateCourseconfirmation.jsp").forward(request, response);
 		} catch (ServletException e) {
 			
 			e.printStackTrace();
 		} catch (IOException e) {
 			
 			e.printStackTrace();
 		}
 			
 		
	}
}
