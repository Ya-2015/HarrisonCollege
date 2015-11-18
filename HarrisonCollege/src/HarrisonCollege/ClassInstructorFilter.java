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
import model.Hdepartment;
import model.Hinstructor;
import model.Hschedule;
import HarrisonCollegeDB.CollegeDB;

/**
 * Servlet implementation class ClassInstructorFilter
 */
@WebServlet("/ClassInstructorFilter")
public class ClassInstructorFilter extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClassInstructorFilter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
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
					+ "<li><a href = \"ClassDepartmentFilter?departmentID="
					+ d.getCode() + "\">"
					+ d.getDepartname() + "</a></li>";
		}

		String instructorDropdown = "";
		ArrayList<Hinstructor> ins = uDB.getAllInstructors();
		for (Hinstructor i : ins) {
			instructorDropdown = instructorDropdown
					+ "<li><a href = \"ClassInstructorFilter?instructorID="
					+ i.getInstructornum() + "\">"
					+i.getInstructorname() + "</a></li>";
		}


		String subjectDropdown = "";
		ArrayList<String> subject = uDB.getAllUniqueSubjests();
		for (String sub : subject) {
			subjectDropdown = subjectDropdown
					+ "<li><a href = \"ClassSubjectFilter?subjectID="
					+sub + "\">"
					+sub + "</a></li>";
		}

		String timeDropdown = "";
		ArrayList<Hschedule> sch = uDB.getAllSchedule();
		for (Hschedule s : sch) {
			timeDropdown = timeDropdown
					+ "<li><a href = \"ClassTimeFilter?timeID="
					+ s.getHour12() + "\">"
					+ s.getHour12()+ "</a></li>";
		}
		
		
	String classTable = "";
		ArrayList<Hclass> data = uDB.getClassByInstructorBySemester(Integer.parseInt(request.getParameter("instructorID")),1);
		for (Hclass dataset : data) {
			if (dataset.getHschedule().getDow2() == null) {
				classTable = classTable
						+ "<div> <tr><td>"
						+ dataset.getClassnum()
						+ "</td><td>"
						+ dataset.getHcourse().getHdepartment().getDepartname()
						+ "</td><td>"
						+ dataset.getHcourse().getSubjectcode()
						+ "</td><td>"
						+ dataset.getHcourse().getDescription()
						+ "</td><td>"
						+ dataset.getHinstructor().getInstructorname()
						+ "</td><td>"
						+ dataset.getHschedule().getDow1()
						+ "</td><td>"
						+ dataset.getHschedule().getHour12()
						+ "</td><td>"
						+ "<a href=\"enroll.jsp?Enrolledclass="
						+ dataset.getClassnum()
						+ "\" class=\"btn btn-info\" role=\"button\">Add Class</a>"
						+ "</td></tr>" + "</div>";
			} else {
				classTable = classTable
						+ "<div> <tr><td>"
						+ dataset.getClassnum()
						+ "</td><td>"
						+ dataset.getHcourse().getHdepartment().getDepartname()
						+ "</td><td>"
						+ dataset.getHcourse().getSubjectcode()
						+ "</td><td>"
						+ dataset.getHcourse().getDescription()
						+ "</td><td>"
						+ dataset.getHinstructor().getInstructorname()
						+ "</td><td>"
						+ dataset.getHschedule().getDow1()
						+ " "
						+ dataset.getHschedule().getDow2()
						+ "</td><td>"
						+ dataset.getHschedule().getHour12()
						+ "</td><td>"
						+ "<a href=\"enroll.jsp?Enrolledclass="
						+ dataset.getClassnum()
						+ "\" class=\"btn btn-info\" role=\"button\">Add Class</a>"
						+ "</td></tr>" + "</div>";
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
