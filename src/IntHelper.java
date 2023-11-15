public class IntHelper {
    public static boolean isLog2(int num) {
        while (num > 1) {
            if (num % 2 != 0) {
                return false;
            }
            num = num / 2;
        }
        return true;
    }

    public static boolean isLog10(int num) {
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
     * Calculates the power of a number.
     *
     * @param base The base number.
     * @param exponent The exponent.
     * @return The result of base raised to the power of exponent.
     */
    public static int power(int base, int exponent) {
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
        if (n <= 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static boolean isPerfectNumber(int number) {
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

    public static int max(int a, int b) {
        return (a > b) ? a : b;
    }

    public static int min(int a, int b) {
        return (a < b) ? a : b;
    }
}
