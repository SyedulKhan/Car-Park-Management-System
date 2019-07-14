//abstract interface that includes abstract methods which will be implemented in another interface
public abstract interface CarParkManager {

    public abstract void addVehicle(Vehicle vehicle);
    public abstract void removeVehicle();
    public abstract void printParkingList();
    public abstract void printStats();
    public abstract void printTicketCharges();
    public abstract void specificDayParkingList();
    public abstract boolean runMenu();

}
