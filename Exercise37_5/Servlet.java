/*Program name: Servlet.java
* Author: Laura Amorim
* Date last updated: 3/2/2026
* Purpose: computes loan payment
*/

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Servlet")
public class Servlet  extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try 
        {
            double loanAmount = Double.parseDouble(request.getParameter("loanAmount"));
            double interestRate = Double.parseDouble(request.getParameter("interestRate"));
            int years = Integer.parseInt(request.getParameter("years"));

            //loan class from textbook
            Loan loan = new Loan(interestRate, years, loanAmount);

            double monthlyPayment = loan.getMonthlyPayment();
            double totalPayment = loan.getTotalPayment();

            out.println("<html><body>");
            out.println("<h2>Loan Payment Results</h2>");

            out.println("<p>Loan Amount: $" + loanAmount + "</p>");
            out.println("<p>Interest Rate: " + interestRate + "%</p>");
            out.println("<p>Years: " + years + "</p>");
            out.println("<hr>");

            out.println("<p><strong>Monthly Payment: $" + String.format("%.2f", monthlyPayment) + "</strong></p>");
            out.println("<p><strong>Total Payment: $" + String.format("%.2f", totalPayment) + "</strong></p>");
            out.println("<p>Loan Date: " + loan.getLoanDate() + "</p>");
            out.println("<br><a href='loan.html'>Back</a>");
            out.println("</body></html>");

        } catch (Exception e) 
            {
                out.println("<html><body>");
                out.println("<h3>Error: Please enter valid numeric values.</h3>");
                out.println("<a href='loan.html'>Try Again</a>");
                out.println("</body></html>");
            }
    }
}
