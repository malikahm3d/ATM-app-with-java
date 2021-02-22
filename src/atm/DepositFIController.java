
package atm;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;


public class DepositFIController implements Initializable {

    @FXML
    private Label msg;
    @FXML
    private Button no;
    @FXML
    private Button yes;
    DepositController d=new DepositController();
    String s="The amount has been deposited into your account";
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        msg.setText(s);
    }    

    @FXML
    private void loginScreen(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void anotherTransaction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("User.fxml"));
        
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    
}
