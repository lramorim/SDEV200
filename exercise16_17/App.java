/*Program name: App.java
* Author: Laura Amorim
* Date last updated: 02/16/2026
* Purpose: to display a window that uses scroll bars to select the color for the title text
*/
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.ScrollBar;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;


public class App extends Application{
    public static void main(String[] args) throws Exception {
        launch();
    }

    @Override
    public void start(Stage stage)
    {
       Text text = new Text("Show Colors");
       text.setStyle("-fx-font-size: 30px;");
    
       ScrollBar redBar = colorBar(0, 255); //creates the scrollbars
       ScrollBar greenBar = colorBar(0, 255);
       ScrollBar blueBar = colorBar(0, 255);
       ScrollBar opacityBar = colorBar(0, 100);

       redBar.valueProperty().addListener(e -> updateColor(text, redBar, greenBar, blueBar, opacityBar)); //lambda expression to uptdate color 
       greenBar.valueProperty().addListener(e -> updateColor(text, redBar, greenBar, blueBar, opacityBar));
       blueBar.valueProperty().addListener(e -> updateColor(text, redBar, greenBar, blueBar, opacityBar));
       opacityBar.valueProperty().addListener(e -> updateColor(text, redBar, greenBar, blueBar, opacityBar));

       VBox root = new VBox(10, text, new Label("Red"), redBar, new Label("Green"), greenBar, new Label("BLue"), blueBar, new Label("Opacity"), opacityBar);
       root.setAlignment(Pos.CENTER); //centers text
       root.setStyle("-fx-padding: 20px;");

       stage.setScene(new Scene(root, 400, 400));
       stage.setTitle("Exercise16_17");
       stage.show();

       updateColor(text, redBar, greenBar, blueBar, opacityBar);
    }

    private ScrollBar colorBar(double min, double max)
    {
        ScrollBar bar = new ScrollBar();
        bar.setMin(min);
        bar.setMax(max);
        bar.setValue(min);
        bar.setOrientation(Orientation.HORIZONTAL);
        bar.setPrefWidth(300);
        return bar;
    }

    private void updateColor(Text text, ScrollBar r, ScrollBar g, ScrollBar b, ScrollBar o)
    {
        int red =(int) r.getValue();
        int green =(int) g.getValue();
        int blue =(int) b.getValue();
        double opacity= o.getValue() / 100.0;
        
        text.setFill(Color.rgb(red, green, blue, opacity));
    }

}
