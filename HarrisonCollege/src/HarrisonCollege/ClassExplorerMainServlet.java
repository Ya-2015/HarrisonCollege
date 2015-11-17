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

import model.Hclass;
import model.Hcourse;
import model.Hdepartment;
import model.Hinstructor;
import model.Hschedule;
import HarrisonCollegeDB.CollegeDB;

/**
 * Servlet implementation class ClassExplorerMainServlet
 */
@WebServlet("/ClassExplorerMainServlet")
public class ClassExplorerMainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ClassExplorerMainServlet() {
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
		for (Hinstructor i : ins) {
			instructorDropdown = instructorDropdown
					+ "<li><input type=\"checkbox\" name=\"departmentid\" id=\"departmentid\" value="
					+ i.getNetid() + "><label for=\"departmentid\">"
					+ i.getInstructorname() + "</label></li>";
		}

		String subjectDropdown = "";
		ArrayList<String> subject = uDB.getAllUniqueSubjests();
		for (String sub : subject) {
			subjectDropdown = subjectDropdown
					+ "<li><input type=\"checkbox\" name=\"departmentid\" id=\"departmentid\" value="
					+ sub + "><label for=\"departmentid\">" + sub
					+ "</label></li>";
		}

		String timeDropdown = "";
		ArrayList<Hschedule> sch = uDB.getAllSchedule();
		for (Hschedule s : sch) {
			timeDropdown = timeDropdown
					+ "<li><input type=\"checkbox\" name=\"departmentid\" id=\"departmentid\" value="
					+ s.getHour12() + "><label for=\"departmentid\">"
					+ s.getHour12() + "</label></li>";
		}
		String classTable = "";
		ArrayList<Hclass> data = uDB.getAllClasses();
		for (Hclass dataset : data) {
			if (dataset.getHschedule().getDow2() == null) {
				classTable = classTable + "<div> <tr><td>"
						+ dataset.getClassnum() + "</td><td>"
						+ dataset.getHcourse().getHdepartment().getDepartname()
						+ "</td><td>" + dataset.getHcourse().getSubjectcode()
						+ "</td><td>" + dataset.getHcourse().getDescription()
						+ "</td><td>"
						+ dataset.getHinstructor().getInstructorname()
						+ "</td><td>" + dataset.getHschedule().getDow1()
						+ "</td><td>" + dataset.getHschedule().getHour12()
						+ "</td></tr>" + "</div>";
			} else {
				classTable = classTable + "<div> <tr><td>"
						+ dataset.getClassnum() + "</td><td>"
						+ dataset.getHcourse().getHdepartment().getDepartname()
						+ "</td><td>" + dataset.getHcourse().getSubjectcode()
						+ "</td><td>" + dataset.getHcourse().getDescription()
						+ "</td><td>"
						+ dataset.getHinstructor().getInstructorname()
						+ "</td><td>" + dataset.getHschedule().getDow1() + " "
						+ dataset.getHschedule().getDow2()  +"</td><td>"
						+ dataset.getHschedule().getHour12() + "</td></tr>"
						+ "</div>";
			}
		}

		request.setAttribute("departmentDropdown", departmentDropdown);
		request.setAttribute("instructorDropdown", instructorDropdown);
		request.setAttribute("subjectDropdown", subjectDropdown);
		request.setAttribute("timeDropdown", timeDropdown);
		request.setAttribute("classTable", classTable);
		getServletContext().getRequestDispatcher("/ClassExplorerMainPage.jsp")
				.forward(request, response);
	}
}
