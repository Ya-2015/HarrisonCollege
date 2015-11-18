package HarrisonCollege;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import HarrisonCollegeDB.CollegeDB;

/**
 * Servlet implementation class realDrop
 */
@WebServlet("/realDrop")
public class realDrop extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public realDrop() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProcessDrop(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProcessDrop(request,response);
	}
	
   protected void ProcessDrop(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   String strstudentnum = request.getParameter("studentNUM");
	   String strclassnum=request.getParameter("classNUM");
	   int StudentNum =Integer.parseInt(strstudentnum);
	   int ClassNum =Integer.parseInt(strclassnum);
		CollegeDB  db= new CollegeDB();
		boolean  drop=db.unenrollClass(ClassNum, StudentNum);
		
		request.setAttribute("Dropflag", drop);
	
	try {
		getServletContext().getRequestDispatcher("/Dropconfirmation.jsp").forward(request, response);
	} catch (ServletException e) {
		
		e.printStackTrace();
	} catch (IOException e) {
		
		e.printStackTrace();
	}
	}

}
