/*Program name: exercise21_3.java
* Author: Laura Amorim
* Date last updated: 02/07/2026
* Purpose: to count the keywords in Java source code (if keyword is in a comment or in a string, don’t count it.)
*/
import java.util.*;
import java.io.*;


public class exercise21_3 { //LiveExample 21.7
  public static void main(String[] args) throws Exception { 

    if (args.length != 1) 
        {
            System.out.println("Enter a Java source file: ");
            return;
        }

    File file = new File(args[0]);
    if (file.exists()) {
      System.out.println("The number of keywords in " + args[0] 
        + " is " + countKeywords(file));
    }
    else {
      System.out.println("File " + args[0]+ " does not exist");
    }    
  }

  public static int countKeywords(File file) throws Exception {  
    // Array of all Java keywords + true, false and null
    String[] keywordString = {"abstract", "assert", "boolean", 
      "break", "byte", "case", "catch", "char", "class", "const",
      "continue", "default", "do", "double", "else", "enum",
      "extends", "for", "final", "finally", "float", "goto",
      "if", "implements", "import", "instanceof", "int", 
      "interface", "long", "native", "new", "package", "private",
      "protected", "public", "return", "short", "static", 
      "strictfp", "super", "switch", "synchronized", "this",
      "throw", "throws", "transient", "try", "void", "volatile",
      "while", "true", "false", "null"};

    Set<String> keywordSet = new HashSet<>(Arrays.asList(keywordString));
    int count = 0;    

    boolean multiLineComment = false;
    boolean isString = false;

    Scanner input = new Scanner(file);

    while (input.hasNext()) {
      String word = input.next();
      if (word.contains("//")) 
      {
      word = word.substring(0, word.indexOf("//")); //doesn't count comments
      }

      if (word.contains("/*")) 
      {
        multiLineComment = true;
      }

      if (word.contains("*/")) 
      {
        multiLineComment = false;
        continue;
      }

      if (word.contains("\"")) //doesn't count strings
      {
        isString = !isString;
        continue;
      }

      if (!multiLineComment && !isString)
      {
        if (keywordSet.contains(word)) // Test if word is a keyword
        count++;
      }
        
    }

    input.close();
    return count;
  }
}
