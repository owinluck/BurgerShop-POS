package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class DashBordFormController {

    public void btnPlaceOrderOnAction(ActionEvent actionEvent) {
        try {
            Parent fxmlLorder= new FXMLLoader(getClass().getResource("../View/placeOrderForm.fxml")).load();
            Stage stage=new Stage();
            stage.setScene(new Scene(fxmlLorder));
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void btnSearchOnAction(ActionEvent actionEvent) {
        try {
            Parent fxmlLorder= new FXMLLoader(getClass().getResource("../View/SearchForm.fxml")).load();
            Stage stage=new Stage();
            stage.setScene(new Scene(fxmlLorder));
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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

    public void btnUpdateOnAction(ActionEvent actionEvent) {
        try {
            Parent fxmlLorder= new FXMLLoader(getClass().getResource("../View/updateOrderForm.fxml")).load();
            Stage stage=new Stage();
            stage.setScene(new Scene(fxmlLorder));
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void btnExitOnAction(ActionEvent actionEvent) {
    }

    public void btnSearchCustomerOnAction(ActionEvent event) {
        try {
            Parent fxmlLorder= new FXMLLoader(getClass().getResource("../View/searchCustomerForm.fxml")).load();
            Stage stage=new Stage();
            stage.setScene(new Scene(fxmlLorder));
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
