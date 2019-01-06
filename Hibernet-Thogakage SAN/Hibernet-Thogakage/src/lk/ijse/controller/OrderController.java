package lk.ijse.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;
import lk.ijse.bo.custom.CustomerBO;
import lk.ijse.bo.custom.ItemBO;
import lk.ijse.bo.custom.OrderBO;
import lk.ijse.bo.custom.impl.CustomerBOImpl;
import lk.ijse.bo.custom.impl.ItemBOImpl;
import lk.ijse.bo.custom.impl.OrderBOImpl;
import lk.ijse.entity.Customer;
import lk.ijse.entity.Item;
import lk.ijse.entity.OrderDetail;
import lk.ijse.entity.Orders;
import lk.ijse.model.CommenDTO;
import lk.ijse.model.CustomerDTO;
import lk.ijse.model.ItemDTO;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;

public class OrderController implements Initializable {

    @FXML
    private TextField textCustName;

    @FXML
    private TextField textCustAddress;

    @FXML
    private TextField textItemCode;

    @FXML
    private JFXComboBox<String> comboItemName;

    @FXML
    private TextField textQTY;

    @FXML
    private TextField textUnitPrice;

    @FXML
    private TableView<ItemDTO> tblOder;

    @FXML
    private TextField textTotale;

    @FXML
    private JFXButton btnAdd;

    @FXML
    private JFXButton btnSave;
    @FXML
    private TextField search;

    @FXML
    private JFXButton btnSearch;

    @FXML
    private JFXButton btnDelete;

    @FXML
    private JFXButton btnUpdate;

    @FXML
    private TextField textOderID;

    @FXML
    private Label lblDate;

    @FXML
    private TextField textCustID;

    private ItemBO itemBo;
    private OrderBO orderBO;
    private CustomerBO customerBO;
    double tot;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        itemBo=new ItemBOImpl();
        orderBO=new OrderBOImpl();
        customerBO=new CustomerBOImpl();

        try {
            loadCombo();
            date();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void loadCombo() throws Exception{
        List<ItemDTO>item=itemBo.getAll();
        ArrayList<String>strings=new ArrayList<>();
        for (ItemDTO itemDTO:item){
            strings.add(itemDTO.getItemName());
        }

        for(String s:strings){
            comboItemName.getItems().add(s);
        }

    }
    private void date()throws Exception{
        Timeline time = new Timeline(new KeyFrame(Duration.seconds(0), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                lblDate.setText(new SimpleDateFormat("YYYY-MM-dd").format(new Date()));
            }
        }), new KeyFrame(Duration.seconds(1)));
        time.setCycleCount(Animation.INDEFINITE);
        time.play();
    }

    @FXML
    void btnAddOnAction(ActionEvent event) {
        ItemDTO itemDTO=new ItemDTO(Integer.parseInt(textItemCode.getText()),comboItemName.getSelectionModel().getSelectedItem(),Integer.parseInt(textQTY.getText()),Double.parseDouble(textUnitPrice.getText()));

        tblOder.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("itemCode"));
        tblOder.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("itemName"));
        tblOder.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("qty"));
        tblOder.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("unitPrice"));

        tblOder.getItems().addAll(itemDTO);

        double lastAmount=Double.parseDouble(textUnitPrice.getText());
        tot+=lastAmount;
        textTotale.setText(tot+"");

    }
    @FXML
    void lblDateOnAction(MouseEvent event) {

    }


    @FXML
    void btnDeleteOnAction(ActionEvent event) {

    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {
        try {
            Customer customer = new Customer();
            customer.setCustID(Integer.parseInt(textCustID.getText()));
            Orders orders = new Orders(Integer.parseInt(textOderID.getText()), new Date(), Double.parseDouble(textTotale.getText()), customer);
            orders.setOID(Integer.parseInt(textOderID.getText()));
            Item item = new Item();
            item.setItemCode(Integer.parseInt(textItemCode.getText()));
            OrderDetail orderDetail = new OrderDetail(Integer.parseInt(textQTY.getText()), Double.parseDouble(textTotale.getText()), item, orders);
            CommenDTO commenDTO = new CommenDTO(orders, orderDetail);
            boolean add = orderBO.addOrder(commenDTO);
            if (add){
                Alert alert=new Alert(Alert.AlertType.INFORMATION,"Add Orders", ButtonType.OK);
                alert.show();
            }else {
                Alert alert=new Alert(Alert.AlertType.INFORMATION,"order not added", ButtonType.OK);
                alert.show();
            }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }




    @FXML
    void btnUpdateOnAction(ActionEvent event) {

    }

    @FXML
    void comboItemNameOnAction(ActionEvent event) {
        String id=comboItemName.getSelectionModel().getSelectedItem();
        try {
            List<ItemDTO> all=itemBo.getAll();
            for (ItemDTO itemDTO:all){
                if(id.equalsIgnoreCase(itemDTO.getItemName())){
                    textItemCode.setText(itemDTO.getItemCode()+"");
                    textUnitPrice.setText(itemDTO.getUnitPrice()+"");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @FXML
    void tblOderOnActon(ActionEvent event) {

    }

    @FXML
    void textCustAddressOnAction(ActionEvent event) {
        try {
            CustomerDTO customerDTO=new CustomerDTO(Integer.parseInt(textCustID.getText()),textCustName.getText(),textCustAddress.getText());
            boolean add=customerBO.addCustomer(customerDTO);

            if(add){
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION,"Customer Added");
                alert.show();
            }else {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION,"Customer Not Added");
                alert.show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    void textCustIDOnAction(ActionEvent event) {
        textCustName.requestFocus();

    }

    @FXML
    void textCustNameOnAction(ActionEvent event) {
        textCustAddress.requestFocus();
    }

    @FXML
    void textQTYOnAction(ActionEvent event) {
        double tootale=0;
        double ammount=Double.parseDouble(textUnitPrice.getText())*Integer.parseInt(textQTY.getText());
        tootale+=ammount;
        textUnitPrice.setText(tootale+"");

    }

    @FXML
    void textTotaleOnAction(ActionEvent event) {

    }

    @FXML
    void textUnitPriceOnAction(ActionEvent event) {

    }

    public void textOderIDOnAction(ActionEvent actionEvent) {
    }

    public void searchOnAction(ActionEvent actionEvent) {
        try {
            CustomerDTO customerDTO=customerBO.searchCustomerByID(Integer.parseInt(search.getText()));
            if (customerDTO!=null){
                textCustID.setText(""+customerDTO.getId());
                textCustName.setText(customerDTO.getName());
                textCustAddress.setText(customerDTO.getAddress());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void btnSearchOnAction(ActionEvent actionEvent) {
    }
}
