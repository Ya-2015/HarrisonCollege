package HarrisonCollege;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Hcourse;
import model.Hdepartment;
import model.Hinstructor;
import HarrisonCollegeDB.CollegeDB;

/**
 * Servlet implementation class CourseStatusChangerServlet
 */
@WebServlet("/CourseStatusChangerServlet")
public class CourseStatusChangerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CourseStatusChangerServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

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

		String departmentDropdown = "";
		ArrayList<Hdepartment> depar = uDB.getAllDepartments();
		for (Hdepartment d : depar) {
			departmentDropdown = departmentDropdown
					+ "<li><a href = \"departmentFilter?departmentID="
					+ d.getCode() + "\">" + d.getDepartname() + "</a></li>";
		}

		String instructorDropdown = "";
		ArrayList<Hinstructor> ins = uDB.getAllInstructors();
		for (Hinstructor i : ins) {
			instructorDropdown = instructorDropdown
					+ "<li><a href = \"instructorFilter?instructorID="
					+ i.getNetid() + "\">" + i.getInstructorname()
					+ "</a></li>";
		}

		String subjectDropdown = "";
		ArrayList<String> subject = uDB.getAllUniqueSubjests();
		for (String sub : subject) {
			subjectDropdown = subjectDropdown
					+ "<li><a href = \"subjectFilter?subjectID=" + sub + "\">"
					+ sub + "</a></li>";
		}

		String courseTable = "";
		ArrayList<Hcourse> data = uDB.getAllCourses();
		for (Hcourse dataset : data) {
			courseTable = courseTable
					+ "<div> <tr><td>"
					+ dataset.getHdepartment().getDepartname()
					+ "</td><td>"
					+ dataset.getSubjectcode()
					+ "</td><td>"
					+ dataset.getDescription()
					+ "</td><td>"
					+ dataset.getCredits()
					+ "</td><td>"
					+ "<a href=\"ChangeStatusCourses.jsp?Coursecode="
					+ dataset.getCoursecode()+"&Coursestatus="+dataset.getStatuscode()
					+ "\" class=\"btn btn-info\" role=\"button\">Change Status</a>"
					+ "</td></tr>" + "</div>";
		}

		request.setAttribute("departmentDropdown", departmentDropdown);
		request.setAttribute("instructorDropdown", instructorDropdown);
		request.setAttribute("subjectDropdown", subjectDropdown);
		request.setAttribute("courseTable", courseTable);

		getServletContext().getRequestDispatcher("/CourseExplorerMainPage.jsp")
				.forward(request, response);
	}
}
