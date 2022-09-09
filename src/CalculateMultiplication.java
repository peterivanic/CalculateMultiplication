import java.math.BigInteger;

public class CalculateMultiplication {

    public static void main(String[] args) {
        if (isArgumentsCorrect(args)) {
            switch (args[0]) {
                case "-alg1":
                    System.out.println(algoWithBigIntegerMultiply(args[1], args[2]));
                case "-alg2":
                    System.out.println(multiplyAlgo(args[1], args[2]));
            }
        }
    }

    public static boolean isArgumentsCorrect(String[] args) {
        if (args.length >= 1) {
            if (args.length == 3 && isNumeric(args[1]) && isNumeric(args[2])) {
                if (args[0].equals("-alg1") || args[0].equals("-alg2")) {
                    return true;
                } else {
                    badArgumentMessage();
                    return false;
                }
            } else {
                badArgumentMessage();
                return false;
            }
        } else {
            infoMessage();
            return false;
        }
    }

    public static String algoWithBigIntegerMultiply(String a, String b) {
        BigInteger result = new BigInteger(a).multiply(new BigInteger(b));
        return result.toString();
    }

    //I found this great solutions with explanation on www.geeksforgeeks.org
    static String multiplyAlgo(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        if (len1 == 0 || len2 == 0) {
            return "0";
        }

        // will keep the result number in vector
        // in reverse order
        int[] result = new int[len1 + len2];

        // Below two indexes are used to
        // find positions in result.
        int indexNumber1 = 0;
        int indexNumber2;

        // Go from right to left in num1
        for (int i = len1 - 1; i >= 0; i--) {
            int carry = 0;
            int n1 = num1.charAt(i) - '0';

            // To shift position to left after every
            // multiplicationAction of a digit in num2
            indexNumber2 = 0;

            // Go from right to left in num2
            for (int j = len2 - 1; j >= 0; j--) {

                // Take current digit of second number
                int n2 = num2.charAt(j) - '0';

                // Multiply with current digit of first number
                // and add result to previously stored result
                // charAt current position.
                int sum = n1 * n2 + result[indexNumber1 + indexNumber2] + carry;

                // Carry for next itercharAtion
                carry = sum / 10;

                // Store result
                result[indexNumber1 + indexNumber2] = sum % 10;
                indexNumber2++;
            }
            // store carry in next cell
            if (carry > 0) {
                result[indexNumber1 + indexNumber2] += carry;
            }
            // To shift position to left after every
            // multiplication of a digit in num1.
            indexNumber1++;
        }
        // ignore '0's from the right
        int i = result.length - 1;
        while (i >= 0 && result[i] == 0) {
            i--;
        }
        // If all were '0's - means either both
        // or one of num1 or num2 were '0'
        if (i == -1) {
            return "0";
        }
        // generate the result String
        StringBuilder s = new StringBuilder();
        while (i >= 0) {
            s.append(result[i--]);
        }
        return s.toString();
    }


    public static boolean isNumeric(String str) {
        int sum = 0;
        for (char ch : str.toCharArray())
            try {
                Integer.parseInt(String.valueOf(ch));
                sum++;
            } catch (NumberFormatException e) {
                sum--;
            }
        return sum == str.length();
    }

    public static void badArgumentMessage() {
        System.out.println(
                """
                            BAD ARGUMENTS!
                            
                            input must be: -alg1/-alg2 first_number second_number
                            
                        """);
    }

    public static void infoMessage() {
        System.out.println("Command Line Multiplication app\n" +
                "=============================");
        System.out.println();
        System.out.println("Command line arguments:");
        System.out.println(
                """
                            -alg1 BigIntegers multiply
                            -alg2 Multiply algorithm
                            
                            input must be: -alg1/-alg2 first_number second_number
                            
                        """);
    }

}
