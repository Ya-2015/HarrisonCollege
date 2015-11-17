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
import model.Product;
import model.Productreview;
import HarrisonCollegeDB.CollegeDB;
import amazon.AmazonDB;

/**
 * Servlet implementation class CourseExplorerMainServlet
 */
@WebServlet("/CourseExplorerMainServlet")
public class CourseExplorerMainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CourseExplorerMainServlet() {
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
		int j=0;
		double avgRating =0;
		HttpSession session = request.getSession();
		String departmentDropdown = "";
		ArrayList<Hdepartment> depar = uDB.getAllDepartments();
		for (Hdepartment d : depar){
			departmentDropdown = departmentDropdown + "<div class = \"row\"<br><td>" + dataset.getProdbrand()
					+ "</td><td>" + dataset.getProdname() + "</td><td>"
					+ dataset.getProddescription() + "</td><td>"
					+ dataset.getProdcost() + "</td>" + "</div>";	
		}
		
		
		String message2 = "";
		

		if (dataset2 != null) {
			for(j = 0; j< dataset2.size(); j++) {
				message2 = message2 + "<div <br><tr><td>"
						+ dataset2.get(j).getCustomerusername() + "</td><td>"
						+ dataset2.get(j).getCustrating() + "</td><td>"
						+ dataset2.get(j).getCustreview() + "</td><td>"
						+ "</tr></div>";
				avgRating = avgRating + dataset2.get(j).getCustrating().doubleValue();
			}
		} else
			message2 = "<h4> There Are No Reviews Yet</h4>";

		request.setAttribute("message", message);
		request.setAttribute("message2", message2);
		request.setAttribute("avgRating", (avgRating/j));
		request.setAttribute("url", dataset.getImageLink());
		getServletContext().getRequestDispatcher("/ProdPage.jsp").forward(
				request, response);
	}
}
