package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        String cssDarkMode = getClass().getResource("../css/light.css").toExternalForm();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../FXML/sample.fxml"));
        Parent root = loader.load();
        Controller controller = loader.getController();
        Scene scene = new Scene(root);
        scene.getStylesheets().add(cssDarkMode);
        controller.setScene(scene);
        controller.setStage(primaryStage);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}