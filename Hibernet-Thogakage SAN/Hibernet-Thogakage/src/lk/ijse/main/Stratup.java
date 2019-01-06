package lk.ijse.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Stratup extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent parent= FXMLLoader.load(this.getClass().getResource("/lk/ijse/view/login.fxml"));
        Scene scene=new Scene(parent);
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.centerOnScreen();
        primaryStage.setResizable(false);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
