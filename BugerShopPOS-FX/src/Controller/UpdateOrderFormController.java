package Controller;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import model.Orders;

import java.net.URL;
import java.util.ResourceBundle;

public class UpdateOrderFormController implements Initializable {


    public ComboBox<String> comboBox;
    public TextField txtCusname;
    public TextField txtCustomerId;
    public TextField txtQty;
    public TextField txtTotal;

    public static PlaceOederFormController cusController=PlaceOederFormController.getInstance();
    public TextField txtOrderId;
    public TextField txtStatus;
    private Orders customer=new Orders();
    private static int index;
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        comboBox.setItems(FXCollections.observableArrayList("PREPARING","DELEVERD","CANCEL"));
    }

    public void comboGetInfoOnAction(ActionEvent event) {

        if(comboBox.getValue().equals("PREPARING")){
            customer.setStatus(0);
            txtStatus.setText("PREPARING");
        }else if(comboBox.getValue().equals("DELEVERD")){
            customer.setStatus(1);
            txtStatus.setText("DELEVERD");
        }else {
            customer.setStatus(2);
            txtStatus.setText("CANCEL");
        }
    }

    public void btnSearchOnAction(ActionEvent event) {
        if(cusController.isoderValide(txtOrderId.getText())){
            index=cusController.getorderindex(txtOrderId.getText());
            txtCustomerId.setText(cusController.get(index).getPhoneNumber());
            txtCusname.setText(cusController.get(index).getName());
            txtStatus.setEditable(false);
            txtStatus.setText(cusController.get(index).getStatus()==0 ? "PREPARING" : cusController.get(index).getStatus()==2 ? "CANCEL" : "DELIVERD");
        }if(cusController.get(index).getStatus()==1 || cusController.get(index).getStatus()==2){
            txtQty.setText(cusController.get(index).getQuantity()+"");
            disavleTextFiels();
            comboBox.setItems(FXCollections.observableArrayList(""));
        }else{
            txtQty.setText(cusController.get(index).getQuantity()+"");
            enableTextFiels();

        }
        txtTotal.setText(cusController.get(index).getTotal()+"/=");
        customer=cusController.get(index);
    }
    private void disavleTextFiels(){
        txtQty.setEditable(false);
        comboBox.setEditable(false);
    }
    private void enableTextFiels(){
        txtQty.setEditable(true);
        comboBox.setEditable(true);
    }

    public void btnUpdateOnAction(ActionEvent event) {
        int Qty=Integer.parseInt(txtQty.getText());
        customer.setQuantity(Qty);
        customer.setTotal(Qty*500);
        txtQty.setText(Qty+"");
        txtTotal.setText(Qty*500+"/=");
    }
}
