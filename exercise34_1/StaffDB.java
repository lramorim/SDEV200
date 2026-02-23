/*Program name: StaffDB.java
* Author: Laura Amorim
* Date last updated: 02/23/2026
* Purpose: executes SQL commands
*/

import java.sql.*;

public class StaffDB 
{
    public static void viewStaff(String id) //for view button
    {
        String sql = "SELECT * FROM Staff WHERE id = ?";

        try (Connection c = DBconnection.getConnection(); PreparedStatement statement = c.prepareStatement(sql))
            {
                statement.setString(1, id);
                ResultSet result = statement.executeQuery();
                if (result.next()) {
                System.out.println("ID: " + result.getString("id"));
                System.out.println("First Name: " + result.getString("firstName"));
                System.out.println("Last Name: " + result.getString("lastName"));
                System.out.println("MI: " + result.getString("mi"));
                System.out.println("Address: " + result.getString("address"));
                System.out.println("City: " + result.getString("city"));
                System.out.println("State: " + result.getString("state"));
                System.out.println("Telephone: " + result.getString("telephone"));
                System.out.println("Email: " + result.getString("email"));
            } else {
                System.out.println("Record not found.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }

    public static void insertStaff(String id, String lastName, String firstName, String mi, String address, //for insert button
                                    String city, String state, String phone, String email)
    {
        String sql = "INSERT INTO STAFF VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection c = DBconnection.getConnection(); PreparedStatement statement = c.prepareCall(sql))
        {
            statement.setString(1, id);
            statement.setString(2, lastName);
            statement.setString(3, firstName);
            statement.setString(4, mi);
            statement.setString(5, address);
            statement.setString(6, city);
            statement.setString(7, state);
            statement.setString(8, phone);
            statement.setString(9, email);

            statement.executeUpdate();
            System.out.println("Success.");
        } catch (SQLException e) 
            {
                e.printStackTrace();
            }
    }

    public static void updateStaff(String id, String lastName, String firstName, String mi, String address, String city, //for update button
                        String state, String phone, String email)
    {
         String sql = "UPDATE Staff SET lastName=?, firstName=?, mi=?, address=?, city=?, state=?, telephone=?, email=? WHERE id=?";
         try (Connection c = DBconnection.getConnection(); PreparedStatement statement = c.prepareCall(sql))
        {
            statement.setString(1, lastName);
            statement.setString(2, firstName);
            statement.setString(3, mi);
            statement.setString(4, address);
            statement.setString(5, city);
            statement.setString(6, state);
            statement.setString(7, phone);
            statement.setString(8, email);
            statement.setString(9, id);

            int rows = statement.executeUpdate();
            
            if (rows > 0) 
            {
                System.out.println("Success.");
            } else 
                {
                    System.out.println("Record not found.");
                }
        } catch (SQLException e)
            {
                e.printStackTrace();
            }
            
    }
}
