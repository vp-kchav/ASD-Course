package project.ccard;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateManager {
	private Calendar startDate;
    private Calendar endDate;
    
    public DateManager(Date startDate, Date endDate)
    {
        this.startDate = new GregorianCalendar();
        this.startDate.setTime(startDate);
        
        this.endDate = new GregorianCalendar();
        this.endDate.setTime(endDate);
    }
    
    /**
     * Check whether a given Date is in the date range represented by this 
     * object
     */
    public boolean isInRange(Date date)
    {
        Calendar newDate = new GregorianCalendar();
        newDate.setTime(date);
        
        if (newDate.compareTo(startDate) >= 0 &&
            newDate.compareTo(endDate) <= 0)
        {
            return true;
        }
        return false;
    }
    
    /**
     * Returns a string in the form "Dec 1, 2012 - Dec 31, 2012"
     */
    public String toString()
    {
        DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);
        String dateRangeStr = df.format(startDate.getTime()) + " - " + 
                              df.format(endDate.getTime());   
        return dateRangeStr;
    }
    
    /**
     * Returns the date of the first day of the same month as "anyDate".
     */
    public static Date getFirstDayOfMonth(Date anyDate)
    {
        Calendar firstDayOfMonth = new GregorianCalendar();
        firstDayOfMonth.setTime(anyDate);
        firstDayOfMonth.set(Calendar.DAY_OF_MONTH, 1);
        return firstDayOfMonth.getTime();
    }

    /**
     * Returns the date of the last day of the same month as "anyDate".
     */
    public static Date getLastDayOfMonth(Date anyDate)
    {
        Calendar lastDayOfMonth = new GregorianCalendar();
        lastDayOfMonth.setTime(anyDate);
        lastDayOfMonth.set(Calendar.DAY_OF_MONTH, 
                lastDayOfMonth.getActualMaximum(Calendar.DAY_OF_MONTH));
        return lastDayOfMonth.getTime();  
    }
    
    
    public static Date subToDate(Date anyDate){		
		
		Calendar c1 = Calendar.getInstance(); 		
		
		c1.set(anyDate.getYear()+1900, anyDate.getMonth() , anyDate.getMonth()); 		
		
		c1.add(Calendar.MONTH, -1); 		// substract 1 month		
			
    	return c1.getTime();
    	
    }

}
