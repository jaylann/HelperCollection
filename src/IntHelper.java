/*
 * - Lanfermann, Justin (jaylann). "HelperCollection." GitHub repository.
 *   https://github.com/jaylann/HelperCollection.
 *   Last commit: Wed, 20th December 2023, 17:00
 *
 * This file is part of the "HelperCollection" project, developed and maintained by
 * Justin Lanfermann (jaylann). For more information, updates, collaborators and terms of use,
 * please visit the GitHub repository.
 */


public class IntHelper {
    public static boolean isLog2(int num) {
        if (num < 1) {
            return false;
        }
        while (num > 1) {
            if (num % 2 != 0) {
                return false;
            }
            num = num / 2;
        }
        return true;
    }

    public static boolean isLog10(int num) {
        if (num < 1) {
            return false;
        }
        while (num > 1) {
            if (num % 10 != 0) {
                return false;
            }
            num = num / 10;
        }
        return true;
    }

    public static boolean isLog(int num, int base) {
        if (base <= 1) {
            throw new IllegalArgumentException("Base must be greater than 1");
        }
        while (num > 1) {
            if (num % base != 0) {
                return false;
            }
            num = num / base;
        }
        return true;
    }

    /**
     * Calculates the logarithm base 2 of an integer.
     *
     * @param num The number to calculate the log base 2 of.
     * @return The floor value of the logarithm base 2 of the number.
     */
    public static int log2(int num) {
        if (num <= 0) {
            throw new IllegalArgumentException("Number must be positive");
        }
        int log = 0;
        while (num > 1) {
            num >>= 1; // equivalent to num = num / 2;
            log++;
        }
        return log;
    }

    /**
     * Calculates the logarithm base 10 of an integer.
     *
     * @param num The number to calculate the log base 10 of.
     * @return The floor value of the logarithm base 10 of the number.
     */
    public static int log10(int num) {
        if (num <= 0) {
            throw new IllegalArgumentException("Number must be positive");
        }
        int log = 0;
        while (num >= 10) {
            num /= 10;
            log++;
        }
        return log;
    }

    /**
     * Calculates the logarithm of an integer for a given base.
     *
     * @param num  The number to calculate the logarithm of.
     * @param base The base of the logarithm.
     * @return The floor value of the logarithm of the number for the given base.
     */
    public static int log(int num, int base) {
        if (num <= 0 || base <= 1) {
            throw new IllegalArgumentException("Number must be positive and base must be greater than 1");
        }
        int log = 0;
        while (num >= base) {
            num /= base;
            log++;
        }
        return log;
    }

    /**
     * Calculates the power of a number.
     *
     * @param base     The base number.
     * @param exponent The exponent.
     * @return The result of base raised to the power of exponent.
     */
    public static int power(int base, int exponent) {
        if (exponent < 0) {
            throw new ArithmeticException("Negative exponent");
        }
        long result = 1;
        for (int i = 0; i < exponent; i++) {
            result *= base;
            if (result > Integer.MAX_VALUE) {
                throw new ArithmeticException("Integer overflow");
            }
        }
        return (int) result;
    }

    // Overloaded version for longs
    public static long power(long base, int exponent) {
        long result = 1;
        for (int i = 0; i < exponent; i++) {
            result *= base;
            if (result < 0) {
                throw new ArithmeticException("Long overflow");
            }
        }
        return result;
    }

    /**
     * Computes the factorial of a number.
     *
     * @param number The number to compute the factorial of.
     * @return The factorial of the number.
     */
    public static int factorial(int number) {
        if (number < 0) {
            return -1; // Error case
        }
        long result = 1;
        for (int i = 2; i <= number; i++) {
            result *= i;
            if (result > Integer.MAX_VALUE) {
                throw new ArithmeticException("Integer overflow");
            }
        }
        return (int) result;
    }

    // Overloaded version for longs
    public static long factorial(long number) {
        if (number < 0) {
            return -1; // Error case
        }
        long result = 1;
        for (long i = 2; i <= number; i++) {
            result *= i;
            if (result < 0) {
                throw new ArithmeticException("Long overflow");
            }
        }
        return result;
    }

    /**
     * Finds the greatest common divisor of two numbers.
     *
     * @param a The first number.
     * @param b The second number.
     * @return The greatest common divisor of a and b.
     */
    public static int gcd(int a, int b) {
        if (a == b && a == 0) {
            throw new ArithmeticException("No denominator for 0");
        }
        a = abs(a);
        b = abs(b);
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }


