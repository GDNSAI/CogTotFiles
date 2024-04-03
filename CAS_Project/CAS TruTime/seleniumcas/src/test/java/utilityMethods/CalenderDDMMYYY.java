package utilityMethods;

import java.time.LocalDate;
import java.time.Month;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;

public class CalenderDDMMYYY {
	
	//retrieving current month
	public String localCurrentMonth() {

		int monthNumber = YearMonth.now().getMonthValue();
        String monthName = Month.of(monthNumber).name();
        
        monthName = monthName.toLowerCase();

        // Capitalize the first letter of the month
        monthName = monthName.substring(0, 1).toUpperCase() + monthName.substring(1);
 
        return monthName;
	}
	
	//retrieving current year
	public String localCurrentYear() {
		String currentYear = Integer.toString(YearMonth.now().getYear());
		return currentYear;
	}
	
	//formating date
	public String localHighlightedDayDateFormat() {	
		LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("E, dd MMM", Locale.ENGLISH);
        String formattedDate = currentDate.format(formatter);
        System.out.println(formattedDate);
        return formattedDate;
	}
	
	//formating week dates
	public ArrayList<String> localWeekDates() {		
		ArrayList<String> myDates = new ArrayList<String>();
		LocalDate currentDate = LocalDate.now();
        int dayOfWeek = currentDate.getDayOfWeek().getValue();
        LocalDate sundayOfCurrentWeek = currentDate.minusDays((dayOfWeek)%7);
        
        for(int i=0;i<7;i++) {
        	 LocalDate currentDateInWeek = sundayOfCurrentWeek.plusDays(i);
	         DateTimeFormatter formatter = DateTimeFormatter.ofPattern("E, dd MMM");
	         String formattedDate = currentDateInWeek.format(formatter);
	         myDates.add(formattedDate);
        }
        
        return myDates;
	}
	
	//retrieving date 15 days before 
	public String date15DaysBefore() {
		LocalDate today = LocalDate.now();
        LocalDate dateBefore15Days = today.minusDays(15);
        DateTimeFormatter formatterr = DateTimeFormatter.ofPattern("E, dd MMM", Locale.ENGLISH);
        String formatteddDate = dateBefore15Days.format(formatterr);
        System.out.println("Date 15 days before today: " + formatteddDate);
		
		return formatteddDate;
	}
	
}
