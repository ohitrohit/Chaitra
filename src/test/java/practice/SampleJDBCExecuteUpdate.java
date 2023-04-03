package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBCExecuteUpdate {


	public static void main(String[] args) throws SQLException {
		
		Connection con =null;
		
		try {
		Driver driverRef = new Driver();
		
		DriverManager.registerDriver(driverRef);
		
		con = DriverManager.getConnection("jdbc:mysql://localhost:3307/wasa3db","root","root");
		
		Statement state = con.createStatement();
		
		String query = "insert into candidateinfo values('sid',28,'banglore');";
		int result = state.executeUpdate(query);
		
		if(result>=1)
		{
			System.out.println("data added");
		}
		
		ResultSet result1 = state.executeQuery("select * from candidateinfo;");
		
		while(result1.next())
		{
			System.out.println(result1.getString(1));
		}
		}
		finally{
		con.close();
		System.out.println("db closed");
		}
	}
}
