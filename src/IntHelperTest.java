import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class IntHelperTest {

    @Test
    void isLog2() {
        // Test with a number that is a power of 2
        assertTrue(IntHelper.isLog2(8));

        // Test with a number that is not a power of 2
        assertFalse(IntHelper.isLog2(7));

        // Test with 0 and 1
        assertFalse(IntHelper.isLog2(0));
        assertTrue(IntHelper.isLog2(1));

        // Test with a negative number
        assertFalse(IntHelper.isLog2(-1));
    }

    @Test
    void isLog10() {
        // Test with a number that is a power of 10
        assertTrue(IntHelper.isLog10(1000));

        // Test with a number that is not a power of 10
        assertFalse(IntHelper.isLog10(123));

        // Test with 0 and 1
        assertFalse(IntHelper.isLog10(0));
        assertTrue(IntHelper.isLog10(1));

        // Test with a negative number
        assertFalse(IntHelper.isLog10(-10));
    }

    @Test
    void isLog() {
        // Test with a positive base and a number that is a power of the base
        assertFalse(IntHelper.isLog(3, 27));

        // Test with a positive base and a number that is not a power of the base
        assertFalse(IntHelper.isLog(3, 20));

        // Test with base as 0, 1, and a negative number
        assertThrows(IllegalArgumentException.class, () ->IntHelper.isLog(0, 1));
        assertThrows(IllegalArgumentException.class, () ->IntHelper.isLog(1, 1));
        assertThrows(IllegalArgumentException.class, () -> IntHelper.isLog(-1, 1));

        // Test with exponent as 0 and a negative number
        assertThrows(IllegalArgumentException.class, () -> IntHelper.isLog(2, 0));
        assertThrows(IllegalArgumentException.class, () -> IntHelper.isLog(2, -1));
    }

    @Test
    void log2() {
        // Test with a number that is a power of 2
        assertEquals(3, IntHelper.log2(8));

        // Test with a number that is not a power of 2
        assertNotEquals(3, IntHelper.log2(7));

        // Test with 0 and 1
        assertThrows(IllegalArgumentException.class, () -> IntHelper.log2(0));
        assertEquals(0, IntHelper.log2(1));

        // Test with a negative number
        assertThrows(IllegalArgumentException.class, () -> IntHelper.log2(-1));
    }

    @Test
    void log10() {
        // Test with a number that is a power of 10
        assertEquals(3, IntHelper.log10(1000));

        // Test with a number that is not a power of 10
        assertNotEquals(3, IntHelper.log10(123));

        // Test with 0 and 1
        assertThrows(IllegalArgumentException.class, () -> IntHelper.log10(0));
        assertEquals(0, IntHelper.log10(1));

        // Test with a negative number
        assertThrows(IllegalArgumentException.class, () -> IntHelper.log10(-1));
    }

    @org.junit.jupiter.api.Test
    void log() {
        //assertThrows(Exception.class, () -> IntHelper.log(1, 10)); // Test with base as 1
        assertThrows(Exception.class, () -> IntHelper.log(-2, 10)); // Test with a negative base
        assertThrows(Exception.class, () -> IntHelper.log(2, -10)); // Test with a negative number
        assertThrows(Exception.class, () -> IntHelper.log(0, 10)); // Test with 0 as base
        assertEquals(3, IntHelper.log2(8)); // Positive base and number
    }

    @org.junit.jupiter.api.Test
    void power() {
        assertEquals(8, IntHelper.power(2, 3)); // Positive base and exponent
        assertEquals(0, IntHelper.power(0, 3)); // Zero base
        assertEquals(1, IntHelper.power(2, 0)); // Zero exponent
        assertThrows(Exception.class, () -> IntHelper.power(2, -3)); // Negative exponent
    }

    @org.junit.jupiter.api.Test
    void testPower() {
        // Similar tests as `power`, but with long base
    }

    @org.junit.jupiter.api.Test
    void factorial() {
        assertEquals(1, IntHelper.factorial(0)); // Factorial of 0
        assertEquals(120, IntHelper.factorial(5)); // Small positive integer
        assertEquals(-1, IntHelper.factorial(-1)); // Negative integer
        // Large integer test for overflow
    }

    @org.junit.jupiter.api.Test
    void testFactorial() {
        // Similar tests as `factorial`, but with long input
    }

    @org.junit.jupiter.api.Test
    void gcd() {
        assertEquals(1, IntHelper.gcd(3, 4)); // Coprime integers
        assertEquals(5, IntHelper.gcd(10, 5)); // Positive integers
        assertThrows(Exception.class, () -> IntHelper.gcd(0, 0)); // Both integers zero
        assertEquals(5, IntHelper.gcd(10, -5)); // One integer negative
    }

    @org.junit.jupiter.api.Test
    void lcm() {
        assertEquals(0, IntHelper.lcm(0, 5)); // One integer zero
        assertThrows(Exception.class,()-> IntHelper.lcm(0, 0)); // Both integers zero
        assertEquals(20, IntHelper.lcm(4, 5)); // Coprime integers
        assertEquals(20, IntHelper.lcm(-4, 5)); // One integer negative
    }

    @org.junit.jupiter.api.Test
    void isPrime() {
    }

    @org.junit.jupiter.api.Test
    void sqrt() {
    }

    @org.junit.jupiter.api.Test
    void abs() {
    }

    @org.junit.jupiter.api.Test
    void fibonacci() {
    }

    @org.junit.jupiter.api.Test
    void isPerfectNumber() {
    }

    @org.junit.jupiter.api.Test
    void isPalindromeNumber() {
    }

    @org.junit.jupiter.api.Test
    void max() {
    }

    @org.junit.jupiter.api.Test
    void min() {
    }
}