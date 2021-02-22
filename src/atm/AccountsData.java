
package atm;


public class AccountsData {
    private String firstName;
    private String lastName;
    private int accountNumber;
    private double Balance;
    private String phoneNumber;
    private String email;
    
    public AccountsData (String firstName, String lastName,int accountNumber, double balance,String PhoneNumber,String email){
        this.firstName=firstName;
        this.lastName=lastName;
        this.accountNumber=accountNumber;
        this.Balance=balance;
        this.phoneNumber=PhoneNumber;
        this.email=email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getBalance() {
        return Balance;
    }

    public void setBalance(double Balance) {
        this.Balance = Balance;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }
    
}
