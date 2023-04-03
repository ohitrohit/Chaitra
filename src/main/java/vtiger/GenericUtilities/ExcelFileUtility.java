package vtiger.GenericUtilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * this class contain genric methods related to excile file
 * @author rohit
 *
 */
public class ExcelFileUtility {

	/**
	 * this method will read data from excel sheet based on row and cell value
	 * @param sheet
	 * @param row
	 * @param cel
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String readDataFromExcel(String sheet , int row , int cel) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(IContactsUtility.ExcelFilePath);
	    Workbook wb = WorkbookFactory.create(fis);
	    Sheet sh = wb.getSheet(sheet);
	    Row rw = sh.getRow(row);
	    Cell ce = rw.getCell(cel);
	    String value = ce.getStringCellValue();
	    wb.close();
		return value;
	}
	/**
	 *  this method will get the total rows utilised.
	 * @param sheet
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public int getRowCount(String sheet) throws EncryptedDocumentException, IOException {
		
		FileInputStream fis = new FileInputStream(IContactsUtility.ExcelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheet);
		int rowCount = sh.getLastRowNum();
		wb.close();
		return rowCount;
		
		
	}
	
	/**
	 * this method will write the data into the excel sheet.
	 * @param sheet
	 * @param row
	 * @param cel
	 * @param value
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public void writeDataIntoExcel(String sheet , int row ,int cel , String value) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(IContactsUtility.ExcelFilePath);
	    Workbook wb = WorkbookFactory.create(fis);
	    Row rw = wb.getSheet(sheet).getRow(row);
	    rw.createCell(cel).setCellValue(value);
	    
	    FileOutputStream fos = new FileOutputStream(IContactsUtility.ExcelFilePath);
	    wb.write(fos);
	    System.out.println(value+"--data added");
	    wb.close();
	}
	  /**
     * this methods will provide the multiple data in a single time
     * @param Sheetname
     * @return
     * @throws EncryptedDocumentException
     * @throws IOException
     */
    public Object[][] readMultipleData(String Sheetname) throws EncryptedDocumentException, IOException{
    	
    	FileInputStream fis = new FileInputStream(IContactsUtility.ExcelFilePath);
        Workbook wb = WorkbookFactory.create(fis);
        Sheet sh = wb.getSheet(Sheetname);
        int lastRow = sh.getLastRowNum();
        int lastCel = sh.getRow(0).getLastCellNum();
        
        Object[][] data = new Object[lastRow][lastCel];
        
        for(int i=0; i<lastRow;i++) {
        	for(int j=0; j<lastCel;j++) {
        		data[i][j]=sh.getRow(i+1).getCell(j).getStringCellValue();
        	}
        }
        return data;
    }
    
}
