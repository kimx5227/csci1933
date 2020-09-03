public class Bike implements Drivable{

    public Bike(){}

    public void movingForward(){
        System.out.println("Bike Moving Forward");
    }

    public void movingBackward(){
        System.out.println("Bike Moving Backward");
    }

    public static void main(String[] args){
        Bike bike = new Bike();
        bike.movingForward();
        bike.movingBackward();
    }
}
