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
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author temp
 */
public class FXMLDocumentController implements Initializable {
    
    private Label label;
    @FXML
    private PasswordField password;
    @FXML
    private Button newUser;
    @FXML
    private TextField accNum;
    @FXML
    private Button loginBtn;
    
    ModuleClass m = new ModuleClass();
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    
        //if (accNum.getText().equalsIgnoreCase("user")&&password.getText().equalsIgnoreCase("user")){
        
        //}
        //else if(accNum.getText().equalsIgnoreCase("admin")&&password.getText().equalsIgnoreCase("admin")){
            
        //}

    

    @FXML
    private void newUser(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("NewUser.fxml"));
        
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void login(ActionEvent event) throws IOException, SQLException {
        //String a=accNum.getText();
        //String p =password.getText();
        //int accNo=Integer.parseInt(accNum.getText());
        //int pin=Integer.parseInt(password.getText());
       
        
        if (accNum.getText().equalsIgnoreCase("user")&&password.getText().equalsIgnoreCase("user")){
        Parent root = FXMLLoader.load(getClass().getResource("User.fxml"));
        
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
        
        
        
        }
        if(accNum.getText().equalsIgnoreCase("admin")&&password.getText().equalsIgnoreCase("admin")){
            Parent root = FXMLLoader.load(getClass().getResource("Admin.fxml"));
        
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
        }
        
         if(m.checkUser(Integer.parseInt(accNum.getText()))&&m.checkPin(Integer.parseInt(accNum.getText()),password.getText() )){
             Parent root = FXMLLoader.load(getClass().getResource("User.fxml"));
        
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
        }
        
    }

    
    
}
