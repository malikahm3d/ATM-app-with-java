
package atm;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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


public class TransferFI2Controller implements Initializable {

    @FXML
    private Label msg;
    @FXML
    private Button no;
    @FXML
    private Button yes;

    
    TransfareController t= new TransfareController();
    ModuleClass m = new ModuleClass();
    
    int accountNo=t.RAN;
    double amount=t.transferAmount;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            String s="you have transferred "+amount+" to "+m.getUserName(accountNo)+" ";
            msg.setText(s);
        } catch (SQLException ex) {
            Logger.getLogger(TransferFIController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
    private void userScreen(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("User.fxml"));
        
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    
}
