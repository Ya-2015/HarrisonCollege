package HarrisonCollege;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Hcourse;
import model.Hdepartment;
import model.Hinstructor;

import HarrisonCollegeDB.CollegeDB;


/**
 * Servlet implementation class CourseExplorerMainServlet
 */
@WebServlet("/CourseExplorerMainServlet")
public class CourseExplorerMainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CourseExplorerMainServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		CollegeDB uDB = new CollegeDB();
		PrintWriter out = response.getWriter();
		int j = 0;
		double avgRating = 0;
		HttpSession session = request.getSession();
		String departmentDropdown = "";
		ArrayList<Hdepartment> depar = uDB.getAllDepartments();
		for (Hdepartment d : depar) {
			departmentDropdown = departmentDropdown
					+ "<li><input type=\"checkbox\" name=\"departmentid\" id=\"departmentid\" value="
					+ d.getCode() + "><label for=\"departmentid\">"
					+ d.getDepartname() + "</label></li>";
		}

		

		String instructorDropdown = "";
		ArrayList<Hinstructor> ins = uDB.getAllInstructors();
		for (Hinstructor i : ins){
			instructorDropdown = instructorDropdown
					+ "<li><input type=\"checkbox\" name=\"departmentid\" id=\"departmentid\" value="
					+ i.getNetid() + "><label for=\"departmentid\">"
					+ i.getInstructorname() + "</label></li>";
		}
		
		String subjectDropdown = "";
		ArrayList<String> subject = uDB.getAllUniqueSubjests();		
		for (String s : subject){
			subjectDropdown = subjectDropdown
					+ "<li><input type=\"checkbox\" name=\"departmentid\" id=\"departmentid\" value="
					+s + "><label for=\"departmentid\">"
					+ s + "</label></li>";
		}

	
		
		String courseTable = "";
		ArrayList<Hcourse> data =uDB.getAllCourses();
		for (Hcourse dataset : data){
		courseTable = courseTable + "<div> <tr><td>" + dataset.getHdepartment().getDepartname()
				+ "</td><td>" + dataset.getSubjectcode()+ "</td><td>"
				+ dataset.getDescription() + "</td><td>"
				+ dataset.getCredits() + "</td></tr>" + "</div>";
		}

		request.setAttribute("departmentDropdown", departmentDropdown);
		request.setAttribute("instructorDropdown", instructorDropdown);
		request.setAttribute("subjectDropdown", subjectDropdown);
		request.setAttribute("courseTable", courseTable);
		
		getServletContext().getRequestDispatcher("/CourseExplorerMainPage.jsp").forward(
				request, response);
	}
}
