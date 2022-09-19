package in.ashokit.test;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import in.ashokit.beans.PalindromeCheck;

public class PalindromeTest {

	//@test execute only one time,@ParameterizedTest(executes for all inputs)
	//is used to test for all the parameters cmg from @ValueSource
	
	@ParameterizedTest
	@ValueSource(strings= {"racecar","radar","madam","liril"})
	public void testIsPalindrome(String str)
	{
		PalindromeCheck pc=new PalindromeCheck();
		boolean actual = pc.ispalindrome(str);
		assertTrue(actual);
	}
}
