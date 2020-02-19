import java.util.Scanner;

public class Fib{

        private static int lastVal = 0;
        private static int termVal = 1;
        private static int addVal = 0;

        public static void main(String[] args){
                Scanner askUser = new Scanner(System.in);
                System.out.println("Give an Integer: ");
                String nAsk = askUser.nextLine();
                int n = Integer.parseInt(nAsk);
                System.out.println("The "+ n + "th term in the fibonacci sequence is: " + fibonacciRecursive(n));
        }

        public static int fibonacciRecursive(int n){
                if (n <= 1 && n > 0){
                    return termVal;
                } else if (n >= 2){
                    addVal = lastVal;
                    lastVal = termVal;
                    termVal = termVal + addVal;
                    return fibonacciRecursive(n-1);
                } else {
                    return 0;
                }
        }
}
