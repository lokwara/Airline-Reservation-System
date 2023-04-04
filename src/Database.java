//import java library
import java.sql.*;
import java.sql.Connection;

public class Database {

	public static Connection mycon()
	{
		Connection con = null;
		try{
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/registeration","root","");
		} catch (ClassNotFoundException | SQLException e)
		{
			System.out.println(e);
		}
		return con;
	}
}

