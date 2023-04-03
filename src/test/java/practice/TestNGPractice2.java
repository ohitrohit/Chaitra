package practice;

import org.testng.annotations.Test;

public class TestNGPractice2 {

	@Test(priority=3)
	public void createUser() {
		System.out.println("create User");
	}
	
	@Test(priority=1)
	public void deleteUser() {
	
		System.out.println("delete User");
	}
	
	@Test(priority=-1)
	public void updateUser() {
		
		System.out.println("update User");
	}
}
