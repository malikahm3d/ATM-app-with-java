
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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;


public class UsersInfoController implements Initializable {

    @FXML
    private TableColumn<AccountsData, String> first_name;
    @FXML
    private TableColumn<AccountsData, String> last_name;
    @FXML
    private TableColumn<AccountsData, String> account_number;
    @FXML
    private TableColumn<AccountsData, String> balance;
    @FXML
    private TableColumn<AccountsData, String> email;
    @FXML
    private TableColumn<AccountsData, String> phone_number;
    @FXML
    private Button backBtn;
    @FXML
    private TableView<AccountsData> accTbl;
    
    ModuleClass m ;
    ObservableList<AccountsData> obList = FXCollections.observableArrayList();
    @FXML
    private TextField search;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        first_name.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        last_name.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        account_number.setCellValueFactory(new PropertyValueFactory<>("accountNumber"));
        balance.setCellValueFactory(new PropertyValueFactory<>("balance"));
        phone_number.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        email.setCellValueFactory(new PropertyValueFactory<>("email"));
        
        m = new ModuleClass();
        try {
            ResultSet rs = m.accountsData();
            
           while (rs.next()) {
                obList.add(new AccountsData(rs.getString("FirstName"),rs.getString("LastName"),
                        rs.getInt("AccountNumber"), rs.getDouble("Balance"), rs.getString("PhoneNumber"), rs.getString("Email")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(RequestsController.class.getName()).log(Level.SEVERE, null, ex);
        }

        accTbl.setItems(obList);
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
    private void search(KeyEvent event) {
         String userAccount = search.getText();
         
accTbl.getItems().clear();



m = new ModuleClass();
try {
ResultSet rs = m.accountsData(userAccount);
while(rs.next())
{
obList.add(new AccountsData(rs.getString("FirstName"),rs.getString("LastName"),
                        rs.getInt("AccountNumber"), rs.getDouble("Balance"), rs.getString("PhoneNumber"), rs.getString("Email")));
}
} catch (SQLException ex) {
Logger.getLogger(UsersInfoController.class.getName()).log(Level.SEVERE, null, ex);
}
accTbl.setItems(obList);
    }
    
}
