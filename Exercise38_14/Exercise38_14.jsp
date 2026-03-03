<!--Program name: Exercise38_14.jsp
* Author: Laura Amorim
* Date last updated: 3/2/2026
* Purpose:  generates addition quizzes randomly. After the user answers all questions, displays result
-->

<%@ page import="java.util.*" %>
<%
    int totalQuestions = 5;

    boolean submitted = request.getParameter("submitted") != null;
%>


<html>
<head>
    <title>Addition Quiz</title>
</head>
<body>

<%
if (!submitted) {
%>

    <form method="post" action="Exercise38_14.jsp">

    <%
        Random rand = new Random();

        for (int i = 1; i <= totalQuestions; i++) {
            int num1 = rand.nextInt(50);  // random 0–49
            int num2 = rand.nextInt(50);

    %>
            <p>
                <%= num1 %> + <%= num2 %> = 
                <input type="text" name="answer<%= i %>" required>
            </p>

            <input type="hidden" name="num1_<%= i %>" value="<%= num1 %>"> <!-- Hidden fields to store correct values -->
            <input type="hidden" name="num2_<%= i %>" value="<%= num2 %>">
    <%
        }
    %>

        <input type="hidden" name="submitted" value="true">
        <input type="submit" value="Submit">
    </form>

<%
} else {

    int score = 0;

    for (int i = 1; i <= totalQuestions; i++) { <!-- Answer display -->

        int num1 = Integer.parseInt(request.getParameter("num1_" + i));
        int num2 = Integer.parseInt(request.getParameter("num2_" + i));
        int correctAnswer = num1 + num2;

        int userAnswer = 0;

        try 
        {
            userAnswer = Integer.parseInt(request.getParameter("answer" + i));
        } catch (NumberFormatException e) {
            userAnswer = 0;
            }

        if (userAnswer == correctAnswer) {  <!-- Displays if asnwer is correct or wrong -->
            score++;
%>
        <p>
            <%= num1 %> + <%= num2 %> = <%= userAnswer %>
            Correct
        </p>
<%
    } else {
%>
        <p>
            <%= num1 %> + <%= num2 %> = <%= userAnswer %>
            Wrong
        </p>
<%
    }
}
%>

    <h3>The total correct count is: <%= score %></h3>

    <br>
    <a href="Exercise38_14.jsp">New quiz</a>

<%
}
%>

</body>
</html>