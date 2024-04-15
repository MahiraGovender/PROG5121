package poe5121_part_1;

//Import JOptionPane
import javax.swing.*;

public class Login {
    
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    
    
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()-+?_=,<>/";
    
    public Login (String userName, String password, String firstName, String lastName) {
       this.userName = userName;
       this.password = password;
       this.firstName = firstName;
       this.lastName = lastName;
    }
    
    public boolean checkUserName (String userName) {
        this.userName = userName;     
        
        if (!userName.isBlank() && userName.matches(".*[_].*") && userName.length() <= 5) {
            return true;
        }
        else {
            
           return false;
           }
        }
    
      public boolean checkPasswordComplexity(String password) {
        this.password = password;
        
        if (!password.isBlank() && password.length() >= 8 &&
                password.matches(".*[A-Z].*") &&
                password.matches(".*[0-9].*") &&
                password.matches(".*[" + SPECIAL_CHARACTERS + "].*"))
        {
            return true;
        }
        else {
            return false;
        }
        
      }
   
   public boolean registerUser () {
        if (!checkUserName(userName) || !checkPasswordComplexity(password)) {
            JOptionPane.showMessageDialog(null, "Registration failed. Please ensure that the username and password meet the requirements.");
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Registration successful.");
            return false;
        }
   }
   
   public boolean loginUser () {
       //Re-entering data for login verification
       String LoginuserName = JOptionPane.showInputDialog(null, "Please enter your user name to login");
       String Loginpassword = JOptionPane.showInputDialog(null, "Please enter your password to login");
       
        if (LoginuserName.matches(userName) && Loginpassword.matches(password)) {
        return true;
       } 
        
        else {
            JOptionPane.showMessageDialog(null, "Invalid username or password. Please try again.");
        return false;
       }
        
   }
   
    public String returnLoginStatus() {
        if (loginUser()) {
            String success = "Successfull login! \nWelcome " + firstName + ",  " + lastName + " it is great to see you.\"";
            return success;
        } else {
            String fail ="Failed login";
            return fail;
        }
    }
    
  }