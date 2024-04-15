package poe5121_part_1;

//Import JOptionPane
import javax.swing.*; //* as a wild card

public class POE5121_Part_1 {

    public static void main(String[] args) {
        Login login = new Login("", "", "", ""); //Implments my Login class
        
        JOptionPane.showMessageDialog(null, "Welcome to my website"); //introduction to new user
       
       //input user's name       
       String firstName =  JOptionPane.showInputDialog(null, "Please enter your First Name to register");
       
       //Referencing code on how to do a do while loop with user input
    
    /************************************************************
    *********************************************************
    Title: JOptionPane.showInputDialog loop (using do while loop)
    Author: asiew, StackOverflow
    Date: 2015
    Code version: 2.0
    Availability: http:www.overflow.com/questions/343943359/
    joptionpane-showinputdialog-loop-using-do-while-loop
    *********************************************************
    *************************************************************/
       
         //Name is required field with a set format
         do {
           if (firstName.isBlank() || firstName.matches(".*[0-9].*") || 
              firstName.matches(".*[  '!' + '@' + '#' + '$' + '%' + '^' + '&' + '*' + '(' + ')' + '-' + '_' + '+' + '=' + '{' + '}' + '[' + ']' + ';' + ':' + '<' + '>' + ',' + '.' + '?' + '/' + '|'].*")) {
               
               //First name must not be blank nor have a number or a special character in it
           firstName = JOptionPane.showInputDialog(null, "Please enter your First Name to register");
           }
           
           else {
                 
           break;} //Discontinues loop
           
         }while (firstName.isBlank() || firstName.matches(".*[0-9].*") ||
                   firstName.matches(".*[  '!' + '@' + '#' + '$' + '%' + '^' + '&' + '*' + '(' + ')' + '-' + '_' + '+' + '=' + '{' + '}' + '[' + ']' + ';' + ':' + '<' + '>' + ',' + '.' + '?' + '/' + '|'].*"));
         //Loop for incorrect firstNames
              
       //Input user's surname       
        String lastName =  JOptionPane.showInputDialog(null, "Please enter your Last Name to register");
        
         //Surname is required field with a set format
         do {
              if (lastName.isBlank() || lastName.matches(".*[0-9].*")||
                 lastName.matches(".*[  '!' + '@' + '#' + '$' + '%' + '^' + '&' + '*' + '(' + ')' + '-' + '_' + '+' + '=' + '{' + '}' + '[' + ']' + ';' + ':' + '<' + '>' + ',' + '.' + '?' + '/' + '|'].*")) {
                 
                  //Last name must not be blank nor have a number or a special character in it
                 lastName = JOptionPane.showInputDialog(null, "Please enter your Last Name to register");
              }
              
              else {
                  
                  break; //Discontinues loop
              }
           
         }while (lastName.isBlank() || lastName.matches(".*[0-9].*")||
                   lastName.matches(".*[  '!' + '@' + '#' + '$' + '%' + '^' + '&' + '*' + '(' + ')' + '-' + '_' + '+' + '=' + '{' + '}' + '[' + ']' + ';' + ':' + '<' + '>' + ',' + '.' + '?' + '/' + '|'].*"));
                   //Loop for incorrect firstNames
        
        //Input new userName
        String userName = JOptionPane.showInputDialog(null, """
                Please create a user Name to register.
                (Your User Name must be no longer than 5 characters long and must contain an underscore)""");
        
        if (!login.checkUserName(userName)) {
       
        //Loop for incorrectly formatted usernames
            do { 
                
                 JOptionPane.showMessageDialog(null, 
                "Username is not correctly formatted, please ensure that your "
                + "username contains an underscore and is no longer than 5 characters in length");
                 
                 //Displays registration failed only
                  login.registerUser();
                  
                  //Re-promptes user to recapture username
                  userName =  JOptionPane.showInputDialog(null, """
                Please create a user Name to register.
                (Your User Name must be no longer than 5 characters long and must contain an underscore)""");
               }while (!login.checkUserName(userName)); //Exits with a correctly formatted username
            
          }
          
        //Input new password
        String password =  JOptionPane.showInputDialog(null,  """
        Please create a password to register.
        (Your password must be 8 or more characters long,
        must contain a capital letter, a number and a special character)""");
            
        if (!login.checkPasswordComplexity(password)) {
              
           //Loop response for incorrectly formatted passwords
           do {  
               
                 JOptionPane.showMessageDialog(null, """
                  Password is not correctly formatted, please ensure that the 
                  password contains at least 8 characters, a capital letter, a number and a special character""");
                 
                 //Displays registration failed only
                 login.registerUser();
                 
                 //Re-promptes user to recapture password
                 password =  JOptionPane.showInputDialog(null,  """
               Please create a password to register.
               (Your password must be 8 or more characters long,
               must contain a capital letter, a number and a special character)""");
                 
             }while (!login.checkPasswordComplexity(password)); //Exits with a correctly formatted password
         }
        //Correct password format response
         else {
             JOptionPane.showMessageDialog(null, "Password successfully captured");
           }
        
        //Response to correctly formatted usernames and passwords
        //Only displays registration successful 
        login.registerUser();
     
        //Simultaneous execution of method 4 and 5 to display login success at the end in JOptionPane.showMessageDialog box
        JOptionPane.showMessageDialog(null, login.returnLoginStatus(firstName, lastName));

    }
    
}
