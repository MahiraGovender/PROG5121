package poe5121_part_1;

//Import JOptionPane
import javax.swing.*; //* as a wild card

public class POE5121_Part_1 {

    public static void main(String[] args) {
        Login login = new Login("", "", "", "");
        
        JOptionPane.showMessageDialog(null, "Welcome to my website"); //introduction to new user
       
       //input user's name       
       String firstName =  JOptionPane.showInputDialog(null, "Please enter your First Name to register");
       
       //Name is required field with a set format
         do {
           if (firstName.isBlank() || firstName.matches(".*[0-9].*") || 
              firstName.matches(".*[  '!' + '@' + '#' + '$' + '%' + '^' + '&' + '*' + '(' + ')' + '-' + '_' + '+' + '=' + '{' + '}' + '[' + ']' + ';' + ':' + '<' + '>' + ',' + '.' + '?' + '/' + '|'].*")) {
               
           firstName = JOptionPane.showInputDialog(null, "Please enter your First Name to register");
           }
           
           else {
                 
           break;}
           
         }while (firstName.isBlank() || firstName.matches(".*[0-9].*") ||
                   firstName.matches(".*[  '!' + '@' + '#' + '$' + '%' + '^' + '&' + '*' + '(' + ')' + '-' + '_' + '+' + '=' + '{' + '}' + '[' + ']' + ';' + ':' + '<' + '>' + ',' + '.' + '?' + '/' + '|'].*"));
              
       //Input user's surname       
        String lastName =  JOptionPane.showInputDialog(null, "Please enter your Last Name to register");
        
       //Surname is required field with a set format
       do {
              if (lastName.isBlank() || lastName.matches(".*[0-9].*")||
                 lastName.matches(".*[  '!' + '@' + '#' + '$' + '%' + '^' + '&' + '*' + '(' + ')' + '-' + '_' + '+' + '=' + '{' + '}' + '[' + ']' + ';' + ':' + '<' + '>' + ',' + '.' + '?' + '/' + '|'].*")) {
           
                 lastName = JOptionPane.showInputDialog(null, "Please enter your Last Name to register");
              }
              
              else {
                  
                  break;
              }
           
         }while (lastName.isBlank() || lastName.matches(".*[0-9].*")||
                   lastName.matches(".*[  '!' + '@' + '#' + '$' + '%' + '^' + '&' + '*' + '(' + ')' + '-' + '_' + '+' + '=' + '{' + '}' + '[' + ']' + ';' + ':' + '<' + '>' + ',' + '.' + '?' + '/' + '|'].*"));
      
        
        
                 
       //Input new userName
          
          String userName = JOptionPane.showInputDialog(null, """
                Please create a user Name to register.
                (Your User Name must be no longer than 5 characters long and must contain an underscore)""");
        
        if (!login.checkUserName(userName)) {
       
        //the loop for username format
            do {
                 JOptionPane.showMessageDialog(null, 
                "Username is not correctly formatted, please ensure that your "
                + "username contains an underscore and is no longer than 5 characters in length");
                 
                  login.registerUser();
                  
                  userName =  JOptionPane.showInputDialog(null, """
                Please create a user Name to register.
                (Your User Name must be no longer than 5 characters long and must contain an underscore)""");
               }while (!login.checkUserName(userName));
            
          }
          
            //Input new password
            String password =  JOptionPane.showInputDialog(null,  """
            Please create a password to register.
            (Your password must be 8 or more characters long,
            must contain a capital letter, a number and a special character)""");
            
        if (!login.checkPasswordComplexity(password)) {
              
           //Loop response for password format
           do {  
               
                 JOptionPane.showMessageDialog(null, """
                  Password is not correctly formatted, please ensure that the 
                  password contains at least 8 characters, a capital letter, a number and a special character""");
                 
                 login.registerUser();
                 
                 password =  JOptionPane.showInputDialog(null,  """
               Please create a password to register.
               (Your password must be 8 or more characters long,
               must contain a capital letter, a number and a special character)""");
                 
             }while (!login.checkPasswordComplexity(password));
         }
        //Correct password format response
         else {
             JOptionPane.showMessageDialog(null, "Password successfully captured");
           }
        
        
        login.registerUser();
     

        JOptionPane.showMessageDialog(null, login.returnLoginStatus());

    }
    
}
