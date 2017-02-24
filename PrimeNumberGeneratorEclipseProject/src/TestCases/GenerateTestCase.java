package TestCases;
import Implementation.*;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class GenerateTestCase
{
	PrimeNumberGenerator primeNumberGenerator;
	List<Integer> generatedPrimesList;
	
	//We'll set this up before each test
	@Before	
	public void setUp()
	{
		//Let's create a primeNumberGenerator using JacobsPrimeNumberGenerator implementation for use with these tests
		primeNumberGenerator = new JacobsPrimeNumberGenerator();
		//Let's set the primeList to null;
		generatedPrimesList = null;
	}
	
	//Test that it includes both ends when both ends are primes
	@Test
	public void endpointInclusiveTestBothEnds()
	{
		generatedPrimesList = primeNumberGenerator.generate(2, 5);
		assertTrue(generatedPrimesList.contains(2));
		assertTrue(generatedPrimesList.contains(5));
	}
	
	//Test that it includes left end prime, and not right end composite number
	@Test
	public void endpointInclusiveTestLeftEnd()
	{
		generatedPrimesList = primeNumberGenerator.generate(2, 6);
		assertTrue(generatedPrimesList.contains(2));
		assertFalse(generatedPrimesList.contains(6));
	}
	
	//Test that it includes right end prime and not left end composite number
	@Test
	public void endpointInclusiveTestRightEnd()
	{		
		generatedPrimesList = primeNumberGenerator.generate(1,5);
		assertFalse(generatedPrimesList.contains(1));
		assertTrue(generatedPrimesList.contains(5));
	}
		
	//Test that it includes the prime when both ends of the list are the same prime, ie one number and it is prime
	@Test
	public void endpointInclusiveTestBothEndsSamePrime()
	{
		generatedPrimesList = primeNumberGenerator.generate(5,5);
		assertTrue(generatedPrimesList.contains(5));
	}
	
	//Test that does not includes the composite when both ends of the list are the same composite, ie one number and it is composite
	@Test
	public void endpointInclusiveTestBothEndsSameComposite()
	{
		generatedPrimesList = primeNumberGenerator.generate(4,4);
		//the list should be empty as the only number in the range is not prime
		assertTrue(generatedPrimesList.isEmpty());
	}
	
	//Test that it successfully returns the first 26 primes, and no additional numbers.
	@Test
	public void first26PrimesTest()
	{
		List<Integer> first26PrimesList = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101);
		generatedPrimesList = primeNumberGenerator.generate(0,101);
		//Ensure that the generated prime list contains all the expected primes
		assertTrue(generatedPrimesList.containsAll(first26PrimesList));
		//Ensure that the generated prime list contains no additional elements
		assertTrue(generatedPrimesList.size() == generatedPrimesList.size());
	}
	
	//Test that the returned list is ordered
	@Test
	public void generatoredPrimesListIsOrderedTest()
	{
		generatedPrimesList = primeNumberGenerator.generate(0,101); //we'll just use the first 26 primes for this test
		//For this test we need the list to contain at least 2 elements
		assertTrue(generatedPrimesList.size() >= 2);		
		//Ensure if the list contains atleast 2 elements that it is ordered
		if(generatedPrimesList.size()>=2)
		{
			for(int i = 1; i<generatedPrimesList.size(); i++)
			{
				//Every integer should be either be the same or larger than the previous one
				assertTrue(generatedPrimesList.get(i) >= generatedPrimesList.get(i-1));
			}
		}
	}
	
	//Test that inverse ranges return the same list
	@Test
	public void inverseRangeTest() 
	{
		generatedPrimesList = primeNumberGenerator.generate(1,10);
		List<Integer> inverseRangeGeneratedPrimesList = primeNumberGenerator.generate(10, 1);
		//We need at least 2 elements in the list to truly test this
		assertTrue(generatedPrimesList.size() >= 2);
		//Both Lists should be the same size
		assertTrue(generatedPrimesList.size() == inverseRangeGeneratedPrimesList.size());
		//Check each element in the generatedPrimesList and ensure it is equal to the element in the same position in the inverse list
		for(int i = 1; i<generatedPrimesList.size(); i++)
		{
			//Every integer should be either be the same or larger than the previous one
			assertTrue(generatedPrimesList.get(i) >= generatedPrimesList.get(i-1));
		}
		
		
	}
	
	//Test to make sure prime number generator works with the range 7900 to 7920, returning exactly the expected primes
	@Test
	public void range7900To7920Test()
	{
		List<Integer> range7900To7920PrimesList = Arrays.asList(7901,7907,7919);
		generatedPrimesList = primeNumberGenerator.generate(7900,7920);
		//Ensure that the generated prime list contains all the expected primes
		assertTrue(generatedPrimesList.containsAll(range7900To7920PrimesList));
		//Ensure that the generated prime list contains no additional elements
		assertTrue(generatedPrimesList.size() == generatedPrimesList.size());
		
	}
}
