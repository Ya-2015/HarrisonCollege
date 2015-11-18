package HarrisonCollege;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Hclass;
import HarrisonCollegeDB.CollegeDB;



/**
 * Servlet implementation class advisorServlet
 */
@WebServlet("/advisorServlet")
public class advisorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public advisorServlet() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action.equals("Transcript")){
		processTranscript(request,response);}
		
		else if(action.equals("Enroll")){
		processEnroll(request,response);}
		else if(action.equals("Drop")){
		processDrop(request,response);}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
	

	protected void processTranscript(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		getServletContext()
     	.getRequestDispatcher("/transcript.jsp")
     		.forward(request, response);
		
	}
	
	protected void processEnroll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*EntityManager em = HarrisonCollege.DBUtil.getEmFactory().createEntityManager();
		String qString = "select p from Product p ";
		TypedQuery<Product> q = em.createQuery(qString, Product.class);
	
		
		List<Product> productPool = null;
		
		String tableinfo  = "";
		try{
			productPool=q.getResultList();

			
			for(int i=0;i<productPool.size();i++){
			
			we need go from all the classes to the student information then enrolll 
		tableinfo += "<tr><td>" + productPool.get(i).getProductId()+"</td><td>" + productPool.get(i).getProductName() + "</td><td>" + productPool.get(i).getProductPrice()+ "</td><td><a href=\"http://localhost:8080/HarrisonCollege/enrollInsert?productId="+  productPool.get(i).getProductId() + "\">Enroll</a></td></tr>";
		
			
			}
			}
			catch (Exception e)
			{
				System.out.println(e);
			}
			finally{
				em.close();
				System.out.println("end of product pools");
			}
			
			
			
			
			
			
			
		*/
		//request.setAttribute("tableinfo", tableinfo);
		
		getServletContext()
     	.getRequestDispatcher("/enroll.jsp")
     		.forward(request, response);
		
	}
	protected void processDrop(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CollegeDB studentSchedule= new CollegeDB();
		ArrayList<Hclass> hClass=studentSchedule.getClassByStudentBySemester(1, 1);
		
		getServletContext()
     	.getRequestDispatcher("/drop.jsp")
     		.forward(request, response);
		
	}
	
	


}
