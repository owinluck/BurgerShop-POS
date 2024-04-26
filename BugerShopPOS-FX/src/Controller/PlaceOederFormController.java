package Controller;

import DB.List;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Orders;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ResourceBundle;

import static Controller.SearchOrderFormContoller.index;

public class PlaceOederFormController extends Component implements Initializable {

    private static PlaceOederFormController instance;
    public TextField txtPhoneNumber;
    public TextField txtQty;

    private static int count=0;
    public TextField txtName;

    public static List list=List.getInstance();
    public Label lblOrderId;
    public Label lblTotal;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("Hello..");
        generatID(count);
    }

    public void btnPlaceOrderOnAction(ActionEvent actionEvent) {
        int tot=Integer.parseInt(txtQty.getText())*500;
        Orders oder=new Orders(lblOrderId.getText(),
                txtPhoneNumber.getText(),
                txtName.getText(),
                Integer.parseInt(txtQty.getText()),
                tot,
                0
        );
        count++;
        generatID(count);
        clearText();
        list.add(oder);
        System.out.println(oder);
    }
    public void btnCalcOnAction(ActionEvent actionEvent) {
        int qty=Integer.parseInt(txtQty.getText());
        double total=qty*burgerPrice;
        lblTotal.setText(total+"/=");
    }
    public void clearText(){
        txtName.clear();
        txtQty.clear();
        txtPhoneNumber.clear();
        lblTotal.setText("00.00");
    }

    //--------------------------------------------------------------------------//


    public static double burgerPrice=500;
    public static int get;
    //-----------------phone number validation------
    public static boolean isvalid(String phn){
        int length=phn.length();
        return length==10 && phn.startsWith("0");
    }
    //------------GeneratID--------------------------
    public void generatID(int count){
        count++;
        String odrId=String.format("B%04d",count);
        //return odrId;
        lblOrderId.setText(odrId);
    }
    public boolean isIndexcheck(String phn){
        return list.isIndexcheck(phn);
    }
    public int getindex(String phn){

        int i=list.getindex(phn);
        return i;
    }
    public Orders get(int index){
        Orders data=list.get(index);
        return data;
    }
    public void add(String ID,String phn,String cusname,int qut,double value,int Status){
        list.add(new Orders(ID,phn,cusname,qut,value,Status));
    }

    //--------------------isoderValide Check---------------
    public boolean isoderValide(String ID){
        for (int i = 0; i < list.size(); i++){
            if(ID.equals(list.get(i).getOrderID())){
                return true;
            }
        }
        return false;
    }
    //---------------Get Order index-----------------------
    public int getorderindex(String Value){
        for (int i = 0; i < list.size();  i++){
            if(Value.equals(list.get(i).getOrderID())){
                return i;
            }
        }
        return-1;
    }
    /*public int size(){

        return list.size();
    }*/
    //-----------------Update-----------------------
    public static void Update(int data,int index){
        for (int i = 0; i <list.size() ; i++){
            if(index==i){
                Orders Customer=list.get(i);
                Customer.setQuantity(data);
                Customer.setTotal(data*500);
            }
        }
    }
    //----------------Update Status-----------------
    public static void UpdateStatus(int data,int index){
        for (int i = 0; i <list.size() ; i++){
            if(index==i){
                Orders Customer=list.get(i);
                Customer.setStatus(data);
            }
        }
    }
    public static boolean Search(String value, String []ar){

        for (String ar1 : ar) {
            if (value.equals(ar1)) {
                return true;
            }
        }
        return false;
    }
    //---------------Extend Array----------------------
    public static String[] extendArray(String []br){
        String []temp=new String[br.length+1];
        System.arraycopy(br, 0, temp, 0, br.length);
        return temp;
    }

    public static PlaceOederFormController getInstance(){
        if(instance==null){
            return instance=new PlaceOederFormController();
        }
        return instance;
    }
    public void btnViewOrderOnAction(ActionEvent actionEvent) {
        try {
            Parent fxmlLorder= new FXMLLoader(getClass().getResource("../View/ViewOrder.fxml")).load();
            Stage stage=new Stage();
            stage.setScene(new Scene(fxmlLorder));
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void txtPhoneNumberOnAction(ActionEvent actionEvent) {
        System.out.println("Enter");
        int index = getindex(txtPhoneNumber.getText());
        try{
            txtName.setText(get(index).getName());
        }catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Customer Not found...");
        }

    }
}
