package TestCases;

import static org.junit.Assert.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.*;
import Implementation.*;

public class PrimeFactorConsoleApplicationTestCase {

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

	@Before
	public void setUp() {
		//Set up new out stream, this will allow us to capture the console output so we can check to make sure it is what we expect
	    System.setOut(new PrintStream(outContent));
	}
	
	//Test 0 parameters passed
	@Test
	public void zeroParametersPassedTest() {
		String[] args = new String[0];
		PrimeFactorConsoleApplication.main(args);
		String expectedOut = "Error, expecting 2 arguments: int startingValue, int endingValue\n";
		//Make sure the outContent equals the expected out content, but we'll trim them as we don't care if the white space isn't exactly the same
		assertEquals(expectedOut.trim(), outContent.toString().trim());
	}
	
	//Test 2 parameters passed, but first is not an acceptable integer
	@Test
	public void firstParameterExceptionTest() {
		String[] args = {"a","10"};
		PrimeFactorConsoleApplication.main(args);
		String expectedOut = "Error, could not Parse starting Value, please ensure starting value is an integer.";
		//Make sure the outContent equals the expected out content, but we'll trim them as we don't care if the white space isn't exactly the same
		assertEquals(expectedOut.trim(), outContent.toString().trim());
	}
	
	//Test 2 parameters passed, but second is not an acceptable integer
	@Test
	public void secondParameterExceptionTest() {
		String[] args = {"1","2$"};
		PrimeFactorConsoleApplication.main(args);
		String expectedOut = "Error, could not Parse endingValue Value, please ensure starting value is an integer.";
		//Make sure the outContent equals the expected out content, but we'll trim them as we don't care if the white space isn't exactly the same
		assertEquals(expectedOut.trim(), outContent.toString().trim());
	}
	
	//Test 2 Parameters passed, both acceptable integers
	@Test
	public void TwoAcceptableParametersTest() {
		String[] args = {"1","11"};
		PrimeFactorConsoleApplication.main(args);
		String expectedOut = "Generated primes between 1 and 11 inclusive: [2, 3, 5, 7, 11]";
		//Make sure the outContent equals the expected out content, but we'll trim them as we don't care if the white space isn't exactly the same
		assertEquals(expectedOut.trim(), outContent.toString().trim());
	}


}