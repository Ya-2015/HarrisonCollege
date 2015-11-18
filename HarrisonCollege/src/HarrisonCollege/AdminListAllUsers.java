package HarrisonCollege;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Huser;
import HarrisonCollegeDB.CollegeDB;

/**
 * Servlet implementation class AdminListAllUsers
 */
@WebServlet("/AdminListAllUsers")
public class AdminListAllUsers extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public AdminListAllUsers() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processListAllUsers(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processListAllUsers(request,response);
	}

    protected void processListAllUsers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	CollegeDB  db= new CollegeDB();
    	ArrayList<Huser> allUsers=db.getAllUsers();
    	request.setAttribute("AllUsers",allUsers);
    	getServletContext().getRequestDispatcher("/AllUsersList.jsp").forward(request, response);
	}
}
