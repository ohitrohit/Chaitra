package practice;


import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGPrcatice4 {

	@Test
	public void createUser() {
		System.out.println("create User");
		Assert.fail();
	}
	
	@Test(dependsOnMethods = "createUser")
	public void deleteUser() {
	
		System.out.println("delete User");
	}
	
	@Test()
	public void updateUser() {
		
		System.out.println("update User");
	}
}
