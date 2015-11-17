package HarrisonCollege;

import model.Hinstructor;
import model.Hstudent;
import model.Huser;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import HarrisonCollegeDB.CollegeDB;


/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		CollegeDB cDB = new CollegeDB();
		String name = request.getParameter("username");
		String pwd = request.getParameter("password");
		Huser loggedIn =cDB.getUserProfile(request.getParameter("username"),
				request.getParameter("password"));
		if (loggedIn != null)
		{
			session.setAttribute("netid", loggedIn.getNetid());
				switch(loggedIn.getUsertype().intValueExact()){
				case 1 :	session.setAttribute("usertype", "student");
							Hstudent studentProfile= cDB.getStudentProfileByNetId(loggedIn.getNetid());
							session.setAttribute("studentNumber",studentProfile.getStudentnum());
							response.sendRedirect("StudentPage.jsp");
							break;
				case 2 : 	session.setAttribute("usertype", "instructor");
							Hinstructor instructorProfile= cDB.getInstructorProfileByNetId(loggedIn.getNetid());
							session.setAttribute("instructorNumber",instructorProfile.getInstructornum());
							response.sendRedirect("InstructorPage.jsp");
							break;
				case 3 :    session.setAttribute("usertype", "advisor");
							response.sendRedirect("AdvisorPage.jsp");
							break;
				case 4 :	session.setAttribute("usertype", "admin");
							response.sendRedirect("AdministratorPage.jsp");
							break;
				
				}
		}
		

		else {
			response.sendRedirect("InvalidLogin.jsp");
		}

	}
}
