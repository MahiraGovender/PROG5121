package poe5121_part_1;

//Import JOptionPane
import javax.swing.*;

public class Login {
    /*Decided to incorparated first and last names along with username and password*/
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    
    //Create my constructer, must match the class's name
    public Login (String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
       
    }
    
    /*First method: boolean type to check that the user has inputted a correctly formatted username for
    registration*/
    public boolean checkUserName (String username) {
        this.username = username;
        /*This is the users input that will be tested putting user's input in here will allow me to impliment
        methods 1, 2  & 3  simultaniously in main*/
       username = JOptionPane.showInputDialog(null, """
                          Please create a username to register.
                          (Your username must be no longer than 5 characters long and must contain an underscore)""");
        
        /*If statement is redundent however, after I tested various other wys, this way is the only one
        that makes sure all conditions are tested*/
        if(!username.isBlank() && username.matches(".*[_].*") && username.length() <= 5) {
            return true;
            /*the application will only allow usernames that:
            are not blank, have an underscore and is 5 characters or less in length*/
        }
        
        else { //or else it is incorrectly formatted
            
            //This is the response to incorrect username formats
            JOptionPane.showMessageDialog(null, """
            Username is not correctly formatted, please ensure that your
            username contains an underscore and is no longer than 5 characters in length""");
            return false;
        }
        
    }
    
    //Second method: boolean type to check that the user's password meets the set criteria
    public boolean checkPasswordComplexity () {
            
        /*This is the users input that will be tested putting user's input in here will allow me to impliment
        methods 1, 2  & 3  simultaniously in main*/
        password = JOptionPane.showInputDialog(null, """
                          Please create a password to register.
                          (Your password must be 8 or more characters long,
                          must contain a capital letter, a number and a special character)""");
        
        /*If statement is redundent however, after I tested various other wys, this way is the only one
        that makes sure all conditions are tested*/
        if (!password.isBlank() && password.length() >= 8 &&
             password.matches(".*[A-Z].*") &&
             password.matches(".*[0-9].*") &&
             password.matches(".*[ '!' + '@' + '#' + '$' + '%' + '^' + '&' + '*' + '(' + ')' + '_' + '-' + '+' + '=' + '{' + '}' + '[' + ']' + '|' + ':' + ';' + '<' + ',' + '>' + '.' + '?' + '/' ].*"))
            /*Keeps showing me error code when I use anything else other than what's above*/
        { //Responce to correct formats allowing for a more user friendly, personalized welcome
            JOptionPane.showMessageDialog(null, "Password successfully captured");
            
            return true;
            /*The application only allows passwords that:
            are not blank, have a capital letter, have a number and have a special character*/
        }
        
        else { //or else it is incorrectly formatted
            JOptionPane.showMessageDialog(null, """
            Password is not correctly formatted, please ensure that the
            username contains at least 8 characters, a capital letter, a number and a special charcter""");
            return false;
        }
        
    }
    
    /*Third method: boolean type checks what both method 1 & 2 are returning before giving an appropriate
    response with regards to a user's registration status*/
    public boolean registerUser (/*Empty parameters because I am not taking any variables from main*/) {
        
        //Put methods 1 & 2 in If statement to check that if either are false before displaying registration failed
        //All three methods will be implimented simultaniously
        if (checkUserName(username) && checkPasswordComplexity()) {
            JOptionPane.showMessageDialog(null, "Registration successfull."); 
            return true;
        }
        
        else {
           JOptionPane.showMessageDialog(null, "Registration failed. Please ensure that the username and password meet the requirements");
            return false;
        }
        
      }
    
    /*Fourth method: boolean type is for the user to login, checks that the user's inputs for username
    and password match what they previously entered for their registration*/
    public boolean loginUser (/*Empty parameters because I am not taking any variables from main*/) {
        
        //Prompts user to capture their input in order to proceed with testing
        String loginUserName = JOptionPane.showInputDialog(null, "Please enter your username to login");
        String loginPassword =JOptionPane.showInputDialog(null, "Please enter your password to login");
        
        /*If statement checks that they both match what was previously entered before the application
        can proceed to the next instruction*/
        if (loginUserName.matches(username) && loginPassword.matches(password)) {
            return true;
            //Signal to proceed
        }
        
        else { //Alerts user that they made a mistake and it triggers the loop I will create in main
            JOptionPane.showMessageDialog(null, "Invalid username or password. Please try again.");
            return false;
        }
        //This method will be implicated in method 5 not main for simultainious execution as well
    }
    
    /*Fifth method: String type is a message to tell the user if they managed to login or not
    even after method 4 shows the message for incorrect usernames or passwords*/
    public String returnLoginStatus (/*Empty parameters because I am not taking any variables from main*/) {
        
        //Executes both methods
        if (loginUser()) {
            String success = "Successful login! \nWelcome " + firstName + ", " + lastName + " it is great to see you.";
            return success;
            /*Returns this message to be displayed via a JOptionPane.showMessageDialog box 
            that will be implimented in main if loginUser is true*/
        }
        
        else {
            String fail = "Failed login";
            return fail;
            /*Returns this message to be displayed via a JOptionPane.showMessageDialog box 
            that will be implimented in main if loginUser is false*/
        }
        //This method will be implicated in main within a JOptionPane.showMessageDialog box.
    }
    /*Now I will begin coding in main for firstName and lastName for them to be incorparated in 
    checkPassword and for registration. registerUser and returnLoginStatus methods also have to be 
    implicated in main too*/
    
}
