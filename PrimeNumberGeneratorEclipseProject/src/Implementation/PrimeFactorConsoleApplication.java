package Implementation;

import java.util.List;

public class PrimeFactorConsoleApplication
{
	
	public static void main(String[] args)
	{
		int startingValue = 0;
		int endingValue = 0;
		boolean parameterError = false;
		if(args.length == 2)
		{
			//attempt to parse the starting value as an int
			try{startingValue = Integer.parseInt(args[0]);}
			catch(NumberFormatException nfe) 
			{
				System.out.println("Error, could not Parse starting Value, please ensure starting value is an integer.");
				parameterError = true;
			}
			//attempt to parse the ending value as an int
			try{endingValue = Integer.parseInt(args[1]);}
			catch(NumberFormatException nfe)
			{
				System.out.println("Error, could not Parse endingValue Value, please ensure starting value is an integer.");
				parameterError = true;
			}
		}
		else
		{
			System.out.println("Error, expecting 2 arguments: int startingValue, int endingValue");
			parameterError = true;
		}
		if(!parameterError)
		{
			//Now we have our range, let's get the primes in that range and print them.
			PrimeNumberGenerator primeNumberGenerator = new JacobsPrimeNumberGenerator();
			List<Integer> generatedPrimesList = primeNumberGenerator.generate(startingValue, endingValue);
			System.out.println("Generated primes between " + startingValue + " and " + endingValue + " inclusive: " + generatedPrimesList.toString());
		}
	}
}
