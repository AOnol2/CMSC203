/**
 * Class: CMSC203 CRN23488
 * Instructor: Dr. Aygun
 * Assignment #3
 * Description: (Encrypt and decrypt a phrase using Caesar and Bellaso ciphers.)
 * Due: 10/14/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently.
 * Print your Name here: Ata Onol
 */

/**
 * This is a utility class that encrypts and decrypts a phrase using two different approaches.
 * The first approach is called the Caesar Cipher and the second approach is the Bellaso Cipher.
 * Both are substitution ciphers with varying logic.
 */
public class CryptoManager {

    private static final char LOWER_RANGE = ' '; // ASCII Space character
    private static final char UPPER_RANGE = '_'; // ASCII Underscore character
    private static final int RANGE = UPPER_RANGE - LOWER_RANGE + 1; // Total range for wrapping characters
    private static final String ERROR_MESSAGE = "The selected string is not in bounds. Try again."; // Error for out-of-bound strings

    /**
     * Checks if all characters in plainText are within the valid ASCII range.
     */
    public static boolean isStringInBounds(String plainText) {
        for (char c : plainText.toCharArray()) {
            if (c < LOWER_RANGE || c > UPPER_RANGE) {
                return false; // Return false if any character is out of bounds
            }
        }
        return true; // All characters are in range
    }

    /**
     * Encrypts a string using the Caesar Cipher. Adds the given key to each character.
     */
    public static String caesarEncryption(String plainText, int key) {
        key = adjustKey(key); // Adjust key to fit within ASCII range
        if (!isStringInBounds(plainText)) return ERROR_MESSAGE;

        StringBuilder encrypted = new StringBuilder();
        for (char c : plainText.toCharArray()) {
            char encryptedChar = (char) (c + key);
            if (encryptedChar > UPPER_RANGE) encryptedChar -= RANGE; // Wrap if exceeds range
            encrypted.append(encryptedChar);
        }
        return encrypted.toString();
    }

    /**
     * Decrypts a Caesar Cipher by subtracting the key from each character.
     */
    public static String caesarDecryption(String encryptedText, int key) {
        key = adjustKey(key); // Adjust key for the Caesar cipher
        if (encryptedText.equals(ERROR_MESSAGE)) return ERROR_MESSAGE;

        StringBuilder decrypted = new StringBuilder();
        for (char c : encryptedText.toCharArray()) {
            char decryptedChar = (char) (c - key);
            if (decryptedChar < LOWER_RANGE) decryptedChar += RANGE; // Wrap if below range
            decrypted.append(decryptedChar);
        }
        return decrypted.toString();
    }

    /**
     * Encrypts a string using the Bellaso Cipher, offsetting each character by a character from bellasoStr.
     */
    public static String bellasoEncryption(String plainText, String bellasoStr) {
        bellasoStr = adjustKey(plainText, bellasoStr); // Ensure bellasoStr matches plainText length
        StringBuilder bellasoEncrypted = new StringBuilder();
        int modifiedASCII;

        // Encrypt if string is in bounds
        if (isStringInBounds(plainText)) {
            for (int i = 0; i < plainText.length(); i++) {
                char plainChar = plainText.charAt(i);
                char bellasoChar = bellasoStr.charAt(i);

                // If plainText + bellasoStr exceeds upper range, subtract range
                modifiedASCII = plainChar + bellasoChar;
                while (modifiedASCII > UPPER_RANGE) {
                    modifiedASCII -= RANGE;  // Continue wrapping until within range
                }
                bellasoEncrypted.append((char) modifiedASCII);
            }
            return bellasoEncrypted.toString();
        } else {
            return ERROR_MESSAGE;  // If string is out of bounds, return an error message
        }
    }

    /**
     * Decrypts a string using the Bellaso Cipher by reversing the offset from bellasoStr.
     */
    public static String bellasoDecryption(String encryptedText, String bellasoStr) {
        bellasoStr = adjustKey(encryptedText, bellasoStr); // Ensure bellasoStr matches encryptedText length
        StringBuilder bellasoDecrypted = new StringBuilder();
        int modifiedASCII;

        // Decrypt if string is valid
        if (!encryptedText.equals(ERROR_MESSAGE)) {
            for (int i = 0; i < encryptedText.length(); i++) {
                char encryptedChar = encryptedText.charAt(i);
                char bellasoChar = bellasoStr.charAt(i);

                // If encryptedText - bellasoStr goes below lower range, add range
                modifiedASCII = encryptedChar - bellasoChar;
                while (modifiedASCII < LOWER_RANGE) {
                    modifiedASCII += RANGE;  // Continue wrapping until within range
                }
                bellasoDecrypted.append((char) modifiedASCII);
            }
            return bellasoDecrypted.toString();
        } else {
            return ERROR_MESSAGE;  // Return an error if the input is invalid
        }
    }

    /**
     * Adjusts the integer key to fit within the acceptable ASCII range (32-95).
     */
    private static int adjustKey(int key) {
        key %= RANGE; // Use modulus to keep key within range
        return key < 0 ? key + RANGE : key; // Ensure key is positive
    }

    /**
     * Adjusts the key string (bellasoStr) to match the length of the plainText or encryptedText.
     */
    private static String adjustKey(String text, String key) {
        StringBuilder adjustedKey = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            adjustedKey.append(key.charAt(i % key.length())); // Repeat key to match text length
        }
        return adjustedKey.toString();
    }
}