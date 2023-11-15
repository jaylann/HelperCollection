/*
 * - Lanfermann, Justin (jaylann). "HelperCollection." GitHub repository.
 *   https://github.com/jaylann/HelperCollection.
 *   Last commit: Wed 15. Nov 2023 17:15
 *
 * This file is part of the "HelperCollection" project, developed and maintained by
 * Justin Lanfermann (jaylann). For more information, updates, and terms of use,
 * please visit the GitHub repository.
 */

import java.util.Base64;
import java.util.Random;


public class StringHelper {

    // Reverses the given string
    public static String reverse(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }

        char[] charArray = str.toCharArray();
        int left = 0;
        int right = charArray.length - 1;
        while (left < right) {
            char temp = charArray[left];
            charArray[left] = charArray[right];
            charArray[right] = temp;
            left++;
            right--;
        }
        return new String(charArray);
    }

    // Checks if the string is a palindrome
    public static boolean isPalindrome(String str) {
        if (str == null) {
            return false;
        }

        str = str.toLowerCase();
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // Counts the number of occurrences of a specified character in the string
    public static int countOccurrences(String str, char ch) {
        if (str == null) {
            return 0;
        }

        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ch) {
                count++;
            }
        }
        return count;
    }

    // Removes all whitespace from the string
    public static String removeWhitespace(String str) {
        if (str == null) {
            return str;
        }

        return str.replaceAll("\\s", "");
    }

    // Capitalizes the first letter of each word in the string
    public static String capitalizeFirstLetter(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }

        char[] chars = str.toLowerCase().toCharArray();
        boolean capitalizeNext = true;

        for (int i = 0; i < chars.length; i++) {
            if (Character.isWhitespace(chars[i])) {
                capitalizeNext = true;
            } else if (capitalizeNext) {
                chars[i] = Character.toUpperCase(chars[i]);
                capitalizeNext = false;
            }
        }

        return new String(chars);
    }

    // Uncapitalizes the first letter of each word in the string
    public static String uncapitalizeFirstLetter(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }

        char[] chars = str.toCharArray();
        boolean uncapitalizeNext = true;

        for (int i = 0; i < chars.length; i++) {
            if (Character.isWhitespace(chars[i])) {
                uncapitalizeNext = true;
            } else if (uncapitalizeNext) {
                chars[i] = Character.toLowerCase(chars[i]);
                uncapitalizeNext = false;
            }
        }

        return new String(chars);
    }

    // Converts a string to camelCase
    public static String toCamelCase(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }

        str = str.toLowerCase();
        StringBuilder builder = new StringBuilder();
        boolean capitalizeNext = false;

        for (char c : str.toCharArray()) {
            if (Character.isLetter(c)) {
                if (capitalizeNext) {
                    builder.append(Character.toUpperCase(c));
                    capitalizeNext = false;
                } else {
                    builder.append(c);
                }
            } else {
                capitalizeNext = true;
            }
        }

        return builder.toString();
    }

    // Converts a string to snake_case
    public static String toSnakeCase(String str) {
        return toDelimitedCase(str, '_');
    }

    // Converts a string to kebab-case
    public static String toKebabCase(String str) {
        return toDelimitedCase(str, '-');
    }

    // Helper method for converting to a delimited case
    private static String toDelimitedCase(String str, char delimiter) {
        if (str == null || str.isEmpty()) {
            return str;
        }

        str = str.toLowerCase();
        StringBuilder builder = new StringBuilder();
        boolean wasPrevLetter = false;

        for (char c : str.toCharArray()) {
            if (Character.isLetter(c)) {
                if (wasPrevLetter) {
                    builder.append(delimiter);
                }
                builder.append(c);
                wasPrevLetter = false;
            } else {
                wasPrevLetter = true;
            }
        }

        return builder.toString();
    }

    // Generates a random string of a specified length
    public static String generateRandomString(int length) {
        if (length < 1) {
            throw new IllegalArgumentException("Length must be at least 1");
        }

        Random random = new Random();
        StringBuilder builder = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            builder.append((char) (random.nextInt(26) + 'a'));
        }
        return builder.toString();
    }
    // Checks if the string contains only numeric characters
    public static boolean isNumeric(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    // Checks if the string contains only alphabetic characters
    public static boolean isAlpha(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isLetter(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    // Checks if the string contains only alphanumeric characters
    public static boolean isAlphaNumeric(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isLetterOrDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    // Repeats the string n times
    public static String repeat(String str, int n) {
        if (str == null || n <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(str);
        }
        return sb.toString();
    }

    // Truncates the string to a specified length
    public static String truncate(String str, int length) {
        if (str == null || length < 0) {
            return "";
        }
        return str.length() > length ? str.substring(0, length) : str;
    }

    // Counts the number of words in the string
    public static int countWords(String str) {
        if (str == null || str.trim().isEmpty()) {
            return 0;
        }
        String[] words = str.trim().split("\\s+");
        return words.length;
    }

    // Replaces the last occurrence of a substring
    public static String replaceLast(String str, String from, String to) {
        if (str == null || from == null || to == null) {
            return str;
        }
        int lastIndex = str.lastIndexOf(from);
        if (lastIndex < 0) {
            return str;
        }
        return str.substring(0, lastIndex) + to + str.substring(lastIndex + from.length());
    }

    // Encodes the string to Base64
    public static String encodeToBase64(String str) {
        if (str == null) {
            return "";
        }
        return Base64.getEncoder().encodeToString(str.getBytes());
    }

    // Decodes the string from Base64
    public static String decodeFromBase64(String str) {
        if (str == null) {
            return "";
        }
        return new String(Base64.getDecoder().decode(str));
    }

    // Computes the Levenshtein distance between two strings
    public static int levenshteinDistance(String str1, String str2) {
        if (str1 == null || str2 == null) {
            return -1;
        }
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];

        for (int i = 0; i <= str1.length(); i++) {
            for (int j = 0; j <= str2.length(); j++) {
                if (i == 0) {
                    dp[i][j] = j;
                } else if (j == 0) {
                    dp[i][j] = i;
                } else {
                    int cost = (str1.charAt(i - 1) == str2.charAt(j - 1)) ? 0 : 1;
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1), dp[i - 1][j - 1] + cost);
                }
            }
        }
        return dp[str1.length()][str2.length()];
    }

    public static boolean isBlank(String str) {
        return str == null || str.trim().isEmpty();
    }

    public static String leftPad(String str, int length, char padChar) {
        if (str == null) {
            return null;
        }
        int padLength = length - str.length();
        StringBuilder sb = new StringBuilder();
        while (padLength-- > 0) {
            sb.append(padChar);
        }
        sb.append(str);
        return sb.toString();
    }

    public static String rightPad(String str, int length, char padChar) {
        if (str == null) {
            return null;
        }
        int padLength = length - str.length();
        StringBuilder sb = new StringBuilder(str);
        while (padLength-- > 0) {
            sb.append(padChar);
        }
        return sb.toString();
    }

    public static boolean containsOnly(String str, String validChars) {
        if (str == null || validChars == null) {
            return false;
        }
        for (char c : str.toCharArray()) {
            if (validChars.indexOf(c) == -1) {
                return false;
            }
        }
        return true;
    }

    public static String shuffle(String str) {
        if (str == null) {
            return null;
        }
        char[] characters = str.toCharArray();
        Random rnd = new Random();
        for (int i = characters.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            char a = characters[index];
            characters[index] = characters[i];
            characters[i] = a;
        }
        return new String(characters);
    }

    public static String substringBetween(String str, String open, String close) {
        if (str == null || open == null || close == null) {
            return null;
        }
        int start = str.indexOf(open);
        if (start != -1) {
            int end = str.indexOf(close, start + open.length());
            if (end != -1) {
                return str.substring(start + open.length(), end);
            }
        }
        return null;
    }

    public static String normalizeWhitespace(String str) {
        if (str == null) {
            return null;
        }
        return str.trim().replaceAll("\\s+", " ");
    }

    public static boolean isNullOrEmpty(String str) {
        return str == null || str.isEmpty();
    }

    public static String defaultIfNullOrEmpty(String str, String defaultStr) {
        return isNullOrEmpty(str) ? defaultStr : str;
    }

    public static String[] splitByLength(String str, int length) {
        if (str == null || length <= 0) {
            return null;
        }
        int parts = (str.length() + length - 1) / length;
        String[] result = new String[parts];
        for (int i = 0; i < parts; i++) {
            result[i] = str.substring(i * length, Math.min(str.length(), (i + 1) * length));
        }
        return result;
    }

    public static char[] getUniqueChars(String str) {
        if (str == null) {
            return null;
        }
        StringBuilder uniqueChars = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (uniqueChars.indexOf(String.valueOf(c)) == -1) {
                uniqueChars.append(c);
            }
        }
        char[] uniqueCharArray = new char[uniqueChars.length()];
        for (int i = 0; i < uniqueChars.length(); i++) {
            uniqueCharArray[i] = uniqueChars.charAt(i);
        }
        return uniqueCharArray;
    }

}


