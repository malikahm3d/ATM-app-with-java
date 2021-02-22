package atm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.mail.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class ModuleClass {

    public static int currentUser;
    static double balance;

    private Connection connect() throws SQLException {
        Connection con;
        String url = "jdbc:sqlite:C:/Users/makka/Documents/NetBeansProjects/ATM/DB/BankingSystem.db";
        con = DriverManager.getConnection(url);
        System.out.println("The Connection established");
        return con;

    }

    public String getUserName(int accountNo) throws SQLException {
        String sql = "select FirstName||' '||LastName as FullName from Users where AccountNumber='" + accountNo + "'";
        Connection con = this.connect();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);

        String fullName = rs.getString("FullName");
        st.close();
        con.close();
        return fullName;
    }

    public boolean checkUser(int accountNo) throws SQLException {
        String sql = "SELECT AccountNumber FROM Accounts WHERE AccountNumber ='" + accountNo + "'";
        Connection con = this.connect();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        int accountNo2 = rs.getInt("AccountNumber");
        st.close();
        con.close();
        if (accountNo == accountNo2) {
            st.close();
            con.close();
            return true;
        }
        return false;
    }

    public boolean checkPin(int accountNo, String pin) throws SQLException {
        String sql = "SELECT PIN FROM Accounts WHERE AccountNumber ='" + accountNo + "'";
        Connection con = this.connect();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        String pin2 = rs.getString("PIN");
        st.close();
        con.close();
        if (pin.equals(pin2)) {
            currentUser = accountNo;
            st.close();
            con.close();
            balance = this.getBalance();
            return true;
        }
        return false;
    }

    public void addUser(String firstName, String lastName, String email, String phone, String gender) throws SQLException {

        String sql = "INSERT INTO Users(FirstName, LastName,Email,PhoneNumber,Gender) VALUES('" + firstName + "','" + lastName + ""
                + "','" + email + "','" + phone + "','" + gender + "')";

        Connection con = this.connect();
        Statement st = con.createStatement();
        st.executeUpdate(sql);
        st.close();

        con.close();
        System.out.println("user Created Successfully");
    }

    public void newAccount(int accountNo, int userID, double balance) throws SQLException {
        String sql = "INSERT INTO Accounts(AccountNumber, UserID,Balance) VALUES('" + accountNo + "','" + userID + "','" + balance + "')";

        Connection con = this.connect();
        Statement st = con.createStatement();
        st.executeUpdate(sql);
        st.close();

        con.close();
        
    }

    public void setAccountNo(int accountNo, int id) throws SQLException {
        String sql = "UPDATE Users SET AccountNumber = '" + accountNo + "'WHERE UserID = '" + id + "'";
        Connection con = this.connect();
        Statement st = con.createStatement();
        st.executeUpdate(sql);
        st.close();
        con.close();
        
    }

    public int generateAccountNo(int userID) {
        int fixed = 75300;
        return fixed + userID;
    }

    public void setStatus(String status, int id) throws SQLException {
        String sql = "UPDATE Users SET Status = '" + status + "'WHERE UserID = '" + id + "'";
        Connection con = this.connect();
        Statement st = con.createStatement();
        st.executeUpdate(sql);
        st.close();
        con.close();

    }

    public ResultSet requestData() throws SQLException {

        String sql = "SELECT UserID,FirstName, LastName, Gender, phoneNumber, Email FROM Users WHERE Status ='Pending'";
        Connection con = this.connect();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);

        return rs;
    }

    public ResultSet accountsData() throws SQLException {
        String sql = "select FirstName,LastName,AccountNumber,Balance,PhoneNumber,Email from Users natural join Accounts where AccountNumber "
                + "in (select AccountNumber from Users where Status ='Active')";
        Connection con = this.connect();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);

        return rs;
    }

    public ResultSet accountsData(String in) throws SQLException {
        String sql = "select * from(select FirstName,LastName,AccountNumber,Balance,PhoneNumber,Email from Users natural join Accounts "
                + "where AccountNumber in (select AccountNumber from Users where Status ='Active')) where FirstName like '" + in + "%' or LastName like '" + in + "%'";

        Connection con = this.connect();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        return rs;
    }

    public double getBalance() throws SQLException {
        String sql = "select Balance from Accounts where AccountNumber='" + currentUser + "'";

        Connection con = this.connect();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        double bal = rs.getDouble("Balance");
        st.close();
        con.close();
        return bal;
    }

    public double getBalance(int accountNumber) throws SQLException {
        String sql = "select Balance from Accounts where AccountNumber='" + accountNumber + "'";

        Connection con = this.connect();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        double bal = rs.getDouble("Balance");
        st.close();
        con.close();
        return bal;
    }

    public void balanceInc(double amount) throws SQLException {
        double bal = balance + amount;
        balance = bal;
        String sql = "UPDATE Accounts SET Balance = '" + bal + "'WHERE Accountnumber = '" + currentUser + "'";
        Connection con = this.connect();
        Statement st = con.createStatement();
        st.executeUpdate(sql);
        st.close();
        con.close();
    }

    public void balanceInc(double bal, double amount, int accountNo) throws SQLException {
        double newBal = bal + amount;

        String sql = "UPDATE Accounts SET Balance = '" + newBal + "'WHERE Accountnumber = '" + accountNo + "'";
        Connection con = this.connect();
        Statement st = con.createStatement();
        st.executeUpdate(sql);
        st.close();
        con.close();
    }

    public void balanceDec(double amount) throws SQLException {
        double bal = balance - amount;
        balance = bal;
        String sql = "UPDATE Accounts SET Balance = '" + bal + "'WHERE Accountnumber = '" + currentUser + "'";
        Connection con = this.connect();
        Statement st = con.createStatement();
        st.executeUpdate(sql);
        st.close();
        con.close();
    }

    public void addTransaction() {

    }
    
    public void addTransfer (int receiverAccount, double amount,java.sql.Date date) throws SQLException{
        String sql = "INSERT INTO Transfer(SenderAccountNumber, ReceiverAccountNumber,TransferAmount,TransferDate) VALUES('" + currentUser + "','" + receiverAccount + "','" + amount + "','"+date+"')";

        Connection con = this.connect();
        Statement st = con.createStatement();
        st.executeUpdate(sql);
        st.close();

        con.close();
    }
    
    
    public int pinGen(){
        int pin = (int) ((Math.random()*((9999-1000)+1))+1000);
        return pin;
    }
    
    
    
    
    
    
    
    
    

    public void sendMail(String recepient,String gender,String pin,String accountNo,String fullName) throws Exception{
        System.out.println("preparing to send");
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        
        String myAccount = "BankOfLiberty1@gmail.com";
        String password = "makkawi8299";
        
        
        Session  session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myAccount, password);
            }
           
        });
        
        Message message = prepareConMessage(session, myAccount, recepient,gender,pin,accountNo,fullName);
        Transport.send(message);
        System.out.println("message sent");
    }

    private static Message prepareConMessage(Session session, String myAccount, String recepient,String gen,String PIN,String accountNo,String fullName) {
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccount));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            message.setSubject("Conformation Message");
            
            String name =fullName;
            String gender =gen;
            String pin = PIN;
            String title;
            
            if(gender.equalsIgnoreCase("male")){
                     title = "Mr. ";
                }
            else{
                       title ="Mrs. ";
                }
	
