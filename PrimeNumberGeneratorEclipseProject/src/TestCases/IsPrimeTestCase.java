package TestCases;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Implementation.JacobsPrimeNumberGenerator;
import Implementation.PrimeNumberGenerator;

public class IsPrimeTestCase
{
	PrimeNumberGenerator primeNumberGenerator;
	
	//We'll set this up before each test
	@Before
	public void setUp()
	{
		//Let's create a primeNumberGenerator using JacobsPrimeNumberGenerator implementation for use with these tests
		primeNumberGenerator = new JacobsPrimeNumberGenerator();
	}
	
	//Test to make sure isPrime returns false for numbers less than 2.
	//For good measure we will test -5,0,1 (negative numbers, 0, and 1 are not considered to be prime)
	@Test
	public void LessThan2Test()
	{
		//Let's test -5		
		assertFalse(primeNumberGenerator.isPrime(-5));
		//Let's test 0		
		assertFalse(primeNumberGenerator.isPrime(0));
		//Let's test 1		
		assertFalse(primeNumberGenerator.isPrime(1));	
	}
	
	//Test to make sure identifying a prime in the loop works
	@Test
	public void isPrimeTest()
	{
		//Let's test 2, it's the first prime and a special case since it won't enter the loop once, since 2 is > 2/2.
		assertTrue(primeNumberGenerator.isPrime(2));
		//Let's test 11, it will go a few cycles through the loop
		assertTrue(primeNumberGenerator.isPrime(11));
	}
	
	//Test to make sure identifying a composite in the loop works
	@Test
	public void isNotPrimeTest()
	{
		//Let's test 4, it's the first non prime after 2, and is a special case as it only has 1 additional factor, '2' (2x2=4)
		assertFalse(primeNumberGenerator.isPrime(4));		
		//Let's test 15, it doesn't have 2 as a factor, so it will go through the loop more than 1 time. (3x5=15)
		assertFalse(primeNumberGenerator.isPrime(15));
	}	
}
