package vTiger.Organizations;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vtiger.GenericUtilities.BaseClass;
import vtiger.ObjectRepository.CreateNewOrganizationPAge;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.OrganizationInfoPage;
import vtiger.ObjectRepository.OrganizationPage;


@Listeners(vtiger.GenericUtilities.ListenersImplementation.class)
public class CreateOrganizationFinalScriptTest extends BaseClass{

	@Test(groups = "smokesuite")
	public void createOrg() throws EncryptedDocumentException, IOException {
	String ORGNAME = eUtil.readDataFromExcel("Organizations", 1, 2)+jUtil.getRandomNumber();
	
	HomePage hp = new HomePage(driver);
    hp.clickOnOrganizationLink();
    Reporter.log("click on organization link successfully");
    
    OrganizationPage op = new OrganizationPage(driver);
    op.clickOnCreateNewOrgLookUp();
    Reporter.log("click on create new organization link successfully");
    
    CreateNewOrganizationPAge cnop = new CreateNewOrganizationPAge(driver);
    cnop.CreateOrganization(ORGNAME);
    Reporter.log("orgnization created  successfully");
    
    OrganizationInfoPage oip = new OrganizationInfoPage(driver);
    String OrgHeader = oip.getOrgHeader();
    Assert.assertTrue(OrgHeader.contains(ORGNAME));
    System.out.println(OrgHeader+" --- Organization created");
}
	
	@Test(groups = "regressionsuite")
	
	public void demoSuite() {
		System.out.println("demo suite");
	}
	
	@Test
	
	public void regionaltesting() {
		System.out.println("regional testing");
		
		
	}
}
