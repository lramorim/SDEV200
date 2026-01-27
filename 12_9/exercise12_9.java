/*Program name: exercise12_9.java
* Author: Laura Amorim
* Date last updated: 01/26/2026
* Purpose: to define a custom exception called BinaryFormatException. Then implement the bin2Dec method to throw a BinaryFormatException 
if the string is not a binary string.
*/

import java.util.Scanner;

public class exercise12_9 {
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);

        System.out.println("Please enter a binary number: ");
        String binary = input.nextLine();

        try 
        {
           int decimal = bin2Dec(binary);
           System.out.println("Here's it's decimal equivalent: " + decimal);
        } 
        catch (BinaryFormatException e) {
            System.out.println(e.getMessage());
    
        }


        input.close();

    }

    static class BinaryFormatException extends Exception //custom exception
    {
        public BinaryFormatException()
        {
            super("That's not a binary string.");
        }
    }

    public static int bin2Dec(String binaryString) throws BinaryFormatException //throws exception if not a binary string
    { 

        int dec = 0;
        for(int i=0; i< binaryString.length(); i++)
        {
            char b = binaryString.charAt(i);

            if (b!= '0' && b!= '1') 
            {
                throw new BinaryFormatException();  
            }

            dec = dec * 2 + (b - '0');
        }

        return dec;
    }
}
