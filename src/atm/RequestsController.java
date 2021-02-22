package atm;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class RequestsController implements Initializable {
    @FXML
    private TableColumn<RequestData, String> ID;
    @FXML
    private TableColumn<RequestData, String> first_name;
    @FXML
    private TableColumn<RequestData, String> last_name;
    //private TableColumn<RequestData, String> birth_date;
    @FXML
    private TableColumn<RequestData, String> gender;
    @FXML
    private TableColumn<RequestData, String> phone_number;
    @FXML
    private TableColumn<RequestData, String> email;
    @FXML
    private Button acceptBtn;
    @FXML
    private Button declineBtn;
    @FXML
    private Button backBtn;
    @FXML
    private TableView<RequestData> reqTbl;

    ModuleClass m;
    ObservableList<RequestData> obList = FXCollections.observableArrayList();
    
    int idNo;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ID.setCellValueFactory(new PropertyValueFactory<>("ID"));
        first_name.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        last_name.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        
        gender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        phone_number.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        email.setCellValueFactory(new PropertyValueFactory<>("email"));
        

        m = new ModuleClass();
        try {
            ResultSet rs = m.requestData();

            while (rs.next()) {
                obList.add(new RequestData(rs.getInt("UserID"),rs.getString("FirstName"), rs.getString("LastName"), rs.getString("Email"), rs.getString("PhoneNumber"), rs.getString("Gender")/*, rs.getString("DateOfBirth")*/));
            }
        } catch (SQLException ex) {
            Logger.getLogger(RequestsController.class.getName()).log(Level.SEVERE, null, ex);
        }

        reqTbl.setItems(obList);
    }
    
    
    

    @FXML
    private void accept(ActionEvent event) throws SQLException, Exception {
        int accountNo=m.generateAccountNo(idNo);
        m.newAccount(accountNo, idNo, 0);
        int pin=m.pinGen();
        String PIN=String.valueOf(pin);
        String accNo=String.valueOf(accountNo);
        m.setPin(accountNo,PIN);
        m.setAccountNo(accountNo, idNo);
        m.setStatus("Active", idNo);
        
        
        reqTbl.getItems().clear();

        
        m = new ModuleClass();
try {
ResultSet rs = m.requestData();
while(rs.next())
{
  obList.add(new RequestData(rs.getInt("UserID"),rs.getString("FirstName"), rs.getString("LastName"), rs.getString("Email"), rs.getString("PhoneNumber"), rs.getString("Gender")/*, rs.getString("DateOfBirth")*/));
}

} catch (SQLException ex) {
Logger.getLogger(RequestsController.class.getName()).log(Level.SEVERE, null, ex);
}
reqTbl.setItems(obList);


/**
 *                             | 
 * email messages code here    |
 *                            \ /
 *                             '
 */
//    public static void sendMail(String recepient,String gender,String pin,String accountNo,String fullName) throws Exception{
        m.sendMail(m.getEmail(accountNo), m.getGender(accountNo), PIN, accNo, m.getUserName(accountNo));
}

    

    @FXML
    private void decline(ActionEvent event) throws SQLException {
        m.setStatus("declined",idNo );
 
        reqTbl.getItems().clear();

        m = new ModuleClass();
try {
ResultSet rs = m.requestData();
while(rs.next())
{
  obList.add(new RequestData(rs.getInt("UserID"),rs.getString("FirstName"), rs.getString("LastName"), rs.getString("Email"), rs.getString("PhoneNumber"), rs.getString("Gender")/*, rs.getString("DateOfBirth")*/));
}

} catch (SQLException ex) {
Logger.getLogger(RequestsController.class.getName()).log(Level.SEVERE, null, ex);
}
reqTbl.setItems(obList);
}    

    @FXML
    private void goBack(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Admin.fxml"));

        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void select(MouseEvent event) {
        int index = reqTbl.getSelectionModel().getSelectedIndex();
        RequestData rd = reqTbl.getItems().get(index);
        idNo=(rd.getID());
    }

}
