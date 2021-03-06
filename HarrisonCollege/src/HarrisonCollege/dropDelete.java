package HarrisonCollege;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Hclass;
import model.Hstudent;
import HarrisonCollegeDB.CollegeDB;

/**
 * Servlet implementation class dropDelete
 */
@WebServlet("/dropDelete")
public class dropDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public dropDelete() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processdropDelete(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processdropDelete(request,response);
	}
	private void processdropDelete(HttpServletRequest request, HttpServletResponse response){
		CollegeDB  db= new CollegeDB();
		String strstudentnum = request.getParameter("studentNumber");

			
		int studentNum =Integer.parseInt(strstudentnum);
		Hstudent stu = db.getStudentProfileByStuNum(studentNum);

		ArrayList<Hclass> currentClass = db.getClassByStudentBySemester(studentNum,1);
		if (stu!=null){
			request.setAttribute("studentInfo",stu);
			request.setAttribute("studentCurrentClass",currentClass);
			
		
		try {
			getServletContext().getRequestDispatcher("/dropOptions.jsp").forward(request, response);
		} catch (ServletException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}

}
}
