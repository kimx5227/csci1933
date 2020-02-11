//Written by kimx5227

/*Program that allows user to create their own random numbers using generator algorithm*/
public class Random {

        private int prime1 = 0;
        private int prime2 = 0;
        private int primeM = 0;
        private int randomOld; //either seed value, S, or rOld
        private int randomNew;

        public Random(int p1, int p2, int m) {
                prime1 = p1;
                prime2 = p2;
                primeM = m;
                randomOld = 0;
        }

        public Random(){}

        public void setSeed(int seed){
                randomOld = seed;
        }

        public int getMaximum(){
                return primeM;
        }

        public int random(){ //Creates new random number with generator algorithm
                randomNew = ((prime1 * randomOld) + prime2) % primeM;
                randomOld = randomNew;
                return randomNew;
        }

        public int randomInteger(int lower, int upper){
                int diff, lowerTemp, random;


                lowerTemp = lower;
                diff = upper - lower;
                if (diff < 0){
                    diff = -1 * diff;
                    lower = upper;
                    upper = lowerTemp;
                }
                diff ++; //accounts for mod operator
                random = random();
                random = (random % diff) + lower;     // adds lower for randomTemp
                return random;                        // to be in range of lower
        }                                             // and upper

        public boolean randomBoolean(){
            int tOrF;
            tOrF = randomInteger(0,1);
            if (tOrF == 1){
                return true;
            } else {
                return false;
            }
        }

        public double randomDouble(double lower, double upper){
          double diff, random, lowerTemp;
          int getRandInt, maximum;


          lowerTemp = lower;
          diff = upper - lower;
          if (diff < 0){
              diff = -1 * diff;
              lower = upper;
              upper = lowerTemp;
          }
          getRandInt = random();
          maximum = getMaximum();
          random = getRandInt / (double)maximum; //random proportional to 0 to 1
          random = (random * diff) + lower;
          return random;
        }

        public static void main(String[] args){


            Random rand1 = new Random(7919, 65537, 102611);
            Random rand2 = new Random();
            rand1.setSeed(4727);
            int one, two, three, four, five, six, numb;
            boolean bool;
            double random;

            System.out.println(rand2.toString());
            System.out.println("Maximum:" + rand1.getMaximum());

            one = two = three = four = five = six = 0;
            for (int i = 0; i < 10000000; i++){
                numb = rand1.randomInteger(1,6);
                if (numb == 1){
                  one ++;
                } else if (numb == 2){
                  two ++;
                } else if (numb == 3){
                  three++;
                } else if (numb == 4){
                  four ++;
                } else if (numb == 5){
                  five ++;
                } else {
                  six ++;
                }
            }
            System.out.print("Frequency in range 1-6: "+ one + ", "+ two + ", ");
            System.out.println(three + ", " + four + ", " + five + ", " +six);


            one = two = three = four = five = six = 0;
            for (int i = 0; i < 10000000; i++){ //test for swapped range
                numb = rand1.randomInteger(6,1);
                if (numb == 1){
                  one ++;
                } else if (numb == 2){
                  two ++;
                } else if (numb == 3){
                  three++;
                } else if (numb == 4){
                  four ++;
                } else if (numb == 5){
                  five ++;
                } else {
                  six ++;
                }
            }
            System.out.print("Frequency in range 1-6 (Incorrect lower/upper): ");
            System.out.print(one + ", "+ two + ", " + three + ", ");
            System.out.println(+four + ", " + five + ", " +six);

            one = 0;
            for (int i = 0; i < 10000000; i++){ //test for single value
                numb = rand1.randomInteger(1,1);
                if (numb == 1){
                  one ++;
                }
            }
            System.out.println("Frequency of 1: " + one);


            System.out.println("Generating 20 random variables:"); //randomDouble test
            for (int i = 0; i < 20; i++){
              System.out.println(" " + rand1.randomDouble(0,5));
            }

            one = two = three = four = five = 0;
            rand1.setSeed(0);
            for (int i = 0; i < 10000000; i++){ //randomInteger test w/ different range and seed
                numb = rand1.randomInteger(-2,2);
                if (numb == -2){
                  one ++;
                } else if (numb == -1){
                  two ++;
                } else if (numb == 0){
                  three++;
                } else if (numb == 1){
                  four ++;
                } else {
                  five ++;
                }
            }
            System.out.print("Frequency in range [-2,2]: ");
            System.out.println(one + ", "+ two + ", " + three + ", " + four + ", " + five);


            one = two =0;
            for (int i = 0; i < 10000000; i++){ // randomBoolean test
                bool = rand1.randomBoolean();
                if (bool == true){
                  one ++;
                } else {
                  two ++;
                }
            }
            System.out.println("True to False Ratio: " + one + ":" + two);
            System.out.println("");


            one = two =0;
            for (int i = 0; i < 10000000; i++){   // randomBoolean test w/ new seed
                bool = rand1.randomBoolean();
                if (bool == true){
                  one ++;
                } else {
                  two ++;
                }
            }
            System.out.println("True to False Ratio: " + one + ":" + two);


            System.out.println("Generating 20 random variables:"); //randomDouble test w/ new seed and swapped range
            for (int i = 0; i < 20; i++){
              System.out.println(" " + rand1.randomDouble(20,0));
            }
        }//main
}// End of Random
