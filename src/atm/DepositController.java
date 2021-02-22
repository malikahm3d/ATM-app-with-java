package atm;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class DepositController implements Initializable {

    @FXML
    private TextField amount;
    @FXML
    private Button correctBtn;
    @FXML
    private Button changeBtn;
    @FXML
    private Button backBtn;

    ModuleClass m = new ModuleClass();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        

    }

    @FXML
    private void correct(ActionEvent event) throws SQLException, IOException {
        double amo = Double.parseDouble(amount.getText());
        if (amo % 50 == 0) {
            System.out.println("good");
            m.balanceInc(amo);

            Parent root = FXMLLoader.load(getClass().getResource("DepositFI.fxml"));

            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();

        } else {
            System.out.println("try another amount");
            amount.clear();
            amount.requestFocus();
        }
    }

    @FXML
    private void change(ActionEvent event) {
        amount.setText("");
        amount.requestFocus();

    }

    @FXML
    private void goBack(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("User.fxml"));

        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

}
