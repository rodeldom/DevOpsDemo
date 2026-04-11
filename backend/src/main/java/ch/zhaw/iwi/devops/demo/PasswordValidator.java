package ch.zhaw.iwi.devops.demo;

public class PasswordValidator {

    // public static boolean isValid(String password) {
    // return password.length() >= 8;
    // }

    public static boolean isValid(String password) {
        boolean longEnough = password.length() >= 8;
        boolean hasNumber = password.chars().anyMatch(Character::isDigit);
        boolean hasUpper = password.chars().anyMatch(Character::isUpperCase);
        return longEnough && hasNumber && hasUpper;
    }

}
