
public abstract class Vehicle implements Comparable<Vehicle> {
    
    protected String idPlate;
    protected String brand;
    protected DateTime entryDateTime;

    //constructors
    public Vehicle() {

    }

    public Vehicle(String idPlate, String brand, DateTime entryDateTime) {
        this.idPlate = idPlate;
        this.brand = brand;
        this.entryDateTime = entryDateTime;
    }

    //set methods
    public void setIdPlate(String idPlate) {
        this.idPlate = idPlate;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setEntryDateTime(DateTime entryDateTime) {
        this.entryDateTime = entryDateTime;
    }

    //get methods
    public String getIdPlate() {
        return idPlate;
    }

    public String getBrand() {
        return brand;
    }

    public DateTime getEntryDateTime() {
        return entryDateTime;
    }

    //abstract method to identify the type of vehicle
    public abstract String getVehicle();

    //the method to compare the entry time and date of each vehicle and will be sorted
    @Override
    public int compareTo(Vehicle o) {
        if (getEntryDateTime() == null || o.getEntryDateTime() == null) {
            return 0;
        }
        return getEntryDateTime().compareTo(o.getEntryDateTime());
    }
}
