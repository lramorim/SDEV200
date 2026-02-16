/*Program name: App.java
* Author: Laura Amorim
* Date last updated: 02/14/2026
* Purpose: to display four images in a grid pane
*/

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class App extends Application{
    public static void main(String[] args) throws Exception {
        launch();
    }

    @Override
    public void start(Stage stage)
    {
        GridPane grid = new GridPane(); //creates grid with 10px spacing betweeen flags
        grid.setPadding(new Insets(10));
        grid.setHgap(10);
        grid.setVgap(10);
        
        Image flag1 = new Image(getClass().getResourceAsStream("/br.png")); //get images from folder
        Image flag2 = new Image(getClass().getResourceAsStream("/cl.png"));
        Image flag3 = new Image(getClass().getResourceAsStream("/ar.png"));
        Image flag4 = new Image(getClass().getResourceAsStream("/ch.png"));

        ImageView v1 = new ImageView(flag1);
        ImageView v2 = new ImageView(flag2);
        ImageView v3 = new ImageView(flag3);
        ImageView v4 = new ImageView(flag4);

        v1.setFitWidth(150); //resizing
        v1.setFitHeight(150);
        v1.setPreserveRatio(true);

        v2.setFitWidth(150);
        v2.setFitHeight(150);
        v2.setPreserveRatio(true);

        v3.setFitWidth(150);
        v3.setFitHeight(150);
        v3.setPreserveRatio(true);

        v4.setFitWidth(150);
        v4.setFitHeight(150);
        v4.setPreserveRatio(true);

        grid.add(v1, 0, 0); //creates grid
        grid.add(v2, 1, 0);
        grid.add(v3, 0, 1);
        grid.add(v4, 1, 1);

        Scene scene = new Scene(grid, 350, 350);
        stage.setTitle("Exercise14_1");
        stage.setScene(scene);
        stage.show();
    }

}
