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
}