package icu.xiii;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.security.SecureRandom;

public class PasswordGenerator {

    private static final String LOWER = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPER = LOWER.toUpperCase();
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL_CHARS = "!@#$%&*()_+-=[]?";
    private static final List<String> CHAR_CATEGORIES;

    private static final SecureRandom RANDOM = new SecureRandom();

    static {
        CHAR_CATEGORIES = new ArrayList<>(4);
        CHAR_CATEGORIES.add(LOWER);
        CHAR_CATEGORIES.add(UPPER);
        CHAR_CATEGORIES.add(DIGITS);
        CHAR_CATEGORIES.add(SPECIAL_CHARS);
    }

    public String generatePassword(int len) {
        if (len <= 0) {
            return "";
        }

        StringBuilder password = new StringBuilder(len);

        for (int i = 0; i < len; i++) {
            String charCategory = CHAR_CATEGORIES.get(
                    RANDOM.nextInt(CHAR_CATEGORIES.size())
            );

            password.append(charCategory.charAt(
                    RANDOM.nextInt(charCategory.length()))
            );
        }

        return password.toString();
    }
}
