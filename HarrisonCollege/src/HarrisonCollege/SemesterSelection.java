package HarrisonCollege;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Hclass;
import model.Hsemester;
import HarrisonCollegeDB.CollegeDB;

/**
 * Servlet implementation class SemesterSelection
 */
@WebServlet("/SemesterSelection")
public class SemesterSelection extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SemesterSelection() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		CollegeDB uDB = new CollegeDB();
	
		String semesterDropdown = "<div><a href = \"RosterServlet?semesterID=1\">Current Semester</a></div><br><br>";
		ArrayList<Hsemester> sem = uDB.getAllSemesters();
		for (Hsemester dataset : sem) {
		semesterDropdown = semesterDropdown + "<div><a href = \"RosterServlet?semesterID="+ dataset.getSemestercode()+"\">"
		+dataset.getSemester().toUpperCase()+"	"+dataset.getHyear()		 + "</div>";
		}
		request.setAttribute("semesterDropdown", semesterDropdown);
		getServletContext().getRequestDispatcher("/SemesterDisplay.jsp")
				.forward(request, response);
	}

}
