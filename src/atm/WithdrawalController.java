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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author temp
 */
public class WithdrawalController implements Initializable {

    @FXML
    private Button btn50;
    @FXML
    private Button btn100;
    @FXML
    private Button btn200;
    @FXML
    private Button btn500;
    @FXML
    private Button btn1000;
    @FXML
    private Button btn1500;
    @FXML
    private Button btn2000;
    @FXML
    private Button backBtn;
    @FXML
    private Button otherAmountBtn;

    ModuleClass m = new ModuleClass();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
    private void otherAmount(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("OtherAmount.fxml"));

        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void get50(ActionEvent event) throws SQLException, IOException {
        if(m.getBalance()>=50){
        m.balanceDec(50.00);
        Parent root = FXMLLoader.load(getClass().getResource("WithdrawlFI.fxml"));
        
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    }

    @FXML
    private void get100(ActionEvent event) throws SQLException, IOException {
        if(m.getBalance()>=100){
        m.balanceDec(100.00);
        Parent root = FXMLLoader.load(getClass().getResource("WithdrawlFI.fxml"));
        
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();

    }
    }

    @FXML
    private void get200(ActionEvent event) throws SQLException, IOException {
        if(m.getBalance()>=200){
        m.balanceDec(200.00);
        Parent root = FXMLLoader.load(getClass().getResource("WithdrawlFI.fxml"));
        
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();

    }
    }

    @FXML
    private void get500(ActionEvent event) throws SQLException, IOException {
        if(m.getBalance()>=500){
        m.balanceDec(500.00);
        Parent root = FXMLLoader.load(getClass().getResource("WithdrawlFI.fxml"));
        
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    }

    @FXML
    private void get1000(ActionEvent event) throws SQLException, IOException {
        if(m.getBalance()>=1000){
        m.balanceDec(1000.00);
        Parent root = FXMLLoader.load(getClass().getResource("WithdrawlFI.fxml"));
        
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    }

    @FXML
    private void get1500(ActionEvent event) throws SQLException, IOException {
        if(m.getBalance()>=1500){
        m.balanceDec(1500.00);
        Parent root = FXMLLoader.load(getClass().getResource("WithdrawlFI.fxml"));
        
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    }
    
    @FXML
    private void get2000(ActionEvent event) throws SQLException, IOException {
        if(m.getBalance()>=2000){
        m.balanceDec(2000.00);
        Parent root = FXMLLoader.load(getClass().getResource("WithdrawlFI.fxml"));
        
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    }

}
