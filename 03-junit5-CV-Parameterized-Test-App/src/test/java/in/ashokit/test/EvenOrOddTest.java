package in.ashokit.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import in.ashokit.beans.EvenOrOdd;

public class EvenOrOddTest {

	//@test execute only one time,@ParameterizedTest(executes for all inputs)
	//is used to test for all the parameters cmg from @ValueSource
	
	@ParameterizedTest
	//i want to takhe input for test method from csv file(csv means comma seperated value) first row contain meta data
	@CsvFileSource(resources ="/data.csv", numLinesToSkip = 1)
	public void evenOrOddTest(String input,String expected)
	{
		System.out.println(input);
		EvenOrOdd eoo=new EvenOrOdd();
		//from xl input is cmg as string so convert it to integer
		String actual = eoo.evenOrOddNo(Integer.parseInt(input));
		assertEquals(expected, actual);;
	}
}
