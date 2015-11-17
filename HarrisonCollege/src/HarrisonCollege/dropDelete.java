package HarrisonCollege;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		try {
			getServletContext().getRequestDispatcher("/Dropconfirmation.jsp").forward(request, response);
		} catch (ServletException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}

}
