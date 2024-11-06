import java.util.regex.*;

public class PasswordValidator {

    public static boolean isValidPassword(String pwd) {
        // Check if password length is between 8 and 16
        if (pwd.length() < 8 || pwd.length() > 16) {
            return false;
        }

        // Define patterns for each category with modified variable names
        Pattern lowerCaseCheck = Pattern.compile("[a-z]");
        Pattern upperCaseCheck = Pattern.compile("[A-Z]");
        Pattern digitCheck = Pattern.compile("[0-9]");
        Pattern specialCharCheck = Pattern.compile("[~!@#$%^&*()\\-=+_]");

        // Check for the presence of each category
        boolean containsLower = lowerCaseCheck.matcher(pwd).find();
        boolean containsUpper = upperCaseCheck.matcher(pwd).find();
        boolean containsDigit = digitCheck.matcher(pwd).find();
        boolean containsSpecial = specialCharCheck.matcher(pwd).find();

        // Count the number of categories present
        int numOfCategories = 0;
        if (containsLower) numOfCategories++;
        if (containsUpper) numOfCategories++;
        if (containsDigit) numOfCategories++;
        if (containsSpecial) numOfCategories++;

        // Password is valid if it contains at least 3 out of 4 categories
        return numOfCategories >= 3;
    }

    public static void main(String[] args) {
        // Test cases
        String[] passwords = {"joshgudger", "untameablejosh385f3", "DOJEF3489f!!", "eggsandbacon482AA", "passORfaIl!3"};

        for (String password : passwords) {
            System.out.println("Password: " + password + " is valid: " + isValidPassword(password));
        }
    }
}
