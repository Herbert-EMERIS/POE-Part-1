import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LoginTest {

    Login login = new Login();

    // --- assertTrue / assertFalse Tests (Screenshots 90 & 91) ---

    @Test
    public void testCheckUserNameCorrect() {
        assertTrue(login.checkUsername("kyl_1"));
    }

    @Test
    public void testCheckUserNameIncorrect() {
        assertFalse(login.checkUsername("kyle!!!!!!!"));
    }

    @Test
    public void testCheckPasswordComplexityCorrect() {
        assertTrue(login.checkPasswordComplexity("Ch&&sec@ke99!"));
    }

    @Test
    public void testCheckPasswordComplexityIncorrect() {
        assertFalse(login.checkPasswordComplexity("password"));
    }

    @Test
    public void testCheckCellPhoneNumberCorrect() {
        assertTrue(login.checkCellPhoneNumber("+27838968976"));
    }

    @Test
    public void testCheckCellPhoneNumberIncorrect() {
        assertFalse(login.checkCellPhoneNumber("08966553"));
    }

    @Test
    public void testLoginSuccessful() {
        // First register the user so there is data to log in with
        login.registerUser("kyl_1", "Ch&&sec@ke99!", "+27838968976", "Kyle", "Smith");
        assertTrue(login.loginUser("kyl_1", "Ch&&sec@ke99!"));
    }

    @Test
    public void testLoginFailed() {
        login.registerUser("kyl_1", "Ch&&sec@ke99!", "+27838968976", "Kyle", "Smith");
        assertFalse(login.loginUser("wrongUser", "wrongPass"));
    }

    // --- assertEquals Tests (Screenshots 88, 89, & 90) ---

    @Test
    public void testUsernameIncorrectlyFormattedMessage() {
        String expected = "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.";
        String actual = login.registerUser("kyle!!!!!!!", "Ch&&sec@ke99!", "+27838968976", "Kyle", "Smith");
        assertEquals(expected, actual);
    }

    @Test
    public void testPasswordIncorrectlyFormattedMessage() {
        String expected = "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
        // Passing a correct username but incorrect password to trigger the password error message
        String actual = login.registerUser("kyl_1", "password", "+27838968976", "Kyle", "Smith");
        assertEquals(expected, actual);
    }

    @Test
    public void testCellPhoneNumberIncorrectlyFormattedMessage() {
        String expected = "Cell number is incorrectly formatted or does not contain an international code; please correct the number and try again.";
        // Passing correct user/pass but incorrect cell to trigger cell error message
        String actual = login.registerUser("kyl_1", "Ch&&sec@ke99!", "08966553", "Kyle", "Smith");
        assertEquals(expected, actual);
    }
}