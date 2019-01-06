package lk.ijse.controller;

import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.bo.custom.ItemBO;
import lk.ijse.bo.custom.impl.ItemBOImpl;
import lk.ijse.model.ItemDTO;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;


import java.net.URL;
import java.util.ResourceBundle;

import static sun.net.www.MimeTable.loadTable;

public class ItemController implements Initializable {

    @FXML
    private TableView<ItemDTO> tblItem;

    @FXML
    private JFXButton btnAdd;

    @FXML
    private TextField textItemCode;

    @FXML
    private TextField textItemName;

    @FXML
    private TextField textItemQty;

    @FXML
    private TextField textItemUnitPrice;

    @FXML
    private JFXButton btnDelete;

    @FXML
    private JFXButton btnUpdate;

    @FXML
    private TextField textItemSearch;

    @FXML
    private JFXButton btnSearch;
    private ItemBO itemBO;



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        itemBO=new ItemBOImpl();
        clearText();
        tableLoad();

    }

    private void tableLoad() {
        tblItem.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("itemCode"));
        tblItem.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("itemName"));
        tblItem.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("qty"));
        tblItem.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("unitPrice"));

        try {
            tblItem.setItems(FXCollections.observableArrayList(itemBO.getAll()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void clearText() {
        textItemCode.clear();
        textItemName.clear();
        textItemQty.clear();
        textItemUnitPrice.clear();
        textItemSearch.clear();
    }



    @FXML
    void btnAddOnAction(ActionEvent event) throws Exception {
        int code=Integer.parseInt(textItemCode.getText());
        String name=textItemName.getText();
        int qty=Integer.parseInt(textItemQty.getText());
        double unitPrice=Double.parseDouble(textItemUnitPrice.getText());

        ItemDTO itemDTO= new ItemDTO(code,name,qty,unitPrice);
        boolean add=itemBO.addItem(itemDTO);

        if (add){
            Alert alert=new Alert(Alert.AlertType.INFORMATION,"Item Add");
            alert.showAndWait();
            clearText();
            tableLoad();

        }else {
            Alert alert=new Alert(Alert.AlertType.INFORMATION,"Not add");
        }
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event)throws Exception {
        ItemDTO itemDTO=new ItemDTO(Integer.parseInt(textItemCode.getText()),textItemName.getText(),Integer.parseInt(textItemQty.getText()),Double.parseDouble(textItemUnitPrice.getText()));
        boolean delete=itemBO.deleteItem(itemDTO);
        if (delete){
            Alert alert=new Alert(Alert.AlertType.INFORMATION,"Item Delete");
            alert.showAndWait();
            clearText();
            tableLoad();

        }else {
            Alert alert=new Alert(Alert.AlertType.INFORMATION,"Not delete");
        }
    }

    @FXML
    void btnSearchOnAction(ActionEvent event) {
        try {
            ItemDTO itemDTO=itemBO.searchItem(Integer.parseInt(textItemSearch.getText()));
            if (itemDTO!=null){
                textItemCode.setText(""+itemDTO.getItemCode());
                textItemName.setText(itemDTO.getItemName());
                textItemQty.setText(""+itemDTO.getQty());
                textItemUnitPrice.setText(""+itemDTO.getUnitPrice());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {

    }


}
