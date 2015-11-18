package HarrisonCollege;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Hstudent;
import model.Huser;
import HarrisonCollegeDB.CollegeDB;


@WebServlet("/AdvisorListAllStudents")
public class AdvisorListAllStudents extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public AdvisorListAllStudents() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processListAllStudents(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processListAllStudents(request,response);
	}

	 protected void processListAllStudents(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    	CollegeDB  db= new CollegeDB();
	    	ArrayList<Hstudent> allStudents=db.getAllStudents();
	    	
	    	request.setAttribute("AllStudents",allStudents);
	    	getServletContext().getRequestDispatcher("/AllStudentsList.jsp").forward(request, response);
		}
}
