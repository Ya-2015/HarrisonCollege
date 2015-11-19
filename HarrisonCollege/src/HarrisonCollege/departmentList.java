package HarrisonCollege;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Hdepartment;
import model.Huser;
import HarrisonCollegeDB.CollegeDB;

/**
 * Servlet implementation class departmentList
 */
@WebServlet("/departmentList")
public class departmentList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public departmentList() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processListAllDepartment(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processListAllDepartment(request,response);
	}
	
	 protected void processListAllDepartment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    	CollegeDB  db= new CollegeDB();
	    	ArrayList<Hdepartment> allDepartment=db.getAllDepartments();
	    	HttpSession  session=request.getSession();
			session.setAttribute("AllDepartments",allDepartment);
	    	
	    	getServletContext().getRequestDispatcher("/CreateCoursePage.jsp").forward(request, response);
		}

}
