package poe5121_part_1_and_2;

//Import JOptionPane
import java.awt.Frame;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class Login {
       //My fields for password and username
       private String userName;
       private String password;
        
       //Constant declared for special characters
       private static final String SPECIAL_CHARACTERS = "!@#$%^&*()-+?_=,<>/";
    
       /*Create my constructer, must match the class's name with parameters to capture and bring 
       username, password, firstName and lastName that will be inputed earlier after prompts in main*/
       public Login (String userName, String password, String firstName, String lastName) {
        
       this.userName = userName; //This used because username will be tested in method 1
       this.password = password; //This used because password will be tested in method 2
       
    }
       /*First method: boolean type to check that the user has inputted a correctly formatted username for
       registration*/
       public boolean checkUserName (String userName) {
        //Brings user name entered in main here to be tested
        this.userName = userName;     
        
        //If statement is redundent but this is the only way all conditions are tested and a loop can occur for false
        if (!userName.isBlank() && userName.matches(".*[_].*") && userName.length() <= 5) {
            return true;
            /*the application will only allow usernames that:
            are not blank, have an underscore and is 5 characters or less in length*/
        }
        else { //or else it is considered incorrectly formatted
            
           return false;
           }
        }
      //Second method: boolean type to check that the user's password meets the set criteria
      public boolean checkPasswordComplexity(String password) {
        this.password = password;
        
        //If statement is redundent but this is the only way all conditions are tested and a loop can occur for false
        if (!password.isBlank() && password.length() >= 8 &&
                password.matches(".*[A-Z].*") &&
                password.matches(".*[0-9].*") &&
                password.matches(".*[" + SPECIAL_CHARACTERS + "].*"))
        //Constant used here to check for special characters
        {
            return true;
            /*The application only allows passwords that:
            are not blank, have a capital letter, have a number and have a special character*/
        }
        else { //or else it is considered incorrectly formatted
            return false;
        }
        
      }
       
        /* Third method: boolean type checks what both method 1 & 2 are returning before giving an appropriate
        response with regards to a user's registration status*/
        public boolean registerUser () {
            
            //Put methods 1 & 2 in If statement to displaying registration failed when one or both are false
        if (!checkUserName(userName) || !checkPasswordComplexity(password)) {
            JOptionPane.showMessageDialog(null, "Registration failed. Please ensure that the username and password meet the requirements.");
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Registration successful.");
            return false;
        }
   }
        
        /*Fourth method: boolean type is for the user to login, checks that the user's inputs for username
        and password match what they previously entered for their registration*/
       public boolean loginUser (String firstName, String lastName) {
           
       //Prompts user to capture their input in order to proceed with testing
       String LoginuserName = JOptionPane.showInputDialog(null, "Please enter your user name to login");
       String Loginpassword = JOptionPane.showInputDialog(null, "Please enter your password to login");
       
        /*If statement checks that they both match what was previously entered before the application
        can proceed to the next instruction*/
        if (LoginuserName.matches(userName) && Loginpassword.matches(password)) {
            returnLoginStatus(firstName, lastName, LoginuserName, Loginpassword);
        return true;
        //Signal to proceed
       } 
        
        else { //Alerts user that they made a mistake 
            JOptionPane.showMessageDialog(null, "Invalid username or password. Please try again.");
            returnLoginStatus("", "", LoginuserName, Loginpassword);
        return false;
       }
        //This method will be implicated in method 5 not main for simultainious execution
   }
       
        /*Fifth method: String type is a message to tell the user if they managed to login or not
        even after method 4 shows the message for incorrect usernames or passwords*/
    public void returnLoginStatus(String firstName, String lastName, String LoginuserName, String Loginpassword) {
         
         //Implimenting my 3rd method here for a simultaneous execution in main 
        if (LoginuserName.matches(userName) && Loginpassword.matches(password)) {
            
            //Referencing code on how to decorate my welcome to the user
    
    /************************************************************
    *********************************************************
    Title: JDialog - "line break" in between components
    Author: Hovercraft Full Of Eels, StackOverflow
    Date: 2017
    Code version: 2.0
    Availability: https://stackoverflow.com/questions/47846318/jdialog-line-break-in-between-components
    *********************************************************
    *************************************************************/
            
            final JDialog dialog = new JDialog((Frame) null, "", true);
            dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            dialog.setSize(425,450);
            dialog.setLocationRelativeTo(null);

            JLabel label = new JLabel();
            label.setIcon(new ImageIcon("Welcome.png"));
            dialog.add(label);
    
            //Referencing code on how to make the JOptionPane box close on its own
    
    /************************************************************
    *********************************************************
    Title: java joptionpane which automatically closes after few seconds
    Author: User0, StackOverflow
    Date: 2014
    Code version: 2.0
    Availability:https://stackoverflow.com/questions/25103186/java-joptionpane-which-automatically-closes-after-few-seconds
    *********************************************************
    *************************************************************/
            
            Timer timer = new Timer(4000, (ActionEvent e) -> {
               dialog.dispose();
            });
            timer.setRepeats(false);
            timer.start();
            dialog.setVisible(true);
            
            //Welcome
            ImageIcon gifIcon2 = new ImageIcon("Clover.gif");
            
            String[] newOptions2 = {};
            JOptionPane.showOptionDialog(null,
            firstName + ", " + lastName + " it is great to see you.",
            null,
            JOptionPane.DEFAULT_OPTION,
            JOptionPane.PLAIN_MESSAGE,
            gifIcon2,
            newOptions2,
            null);
           // return success;
            /*Returns this message to be displayed via a JOptionPane.showMessageDialog box 
            that will be implimented in main if loginUser is true*/
        } 
        else {
            JOptionPane.showMessageDialog(null,"Failed login");
            //return fail;
            /*Returns this message to be displayed via a JOptionPane.showMessageDialog box 
            that will be implimented in main if loginUser is false*/
        }
         //This method will be implicated in main within a JOptionPane.showMessageDialog box.
    }
    
  }
