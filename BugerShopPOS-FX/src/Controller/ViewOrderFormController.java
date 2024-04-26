package Controller;

import DB.List;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Orders;

import java.net.URL;
import java.util.ResourceBundle;

public class ViewOrderFormController implements Initializable {


    public TableView tblPlaceOrder;
    public TableColumn colOrderIdPlaceOrder;
    public TableColumn colNamePlaceOrder;
    public TableColumn colQtyPlaceOrder;
    public TableColumn colTotalPlaceOrder;
    public TableView tblDeliverOrders;
    public TableColumn colOrderIdDeleverOrder;
    public TableColumn colNameDeleverOrder;
    public TableColumn colQtyDeleverOrder;
    public TableColumn colTotalDeleverOrder;
    public TableView tblCancelOrders;
    public TableColumn colOrderIdCancel;
    public TableColumn colNameCancel;
    public TableColumn colQtyCancel;
    public TableColumn colTotalCancel;

    List list=List.getInstance();


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tableDetails();

    }
    public void lordTable(){
        ObservableList<Orders> placeOrderArray=list.placeOrder();
        tblPlaceOrder.setItems(placeOrderArray);

        ObservableList<Orders> deleverOrderarray=list.deleverOrder();
        tblDeliverOrders.setItems((deleverOrderarray));

        ObservableList<Orders> cancelOrderArray=list.cancelOrder();
        tblCancelOrders.setItems(cancelOrderArray);
    }

    public void tableDetails(){
        System.out.println("Helloooooo");
        colOrderIdPlaceOrder.setCellValueFactory(new PropertyValueFactory<>("orderID"));
        colNamePlaceOrder.setCellValueFactory(new PropertyValueFactory<>("name"));
        colQtyPlaceOrder.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        colTotalPlaceOrder.setCellValueFactory(new PropertyValueFactory<>("total"));

        colOrderIdDeleverOrder.setCellValueFactory(new PropertyValueFactory<>("orderID"));
        colNameDeleverOrder.setCellValueFactory(new PropertyValueFactory<>("name"));
        colQtyDeleverOrder.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        colTotalDeleverOrder.setCellValueFactory(new PropertyValueFactory<>("total"));

        colOrderIdCancel.setCellValueFactory(new PropertyValueFactory<>("orderID"));
        colNameCancel.setCellValueFactory(new PropertyValueFactory<>("name"));
        colQtyCancel.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        colTotalCancel.setCellValueFactory(new PropertyValueFactory<>("total"));

        lordTable();
    }
}
