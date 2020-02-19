public class Roots{


        private Complex4 root1 = new Complex4(0,0);
        private Complex4 root2 = new Complex4(0,0);


        public Roots(Complex4 newRoot1, Complex4 newRoot2){
                if (newRoot1.equals(newRoot2)){
                    root1 = root2 = newRoot1;
                } else {
                    root1 = newRoot1;
                    root2 = newRoot2;
                }
        }


        public Roots(Complex4 newRoot){
                root1 = newRoot;
        }


        public Roots(){}


        public void printRoots(){
                if (root1.equals(root2)){
                    if (root1.getRealPart() != 0 ^ root1.getImaginaryPart() != 0){
                        System.out.print("The Quadratic formula given has root " + root1.toString());
                        System.out.println(" with multiplicity 2.");
                    } else {
                        System.out.println("The quadratic formula given has no roots.");
                    }
                } else if (root2.getRealPart() == 0 & root2.getImaginaryPart() == 0){
                      System.out.print("The Quadratic formula given has 1 root: " + root1);
                } else {
                    System.out.print("The Quadratic formula given has roots ");
                    System.out.println(root1.toString() + " and " + root2.toString());
                }
        }


        public String toString(){
            return "" + root1.toString() + ", " + root2.toString();
        }

}
