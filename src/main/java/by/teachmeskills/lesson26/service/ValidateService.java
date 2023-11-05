package by.teachmeskills.lesson26.service;

public class ValidateService {

    public static boolean isValidName(String name) {
        return name == null || name.isEmpty();
    }

    public static boolean isValidDescription(String description) {
        return description == null || description.isEmpty();
    }
}
