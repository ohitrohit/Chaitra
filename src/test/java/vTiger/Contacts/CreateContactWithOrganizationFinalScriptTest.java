package vTiger.Contacts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vtiger.GenericUtilities.BaseClass;
import vtiger.ObjectRepository.ContactInfoPage;
import vtiger.ObjectRepository.ContactsPage;
import vtiger.ObjectRepository.CreateNewContactPage;
import vtiger.ObjectRepository.CreateNewOrganizationPAge;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.OrganizationInfoPage;
import vtiger.ObjectRepository.OrganizationPage;

@Listeners(vtiger.GenericUtilities.ListenersImplementation.class)
public class CreateContactWithOrganizationFinalScriptTest extends BaseClass {

	@Test(groups = "regressionsuite")
	public void createContactWithOrg() throws EncryptedDocumentException, IOException {
		    String ORGNAME = eUtil.readDataFromExcel("Contacts", 4, 2)+jUtil.getRandomNumber();
	        String LASTNAME = eUtil.readDataFromExcel("Contacts", 4, 3);
	        
	        HomePage hp = new HomePage(driver);
	        hp.clickOnOrganizationLink();
	        
	        OrganizationPage op = new OrganizationPage(driver);
	        op.clickOnCreateNewOrgLookUp();
	        
	        CreateNewOrganizationPAge cnop = new CreateNewOrganizationPAge(driver);
	        cnop.CreateOrganization(ORGNAME);
	        
	        OrganizationInfoPage oip = new OrganizationInfoPage(driver);
	        String OrgHeader = oip.getOrgHeader();
	        Assert.assertTrue(OrgHeader.contains(ORGNAME));
	        System.out.println(OrgHeader+" --- Organization created");
	       
	        hp.clickOnContactsLink();
	        
	        ContactsPage cp = new ContactsPage(driver);
	        cp.clickOnCreateNewContactIcon();
	        
	        CreateNewContactPage cncp = new CreateNewContactPage(driver);
	        cncp.CreateNewContact(driver, LASTNAME, ORGNAME);
	        
	        ContactInfoPage cip = new ContactInfoPage(driver);
	        String getContactHeader = cip.getContactPageHeaderText();
	        Assert.assertTrue(getContactHeader.contains(LASTNAME));
	        System.out.println(getContactHeader+" --- Contact created ");        
	}
}
