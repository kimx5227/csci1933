public class VehicleApp{

    public static void main(String[] args){
        Car cruze = new Car("Cruze", 220);
        Boat yacht = new Boat("Yacht", 1000);
        Helicopter choppa = new Helicopter("Choppa", 850);
        System.out.println("# of vehicles: " +choppa.getNumVehicles());
        choppa.movingUp();
        yacht.dropAnchor();
        cruze.movingForward();
    }
}
