/*Program name: Exercise31_1.java
* Author: Laura Amorim
* Date last updated: 02/23/2026
* Purpose: display GUI connected to StaffDB.java
*/

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Exercise31_1 extends Application {
     public static void main(String[] args) {
        launch();
    }

    TextField idField = new TextField();
    TextField lastNameField = new TextField();
    TextField firstNameField = new TextField();
    TextField miField = new TextField();
    TextField addressField = new TextField();
    TextField cityField = new TextField();
    TextField stateField = new TextField();
    TextField phoneField = new TextField();
    TextField emailField = new TextField();

    @Override
    public void start(Stage stage)
    {
       GridPane grid = new GridPane(); //lables+text fields
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(15)); 

        grid.add(new Label("ID"), 0, 0);
        grid.add(idField, 1, 0);

        grid.add(new Label("Last Name"), 0, 1);
        grid.add(lastNameField, 1, 1);

        grid.add(new Label("First Name"), 0, 2);
        grid.add(firstNameField, 1, 2);

        grid.add(new Label("MI"), 0, 3);
        grid.add(miField, 1, 3);

        grid.add(new Label("Address"), 0, 4);
        grid.add(addressField, 1, 4);

        grid.add(new Label("City"), 0, 5);
        grid.add(cityField, 1, 5);
        
        grid.add(new Label("State"), 0, 6);
        grid.add(stateField, 1, 6);
        
        grid.add(new Label("Telephone"), 0, 7);
        grid.add(phoneField, 1, 7);

        grid.add(new Label("Email"), 0, 8);
        grid.add(emailField, 1, 8);

        Button viewButton = new Button("View");
        Button insertButton = new Button("Insert");
        Button updateButton = new Button("Update");
        Button clearButton = new Button("Clear");

        grid.add(viewButton, 0, 9);
        grid.add(insertButton, 1, 9);
        grid.add(updateButton, 2, 9);
        grid.add(clearButton, 3, 9);

        viewButton.setOnAction(e -> StaffDB.viewStaff(idField.getText())); //button actions
        
        insertButton.setOnAction(e -> StaffDB.insertStaff(idField.getText(), lastNameField.getText(), firstNameField.getText(), miField.getText(), addressField.getText(), 
                                cityField.getText(), stateField.getText(), phoneField.getText(), emailField.getText())); 

        updateButton.setOnAction(e -> StaffDB.updateStaff(idField.getText(), lastNameField.getText(), firstNameField.getText(), miField.getText(), addressField.getText(), 
                                cityField.getText(), stateField.getText(), phoneField.getText(), emailField.getText()));
        
        clearButton.setOnAction(e -> {idField.setText(""); lastNameField.setText(""); firstNameField.setText(""); miField.setText(""); addressField.setText(""); 
                                cityField.setText(""); stateField.setText(""); phoneField.setText(""); emailField.setText("");});

        Scene scene = new Scene(grid, 400, 400);
        stage.setTitle("ExtraExercise34_01");
        stage.setScene(scene);
        stage.show();
    }




    
}