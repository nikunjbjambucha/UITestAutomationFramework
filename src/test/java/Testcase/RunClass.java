package Testcase;

import org.testng.TestNG;

public class RunClass {

	static TestNG testng;
	
	public static void main(String[] args) {
		
		testng = new TestNG();
		testng.setTestClasses(new Class[] {Testsuite1.class});
		testng.run();
	}

}
