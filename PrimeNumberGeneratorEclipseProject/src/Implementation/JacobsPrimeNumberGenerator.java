package Implementation;
import java.util.ArrayList;
import java.util.List;

public class JacobsPrimeNumberGenerator implements PrimeNumberGenerator
{
	public List<Integer> generate(int startingValue, int endingValue)
	{
		List<Integer> primesList = new ArrayList<Integer>();
		int minValue = Math.min(startingValue, endingValue);
		int maxValue = Math.max(startingValue, endingValue);
		
		//For every number in the range including both ends, check if it's a prime, if it is add it to the primesList
		for(int i = minValue; i <= maxValue; i++)
		{
			if(isPrime(i))
			{
				primesList.add(i);
			}
		}		
		return primesList;
	}
	
	public boolean isPrime(int value)
	{
		boolean isPrime = true;	
		//a prime can't be less than 2
		if(value < 2)
		{
			isPrime = false;
		}
		else
		{
			//check every number up to half of the value, anything over half can not evenly divided into the value
			for(int i = 2; i <= value/2; i++)
			{
				//if the value mod the potential factor we are on is 0, then it evenly divides and is not prime
				if(value % i == 0)
				{
					isPrime = false;
					//At this point we know it's not a prime, no reason to look at any other factors
					break;
				}
			}
		}
		return isPrime;
	}
}
