// Complex4.java
// Revised 2/2020
// A reasonable complex number class
// Can you explain the reasoning behind everything that is done here?
    //We want the user to be able to access, change, add, and subtract
    //complex numbers. Moreover, we want the user to be able to accept
    //any argument for the equals() method, thus, the reason why the
    //object can be an arbitrary Object type.
// What about the mutating of "this" Complex4 operand in the
// addComplex() and subtractComplex() methods?
    //The reason that the add and subtract complex method doesn't use
    //this is because we want the user to be able to change the total
    //of the complex number they are using. We would use this in the
    //case that we want the total to be mutable; or not changable.
// Can you modify addComplex() and subtractComplex() to return a
// new Complex4 object without mutating either of the operands?
    //New methods are listed with the names newAddComplex() and
    //newSubtractComplex.
// Try it, and write a main() driver within Complex4.java to test
// your modified  methods.

public class Complex4 {

    private double realPart = 0;
    private double imaginaryPart = 0;

    public Complex4(double a, double b) {
        realPart = a;
        imaginaryPart = b;
    }

    public Complex4() {}

    // accessor methods

    public void setRealPart(double value) {
        realPart = value;
    }

    public void setImaginaryPart(double value) {
        imaginaryPart = value;
    }

    public double getRealPart() {
        return realPart;
    }

    public double getImaginaryPart() {
        return imaginaryPart;
    }

    // operators

    public void addComplex(Complex4 c) {
        realPart = realPart + c.getRealPart();
        imaginaryPart = imaginaryPart + c.getImaginaryPart();
    }

    public void subtractComplex(Complex4 c) {
        realPart = realPart - c.getRealPart();
        imaginaryPart = imaginaryPart - c.getImaginaryPart();
    }

    public Complex4 newAddComplex(Complex4 c){
        double real = this.getRealPart() + c.getRealPart();
        double img = this.getImaginaryPart() + c.getImaginaryPart();
        Complex4 newComplex = new Complex4(real,img);
        return newComplex;
    }

    public Complex4 newSubtractComplex(Complex4 c){
        double real = this.getRealPart() - c.getRealPart();
        double img = this.getImaginaryPart() - c.getImaginaryPart();
        Complex4 newComplex = new Complex4(real,img);
        return newComplex;
    }

    public String toString() {
      if (imaginaryPart < 0){
        return "" + realPart + "" + imaginaryPart + "i";
      } else {
        return "" + realPart + "+" + imaginaryPart + "i";
      }

    }

    public boolean equals(Object anotherObject) {
        Complex4 temp;
        boolean same = false;
        if (anotherObject instanceof Complex4) {
          temp = (Complex4) anotherObject;
          if (realPart == temp.getRealPart() &&
              imaginaryPart == temp.getImaginaryPart())
              same = true;
        }
        return same;
    }

    public static void main(String[] args){
        Complex4 complex1 = new Complex4(1,2);
        Complex4 complex2 = new Complex4(0,2);
        Complex4 complex3 = complex1.newSubtractComplex(complex2);
        Complex4 complex4 = complex1.newAddComplex(complex2);
        System.out.println(complex1.toString());
        System.out.println(complex2.toString());
        System.out.println(complex3.toString());
        System.out.println(complex4.toString());

    }

}  // Complex4 class
