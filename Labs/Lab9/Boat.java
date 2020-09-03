public class Boat extends Vehicle{

    private String model;
    private double horsepower;

    public Boat(){}

    public Boat(String model, double horsepower){
        this.model = model;
        this.horsepower = horsepower;
        numVehicles ++;
    }

    public String getModel(){return model;}

    public double getHorsepower(){return horsepower;}

    public void movingForward(){
        System.out.println("Boat Moving Forward");
    }
    public void movingBackward(){
        System.out.println("Boat Moving Borward");
    }

    public void hoistAnchor(){
        System.out.println("Boat Hoisting Anchor");
    }

    public void dropAnchor(){
        System.out.println("Boat Dropping Anchor");
    }

}
