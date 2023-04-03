package practice;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Program1  {
	
	     
		public static void main(String[] args) {
				
			Date d = new Date();
			SimpleDateFormat date = new SimpleDateFormat("dd/MMMM/YYYY hh.mm a");
			System.out.println(date.format(d));
			
		}
		
		
}

	

