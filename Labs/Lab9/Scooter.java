public class Scooter implements Drivable{

  public Scooter(){}

  public void movingForward(){
      System.out.println("Scooter Moving Forward");
  }

  public void movingBackward(){
      System.out.println("Scooter Moving Backward");
  }

  public static void main(String[] args){
      Scooter scooter = new Scooter();
      scooter.movingForward();
      scooter.movingBackward();
  }
}
