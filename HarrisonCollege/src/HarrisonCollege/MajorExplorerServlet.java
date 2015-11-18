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
import HarrisonCollegeDB.CollegeDB;

/**
 * Servlet implementation class MajorExplorerServlet
 */
@WebServlet("/MajorExplorerServlet")
public class MajorExplorerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MajorExplorerServlet() {
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
		String departmentDropdown = "";
		ArrayList<Hdepartment> depar = uDB.getAllDepartments();
		for (Hdepartment d : depar) {
			departmentDropdown = departmentDropdown
					+ "<li><a href = \"MajorDisplayServlet?departmentID="
					+ d.getCode() + "\">"
					+ d.getDepartname() + "</a></li>";
		}
		request.setAttribute("departmentDropdown", departmentDropdown);
		getServletContext().getRequestDispatcher("/DepartmentDisplay.jsp")
		.forward(request, response);
	}
}
