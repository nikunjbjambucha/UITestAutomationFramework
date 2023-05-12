package DataProvider;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import com.relevantcodes.extentreports.LogStatus;

public class ReadCSV {

	//Old Normal function
	public static void ReadCSVData(String FileName) 
	{
		String CSV_File_Path = "./Data/"+ FileName +".csv";
		
		try 
		{
			// read the file
			Reader reader = Files.newBufferedReader(Paths.get(CSV_File_Path));
			
			// parse the file into csv values
			//CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);
			CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT
	                .withFirstRecordAsHeader()
	                .withIgnoreHeaderCase()
	                .withTrim());
			
			for (CSVRecord csvRecord : csvParser) 
			{
				// Accessing values by the names assigned to each column
				String username = csvRecord.get("Username");
				String Password = csvRecord.get("Password");
				System.out.println("Username: " + username);
				System.out.println("Password: " + Password);
			}
			
		} 
		catch (IOException e) 
		{
			System.out.println("The exception is: " +e.getMessage());
		}
	}
	
	
	
	public static String getvalue(CSVRecord csvRecord, String parameter) 
	{
		String value = null;
		try
		{
			value = csvRecord.get(parameter);
		}
		catch(Exception ex)
		{
		}
		return value;
	}
	
	public static TestDataRowTitle TestData(String FileName) 
	{
		String CSV_File_Path = "./Data/"+ FileName +".csv";
		TestDataRowTitle Testdatarow = new TestDataRowTitle();
		try 
		{
			// read the file
			Reader reader = Files.newBufferedReader(Paths.get(CSV_File_Path));
			
			// parse the file into csv values
			//CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);
			CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT
	                .withFirstRecordAsHeader()
	                .withIgnoreHeaderCase()
	                .withTrim());
			
			for (CSVRecord csvRecord : csvParser) 
			{
				// Accessing values by the names assigned to each column
				Testdatarow.Username = getvalue(csvRecord, "Uasername");
				Testdatarow.Password = getvalue(csvRecord, "Password");
				Testdatarow.Firstname = getvalue(csvRecord, "Firstname");
			}
			
		} 
		catch (IOException e) 
		{
			System.out.println("The exception is: " +e.getMessage());
		}
		return Testdatarow;
	}
	
}
