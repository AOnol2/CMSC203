/**
 * Class: CMSC203 CRN23488
 * Instructor: Dr. Aygun
 * Assignment #3
 * Description: Encrypt and decrypt a phrase using Caesar and Bellaso ciphers.
 * Due: 10/14/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently.
 * Print your Name here: Ata Onol
 */
import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CryptoManagerTestStudent {

    @BeforeEach
    void setUp() {}
    @AfterEach
    void tearDown() {}

    @Test
    void testStringInvalidBoundsCaesar() {
        assertEquals("The selected string is not in bounds. Try again.", CryptoManager.caesarEncryption("~A@FGVCA@!", 12));
    }

    @Test
    void testEncryptCaesar() {
        assertEquals(">U9DCIUL6CIUIDU<DUI=:G:", CryptoManager.caesarEncryption("I DONT WANT TO GO THERE", 53));
        assertEquals("/F25<+F:;81/?+", CryptoManager.caesarEncryption("I LOVE TURKIYE", 38));
    }

    @Test
    void testDecryptCaesar() {
        assertEquals("I DONT WANT TO GO THERE", CryptoManager.caesarDecryption(">U9DCIUL6CIUIDU<DUI=:G:", 53));
        assertEquals("I LOVE TURKIYE", CryptoManager.caesarDecryption("/F25<+F:;81/?+", 38));
    }

    @Test
    void testStringInvalidBoundsBellaso() {
        assertEquals("The selected string is not in bounds. Try again.", CryptoManager.bellasoEncryption("5123%~", "DSA"));
    }

    @Test
    void testEncryptBellaso() {
        assertEquals("Q%P[]ERJIS ,#@R:W% TTC7", CryptoManager.bellasoEncryption("I DONT WANT TO GO THERE", "HELLO123"));
        assertEquals("Q%X[%M%%[$", CryptoManager.bellasoEncryption("I LOVE TURKIYE", "HELLO"));
    }

    @Test
    void testDecryptBellaso() {
        assertEquals("I DONT WANT TO GO THERE", CryptoManager.bellasoDecryption("Q%P[]ERJIS ,#@R:W% TTC7", "HELLO123"));
        assertEquals("I LOVE TURKIYE", CryptoManager.bellasoDecryption("Q%X[%M%%[$", "HELLO"));
    }
}
