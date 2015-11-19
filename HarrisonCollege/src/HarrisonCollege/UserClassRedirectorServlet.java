package HarrisonCollege;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Hinstructor;
import model.Hstudent;
import model.Huser;
import HarrisonCollegeDB.CollegeDB;

/**
 * Servlet implementation class UserClassRedirectorServlet
 */
@WebServlet("/UserClassRedirectorServlet")
public class UserClassRedirectorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserClassRedirectorServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * protected void doGet(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException { doPost(request,
	 * response); // TODO Auto-generated method stub }
	 * 
	 * /**
	 *
	 * 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		CollegeDB cDB = new CollegeDB();
		String name = request.getParameter("username");
		String pwd = request.getParameter("password");
		Huser loggedIn = cDB.getUserProfile(request.getParameter("username"),
				request.getParameter("password"));

		if ((Integer) session.getAttribute("usercode") != null) {
			switch ((Integer) session.getAttribute("usercode")) {
			case 1: {
				response.sendRedirect("StudentPage.jsp");
				break;
			}
			case 2: {

				response.sendRedirect("InstructorPage.jsp");
				break;
			}
			case 3: {
				response.sendRedirect("AdvisorsPage.jsp");
				break;
			}
			case 4: {
				response.sendRedirect("AdministratorPage.jsp");
				break;
			}

			}
		}
		else
			response.sendRedirect("Login.jsp");
	}
}
