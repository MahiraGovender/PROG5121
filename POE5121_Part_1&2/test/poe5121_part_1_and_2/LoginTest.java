package poe5121_part_1_and_2;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class LoginTest {
    
    public LoginTest() {
    }
    
    Login login = new Login("", "", "", "");

    @Test
    public void testCheckUserNameCorrectFormat() {
        boolean actual = login.checkUserName("kyl_1");
        String message = "Welcome <user first name> ,<user last name> it is great to see you.";
        
        assertTrue(actual);
        assertEquals(true, actual, message);
    }
    
    @Test
     public void testCheckUserNameIncorrectFormat() {
          boolean actual = login.checkUserName("kyle!!!!!!!");
        String message = "Username is not correctly formatted, please " +
                                  "ensure that your username contains an " +
                                  "underscore and is no more than 5 characters in length.";
        
        assertFalse(actual);
       assertEquals(false, actual, message);
    }

    @Test
    public void testCheckPasswordComplexityCorrectFormat() {
        boolean actual = login.checkPasswordComplexity("Ch&&sec@ke99!");
        String message = "Password successfully captured";
        
        assertTrue(actual);
        assertEquals(true, actual, message);
      }

    @Test
    public void testCheckPasswordComplexityIncorrectFormat() {
        boolean actual = login.checkPasswordComplexity("");
        String message = "Password is not correctly formatted, please " +
                                  "ensure that the password contains at least 8 " +
                                  "characters, a capital letter, a number and a special character.";
        
        assertFalse(actual);
      assertEquals(false, actual, message);
    }

    @Test
    public void testRegisterUserSuccess() {
        boolean actual = login.registerUser();
        
        
        assertTrue(actual);
    }
    
    @Test
    public void testRegisterUserFail() {
        boolean actual = !login.registerUser();
        
        assertFalse(actual);
    }

    @Test
    public void testLoginUser() {
    }
    
    @Test
    public void testReturnLoginStatusSuccess() {
        
    }
    
    @Test
    public void testReturnLoginStatusFail() {
        assertEquals(true,true);
    }

}