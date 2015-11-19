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
				ArrayList<Hstudent> rost = uDB
						.getStudentsByClassNum((Integer) dset.getClassnum());
				rosterDropdown = rosterDropdown
						+ "<div class=\"panel-group\"><div class=\"panel panel-info\"><div class=\"panel-heading\">"
						+ dset.getCrn()
						+ "	"
						+ dset.getHcourse().getSubjectcode().toUpperCase()
						+ "	"
						+ dset.getHcourse().getCoursename().toUpperCase()
						+ "</div><div class=\"panel-body\"><table class=\"table table-striped\"><tr><th>NetID</th><th>NetID</th><th>Student Name</th><th>Student Number</th></tr>";
				for (Hstudent dataset : rost) {

					rosterDropdown = rosterDropdown + "<div> <tr><td>"
							+ dataset.getNetid() + "</td><td>"
							+ dataset.getStudentname() + "</td><td>"
							+ dataset.getStudentnum() + "</td></tr>" + "</div>";

				}
				rosterDropdown = rosterDropdown + "</table></div></div></div>";
			}
			request.setAttribute("rosterDropdown", rosterDropdown);
			getServletContext().getRequestDispatcher("/RosterDisplay.jsp")
					.forward(request, response);
		}
	}
}
