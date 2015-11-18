package HarrisonCollege;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	 String strcoursenum = request.getParameter("courseNumber");
	   String strclassnum=request.getParameter("courseStatus");
	   CollegeDB  db= new CollegeDB();
		
		int courseNUM =Integer.parseInt(strcoursenum);
		int classNUM=Integer.parseInt(strclassnum);
		boolean statusFlag=db.updateCourseStatus(courseNUM, classNUM);
		request.setAttribute("CourseStatusFlag",statusFlag);
		getServletContext().getRequestDispatcher("/CourseStatusConfirmation.jsp").forward(request, response);
		
	}

}
