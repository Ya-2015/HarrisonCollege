package HarrisonCollege;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Hclass;
import model.Hstudent;
import HarrisonCollegeDB.CollegeDB;




@WebServlet("/enrollInsert")
public class enrollInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public enrollInsert() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processenrollInsert(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processenrollInsert(request,response);
	}

	private void processenrollInsert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		CollegeDB  db= new CollegeDB();
		String strstudentnum = request.getParameter("studentNumber");
		String strEnrollClass = request.getParameter("enrolledclass");
		
		int studentNum =Integer.parseInt(strstudentnum);
		int classnum=Integer.parseInt(strEnrollClass);

		Hstudent stu = db.getStudentProfileByStuNum(studentNum);
		Hclass enrollClass=db.getClassById(classnum);
		boolean enrollFlag=db.enrollClass(classnum, studentNum); 
		request.setAttribute("EnrollFlag",enrollFlag);
		if (enrollFlag==true){
			
			request.setAttribute("studentInfo",stu);
			request.setAttribute("Enrolledclass", enrollClass);
			getServletContext().getRequestDispatcher("/Enrollconfirmation.jsp").forward(request, response);
		
		
		}else{
			
			request.getRequestDispatcher("/Enrollconfirmation.jsp").forward(request, response);
		
			
		}
		
	}
}
