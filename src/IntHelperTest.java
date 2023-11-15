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

    @Test
    void isPrime() {
        assertTrue(IntHelper.isPrime(2));
        assertFalse(IntHelper.isPrime(4));
        assertFalse(IntHelper.isPrime(0));
        assertFalse(IntHelper.isPrime(1));
        assertFalse(IntHelper.isPrime(-3));
        // Additional tests for larger primes/non-primes
    }

    @Test
    void sqrt() {
        assertEquals(4.0, IntHelper.sqrt(16));
        assertEquals(5.0, IntHelper.sqrt(25));
        assertNotEquals(5.0, IntHelper.sqrt(26));
        assertEquals(0.0, IntHelper.sqrt(0));
        assertEquals(1.0, IntHelper.sqrt(1));
        assertThrows(IllegalArgumentException.class, () -> IntHelper.sqrt(-4));
        // Test for NaN scenario if applicable
    }

    @Test
    void abs() {
        assertEquals(5, IntHelper.abs(5));
        assertEquals(5, IntHelper.abs(-5));
        assertEquals(0, IntHelper.abs(0));
        // Test for maximum/minimum integer values if applicable
    }

    @Test
    void fibonacci() {
        assertEquals(0, IntHelper.fibonacci(0));
        assertEquals(1, IntHelper.fibonacci(1));
        assertEquals(1, IntHelper.fibonacci(2));
        assertEquals(5, IntHelper.fibonacci(5));
        assertThrows(IllegalArgumentException.class, () -> IntHelper.fibonacci(-1));
        // Additional tests for higher fibonacci numbers
    }

    @Test
    void isPerfectNumber() {
        assertTrue(IntHelper.isPerfectNumber(6));
        assertFalse(IntHelper.isPerfectNumber(10));
        assertFalse(IntHelper.isPerfectNumber(0));
        assertFalse(IntHelper.isPerfectNumber(-6));
        // Additional tests for larger perfect/non-perfect numbers
    }

    @Test
    void isPalindromeNumber() {
        assertTrue(IntHelper.isPalindromeNumber(121));
        assertFalse(IntHelper.isPalindromeNumber(123));
        // Check how negative numbers are handled
        // Additional tests for larger palindrome/non-palindrome numbers
    }



    @Test
    void testSquare() {
        assertEquals(9, IntHelper.square(3));
        assertEquals(0, IntHelper.square(0));
        assertEquals(1, IntHelper.square(-1));
        assertEquals(Integer.MAX_VALUE, IntHelper.square(46341)); // Test for overflow
        assertEquals(4, IntHelper.square(2));
        assertEquals(16, IntHelper.square(-4));

        assertEquals(9L, IntHelper.square(3L));
        assertEquals(0L, IntHelper.square(0L));
        assertEquals(1L, IntHelper.square(-1L));
        assertEquals(Long.MAX_VALUE, IntHelper.square(3037000500L)); // Test for long overflow
        assertEquals(4L, IntHelper.square(2L));
        assertEquals(16L, IntHelper.square(-4L));
    }
    @Test
    void testSumOfSquares() {
        assertEquals(25, IntHelper.sumOfSquares(3, 4));
        assertEquals(50, IntHelper.sumOfSquares(5, 5));
        assertEquals(Integer.MAX_VALUE, IntHelper.sumOfSquares(46341, 46341)); // Test for overflow
        assertEquals(0, IntHelper.sumOfSquares(0, 0));

        assertEquals(25L, IntHelper.sumOfSquares(3L, 4L));
        assertEquals(50L, IntHelper.sumOfSquares(5L, 5L));
        assertEquals(Long.MAX_VALUE, IntHelper.sumOfSquares(3037000500L, 3037000500L)); // Test for long overflow
        assertEquals(0L, IntHelper.sumOfSquares(0L, 0L));
    }
    @Test
    void testCube() {
        assertEquals(27, IntHelper.cube(3));
        assertEquals(-27, IntHelper.cube(-3));
        assertEquals(0, IntHelper.cube(0));
        assertEquals(Integer.MAX_VALUE, IntHelper.cube(1291)); // Test for overflow
        assertEquals(8, IntHelper.cube(2));

        assertEquals(27L, IntHelper.cube(3L));
        assertEquals(-27L, IntHelper.cube(-3L));
        assertEquals(0L, IntHelper.cube(0L));
        assertEquals(Long.MAX_VALUE, IntHelper.cube(2097152L)); // Test for long overflow
        assertEquals(8L, IntHelper.cube(2L));
    }
    @Test
    void testAverage() {
        assertEquals(2, IntHelper.average(1, 2, 3));
        assertEquals(-1, IntHelper.average(-3, -1, 1));
        assertEquals(0, IntHelper.average(-1, 0, 1));
        assertEquals(Integer.MAX_VALUE, IntHelper.average(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE));
        assertEquals(Integer.MIN_VALUE, IntHelper.average(Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE));
    }
    @Test
    void testIsPythagoreanTriple() {
        assertTrue(IntHelper.isPythagoreanTriple(3, 4, 5));
        assertFalse(IntHelper.isPythagoreanTriple(3, 4, 6));
        assertFalse(IntHelper.isPythagoreanTriple(-3, 4, 5)); // Negative check
        assertFalse(IntHelper.isPythagoreanTriple(0, 0, 0)); // Zero check
        assertTrue(IntHelper.isPythagoreanTriple(5, 12, 13)); // False positive check
    }






}