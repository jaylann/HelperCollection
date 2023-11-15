import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StringHelperTest {

    @Test
    void testReverse() {
        assertEquals("cba", StringHelper.reverse("abc"));
        assertEquals("12321", StringHelper.reverse("12321"));
        assertNull(StringHelper.reverse(null));
        assertEquals("", StringHelper.reverse(""));
        assertEquals("a", StringHelper.reverse("a"));
    }

    @Test
    void testIsPalindrome() {
        assertTrue(StringHelper.isPalindrome("racecar"));
        assertFalse(StringHelper.isPalindrome("hello"));
        assertTrue(StringHelper.isPalindrome("Madam"));
        assertFalse(StringHelper.isPalindrome(null));
        assertTrue(StringHelper.isPalindrome(""));
        assertTrue(StringHelper.isPalindrome("a"));
    }

    @Test
    void testCountOccurrences() {
        assertEquals(3, StringHelper.countOccurrences("banana", 'a'));
        assertEquals(0, StringHelper.countOccurrences("hello", 'z'));
        assertEquals(0, StringHelper.countOccurrences("", 'a'));
        assertEquals(0, StringHelper.countOccurrences("hello", ' '));
        assertEquals(0, StringHelper.countOccurrences(null, 'a'));
    }

    @Test
    void testRemoveWhitespace() {
        assertEquals("abcde", StringHelper.removeWhitespace("a b c d e"));
        assertEquals("HelloWorld", StringHelper.removeWhitespace("Hello World"));
        assertEquals("", StringHelper.removeWhitespace(" "));
        assertNull(StringHelper.removeWhitespace(null));
        assertEquals("a", StringHelper.removeWhitespace("a"));
    }

    @Test
    void testCapitalizeFirstLetter() {
        assertEquals("Hello World", StringHelper.capitalizeFirstLetter("hello world"));
        assertEquals("A B C", StringHelper.capitalizeFirstLetter("a b c"));
        assertEquals("", StringHelper.capitalizeFirstLetter(""));
        assertNull(StringHelper.capitalizeFirstLetter(null));
        assertEquals("Java", StringHelper.capitalizeFirstLetter("java"));
    }

    @Test
    void testUncapitalizeFirstLetter() {
        assertEquals("hello world", StringHelper.uncapitalizeFirstLetter("Hello World"));
        assertEquals("a b c", StringHelper.uncapitalizeFirstLetter("A B C"));
        assertEquals("", StringHelper.uncapitalizeFirstLetter(""));
        assertNull(StringHelper.uncapitalizeFirstLetter(null));
        assertEquals("java", StringHelper.uncapitalizeFirstLetter("Java"));
    }

    @Test
    void testToCamelCase() {
        assertEquals("helloWorld", StringHelper.toCamelCase("Hello World"));
        assertEquals("javaProgramming", StringHelper.toCamelCase("Java Programming"));
        assertEquals("", StringHelper.toCamelCase(""));
        assertNull(StringHelper.toCamelCase(null));
        assertEquals("java", StringHelper.toCamelCase("java"));
    }

    @Test
    void testToSnakeCase() {
        assertEquals("hello_world", StringHelper.toSnakeCase("Hello World"));
        assertEquals("java_programming", StringHelper.toSnakeCase("Java Programming"));
        assertEquals("", StringHelper.toSnakeCase(""));
        assertNull(StringHelper.toSnakeCase(null));
        assertEquals("java", StringHelper.toSnakeCase("java"));
    }

    @Test
    void testToKebabCase() {
        assertEquals("hello-world", StringHelper.toKebabCase("Hello World"));
        assertEquals("java-programming", StringHelper.toKebabCase("Java Programming"));
        assertEquals("", StringHelper.toKebabCase(""));
        assertNull(StringHelper.toKebabCase(null));
        assertEquals("java", StringHelper.toKebabCase("java"));
    }

    @Test
    void testGenerateRandomString() {
        assertEquals(5, StringHelper.generateRandomString(5).length());
        assertThrows(IllegalArgumentException.class, () -> StringHelper.generateRandomString(0));
        assertThrows(IllegalArgumentException.class, () -> StringHelper.generateRandomString(-1));

        String randomStr = StringHelper.generateRandomString(10);
        assertNotNull(randomStr);
        assertEquals(10, randomStr.length());
        assertTrue(randomStr.matches("^[a-z]+$")); // Check if string contains only lowercase letters
    }
    @Test
    void testIsNumeric() {
        assertTrue(StringHelper.isNumeric("12345"));
        assertFalse(StringHelper.isNumeric("1234a5"));
        assertFalse(StringHelper.isNumeric("")); // Empty string check
        assertFalse(StringHelper.isNumeric(null)); // Null check
    }

    @Test
    void testIsAlpha() {
        assertTrue(StringHelper.isAlpha("abc"));
        assertFalse(StringHelper.isAlpha("abc123"));
        assertFalse(StringHelper.isAlpha("")); // Empty string check
        assertFalse(StringHelper.isAlpha(null)); // Null check
    }

    @Test
    void testIsAlphaNumeric() {
        assertTrue(StringHelper.isAlphaNumeric("abc123"));
        assertFalse(StringHelper.isAlphaNumeric("abc 123"));
        assertFalse(StringHelper.isAlphaNumeric("")); // Empty string check
        assertFalse(StringHelper.isAlphaNumeric(null)); // Null check
    }

    @Test
    void testRepeat() {
        assertEquals("abcabcabc", StringHelper.repeat("abc", 3));
        assertEquals("", StringHelper.repeat("abc", 0)); // Zero repeat check
        assertEquals("", StringHelper.repeat(null, 3)); // Null string check
    }

    @Test
    void testTruncate() {
        assertEquals("Hello", StringHelper.truncate("Hello World", 5));
        assertEquals("Hello World", StringHelper.truncate("Hello World", 20)); // Longer length check
        assertEquals("", StringHelper.truncate("", 5)); // Empty string check
        assertEquals("", StringHelper.truncate(null, 5)); // Null string check
    }

    @Test
    void testCountWords() {
        assertEquals(2, StringHelper.countWords("Hello World"));
        assertEquals(0, StringHelper.countWords("")); // Empty string check
        assertEquals(0, StringHelper.countWords("   ")); // Whitespace string check
        assertEquals(0, StringHelper.countWords(null)); // Null string check
    }

    @Test
    void testReplaceLast() {
        assertEquals("abcxyz", StringHelper.replaceLast("abcabc", "abc", "xyz"));
        assertEquals("abcabc", StringHelper.replaceLast("abcabc", "xyz", "123")); // Substring not found check
        assertEquals("", StringHelper.replaceLast("", "abc", "xyz")); // Empty string check
        assertEquals(null, StringHelper.replaceLast(null, "abc", "xyz")); // Null string check
    }

    @Test
    void testEncodeToBase64() {
        assertEquals("SGVsbG8gV29ybGQ=", StringHelper.encodeToBase64("Hello World"));
        assertEquals("", StringHelper.encodeToBase64("")); // Empty string check
        assertEquals("", StringHelper.encodeToBase64(null)); // Null string check
    }

    @Test
    void testDecodeFromBase64() {
        assertEquals("Hello World", StringHelper.decodeFromBase64("SGVsbG8gV29ybGQ="));
        assertEquals("", StringHelper.decodeFromBase64("")); // Empty string check
        assertEquals("", StringHelper.decodeFromBase64(null)); // Null string check
    }

    @Test
    void testLevenshteinDistance() {
        assertEquals(3, StringHelper.levenshteinDistance("kitten", "sitting"));
        assertEquals(0, StringHelper.levenshteinDistance("hello", "hello")); // Identical strings check
        assertEquals(-1, StringHelper.levenshteinDistance(null, "hello")); // Null string check
        assertEquals(-1, StringHelper.levenshteinDistance("hello", null)); // Null string check
    }
    @Test
    void testIsBlank() {
        assertTrue(StringHelper.isBlank(""));
        assertTrue(StringHelper.isBlank("  "));
        assertFalse(StringHelper.isBlank("a"));
        assertTrue(StringHelper.isBlank(null));
    }

    @Test
    void testLeftPad() {
        assertEquals("  abc", StringHelper.leftPad("abc", 5, ' '));
        assertEquals("xxabc", StringHelper.leftPad("abc", 5, 'x'));
        assertEquals("abc", StringHelper.leftPad("abc", 2, 'x'));
        assertNull(StringHelper.leftPad(null, 5, 'x'));
    }

    @Test
    void testRightPad() {
        assertEquals("abc  ", StringHelper.rightPad("abc", 5, ' '));
        assertEquals("abcxx", StringHelper.rightPad("abc", 5, 'x'));
        assertEquals("abc", StringHelper.rightPad("abc", 2, 'x'));
        assertNull(StringHelper.rightPad(null, 5, 'x'));
    }

    @Test
    void testContainsOnly() {
        assertTrue(StringHelper.containsOnly("abc", "abcdef"));
        assertFalse(StringHelper.containsOnly("abc", "ab"));
        assertFalse(StringHelper.containsOnly(null, "ab"));
        assertFalse(StringHelper.containsOnly("abc", null));
    }

    @Test
    void testShuffle() {
        String str = "abcdef";
        String shuffled = StringHelper.shuffle(str);
        assertNotNull(shuffled);
        assertEquals(str.length(), shuffled.length());
        // More sophisticated tests could be added to test the randomness aspect.
    }

    @Test
    void testSubstringBetween() {
        assertEquals("b", StringHelper.substringBetween("abc", "a", "c"));
        assertNull(StringHelper.substringBetween("abc", "c", "a"));
        assertNull(StringHelper.substringBetween(null, "a", "c"));
        assertNull(StringHelper.substringBetween("abc", null, "c"));
        assertNull(StringHelper.substringBetween("abc", "a", null));
    }

    @Test
    void testNormalizeWhitespace() {
        assertEquals("a b c", StringHelper.normalizeWhitespace("a  b   c"));
        assertEquals("abc", StringHelper.normalizeWhitespace("abc"));
        assertNull(StringHelper.normalizeWhitespace(null));
    }

    @Test
    void testIsNullOrEmpty() {
        assertTrue(StringHelper.isNullOrEmpty(""));
        assertFalse(StringHelper.isNullOrEmpty("abc"));
        assertTrue(StringHelper.isNullOrEmpty(null));
    }

    @Test
    void testDefaultIfNullOrEmpty() {
        assertEquals("abc", StringHelper.defaultIfNullOrEmpty("abc", "default"));
        assertEquals("default", StringHelper.defaultIfNullOrEmpty("", "default"));
        assertEquals("default", StringHelper.defaultIfNullOrEmpty(null, "default"));
    }

    @Test
    void testSplitByLength() {
        assertArrayEquals(new String[]{"ab", "cd", "ef"}, StringHelper.splitByLength("abcdef", 2));
        assertArrayEquals(new String[]{"abc", "def"}, StringHelper.splitByLength("abcdef", 3));
        assertNull(StringHelper.splitByLength(null, 2));
        assertNull(StringHelper.splitByLength("abcdef", 0));
    }

    @Test
    void testGetUniqueChars() {
        assertArrayEquals(new char[]{'a', 'b', 'c'}, StringHelper.getUniqueChars("abc"));
        assertArrayEquals(new char[]{'a', 'b'}, StringHelper.getUniqueChars("abba"));
        assertNull(StringHelper.getUniqueChars(null));
    }
}

