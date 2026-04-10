public class Login {
    private String storedUsername;
    private String storedPassword;
    private String firstName;
    private String lastName;
    
    public boolean checkUsername(String username) {
        return username.contains("_") && username.length() <= 5; //Performing a method check//
    }
    
    public boolean checkCellPhoneNumber(String phoneNumber) {
        return phoneNumber.startsWith("+") && phoneNumber.substring(1).length() <= 10;
    }
    
    public boolean checkPasswordComplexity(String password) {
        //the password needs a capital letter, a number and a special charecter//
        String regex = "^(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]).{8,}$";
        return password.matches(regex);
    }
    
    public String registerUser(String username, String password, String cellPhoneNumber, String firstName, String lastName) {
        if (!checkUsername(username)) {
            return "Username is not correct formatted; please ensure that your username contains an underscore and is more than five characters long.";
        }
        if (!checkCellPhoneNumber(cellPhoneNumber)) {
            return "Cell number is incorrectly formatted or does not contain the international code, please corrct the number and try again.";
        }
        if (!checkPasswordComplexity(password)) {
            return "Password is not correctly formatted, please ensure the password contains at least 8 digit characters, a numberand a special character.";            
        }
        
        this.storedUsername = username;
        this.storedPassword = password;
        this.firstName = firstName;
        this.lastName = lastName; //"this' will store all the user details once every check has been validated//
        
        return "Wlcome " + firstName + ", " + lastName + "it is great to see you.";
    }
    
    public boolean loginUser(String username, String password) {
        return username.equals(this.storedUsername) && password.equals(this.storedPassword);
    }
    
    public String returnLoginStatus(boolean isLoggedIn) {
        if (isLoggedIn) {
            return "Welcome " + firstName + ", " + lastName + "It is great to see you.";
        } else {
            return "Username or password is incorrect, please try again.";
        }
    }
}