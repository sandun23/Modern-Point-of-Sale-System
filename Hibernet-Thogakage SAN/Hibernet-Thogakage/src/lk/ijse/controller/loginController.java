package lk.ijse.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;


public class loginController {

    @FXML
    private JFXButton btnItem;

    @FXML
    private JFXButton btnOrder;

    @FXML
    public void btnItemOnAction(ActionEvent actionEvent) throws Exception{
        AnchorPane root=FXMLLoader.load(getClass().getResource("/lk/ijse/view/Item.fxml"));
        Scene scene=new Scene(root);
        Stage stage= (Stage) this.btnItem.getScene().getWindow();
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
//        Parent parent= FXMLLoader.load(this.getClass().getResource("/lk/ijse/view/login.fxml"));
//        Scene scene=new Scene(parent);
//        Stage.setScene(scene);
//        Stage.show();
    }
    @FXML
    public void btnOrderOnAction(ActionEvent actionEvent) throws IOException {
        AnchorPane root=FXMLLoader.load(getClass().getResource("/lk/ijse/view/Order.fxml"));
        Scene scene=new Scene(root);
        Stage stage= (Stage) this.btnItem.getScene().getWindow();
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }
}
