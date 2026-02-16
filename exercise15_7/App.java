/*Program name: App.java
* Author: Laura Amorim
* Date last updated: 02/15/2026
* Purpose: to display a circle, black when the mouse button is pressed, and white when the mouse button is released.
*/
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;


public class App extends Application{
    public static void main(String[] args) throws Exception {
        launch();
    }

    @Override
    public void start(Stage stage)
    {
       Circle circle = new Circle(150, 150, 100);
       circle.setFill(Color.WHITE); //white w/ black outline
       circle.setStroke(Color.BLACK);
       
       circle.setOnMousePressed(e->{ //color change
        circle.setFill(Color.BLACK);
       });

       circle.setOnMouseReleased(e->{ //change back to white
        circle.setFill(Color.WHITE);
       });

       Pane pane = new Pane();
       pane.getChildren().add(circle);

       Scene scene = new Scene(pane, 300, 300);
       stage.setTitle("Exercise15_7");
       stage.setScene(scene);
       stage.show();

    }

}
