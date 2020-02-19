public class Max{

        private static int max = 0;

        public static void main(String[] args){
                System.out.println(iterativeMaxDigit(1443));
        }

        public static int recursiveMaxDigit(int num){
                int digit;
                if (num > 0){
                    digit = num % 10;
                    num = num / 10;
                    if (digit > max){
                        max = digit;
                    }
                    return recursiveMaxDigit(num);
                } else {
                    return max;
                }

        }

        public static int iterativeMaxDigit(int num){
                int max = 0;
                int digit;
                while (num > 0){
                  digit = num % 10;
                  if (digit > max){
                      max = digit;
                  }
                  num = num / 10;
                }
                return max;
        }
}
