/*Program name: exercise6_31.java
* Author: Laura Amorim
* Date last updated: 01/15/2026
* Purpose: prompts the user to enter a credit card number and displays whether the number is valid or invalid.
*/
import java.util.Scanner;

public class exercise6_31{

    public static void main(String[] args) /*reads user input */
    {
        Scanner input = new Scanner(System.in);

        System.out.print("Please enter your card number: ");
        long cardNum = input.nextLong();

        if (isValid(cardNum)) 
        {
            System.out.println(cardNum + " is valid!");
        } else{
            System.out.println(cardNum + " is invalid.");
        }

        input.close();
    }

    public static boolean isValid(long number)/** Return true if the card number is valid */
    {
        int sum = sumOfDoubleEvenPlace(number) + sumOfOddPlace(number);

        if (sum % 10 !=0) //checks if divisible by 10
        { 
            return false;
        }
        
        int size = getSize(number); //num size check
        if (size < 13 || size > 16)
        {
            return false;
        }

        return prefixMatched(number, 4) || prefixMatched(number, 5) //checks if initial number is valid
            || prefixMatched(number, 37) || prefixMatched(number, 6);
    
    }

    public static int sumOfDoubleEvenPlace(long number) /** Get the result from Step 2 */
    {
        int sum = 0;
        boolean evenP = false;
        
        while (number > 0) 
        {
            int digit = (int)(number%10); 
            if (evenP) 
            {
                sum+=getDigit(digit*2);
            }

            evenP = !evenP;
            number /=10;
        }
        return sum;
    }

    public static int getDigit(int number) /** Return this number if it is a single digit, otherwise, return the sum of the two digits */
    {
        if (number<10) 
        {
            return number;
        } else 
            {
                return number / 10 + number % 10;
            }
    }

    public static int sumOfOddPlace(long number) /** Return sum of odd-place digits in number */
    {
        int sum = 0;
        boolean oddP = true;

        while (number > 0) 
        {
            int digit = (int)(number%10);
            if (oddP)
            {
                sum += digit;
            }
            
            oddP = !oddP;
            number /=10;
        }
        
        return sum;
    }

    public static boolean prefixMatched(long number, int d) /** Return true if the number d is a prefix for number */
    {
        return getPrefix(number, getSize(d)) == d;
    }

    /** Return the number of digits in d */
    public static int getSize(long d)
    {
        int size = 0;
        while (d > 0) 
        {
            size++;
            d/=10;
        }

        return size;
    }

    public static long getPrefix(long number, int k) /** Return the first k number of digits from number. If the number of digits in number is less than k, return number. */
    {
        int numSize = getSize(number);
        if (numSize <= k) 
        {
          return number;  
        }

        for(int i = 0; i < numSize - k; i++)
        {
            number /=10;
        }

        return number;
    }
}