    /**
     * Computes the least common multiple of two numbers.
     *
     * @param a The first number.
     * @param b The second number.
     * @return The least common multiple of a and b.
     */
    public static int lcm(int a, int b) {
        a = abs(a);
        b = abs(b);
        return a * (b / gcd(a, b));
    }


    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= number / 2; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static double sqrt(int number) {
        if (number <= 1 && number > -1) {
            return number;
        }
        if (number < 0) {
            throw new IllegalArgumentException("Cannot calculate sqrt of a negative number");
        }
        double t;
        double squareRoot = number / 2;
        do {
            t = squareRoot;
            squareRoot = (t + (number / t)) / 2;
        } while ((t - squareRoot) != 0);
        return squareRoot;
    }

    public static int abs(int number) {
        if (number < 0) {
            return -number;
        }
        return number;
    }

    public static int fibonacci(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Negative index");
        }
        if (n <= 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static boolean isPerfectNumber(int number) {
        if (number <= 0) {
            return false;
        }
        int sum = 0;
        for (int i = 1; i <= number / 2; i++) {
            if (number % i == 0) {
                sum += i;
            }
        }
        return sum == number;
    }

    public static boolean isPalindromeNumber(int number) {
        int reversed = 0, remainder, original = number;
        while (number != 0) {
            remainder = number % 10;
            reversed = reversed * 10 + remainder;
            number /= 10;
        }
        return original == reversed;
    }


    public static void main(String[] args) {

    }


    public static int square(int n) {
        if (n > 46340 || n < -46340) { // sqrt(Integer.MAX_VALUE) ≈ 46340
            // Handle overflow case
            return Integer.MAX_VALUE;
        }
        return n * n;
    }

    public static int sumOfSquares(int a, int b) {
        int aSquared = square(a);
        int bSquared = square(b);
        if (aSquared == Integer.MAX_VALUE || bSquared == Integer.MAX_VALUE) {
            // Handle overflow case
            return Integer.MAX_VALUE;
        }
        long sum = (long) aSquared + (long) bSquared;
        return sum > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) sum;
    }

    public static int cube(int n) {
        if (n > 1290 || n < -1290) { // cbrt(Integer.MAX_VALUE) ≈ 1290
            // Handle overflow case
            return Integer.MAX_VALUE;
        }
        return n * n * n;
    }

    public static int average(int a, int b, int c) {
        // To prevent overflow, use long for intermediate sums
        long sum = (long) a + (long) b + (long) c;
        return (int) (sum / 3);
    }

    public static boolean isPythagoreanTriple(int a, int b, int c) {
        if (a <= 0 || b <= 0 || c <= 0) {
            return false; // Pythagorean triples are defined for positive integers
        }
        int squareSum = sumOfSquares(a, b);
        return squareSum == square(c);
    }

    public static long square(long n) {
        if (n > 3037000499L || n < -3037000499L) { // sqrt(Long.MAX_VALUE) ≈ 3037000499
            // Handle overflow case for long
            return Long.MAX_VALUE;
        }
        return n * n;
    }

    public static long sumOfSquares(long a, long b) {
        long aSquared = square(a);
        long bSquared = square(b);
        if (aSquared == Long.MAX_VALUE || bSquared == Long.MAX_VALUE) {
            // Handle overflow case for long
            return Long.MAX_VALUE;
        }
        long sum = aSquared + bSquared;
        return sum < 0 ? Long.MAX_VALUE : sum; // Check for overflow
    }

    public static long cube(long n) {
        if (n > 2097151L || n < -2097151L) { // cbrt(Long.MAX_VALUE) ≈ 2097151
            // Handle overflow case for long
            return Long.MAX_VALUE;
        }
        return n * n * n;
    }

    public static boolean willAddOverflow(int a, int b) {
        if (a > 0 && b > 0) {
            // Check positive overflow
            return Integer.MAX_VALUE - a < b;
        } else if (a < 0 && b < 0) {
            // Check negative overflow
            return Integer.MIN_VALUE - a > b;
        }
        // No overflow in mixed sign addition
        return false;
    }

    public static boolean willMultiplyOverflow(int a, int b) {
        if (a == 0 || b == 0) {
            return false;
        }

        // Using long to prevent overflow in comparison

        long result = (long) a * (long) b;
        return result > Integer.MAX_VALUE || result < Integer.MIN_VALUE;
    }

    // I know its not an int function but im to lazy to make a new class just for this so deal with it
    public static boolean willLongMultiplyOverflow(long a, long b) {
        // Zero case - no overflow

        if (a == 0 || b == 0) {
            return false;
        }


        // One and negative one cases - overflow only if other is beyond long range
        if (a == 1 || a == -1) {
            return false; // Multiplying by 1 or -1 doesn't cause overflow
        }
        if (b == 1 || b == -1) {
            return false; // Multiplying by 1 or -1 doesn't cause overflow
        }

        // Overflow check for other cases
        long maxVal = Long.MAX_VALUE / (a > 0 ? a : -a);
        return b > maxVal || b < -maxVal;
    }


}
