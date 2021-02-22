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
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author temp
 */
public class NewUserController implements Initializable {

    @FXML
    private Button backBtn;
    @FXML
    private Button reqBtn;
    @FXML
    private TextField first_name;
    @FXML
    private TextField middle_name;
    @FXML
    private TextField last_name;
    @FXML
    private RadioButton maleRB;
    @FXML
    private RadioButton femaleRB;
    @FXML
    private TextField phone_number;
    @FXML
    private TextField email;
    @FXML
    private DatePicker birth_date;
    
    private String gender;

    
    ModuleClass m=new ModuleClass();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void goBack(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void sendRequest(ActionEvent event) throws SQLException, IOException {
        /*
        if(maleRB.equals(true)){
            gender="male";
        }else if(femaleRB.equals(false)){
            gender="female";
        }else{
            System.out.println("plz select your gender");
        }
        **/ 
        
        if(first_name.getText().isEmpty()){
            System.out.println("plz enter your first name");
        }else if(last_name.getText().isEmpty()){
            System.out.println("plz enter your last name ");
        }else if(email.getText().isEmpty()){
            System.out.println("plz enter your email");
        }else if(phone_number.getText().isEmpty()){
            System.out.println("plz enter your phone number");
        }else{
            m.addUser(first_name.getText(), last_name.getText(), email.getText(), phone_number.getText(), gender);
            Parent root = FXMLLoader.load(getClass().getResource("NewUserFI.fxml"));
        
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
        }
    }

    @FXML
    private void male(ActionEvent event) {
        gender ="male";
        
        femaleRB.setSelected(false);
    }

    @FXML
    private void female(ActionEvent event) {
        gender="female";
        
        maleRB.setSelected(false);
    }
    
}
