/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package poe5121_part_1;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;


/**
 *
 * @author kaioc
 */
public class LoginTest {
    
    Login obj = new Login("", "");

        public LoginTest() {
    }

    @Test
    public void testCheckUserNameCorrect() {
          
        assertTrue(obj.checkUserName("kyl_1"));
                
        
    }
    
     @Test
    public void testCheckUserNameIncorrect() {
                String  username = "kyle!!!!!!!";
                
                assertFalse(false);
                
        
    }

    @Test
    public void testCheckPasswordComplexity() {
    }

    @Test
    public void testRegisterUser() {
    }

    @Test
    public void testLoginUser() {
    }

    @Test
    public void testReturnLoginStatus() {
    }
    
}
