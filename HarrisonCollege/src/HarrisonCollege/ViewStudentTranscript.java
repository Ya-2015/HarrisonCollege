package HarrisonCollege;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Henrollment;
import model.Hstudent;
import model.Huser;
import HarrisonCollegeDB.CollegeDB;

/**
 * Servlet implementation class ViewStudentTranscript
 */
@WebServlet("/ViewStudentTranscript")
public class ViewStudentTranscript extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ViewStudentTranscript() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processViewStudentTranscript(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processViewStudentTranscript(request,response);
	}
	
   protected void processViewStudentTranscript(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	CollegeDB  db= new CollegeDB();
	int StudentNum =0;
	HttpSession session = request.getSession();
	if((Integer) session.getAttribute("usercode")==3)
	{
		String strstudentnum = request.getParameter("studentNUM");
	 StudentNum =Integer.parseInt(strstudentnum);
	}
	else if ((Integer) session.getAttribute("usercode")==1)
	{
			
		   StudentNum =(Integer) session.getAttribute("studentNumber");
	}
	else
	{
		try {
			getServletContext().getRequestDispatcher("UserClassRedirectorServlet").forward(request, response);
		} catch (ServletException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
		
	Hstudent stu = db.getStudentProfileByStuNum(StudentNum);
	ArrayList<Henrollment> aStudentTranscript=db.getTranscriptByStudentNum(StudentNum);
	
	if (stu!=null){
		request.setAttribute("studentInfo",stu);
		request.setAttribute("TheStudentTranscript",aStudentTranscript);
	
	try {
		getServletContext().getRequestDispatcher("/transcript.jsp").forward(request, response);
	} catch (ServletException e) {
		
		e.printStackTrace();
	} catch (IOException e) {
		
		e.printStackTrace();
	}
	
}

   }	
}
