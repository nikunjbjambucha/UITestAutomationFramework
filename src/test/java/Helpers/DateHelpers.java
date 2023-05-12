package Helpers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateHelpers {
	
	static LocalDate today =  LocalDate.now();
	
	public static String TodayDate() {
		
		DateTimeFormatter format = DateTimeFormatter.ofPattern("d/MM/uuuu");
		String Date = today.format(format);
		
		return Date;
	}
	
	public static String AddDaysToTodayDate(int addDays) {
		
		LocalDate tomorrow = today.plusDays(addDays);    //it will add Days
		DateTimeFormatter formatt = DateTimeFormatter.ofPattern("d/MM/uuuu");
		String Date = tomorrow.format(formatt);

		return Date;
	}
	
	public static String SubstractDaysToTodayDate(int minusDays) {
		
		LocalDate yesterday = today.minusDays(minusDays);  //it will minus the days
		DateTimeFormatter formattt = DateTimeFormatter.ofPattern("d/MM/uuuu");
		String Date = yesterday.format(formattt);
		
		return Date;
	}

}