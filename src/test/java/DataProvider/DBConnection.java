package DataProvider;
import DataProvider.ConfigFileReader;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Date;

import org.openqa.selenium.WebDriver;

import com.mongodb.connection.Connection;
import com.mysql.cj.xdevapi.Statement;
import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;


import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.sql.DriverManager;
import java.sql.ResultSet;


public class DBConnection {  
    
	/* ------------- Database Connection ------------------- */
	static ConfigFileReader configFileReader= new ConfigFileReader();
	public static String DBString = configFileReader.getPropertyvalue("DBString");
	public static String DBName = configFileReader.getPropertyvalue("DBName");
	public static String DBPort = configFileReader.getPropertyvalue("DBPort");
	public static String DBUser = configFileReader.getPropertyvalue("DBUser");
	public static String DBPassword = configFileReader.getPropertyvalue("DBPassword");
	
    // Connection object
    public static Connection con = null; 
    
    // Statement object
    public static java.sql.Statement stmt;
    
    // Constant for Database URL
    public static String DB_URL = "jdbc:mysql://"+DBString+":"+DBPort+"/"+DBName;
    
    //Database Username
    public static String DB_USER = DBUser;
    
    // Database Password
    public static String DB_PASSWORD = DBPassword;
    
    public static void DBconnection() throws Exception{
    	
    	try{
    		// Database connection
    		String dbClass = "com.mysql.cj.jdbc.Driver";
    		Class.forName(dbClass).newInstance();
    		
    		// Get connection to DB
    		java.sql.Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    		System.out.println("Connection Established");
    		
    		// Statement object to send the SQL statement to the Database
    		stmt = con.createStatement();
    		}
    		catch (Exception e)
    		{
    		e.printStackTrace();
    		}
    }
	
    public static String GetData_ByNumber(String Query) 
    {
    	try 
    	{
    		
    		ResultSet rs = stmt.executeQuery(Query);
    		String data = null;
    		while (rs.next())
    		{
    			data = rs.getString(1);
    		}
    		return data;
			
		} 
    	catch (SQLException e) {
			e.printStackTrace();
			return "Data Not Found";
		}
    	
    }
    
    public static String GetData_ByName(String Query, String ColumanName) 
    {
    	try 
    	{
    		
    		ResultSet rs = stmt.executeQuery(Query);
    		String data = null;
    		while (rs.next())
    		{
    			data = rs.getString(ColumanName);
    		}
    		return data;
			
		} 
    	catch (SQLException e) {
			e.printStackTrace();
			return "Data Not Found";
		}
    	
    }
    
    public static String[][] Data;
	
	public static void GetDataFromDB(String[] ParameterName,String Tradeid) 
	{
		String[][] Data = new String[2][ParameterName.length];
		Data[0]=ParameterName;

		for(int i =0; i<ParameterName.length;i++) 
		{
			String UpdatedQuery = "Select "+ParameterName[i]+" from vw_ticket_getall where TradeID='"+Tradeid+"';";
			//String Query = "Select DealId, Strike, BaseCurrencyAbbreviation, TermCurrencyAbbreviation, DeliveryDate, TradeID, NotionalCurrency, Cut from vw_ticket_getall where TradeID='10107';";
			Data[1][i]= DBConnection.GetData_ByName(UpdatedQuery, ParameterName[i]);
			System.out.println(" "+Data[0][i]+" : "+Data[1][i]);
			
		}
	}
	
	public static String Getvalue(String parameter) 
	{
		return Data[1][Arrays.asList(Data[0]).indexOf(parameter)];
	}
	
	
}