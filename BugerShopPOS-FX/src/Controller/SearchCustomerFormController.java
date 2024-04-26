package Controller;

import DB.List;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Orders;

public class SearchCustomerFormController {
    public TableView<Orders> tblSearchCustomer;
    public TableColumn<Orders,String> colOrderId;
    public TableColumn<Orders,String> colQty;
    public TableColumn<Orders,String> colTotal;
    public TextField txtCustumerId;
    public Label lblName;
    public Label lblInvalidOrderId;
    public TableColumn<Orders,String> colName;
    int index;
    PlaceOederFormController cusController=PlaceOederFormController.getInstance();

    List list=List.getInstance();
    public void btnSubmitOnAction(ActionEvent event) {
        if(cusController.isIndexcheck(txtCustumerId.getText())){

            System.out.println("Valid");
            index=cusController.getindex(txtCustumerId.getText());
            lblName.setText(cusController.get(index).getName());
            colOrderId.setCellValueFactory(new PropertyValueFactory<>("orderID"));
            colQty.setCellValueFactory(new PropertyValueFactory<>("quantity"));
            colTotal.setCellValueFactory(new PropertyValueFactory<>("total"));
            colName.setCellValueFactory(new PropertyValueFactory<>("name"));
            lordTable();

        }else {
            lblInvalidOrderId.setText("Invali Order ID... Try Again..");
            System.out.println("Invalid");
        }
    }
    private void lordTable(){
        ObservableList<Orders> customerDetailsArray=list.CustomerDetails(txtCustumerId.getText());
        tblSearchCustomer.setItems(customerDetailsArray);
    }

    /*public void txtCustomerIdOnAction(ActionEvent actionEvent) {
        System.out.println("Enter");
        int index = cusController.getindex(txtCustumerId.getText());
        System.out.println("Name --> "+cusController.get(index).getName());
    }*/
}
