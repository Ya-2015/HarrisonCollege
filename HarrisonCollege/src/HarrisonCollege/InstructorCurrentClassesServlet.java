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
import HarrisonCollegeDB.CollegeDB;

/**
 * Servlet implementation class InstructorCurrentClassesServlet
 */
@WebServlet("/InstructorCurrentClassesServlet")
public class InstructorCurrentClassesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InstructorCurrentClassesServlet() {
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
		

		HttpSession session = request.getSession();
		String scheduleDropdown = "";
		if (session.getAttribute("instructorNumber") == null) {
			getServletContext().getRequestDispatcher(
					"/UserClassRedirectorServlet").forward(request, response);
		} else {
			ArrayList<Hclass> depar = uDB.getClassByInstructorBySemester(
					(Integer) session.getAttribute("instructorNumber"), 1);
			for (Hclass dataset : depar) {
				if (dataset.getHschedule().getDow2() == null) {
					scheduleDropdown = scheduleDropdown + "<div> <tr><td>"
							+ dataset.getHclassroom().getBldgname()
							+ "</td><td>"
							+ dataset.getHclassroom().getRoomnumber()
							+ "</td><td>"
							+ dataset.getHcourse().getCoursename()
							+ "</td><td>"
							+ dataset.getHschedule().getDow1().toUpperCase()
							+ "</td><td>" + dataset.getHschedule().getHour12()
							+ " " + dataset.getHschedule().getAmpm()
							+ "</td></tr>" + "</div>";
				} else {
					scheduleDropdown = scheduleDropdown + "<div> <tr><td>"
							+ dataset.getHclassroom().getBldgname()
							+ "</td><td>"
							+ dataset.getHclassroom().getRoomnumber()
							+ "</td><td>"
							+ dataset.getHcourse().getCoursename()
							+ "</td><td>"
							+ dataset.getHschedule().getDow1().toUpperCase()
							+ " "
							+ dataset.getHschedule().getDow2().toUpperCase()
							+ "</td><td>" + dataset.getHschedule().getHour12()
							+ "  " + dataset.getHschedule().getAmpm()
							+ "</td></tr>" + "</div>";
				}
			}
			request.setAttribute("scheduleDropdown", scheduleDropdown);
			getServletContext().getRequestDispatcher(
					"/InstructorClassesDisplay.jsp").forward(request, response);
		}
	}
}
