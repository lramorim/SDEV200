/*Program name: exercise 8_29.java
* Author: Laura Amorim
* Date last updated: 01/17/2026
* Purpose: prompts the user to enter two 3 × 3 arrays of integers and displays whether the two are identical.
*/

import java.util.Scanner;

public class exercise8_29{

    public static void main(String[] args) //reads user input
    {
        Scanner input = new Scanner(System.in);

        int[][] m1 = new int[3][3];
        int[][] m2 = new int[3][3];

        System.out.println("Please enter m1 (3 by 3 matrix) row by row: ");
        
        for(int i =0; i < 3; i++) //first array
        {
            for(int j =0; j < 3; j++)
            {
                m1[i][j] = input.nextInt();
            }
        }

        System.out.println("Please enter m2 (3 by 3 matrix) row by row: ");
        
        for(int i =0; i < 3; i++) //second array
        {
            for(int j =0; j < 3; j++)
            {
                m2[i][j] = input.nextInt();
            }
        }

        if (exercise8_29.equals(m1, m2)) 
        {
            System.out.println("The two arrays are identical!");
        } else {
            System.out.println("The two arrays are not identical.");
        }

        input.close();
    }
    public static boolean equals(int[][] m1, int[][] m2)
    {
        if (m1.length != m2.length) //checks numver of rows
        {
            return false;
        }

        for (int i=0;i<m1.length; i++) //checks each row
        {
            if (m1[i].length!= m2[i].length) 
            {
                return false;
            }

            for (int j = 0; j < m1[i].length; j++)  // checks individual numbers
            {
                if (m1[i][j] != m2[i][j]) 
                {
                    return false;
                }
            }
        }
        
        return true;
    }

}