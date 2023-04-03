package vTiger.Organizations;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import vtiger.GenericUtilities.BaseClass;
import vtiger.ObjectRepository.CreateNewOrganizationPAge;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.OrganizationInfoPage;
import vtiger.ObjectRepository.OrganizationPage;

public class CreateOrgWithMultipleDataUsingDataProvider extends BaseClass{

	@Test(dataProvider = "Rohit")
	
	public void createOrgWithMultipleData(String Org ,String INDUSTRY ) {
		
		String ORGNAME = Org+jUtil.getRandomNumber();
		HomePage hp = new HomePage(driver);
		hp.clickOnOrganizationLink();
		
		OrganizationPage op =new OrganizationPage(driver);
		op.clickOnCreateNewOrgLookUp();
		
		CreateNewOrganizationPAge cnop = new CreateNewOrganizationPAge(driver);
		cnop.CreateOrganization(ORGNAME, INDUSTRY);
		
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String OrgHeader = oip.getOrgHeader();
		Assert.assertTrue(OrgHeader.contains(ORGNAME));
	}
	
	@DataProvider(name="Rohit")
	public Object[][] getData() throws EncryptedDocumentException, IOException{
		Object[][] data = eUtil.readMultipleData("Multiple");
		return data;
	}
}
