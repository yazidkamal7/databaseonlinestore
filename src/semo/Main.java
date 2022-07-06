package semo;


/*
 * Semo Store Project 
 * 
 * -------******------
 *
 * ansam rafat 1171872;
 * yazid kamal 1151674;
 * Ahmad Salamah 1172527
 * 
 * --------*****------
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    private Image icon;
    public Main() {
        icon = new Image(Main.class.getResource("img/semo3.png").toExternalForm());
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("form/main.fxml"));
        primaryStage.getIcons().add(icon);
        primaryStage.setTitle("Semo-Store");
        primaryStage.setScene(new Scene(root, 600  , 400));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);

    }
}
