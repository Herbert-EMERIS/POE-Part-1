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
        String regex = "(?[A-Z])(0-9)([@_-.&])";
        return password.matches(regex);
    }
    
    public String registerUser(String username, String password, String cellPhoneNumber, String firstName, String lastName) {
        if (!checkUserName(username)) {
            return "Username is not correct formatted; please ensure that your username contains an underscore and is more than five characters long.";
        }
        if 
    }
}