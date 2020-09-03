public class VehicleSorter {
	public static void main(String[] args) {
		Vehicle[] vehicles = new Vehicle[5];
		vehicles[0] = new Car("Chevy", 100);
		vehicles[1] = new Boat("Yacht", 800);
		vehicles[2] = new Car("Tesla", 300);
		vehicles[3] = new Helicopter("Choppa", 600);
		vehicles[4] = new Car("Truck", 500);
		System.out.println("Unsorted List:");
		for (Vehicle v : vehicles) {
			System.out.println(v);
		}
		/*	TODO:
			Add vehicle objects of different types to your array. e.g.

			vehicles[0] = new Car("Ford Mustang GT", 425.5);
			... etc ...

			Make sure your list is not in sorted order when you create it!
		*/

		sortVehicles(vehicles);
		System.out.println("Sorted List:");
		for (Vehicle v : vehicles) {
			System.out.println(v);
		}
	}

	public static void sortVehicles(Vehicle[] list) {
		int n = list.length;
    for (int i = 0; i < n-1; i++){
        for (int j = 0; j < n-i-1; j++){
            if (list[j].compareTo(list[j+1]) < 0){
                Vehicle temp = list[j];
                list[j] = list[j+1];
                list[j+1] = temp;
            }
				}
		}
	}
}
