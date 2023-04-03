package practice;

import org.testng.annotations.Test;

public class TestNGPractice3 {

	@Test(invocationCount = 2, priority = 2)
	public void createUser() {
		System.out.println("create User");
	}
	
	@Test(invocationCount = 5)
	public void deleteUser() {
	
		System.out.println("delete User");
	}
	
	@Test(invocationCount = 7)
	public void updateUser() {
		
		System.out.println("update User");
	}
}
