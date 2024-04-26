package Controller;

import DB.List;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class SearchOrderFormContoller {
    public TextField txtOrderId;
    public Label lblCustomerId;
    public Label lblName;
    public Label lblBurgerQty;
    public Label lblTotal;
    public Label lblOrderStatus;

    public static  int index;
    public static PlaceOederFormController cusController=PlaceOederFormController.getInstance();
    public Label lblValidation;

    public void btnEnterOnAction(ActionEvent actionEvent) {
        System.out.println("Order Id >> "+txtOrderId.getText());

        if(cusController.isoderValide(txtOrderId.getText())){
            lblValidation.setText("");
            index=cusController.getorderindex(txtOrderId.getText());
            lblCustomerId.setText(cusController.get(index).getPhoneNumber());
            lblName.setText(cusController.get(index).getName());
            lblBurgerQty.setText(cusController.get(index).getQuantity()+"");
            lblTotal.setText(cusController.get(index).getTotal()+"/=");
            lblOrderStatus.setText(cusController.get(index).getStatus()==0 ? "PREPARING" : cusController.get(index).getStatus()==2 ? "CANCEL" : "DELIVERD");
        }else{
            lblValidation.setText("Invalid Order Id, Try Again...");
            clearLable();
        }

    }
    private void clearLable(){
        lblCustomerId.setText("");
        lblOrderStatus.setText("");
        lblName.setText("");
        lblBurgerQty.setText("");
        lblTotal.setText("");
    }
}
