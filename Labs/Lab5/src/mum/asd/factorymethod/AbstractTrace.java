package mum.asd.factorymethod;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AbstractTrace {
	private boolean debug = false;
	
	public boolean isDebug() {
		return debug;
	}
	
	public void isDebug(boolean debug) {
		this.debug = debug;
	} 
	
	public  String getCurrentDatetime() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		return dateFormat.format(date);
	}
	

}
