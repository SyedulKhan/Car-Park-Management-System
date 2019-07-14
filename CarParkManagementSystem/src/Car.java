// car is a subclass of vehicle
public class Car extends Vehicle{

    private int noOfDoors;
    private String color;

    //constructors
    public Car() {
        super();
    }

    public Car(String idPlate, String brand, DateTime entryDateTime, int noOfDoors, String color) {
        //retrieves variable data from super class and will be added to car variables
        super(idPlate, brand, entryDateTime);
        this.noOfDoors = noOfDoors;
        this.color = color;
    }

    //getters and setters
    public void setNoOfDoors(int noOfDoors) {
        this.noOfDoors = noOfDoors;
    }

    public int getNoOfDoors() {
        return noOfDoors;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public String toString() {
        String carStr = "[ID Plate: " + idPlate + " Brand: " + brand + " No of Doors: " + noOfDoors
                + " Color: " + color + "]";
        return carStr;
    }

    public String getVehicle() {
        return "Car";
    }   
}
