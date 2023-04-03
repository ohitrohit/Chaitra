package practice;

import org.testng.annotations.Test;

public class TestNgPractice5 {

	@Test(enabled = false)
	public void createUser() {
		System.out.println("create User");
	}
	
	@Test
	public void deleteUser() {
	
		System.out.println("delete User");
	}
	
	@Test
	public void updateUser() {
		
		System.out.println("update User");
	}
}
