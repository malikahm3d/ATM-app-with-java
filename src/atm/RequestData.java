
package atm;


public class RequestData {

   private int ID;
   private String firstName;
   private String lastName;
   //private java.util.Date birthDate;
   private String gender;
   private String phoneNumber;
   private String email;
    
    
    public RequestData(int ID,String firstName,String lastName,String email, String phoneNumber, String gender){
       this.ID=ID;
        this.firstName=firstName;
        this.lastName=lastName;
        //this.birthDate=birthDate;
        this.gender=gender;
        this.phoneNumber=phoneNumber;
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
/**
    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }
*/
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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
    
    
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
    
    
}
