//Written by kimx5227
import java.lang.Math;

public class Quadratic{


        private float quadA = 0;
        private float quadB = 0;
        private float quadC = 0;


        public Quadratic(float a, float b, float c){
                quadA = a;
                quadB = b;
                quadC = c;
        }


        public Quadratic() {}


        //getters
        public float getA(){
                return quadA;
        }


        public float getB(){
                return quadB;
        }


        public float getC(){
                return quadC;
        }

        //setters
        public void setA(float a){
                quadA = a;
        }


        public void setB(float b){
                quadB = b;
        }


        public void setC(float c){
                quadC= c;
        }


        public Quadratic add(Quadratic other){
                float newA, newB, newC;
                Quadratic newQuadratic;
                newA = quadA + other.getA();
                newB = quadB + other.getB();
                newC = quadC + other.getC();
                newQuadratic = new Quadratic(newA, newB, newC);
                return newQuadratic;
        }


        public Quadratic subtract(Quadratic other){
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
                xPosImag = xNegImag = 0;
                xPosReal = xNegReal = ((-1) * quadB) / (2 * quadA);
                if (sqrtTerm < 0){
                    sqrtTerm = sqrtTerm * (-1);
                    xPosImag = (float) Math.sqrt(sqrtTerm) / (2 * quadA);
                    xNegImag = (-1) * xPosImag;
                } else {
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
            if (anotherObject instanceof Quadratic) {
              temp = (Quadratic) anotherObject;
              if (quadA - temp.getA() < 0.0001 && quadB - temp.getB() < 0.0001 && quadC - temp.getC() < 0.0001)
                  same = true;
            }
            return same;
        }


        public static void main(String[] args){
                Quadratic quad1 = new Quadratic(9, -4, 1);
                Quadratic quad2 = new Quadratic(2, 4, 2);
                Quadratic quad3 = quad1.add(quad2);
                Quadratic quad4 = quad1.subtract(quad2);
                Roots quad1Roots = quad1.findRoots();
                quad1Roots.printRoots();
                System.out.println(quad1.toString());
                System.out.println(quad2.toString());
                System.out.println(quad3.toString());
                System.out.println(quad4.toString());


        }//main   */
}//End of Quadratic
