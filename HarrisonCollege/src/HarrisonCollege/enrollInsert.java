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

	private void processenrollInsert(HttpServletRequest request, HttpServletResponse response){
		CollegeDB  db= new CollegeDB();
		String strstudentnum = request.getParameter("studentNumber");
	    int  classnum =3;
		
		int studentNum =Integer.parseInt(strstudentnum);
		

		Hstudent stu = db.getStudentProfileByStuNum(studentNum);
		Hclass enrollClass=db.getClassById(classnum);
		if (stu!=null){
			db.enrollClass(classnum, studentNum); //3=CLASSNUM NEED TO PASS
			request.setAttribute("studentInfo",stu);
			request.setAttribute("Enrolledclass", enrollClass);
		
		try {
			getServletContext().getRequestDispatcher("/Enrollconfirmation.jsp").forward(request, response);
		} catch (ServletException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		}else{
			System.out.println("Student not exit");
		}
		
	}
}
