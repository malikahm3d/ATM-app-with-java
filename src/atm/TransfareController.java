/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class TransfareController implements Initializable {

    @FXML
    private TextField accountNum;
    @FXML
    private TextField amount;
    @FXML
    private Button cancelBtn;
    @FXML
    private Button transfareBtn;
    
    public static int RAN;
    public static double transferAmount;
    ModuleClass m = new ModuleClass();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void goBack(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("User.fxml"));
        
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void transfare(ActionEvent event) throws SQLException, IOException {
        double amo=Double.parseDouble(amount.getText());
        int accountNo=Integer.parseInt(accountNum.getText());
        RAN=accountNo;
        transferAmount=amo;
        if(m.getBalance()>=amo){
        Parent root = FXMLLoader.load(getClass().getResource("TransferFI.fxml"));
        
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
        }
        
    }
    
}
