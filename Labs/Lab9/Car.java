public class Car extends Vehicle {

    private String model;
    private double horsepower;

    public Car(){}

    public Car(String model, double horsepower){
        this.model = model;
        this.horsepower = horsepower;
        numVehicles ++;
    }

    public String getModel(){return model;}

    public double getHorsepower(){return horsepower;}

    public void movingForward(){
        System.out.println("Car Moving Forward");
    }
    public void movingBackward(){
        System.out.println("Car Moving Borward");
    }

}
