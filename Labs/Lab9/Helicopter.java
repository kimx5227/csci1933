public class Helicopter extends Vehicle{

    private String model;
    private double horsepower;

    public Helicopter(){}

    public Helicopter(String model, double horsepower){
        this.model = model;
        this.horsepower = horsepower;
        numVehicles ++;
    }

    public String getModel(){return model;}

    public double getHorsepower(){return horsepower;}

    public void movingForward(){
        System.out.println("Helicopter Moving Forward");
    }

    public void movingBackward(){
        System.out.println("Helicopter Moving Backward");
    }

    public void movingDown(){
        System.out.println("Helicopter Moving Down");
    }

    public void movingUp(){
        System.out.println("Helicopter Moving Up");
    }

}
