public class CalculateMultiplication {

    public static void main(String[] args) {
        if (args.length >= 1) {
            if (args.length == 3 && isNumeric(args[1]) && isNumeric(args[2])) {
                if (args[1].equals("-alg1") || args[1].equals("-alg2")) {
                    switch (args[1]) {
                        case "-alg1":
                        case "-alg2":
                    }
                } else {
                    badArgumentMessage();
                }
            } else {
                badArgumentMessage();
            }
        } else {
            System.out.println("Command Line Multiplycation app\n" +
                    "=============================");
            System.out.println();
            System.out.println("Command line arguments:");
            System.out.println(
                    """
                                -alg1 BigIntegers multiply
                                -alg2 Multiply algorithm
                                
                                !input must be: -alg1/-alg2 first_number second_number!
                                
                            """);
        }
    }
}
