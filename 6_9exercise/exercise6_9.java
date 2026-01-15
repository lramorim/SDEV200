/*Program name: exercise6_9.java
* Author: Laura Amorim
* Date last updated: 01/15/2026
* Purpose: converts and displays values from feet to meters and vice versa
*/
 public class exercise6_9{
    public static double footToMeter(double foot)
    {
        return 0.305 * foot;
    }
    
    public static double meterToFoot(double meter)
    {
        return 3.279 * meter;
    }
    public static void main(String[] args) 
    {
        System.out.println("Feet\tMeters\t|\tMeters\tFeet");
        System.out.println("--------------------------------------");
        double meterValue = 20.00;
        
        for(double footValue = 1.0; footValue <= 10.0; footValue++)
            {
             System.out.printf(
                "%.1f\t%.3f\t|\t%.1f\t%.3f%n",
                footValue,
                footToMeter(footValue),
                meterValue,
                meterToFoot(meterValue));
                meterValue +=5;
            }
    }
 

}