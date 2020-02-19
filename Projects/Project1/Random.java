//Written by kimx5227

/*Program that allows user to create their own random numbers using generator algorithm*/
public class Random
{
    private int prime1 = 0;
    private int prime2 = 0;
    private int primeM = 0;
    private int randomOld; //stores seed value or rOld
    private int randomNew;

    public Random(int p1, int p2, int m)
    {
        prime1 = p1;
        prime2 = p2;
        primeM = m;
        randomOld = 0;
    }

    public Random(){}

    public void setSeed(int seed)
    {
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

    public int randomInteger(int lower, int upper) {
        int diff, lowerTemp, random;
        lowerTemp = lower; //stores lower in case of swapped order of parameters
        diff = upper - lower;
        if (diff < 0)
        {
            diff = -1 * diff;
            lower = upper;
            upper = lowerTemp;
        }
        diff ++; //accounts for mod operator
        random = random();
        random = (random % diff) + lower; //finds random  adds lower to adjust range
        return random;
    }

    public boolean randomBoolean(){
        int tOrF;
        tOrF = randomInteger(0,1);
        if (tOrF == 1)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public double randomDouble(int lower, int upper)
    {
        double diff, random;
        int getRandInt, maximum, lowerTemp;
        lowerTemp = lower; //Used to switch lower and upper if inputted incorrectly
        diff = upper - lower;
        if (diff < 0)
        {
            diff = -1 * diff;
            lower = upper;
            upper = lowerTemp;
        }
        getRandInt = random();
        maximum = getMaximum();
        random = getRandInt / (double)maximum; //random proportional to 0-1.
        random = (random * diff) + lower;
        return random;
    }

    public static void main(String[] args)
    {
        Random rand1 = new Random(7919, 65537, 102611);
        rand1.setSeed(4727);
        int countFirst, countSecond, countThird, countFourth, countFifth, countSixth; //variables counting numbers in range
        int numb;
        boolean bool;
        double random, numbDouble;
        System.out.println("Tests for seed value of 4727: ");
        countFirst = countSecond = countThird = countFourth = countFifth = countSixth = 0;
        for (int i = 0; i < 10000000; i++){ //Tests randomInteger and displays distribution to user
            numb = rand1.randomInteger(1,6);
            if (numb == 1){
                countFirst ++;
            } else if (numb == 2){
                countSecond ++;
            } else if (numb == 3){
                countThird++;
            } else if (numb == 4){
                countFourth ++;
            } else if (numb == 5){
                countFifth ++;
            } else {
                countSixth ++;
            }
        }
        System.out.println("Frequency in range 1-6 for 10000000 values: 1: ");
        System.out.println("1: " + countFirst);
        System.out.println("2: " + countSecond);
        System.out.println("3: " + countThird);
        System.out.println("4: " + countFourth);
        System.out.println("5: " + countFifth);
        System.out.println("6: " + countSixth);
        System.out.println("");

        countFirst = countSecond = countThird = countFourth = countFifth = countSixth = 0;
        for (int i = 0; i < 10000000; i++){ //test for swapped range
            numb = rand1.randomInteger(6,1);
            if (numb == 1){
              countFirst ++;
            } else if (numb == 2){
              countSecond ++;
            } else if (numb == 3){
              countThird++;
            } else if (numb == 4){
              countFourth ++;
            } else if (numb == 5){
              countFifth ++;
            } else {
              countSixth ++;
            }
        }
        System.out.println("Frequency in range [1,6] (Incorrect lower/upper) for 10000000 values: ");
        System.out.println("1: " + countFirst);
        System.out.println("2: " + countSecond);
        System.out.println("3: " + countThird);
        System.out.println("4: " + countFourth);
        System.out.println("5: " + countFifth);
        System.out.println("6: " + countSixth);
        System.out.println("");

        countFirst = 0;
        for (int i = 0; i < 10000000; i++){ //test for single value
            numb = rand1.randomInteger(1,1);
            if (numb == 1){
              countFirst ++;
            }
        }
        System.out.println("Frequency of 1 for 10000000 values: " + countFirst);
        System.out.println("");

        countFirst = countSecond =0;
        for (int i = 0; i < 10000000; i++){ // randomBoolean test
            bool = rand1.randomBoolean();
            if (bool == true){
              countFirst ++;
            } else {
              countSecond ++;
            }
        }
        System.out.println("True to False Ratio for 10000000 values: " + countFirst + ":" + countSecond);
        System.out.println("");

        countFirst = countSecond = countThird = countFourth = countFifth = countSixth = 0;
        System.out.println("Generating 10 Random numbers in range [0,5]:"); //randomDouble test
        for (int i = 0; i < 10000000; i++){
            numbDouble = rand1.randomDouble(0,5);
            if (i < 10){
              System.out.println(" " + numbDouble);
            }
            if (numbDouble >= 0 && numbDouble < 1){
              countFirst ++;
            } else if (numbDouble >= 1 && numbDouble < 2){
              countSecond ++;
            } else if (numbDouble >= 2 && numbDouble < 3){
              countThird++;
            } else if (numbDouble >= 3 && numbDouble < 4){
              countFourth ++;
            } else if (numbDouble >= 4 && numbDouble < 5){
              countFifth ++;
            } else if (numbDouble >= 5 && numbDouble < 6){
              countSixth ++;
            }
        }
        System.out.println("");
        System.out.println("The Frequency of Real Numbers between [0,5] for 10000000 values:");
        System.out.println("[0,1) " + countFirst);
        System.out.println("[1,2): " + countSecond);
        System.out.println("[2,3): " + countThird);
        System.out.println("[3,4): " + countFourth);
        System.out.println("[4,5): " + countFifth);
        System.out.println("[5,6): " + countSixth);
        System.out.print("Total Counted elements should be 10000000: ");
        System.out.println(""+(countFirst + countSecond + countThird + countFourth + countFifth + countSixth));
        System.out.println("");

        System.out.println("Tests for seed value of zero:");

        countFirst = countSecond = countThird = countFourth = countFifth = 0;
        rand1.setSeed(0);
        for (int i = 0; i < 10000000; i++){ //randomInteger test w/ different range and seed
            numb = rand1.randomInteger(-2,2);
            if (numb == -2){
              countFirst ++;
            } else if (numb == -1){
              countSecond ++;
            } else if (numb == 0){
              countThird++;
            } else if (numb == 1){
              countFourth ++;
            } else {
              countFifth ++;
            }
        }
        System.out.println("Frequency in range [-2,2] for 10000000 values: ");
        System.out.println("-2: " + countFirst);
        System.out.println("-1: " + countSecond);
        System.out.println("0: " + countThird);
        System.out.println("1: " + countFourth);
        System.out.println("2: " + countFifth);
        System.out.println("");

        countFirst = countSecond =0;
        for (int i = 0; i < 10000000; i++){   // randomBoolean test w/ new seed
            bool = rand1.randomBoolean();
            if (bool == true){
              countFirst ++;
            } else {
              countSecond ++;
            }
        }
        System.out.println("True to False Ratio for 10000000 values: " + countFirst + ":" + countSecond);
        System.out.println("");

        countFirst = countSecond = countThird = countFourth = countFifth = countSixth = 0;
        //randomDouble test w/ new seed and swapped range
        System.out.println("Generating 10 Random numbers in range [0,5] (Swapped Upper/Lower)");
        for (int i = 0; i < 10000000; i++){
            numbDouble = rand1.randomDouble(5,0);
            if (i < 10){
              System.out.println(" " + numbDouble);
            }
            if (numbDouble >= 0 && numbDouble < 1){
              countFirst ++;
            } else if (numbDouble >= 1 && numbDouble < 2){
              countSecond ++;
            } else if (numbDouble >= 2 && numbDouble < 3){
              countThird++;
            } else if (numbDouble >= 3 && numbDouble < 4){
              countFourth ++;
            } else if (numbDouble >= 4 && numbDouble < 5){
              countFifth ++;
            } else if (numbDouble >= 5 && numbDouble < 6){
              countSixth ++;
            }
        }
        System.out.println("");
        System.out.println("The Frequency of Real Numbers between [0,5] (Swapped Upper/Lower) for 10000000 values:");
        System.out.println("[0,1) " + countFirst);
        System.out.println("[1,2): " + countSecond);
        System.out.println("[2,3): " + countThird);
        System.out.println("[3,4): " + countFourth);
        System.out.println("[4,5): " + countFifth);
        System.out.println("[5,6): " + countSixth);
        System.out.print("Total Counted elements should be 10000000: ");
        System.out.println(""+(countFirst + countSecond + countThird + countFourth + countFifth + countSixth));
    }//main
}// End of Random
