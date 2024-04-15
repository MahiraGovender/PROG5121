package poe5121_part_1;

//Import JOptionPane
import javax.swing.*; //* as a wild card

public class POE5121_Part_1 {

    public static void main(String[] args) {
        /*Registration will mostly happen here. User will be welcomed to my website/ application before
        proceeding to input their name and sure. However, before I write the code for that I'l create my
        Login class*/
        
        //My welcome to an unnamed user to make it more user friendly to strangers
        JOptionPane.showMessageDialog(null, "Welcome to my POE Application, Part 1.\nLet's begin your registration!");
        //Decor type coding can also be used here but I will keep it simple
        
        //For registration I will begin with capturing the user's first name
        String firstName = JOptionPane.showInputDialog(null, "Please enter your name.");
        
        /*Now I will check that the user's input matches my desired format
        This will prevent names from: being blank, having numbers or special characters in them*/
        
        //I will also use a loop to ensure a name meeting the criteria is entered
        do {
            //Checking against criteria
            if (firstName.isBlank() || firstName.matches(".*[0-9].*") ||
                    firstName.matches(".*[ '!' + '@' + '#' + '$' + '%' + '^' + '&' + '*' + '(' + ')' + '_' + '-' + '+' + '=' + '{' + '}' + '[' + ']' + '|' + ':' + ';' + '<' + ',' + '>' + '.' + '?' + '/' ].*"))
                /*Keeps showing me error code when I use anything else other than what's above*/
            {
                firstName = JOptionPane.showInputDialog(null, "Please enter your name.");
            }
            
            else {
                break; //Discontinues loop
            }
        }while (firstName.isBlank() || firstName.matches(".*[0-9].*") ||
                    firstName.matches(".*[ '!' + '@' + '#' + '$' + '%' + '^' + '&' + '*' + '(' + ')' + '_' + '-' + '+' + '=' + '{' + '}' + '[' + ']' + '|' + ':' + ';' + '<' + ',' + '>' + '.' + '?' + '/' ].*"));
        //I will now check that the loop functions correctly
        //It is perfectly operational
        
        //Next is the surname
        //User inputs their last name here
        String lastName = JOptionPane.showInputDialog(null, "Please enter your surname.");
        
        //The same process for first name will be implimented for last name
        
        /*I will check that the user's input matches my desired format
        This will prevent surnames from: being blank, having numbers or special characters in them*/
        
        //It will also use a loop to ensure a surname meeting the criteria is entered
        do {
            if (lastName.isBlank() || lastName.matches(".*[0-9].*") ||
                lastName.matches(".*[ '!' + '@' + '#' + '$' + '%' + '^' + '&' + '*' + '(' + ')' + '_' + '-' + '+' + '=' + '{' + '}' + '[' + ']' + '|' + ':' + ';' + '<' + ',' + '>' + '.' + '?' + '/' ].*"))
                 /*Keeps showing me error code when I use anything else other than what's above*/
            {
                lastName = JOptionPane.showInputDialog(null, "Please enter your surname.");
            }
            
            else {
                break; //Discontinues loop
            }
            
        }while (lastName.isBlank() || lastName.matches(".*[0-9].*") ||
                lastName.matches(".*[ '!' + '@' + '#' + '$' + '%' + '^' + '&' + '*' + '(' + ')' + '_' + '-' + '+' + '=' + '{' + '}' + '[' + ']' + '|' + ':' + ';' + '<' + ',' + '>' + '.' + '?' + '/' ].*"));
        
   
        Login login = new Login (firstName, lastName);
        //First is registerUser
       while (!login.registerUser()) {
        
       }
       
        //Next is to check that it works
        //Operational, now to add a loop
        //It is funtioning perfectly but I decided to extend the loop over first and lastName too
        //nevermind makes it too annoying to the user to keep re-entering their name and surname
        
         //Next is for the login feature of this program
       
        JOptionPane.showMessageDialog(null,login.returnLoginStatus());
     
        
        //I will check if it is operational before I add in a timed loop that will stop after 3 attempts
        //It works perfectly now to include a loop to double check
        //I'll just leave it alone
        
    }
    
}
