// Sum3SquaresMethodVersion.java
// January 2020

// Approach to Sum3Squares.java that...
// uses a separate local static method called sum3sq(int, int) in
// place of the inline code within main() found in Sum3Squares.java

public class Sum3SquaresMethodVersion {

    private static int sum3sq(int low, int high) {

    // what does private mean here?  Should is be public?
        //No because then it would affect other classes if we did
        //have them
    // what does static mean here?  Should it be non-static?
        //Static means that it is a method belonging to the class.
        //So, since we didn't instantiate anything, we are fine.
        //It doesn't need to be non-static because we don't have any
        //objects.
    // low and high work like local variables within sum3sq,
    // but how are they different?
        //they are the same except they are initialized from corresponding
        //argument values

        int sum = 0;
        low--;
        while (low < high) {
            low++;
            if (low % 3 == 0)
              sum += Math.pow(low, 2);
        }
        return sum;
    }  // sum3sq


    public static void main(String[] args) {

        int low;
        int high;
        int sum;

        if (args.length != 2)
          System.out.println("Wrong number of arguments supplied.");
        else {
          low = Integer.parseInt(args[0]);
          high = Integer.parseInt(args[1]);
          System.out.println("The sum of the squares of ints evenly divisible by 3" +
              " between " + args[0] + " and " + args[1] + " (inclusive) is: " + sum3sq(low, high));
        }
    }  // main

}  // Sum3SquaresMethodVersion
