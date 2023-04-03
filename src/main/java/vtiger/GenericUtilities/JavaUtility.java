package vtiger.GenericUtilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
/**
 * this class contains all the generic methods related to java
 * @author rohit
 *
 */
public class JavaUtility {
    /**
     * this method provide date and time
     * @return
     */
	public String getStringDate() {
		Date d = new Date();
		return d.toString();
	}
	/**
	 * this method provide date and time in a proper format
	 * @return
	 */
	public String getSystemDateInFormat() {
		
		Date d = new Date();
		SimpleDateFormat date = new SimpleDateFormat("dd/MM/YYYY hh.mm a");
		String finalDate = date.format(d);
		return finalDate;
	}
	/**
	 * this method will return a random number for every run
	 * @return
	 */
	public int getRandomNumber() {
		Random r = new Random();
		return r.nextInt(1000);
	}
}
