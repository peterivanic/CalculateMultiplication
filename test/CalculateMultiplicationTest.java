import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class CalculateMultiplicationTest {

    @Test
    public void testIsArgumentsCorrectOK() {
        String[] args = new String[]{"-alg1", "12345678901234567890", "11111111111111111111"};
        boolean expected = true;
        boolean actual = CalculateMultiplication.isArgumentsCorrect(args);

        assertEquals(expected, actual);
    }

    @Test
    public void testIsArgumentsWithBadArgs() {
        String[] args = new String[]{"-alg", "12345678901234567890", "11111111111111111111"};
        boolean expected = false;
        boolean actual = CalculateMultiplication.isArgumentsCorrect(args);

        assertEquals(expected, actual);
    }

    @Test
    public void testIsArgumentsCorrectWith2Args() {
        String[] args = new String[]{"-alg", "12345678901234567890"};
        boolean expected = false;
        boolean actual = CalculateMultiplication.isArgumentsCorrect(args);

        assertEquals(expected, actual);
    }

    @Test
    public void testAlgoWithBigIntegerMultiplyOK() {
        String a = "12345678901234567890";
        String b = "11111111111111111111";

        String expected = "137174210013717420998628257899862825790";
        String actual = CalculateMultiplication.algoWithBigIntegerMultiply(a, b);

        assertEquals(expected, actual);
    }

    @Test
    public void testIfMultiplyAlgoHaveSameResultLikeAlgoWithBigIntegerMultiply() {
        String a = "12345678901234567890";
        String b = "11111111111111111111";

        String expected = CalculateMultiplication.algoWithBigIntegerMultiply(a, b);
        String actual = CalculateMultiplication.multiplyAlgo(a, b);

        assertEquals(expected, actual);
    }

    @Test
    public void testMultiplyAlgoOK() {
        String a = "12345678901234567890";
        String b = "11111111111111111111";

        String expected = "137174210013717420998628257899862825790";
        String actual = CalculateMultiplication.multiplyAlgo(a, b);

        assertEquals(expected, actual);
    }

    @Test
    public void testIsNumericOK() {
        String s = "12345678901234567890";

        boolean expected = true;
        boolean actual = CalculateMultiplication.isNumeric(s);

        assertEquals(expected, actual);
    }

    @Test
    public void testIsNumericWithWord() {
        String s = "12345HELLO";

        boolean expected = false;
        boolean actual = CalculateMultiplication.isNumeric(s);

        assertEquals(expected, actual);
    }

}