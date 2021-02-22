
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


public class OtherAmountController implements Initializable {

    @FXML
    private Button backBtn;
    @FXML
    private Button correctBtn;
    @FXML
    private Button changeBtn;
    @FXML
    private TextField amount;
    
    ModuleClass m = new ModuleClass();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void goBack(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Withdrawal.fxml"));
        
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void correct(ActionEvent event) throws SQLException, IOException {
        double amo= Double.parseDouble(amount.getText());
        
        if(amo%50==0){
            if(m.getBalance()>=amo){
            m.balanceDec(amo);
            Parent root = FXMLLoader.load(getClass().getResource("WithdrawlFI.fxml"));
        
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
            }
        }else{
            System.out.println("try another number");
            amount.clear();
            amount.requestFocus();
        }
    }

    @FXML
    private void change(ActionEvent event) {
        amount.clear();
        amount.requestFocus();
        
        
    }
    
}
