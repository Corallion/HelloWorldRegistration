package HelloWorldAssessment;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RegistrationPage")
public class RegistrationPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RegistrationPage() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pageName = request.getParameter("pageName");
		
		String firstName = request.getParameter("FirstName");
		String lastName = request.getParameter("LastName");
		String address1 = request.getParameter("Address1");
		String address2 = request.getParameter("Address2");
		String city = request.getParameter("City");
		String state = request.getParameter("State");
		String zip = request.getParameter("Zip");
		String country = request.getParameter("Country");
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		
		UserInformation user = new UserInformation();
		
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setAddress1(address1);
		user.setAddress2(address2);
		user.setCity(city);
		user.setState(state);
		user.setZip(zip);
		user.setCountry(country);
		user.setDate(dateFormat.format(date));
		
		
		try {
			ConnectionManager.Insert(user);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		if(pageName.equals("registration")){
			response.sendRedirect("ConfirmationPage.jsp");
		}		
	}
}
