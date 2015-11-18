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

import model.Hdepartment;
import model.Hmajor;
import HarrisonCollegeDB.CollegeDB;

/**
 * Servlet implementation class MajorDisplayServlet
 */
@WebServlet("/MajorDisplayServlet")
public class MajorDisplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MajorDisplayServlet() {
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
		
		HttpSession session = request.getSession();
		String majorDropdown = "";
		ArrayList<Hmajor>depar = uDB.getMajorByDepartment(Integer.parseInt(request.getParameter("departmentID")));
		for (Hmajor d : depar) {
			majorDropdown = majorDropdown
					+ "<li><a href = \"MajorClassServlet?majorID="
					+ d.getMajorcode()+ "\">"
					+ d.getMajorname() + "</a></li>";
		}
		request.setAttribute("majorDropdown", majorDropdown);
		getServletContext().getRequestDispatcher("/MajorDisplay.jsp")
		.forward(request, response);
	}
}
