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
import model.Henrollment;
import model.Hstudent;
import HarrisonCollegeDB.CollegeDB;

/**
 * Servlet implementation class RosterServlet
 */
@WebServlet("/RosterServlet")
public class RosterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RosterServlet() {
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
		String rosterDropdown = "";
		if (session.getAttribute("instructorNumber") == null) {
			getServletContext().getRequestDispatcher(
					"/UserClassRedirectorServlet").forward(request, response);
		} else {
			ArrayList<Hclass> depar = uDB.getClassByInstructorBySemester(
					(Integer) session.getAttribute("instructorNumber"), 1);
			for (Hclass dset : depar) {
				ArrayList<Henrollment> rost = uDB
						.viewGradeSheetByClass((Integer) dset.getClassnum());

				rosterDropdown = rosterDropdown
						+ "<div class=\"panel-group\"><div class=\"panel panel-info\"><div class=\"panel-heading\">"
						+ dset.getCrn()
						+ "	"
						+ dset.getHcourse().getSubjectcode().toUpperCase()
						+ "	"
						+ dset.getHcourse().getCoursename().toUpperCase()
						+ "</div><div class=\"panel-body\"><table class=\"table table-striped\"><tr><th>NetID</th></th><th>Student Name</th><th>Student Number</th><th>Grade</th></tr>";
				for (Henrollment dataset : rost) {

					if (dataset.getGrade() != null) {
						rosterDropdown = rosterDropdown
								+ "<div> <tr><td>"
								+ dataset.getHstudent().getNetid()
								+ "</td><td>"
								+ dataset.getHstudent().getStudentname()
								+ "</td><td>"
								+ dataset.getHstudent().getStudentnum()
								+ "</td><td>"
								+ dataset.getGrade()
								+ "</td><td><div class=\"dropdown\"><button class=\"btn btn-primary btn-xs dropdown-toggle\" type=\"button\"data-toggle=\"dropdown\">"
								+ "Assign Grade <span class=\"caret\"></span></button><ul class=\"dropdown-menu noclose\">"
								+ "<a href=\"AssignGradeServlet?grade=A&studentNumber="
								+ dataset.getHstudent().getStudentnum()
								+ "&classNumber="
								+ dset.getClassnum()
								+ "\" class=\"btn btn-success\" role=\"button\">A</a>"
								+ "<a href=\"AssignGradeServlet?grade=B&studentNumber="
								+ dataset.getHstudent().getStudentnum()
								+ "&classNumber="
								+ dset.getClassnum()
								+ "\" class=\"btn btn-success\" role=\"button\">B</a>"
								+ "<a href=\"AssignGradeServlet?grade=C&studentNumber="
								+ dataset.getHstudent().getStudentnum()
								+ "&classNumber="
								+ dset.getClassnum()
								+ "\" class=\"btn btn-warning\" role=\"button\">C</a>"
								+ "<a href=\"AssignGradeServlet?grade=D&studentNumber="
								+ dataset.getHstudent().getStudentnum()
								+ "&classNumber="
								+ dset.getClassnum()
								+ "\" class=\"btn btn-warning\" role=\"button\">D</a>"
								+ "<a href=\"AssignGradeServlet?grade=F&studentNumber="
								+ dataset.getHstudent().getStudentnum()
								+ "&classNumber="
								+ dset.getClassnum()
								+ "\" class=\"btn btn-danger\" role=\"button\">F</a>"
								+ "</ul></div></td></tr>" + "</div>";

					} else {
						rosterDropdown = rosterDropdown
								+ "<div> <tr><td>"
								+ dataset.getHstudent().getNetid()
								+ "</td><td>"
								+ dataset.getHstudent().getStudentname()
								+ "</td><td>"
								+ dataset.getHstudent().getStudentnum()
								+ "</td><td>"
								+ "Not Yet Assigned"
								+ "</td><td><div class=\"dropdown\"><button class=\"btn btn-primary btn-xs dropdown-toggle\" type=\"button\"data-toggle=\"dropdown\">"
								+ "Assign Grade <span class=\"caret\"></span></button><ul class=\"dropdown-menu noclose\">"
								+ "<a href=\"AssignGradeServlet?grade=A&studentNumber="
								+ dataset.getHstudent().getStudentnum()
								+ "&classNumber="
								+ dset.getClassnum()
								+ "\" class=\"btn btn-success\" role=\"button\">A</a>"
								+ "<a href=\"AssignGradeServlet?grade=B&studentNumber="
								+ dataset.getHstudent().getStudentnum()
								+ "&classNumber="
								+ dset.getClassnum()
								+ "\" class=\"btn btn-success\" role=\"button\">B</a>"
								+ "<a href=\"AssignGradeServlet?grade=C&studentNumber="
								+ dataset.getHstudent().getStudentnum()
								+ "&classNumber="
								+ dset.getClassnum()
								+ "\" class=\"btn btn-warning\" role=\"button\">C</a>"
								+ "<a href=\"AssignGradeServlet?grade=D&studentNumber="
								+ dataset.getHstudent().getStudentnum()
								+ "&classNumber="
								+ dset.getClassnum()
								+ "\" class=\"btn btn-warning\" role=\"button\">D</a>"
								+ "<a href=\"AssignGradeServlet?grade=F&studentNumber="
								+ dataset.getHstudent().getStudentnum()
								+ "&classNumber="
								+ dset.getClassnum()
								+ "\" class=\"btn btn-danger\" role=\"button\">F</a>"
								+ "</ul></div></td></tr>" + "</div>";

					}
				}
				rosterDropdown = rosterDropdown + "</table></div></div></div>";
			}
			request.setAttribute("rosterDropdown", rosterDropdown);
			getServletContext().getRequestDispatcher("/RosterDisplay.jsp")
					.forward(request, response);
		}
	}
}