String htmlCode1 = "<h1> Bank of Liberty confirmation message:</h1><br> <p> Hello</p>";
				
String htmlCode2 = "<p> this is a message to confirm your account at our bank of liberty. <br> attached, is your Account & PIN number</p>";
				
String htmlCode3 = "<p><br> thank you for choosing our bank</p>";

String finalHTML = htmlCode1 +title+name+htmlCode2+"Account Number:"+accountNo+"      PIN:"+pin+htmlCode3;
            message.setContent(finalHTML, "text/html");
            return message;
        } catch (Exception ex) {
            System.out.println("error");
        }
        return null;
    }
    
    
    public String getEmail(int accountNo) throws SQLException{
                String sql = "select Email from users where AccountNumber='" + accountNo + "'";

        Connection con = this.connect();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        String email = rs.getString("Email");
        st.close();
        con.close();
        return email;
    }
    
    
    
    
    public String getGender (int accountNo) throws SQLException{
                String sql = "select Gender from Users where AccountNumber='" + accountNo + "'";

        Connection con = this.connect();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        String gender = rs.getString("Gender");
        st.close();
        con.close();
        return gender;
    }
    
    
    
    
    public void setPin(int accountNo,String pin ) throws SQLException{
      
        String sql = "UPDATE Accounts SET PIN = '" + pin + "'WHERE Accountnumber = '" + accountNo + "'";
        Connection con = this.connect();
        Statement st = con.createStatement();
        st.executeUpdate(sql);
        st.close();
        con.close();
    }
}
