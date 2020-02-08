public class Rectangle{

        private double length = 0;
        private double width = 0;

        public static void main(String[] args){
            Rectangle rectangle1 = new Rectangle(1,2);
            Rectangle rectangle2 = new Rectangle(2,2);
            System.out.println(rectangle1.getLength());
            System.out.println(rectangle2.getWidth());
            rectangle1.setLength(2);
            rectangle1.setWidth(1);
            System.out.println(rectangle1.getLength());
            System.out.println(rectangle2.getWidth());
            System.out.println(rectangle1.getArea());
            System.out.println(rectangle2.getPerimeter());
            System.out.println(rectangle1.addArea(rectangle2));
            System.out.println(rectangle2.addPerimeter(rectangle1));
            System.out.println(rectangle1.toString());
            System.out.println(rectangle1.equals(rectangle2));
        }

        public Rectangle(double a, double b){
            length = a;
            width = b;
        }

        public Rectangle(){}

        public double getLength(){
            return length;
        }

        public double getWidth(){
            return width;
        }

        public void setLength(double a){
            length = a;
        }

        public void setWidth(double b){
            width = b;
        }

        public double getArea(){
            return this.getLength() * this.getWidth();
        }

        public double getPerimeter(){
            return (2 * this.getLength()) + (2 * this.getWidth());
        }

        public double addArea(Rectangle anotherRectangle){
            return this.getArea() + anotherRectangle.getArea();
        }

        public double addPerimeter(Rectangle anotherRectangle){
            return this.getPerimeter() + anotherRectangle.getArea();
        }

        public String toString(){
            return "" + this.getLength() + ", "+this.getWidth();
        }

        public boolean equals(Object anotherObject){
            boolean equals = false;
            Rectangle temp;
            if (anotherObject instanceof Rectangle){
                temp = (Rectangle) anotherObject;
                if (this.getLength() == temp.getLength() && this.getWidth() == temp.getLength()){
                    equals = true;
                }
            }
            return equals;
        }



}
