package vtiger.GenericUtilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * this class consists of generic methods to read data from properties file
 * @author rohit
 *
 */
public class PropertyFileUtility {
/**
 * this methods will read data from property file
 * @param key
 * @return
 * @throws IOException
 */
	public String readDataFromPropertyFile(String key) throws IOException {
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties pObj = new Properties();
		pObj.load(fis);
		String value = pObj.getProperty(key);
		return value;
		
	}
}
