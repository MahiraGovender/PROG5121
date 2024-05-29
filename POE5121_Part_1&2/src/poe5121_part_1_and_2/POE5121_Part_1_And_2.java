package poe5121_part_1_and_2;

//Import JOptionPane
import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*; //* as a wild card

public class POE5121_Part_1_And_2 {

    public static void main(String[] args) {
        Login login = new Login("", "", "", ""); //Implments my Login class
        
        //introduction to new user
        
        //Referencing code on how to decorate my intro to the user
    
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
        dialog.setSize(500,500);
        dialog.setLocationRelativeTo(null);

        JLabel label = new JLabel();
        label.setIcon(new ImageIcon("EasyKanBan.gif"));
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
        
        //Implementing task class
        Tasks task = new Tasks();
            int option = 0;
        
        while (option != 2) {
        
        ImageIcon icon = new ImageIcon("CuteKitty.png");
            
        String[] options = {"Add Tasks", "Show Report", "Exit"};
        option = JOptionPane.showOptionDialog(null,
        null,
        "Select an option please",
        JOptionPane.DEFAULT_OPTION,
        JOptionPane.PLAIN_MESSAGE,
        icon,
        options,
        options[0]);

        switch (option) {
        //add tasks
        case 0:
        if (login.loginUser(firstName, lastName)) {
            task.taskDetails(firstName, lastName);
            Tasks.setTotalTasks(0);
        }
        break;

        //coming soon
        case 1:
        final JDialog showReport = new JDialog((Frame) null, "", true);
        showReport.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        showReport.setSize(225,225);
        showReport.setLocationRelativeTo(null);
        JLabel message = new JLabel();
        message.setIcon(new ImageIcon("ComingSoon.png"));
        
        showReport.add(message);
        showReport.setVisible(true);
        break;

        //exit application
        case 2:
        ImageIcon gifIcon = new ImageIcon("Clover.gif");
            
        String[] newOptions = {};
        JOptionPane.showOptionDialog(null,
        "See you next time " + firstName + ", " + lastName,
        null,
        JOptionPane.DEFAULT_OPTION,
        JOptionPane.PLAIN_MESSAGE,
        gifIcon,
        newOptions,
        null);
        System.exit(0);
        break;

        default:
        ImageIcon gifIcon2 = new ImageIcon("Clover.gif");
            
        String[] newOptions2 = {};
        JOptionPane.showOptionDialog(null,
        "See you next time " + firstName + ", " + lastName,
        null,
        JOptionPane.DEFAULT_OPTION,
        JOptionPane.PLAIN_MESSAGE,
        gifIcon2,
        newOptions2,
        null);
        System.exit(0);
                   
            }
        }
        
    }
    
    
    
}
