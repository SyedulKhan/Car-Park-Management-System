//van is a subclass of vehicle
public class Van extends Vehicle {

    private int cargoVolume;
    //constructor
    public Van(String idPlate, String brand, DateTime entryDateTime, int cargoVolume) {
        super(idPlate, brand, entryDateTime);
        this.cargoVolume = cargoVolume;
    }

    //getters and setters
    public void setCargoVolume(int cargoVolume) {
        this.cargoVolume = cargoVolume;
    }

    public int getCargoVolume() {
        return cargoVolume;
    }
    
    public String getVehicle() {
        return "Van";
    }

    public String toString() {
        String vanStr = "[ID Plate= " + idPlate + ", Brand= " + brand + ", Cargo Volume= " + cargoVolume
                + "]";
        return vanStr;
    }
}
