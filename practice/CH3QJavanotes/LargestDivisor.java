//Finds the first instance of the integer
//with the largest number of divisors in the range [1,10000]

public class LargestDivisor{

        public static void main(String[] args){
                int divisorCount;
                int largestDivisorInt = 0;
                int largestDivisorCount = 0;

                for (int num = 1; num <= 10000; num++){
                  divisorCount = 0;
                  for (int div = 1; div <= num; div++){
                    if (num % div == 0) {
                      divisorCount ++;
                    }
                  }
                  if (divisorCount > largestDivisorCount) {
                    largestDivisorInt = num;
                    largestDivisorCount = divisorCount;
                  }
                }

                System.out.println("The first integer that has the most divisors is " + largestDivisorInt + " with " + largestDivisorCount + " divisors.");

        }
}
