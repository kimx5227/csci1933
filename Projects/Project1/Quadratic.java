//Written by kimx5227

//Allows user to create quadtratics and operate on them
// as well as finding roots using root.java and complex4.java
import java.lang.Math;

public class Quadratic
{
        private float quadA = 0;
        private float quadB = 0;
        private float quadC = 0;


        public Quadratic(float a, float b, float c)
        {
                quadA = a;
                quadB = b;
                quadC = c;
        }


        public Quadratic() {}


        //getters
        public float getA()
        {
                return quadA;
        }


        public float getB(){
                return quadB;
        }


        public float getC(){
                return quadC;
        }

        //setters
        public void setA(float a)
        {
                quadA = a;
        }


        public void setB(float b)
        {
                quadB = b;
        }


        public void setC(float c)
        {
                quadC= c;
        }


        public Quadratic add(Quadratic other)
        {
                float newA, newB, newC;
                Quadratic newQuadratic;
                newA = quadA + other.getA();
                newB = quadB + other.getB();
                newC = quadC + other.getC();
                newQuadratic = new Quadratic(newA, newB, newC);
                return newQuadratic;
        }


        public Quadratic subtract(Quadratic other)
        {
                float newA, newB, newC;
                Quadratic newQuadratic;
                newA = quadA - other.getA();
                newB = quadB- other.getB();
                newC = quadC - other.getC();
                newQuadratic = new Quadratic(newA, newB, newC);
                return newQuadratic;
        }


        public Roots findRoots(){
                Complex4 xNeg, xPos;
                Roots quadRoot;
                float sqrtTerm, xPosReal, xNegReal, xPosImag, xNegImag;
                sqrtTerm = (float)Math.pow(quadB,2) - (4 * quadA * quadC);
                xPosImag = xNegImag = xPosReal = xNegReal = 0;
                if (quadA != 0){
                    xPosReal = xNegReal = ((-1) * quadB) / (2 * quadA);
                } else if (quadB != 0){
                    xPosReal = (-1) * quadC / quadB;
                    xPos = new Complex4(xPosReal, xPosImag);
                    xNeg = new Complex4(xNegReal, xNegImag);
                    quadRoot = new Roots(xPos, xNeg);
                    return quadRoot;
                }
                if (sqrtTerm < 0){
                    sqrtTerm = sqrtTerm * (-1);
                    xPosImag = (float) Math.sqrt(sqrtTerm) / (2 * quadA);
                    xNegImag = (-1) * xPosImag;
                } else if (sqrtTerm > 0) {
                    xPosReal = xPosReal + (float)(Math.sqrt(sqrtTerm)/ (2 * quadA));
                    xNegReal = xNegReal - (float)(Math.sqrt(sqrtTerm)/ (2 * quadA));
                }
                xPos = new Complex4(xPosReal, xPosImag);
                xNeg = new Complex4(xNegReal, xNegImag);
                quadRoot = new Roots(xPos, xNeg);
                return quadRoot;
        }


        public String toString(){
                return quadA + "x^2" + " + " + quadB + "x" + " + " + quadC; //returns in quadratic form
        }


        public boolean equals(Object anotherObject) {
            Quadratic temp;
            boolean same = false;
            if (anotherObject instanceof Quadratic)
            {
              temp = (Quadratic) anotherObject;
              if (quadA - temp.getA() < 0.0001 && quadB - temp.getB() < 0.0001 && quadC - temp.getC() < 0.0001)
                  same = true;
            }
            return same;
        }


        public static void main(String[] args)
        {
                Quadratic quad1 = new Quadratic(9, -4, 1);
                Quadratic quad2 = new Quadratic(2, 4, 2);
                Quadratic quad3 = quad1.add(quad2);
                Quadratic quad4 = quad1.subtract(quad2);
                Quadratic quad5 = new Quadratic();
                Quadratic quad6 = new Quadratic(0,2,1);
                Quadratic quad7 = new Quadratic(0,0,1);
                Roots quad1Roots = quad1.findRoots();
                Roots quad2Roots = quad2.findRoots();
                Roots quad3Roots = quad3.findRoots();
                Roots quad4Roots = quad4.findRoots();
                Roots quad5Roots = quad5.findRoots();
                Roots quad6Roots = quad6.findRoots();
                Roots quad7Roots = quad7.findRoots();
                System.out.println("");
                System.out.println("Quadratic 1 is : " + quad1.toString());
                quad1Roots.printRoots();
                System.out.println("");
                System.out.println("Quadratic 2 is : " + quad2.toString());
                quad2Roots.printRoots();
                System.out.println("");
                System.out.print("Quadratic 3 is the addition of Quadratic 1 and 2, ");
                System.out.println("which is : " + quad3.toString());
                quad3Roots.printRoots();
                System.out.println("");
                System.out.print("Quadratic 4 is the subtraction of Quadratic 1 by 2, ");
                System.out.println("which is : " + quad4.toString());
                quad4Roots.printRoots();
                System.out.println("");
                System.out.println("Quadratic 5 is : " + quad5.toString());
                quad5Roots.printRoots();
                System.out.println("");
                System.out.println("Quadratic 6 is : " + quad6.toString());
                quad6Roots.printRoots();
                System.out.println("");
                System.out.println("");
                System.out.println("Quadratic 7 is : " + quad7.toString());
                quad7Roots.printRoots();
        }//main   */
}//End of Quadratic
