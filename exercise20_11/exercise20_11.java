/*Program name: exercise20_11.java
* Author: Laura Amorim
* Date last updated: 02/05/2026
* Purpose: to check whether a Java source-code file has correct pairs of grouping symbols (parenthesis, brackets, curly braces)
*/

import java.util.Stack;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class exercise20_11{

    public static void main(String[] args) //test program
    {
        if (args.length != 1) 
        {
            System.out.println("Paste source file name");
            return;
        }

        String name = args[0];

        if (symbolCheck(name))
        {
            System.out.println("Correct grouping pairs!"); 
        } else {
            System.out.println("Incorrect grouping pairs");
        }
    }

    public static boolean symbolCheck(String file)
    {
        Stack<Character> stack = new Stack<>();

        try(Scanner scanner = new Scanner(new File(file))) 
        {
            while (scanner.hasNextLine()) 
            {
                String line = scanner.nextLine();
                
                for(char c : line.toCharArray())
                {
                    if (c == '(' || c =='[' || c =='{') 
                    {
                        stack.push(c); //push item to top of stack
                    }
                    else if (c == ')' || c ==']' || c =='}') 
                    {
                        if (stack.isEmpty()) 
                            {
                                return false;
                            }

                        char open = stack.pop(); //removes from top of stack

                        if (!isMatch(open, c)) 
                        {
                            return false;
                        }
                    } 
                }
            }
        } catch (FileNotFoundException e)
            {
                System.err.println("File not found.");
                return false;
            }

            return stack.isEmpty();        
    }

    public static boolean isMatch(char open, char close)
    {
        return (open == '(' && close == ')') || (open == '[' && close == ']') || (open == '{' && close == '}');
    }

}