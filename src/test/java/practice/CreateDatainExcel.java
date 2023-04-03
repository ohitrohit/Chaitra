package practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class CreateDatainExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		//step1: open the document in java readable format
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
        
		//step2: create a workbook
		Workbook wb = WorkbookFactory.create(fis);
		
		//step3: get control of sheet
		Sheet sh = wb.getSheet("Contacts");
		
		//step4: get control of row
		Row rw = sh.getRow(1);
		
		//step5: Create a cell in that row
		Cell ce = rw.createCell(5);
		
		//Step6: set the value to the cell
		ce.setCellValue("wasa");
		
		//step7: open the ducoment in write mode
		FileOutputStream fos = new FileOutputStream(".\\src\\test\\resources\\TestData.xlsx");
	
		//step8: write the data
	    wb.write(fos);
	    System.out.println("kam katm check");
	    
	    wb.close();
	}
}
