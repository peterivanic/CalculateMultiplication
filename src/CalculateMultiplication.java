import java.math.BigInteger;

public class CalculateMultiplication {

    public static void main(String[] args) {
        if (isArgumentsCorrect(args)) {
            switch (args[0]) {
                case "-alg1":
                    System.out.println(algoWithBigIntegerMultiply(args[1],args[2]));
                case "-alg2":

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
