public class Error {
    public static boolean isInteger(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    public static boolean isValidName(String name) {
        if(name.matches("[a-zA-Z\\s]+")) {
            return true;
        }
        return false;
    }
    public static boolean checkAge(int age) {
        try {
            if (age > 0) {
                return true;
            }
            return false;
        }
        catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            return false;
        }
    }
    public static boolean checkGender(int gender) {
        if (gender == 0 || gender ==1) {
            return true;
        }
        return false;
    }
}