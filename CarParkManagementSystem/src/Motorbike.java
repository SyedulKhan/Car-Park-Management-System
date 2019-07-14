//motorbike is a subclass of vehicle
public class Motorbike extends Vehicle {

    private double engineSize;

    //constructor
    public Motorbike(String idPlate, String brand, DateTime entryDateTime, double engineSize) {
        super(idPlate, brand, entryDateTime);
        this.engineSize = engineSize;
    }

    //getters and setters
    public void setEngineSize(double engineSize) {
        this.engineSize = engineSize;
    }

    public double getEngineSize() {
        return engineSize;
    }
    
    public String getVehicle() {
        return "Motorbike";
    }
    
    public String toString() {
        String motorbikeStr = "[ID Plate= " + idPlate + ", Brand= " + brand + ", Engine Size= " + engineSize
                + "]";
        return motorbikeStr;
    }
}
