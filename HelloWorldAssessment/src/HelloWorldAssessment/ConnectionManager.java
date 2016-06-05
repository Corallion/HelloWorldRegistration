package HelloWorldAssessment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ConnectionManager {

	private final static String username1 = "root";
	private final static String password1 = "VTMngp76412";
	private final static String connection1URL = "jdbc:mysql://mysql12906-HellowWorldAssessment.dal.jelastic.vps-host.net/HelloWorldRegistrationAssessment";
	
	private final static String username2 = "root";
	private final static String password2 = "VM0xQqe1l6";
	private final static String connection2URL = "jdbc:mysql://mysql12913-RegisteredUserReport.dal.jelastic.vps-host.net/HelloWorldRegistrationAssessment";

	private static Connection registerSiteConnection = null;
	private static Connection adminSiteConnection = null;
	
	public ConnectionManager(){
		super();
	}
	
	// Create a connection to the Registration site
	private static boolean openConnection1(){
		try {
			registerSiteConnection = DriverManager.getConnection(connection1URL, username1, password1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return true;
	}
		
	public static Connection getConnection1(){
		if(registerSiteConnection == null)
		{
			if(openConnection1())
			{
				return registerSiteConnection;
			}
			else
			{
				return null;
			}
		}
		
		return registerSiteConnection;
	}	
	
	public static void closeConnection1(){		
		try {
			registerSiteConnection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		registerSiteConnection = null;
	}
	
	// Create a connection to the Admin site
	private static boolean openConnection2(){
		try {
			adminSiteConnection = DriverManager.getConnection(connection2URL, username2, password2);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return true;
	}
	
	public static Connection getConnection2(){
		if(adminSiteConnection == null)
		{
			if(openConnection2())
			{
				System.out.println("OPEN");
				return adminSiteConnection;
			}
			else
			{
				return null;
			}
		}
		
		return adminSiteConnection;
	}
	
	public static void closeConnection2(){	
		try {
			adminSiteConnection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		adminSiteConnection = null;
	}
	
	public static void Insert(UserInformation user) throws ClassNotFoundException, SQLException{
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		getConnection1();
		getConnection2();
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		
		String sql = "insert into registereduserreport (FirstName, LastName, Address1, Address2, City, State, Zip, Country, Date) values (?,?,?,?,?,?,?,?,?)";

		// Send the registration information to the database on each site
		PreparedStatement stmt = registerSiteConnection.prepareStatement(sql);
		PreparedStatement stmt2 = adminSiteConnection.prepareStatement(sql);
		
		stmt.setString(1, user.getFirstName());
		stmt.setString(2, user.getLastName());
		stmt.setString(3, user.getAddress1());
		stmt.setString(4, user.getAddress2());
		stmt.setString(5, user.getCity());
		stmt.setString(6, user.getState());
		stmt.setString(7, user.getZip());
		stmt.setString(8, user.getCountry());
		stmt.setString(9, dateFormat.format(date));
		stmt.execute();
		
		stmt2.setString(1, user.getFirstName());
		stmt2.setString(2, user.getLastName());
		stmt2.setString(3, user.getAddress1());
		stmt2.setString(4, user.getAddress2());
		stmt2.setString(5, user.getCity());
		stmt2.setString(6, user.getState());
		stmt2.setString(7, user.getZip());
		stmt2.setString(8, user.getCountry());
		stmt2.setString(9, dateFormat.format(date));
		stmt2.execute();

		closeConnection1();
		closeConnection2();
	}
}
