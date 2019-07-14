
import java.util.*;

public class WestminsterCarParkManager implements CarParkManager {
    
    private ArrayList<Vehicle> parkingList; // the main ArrayList for the parking lot
    private int parkingSpaces;
    //Global variables that act as counters for each vehicle added or removed
    //as well as how many spaces are left or filled
    int ii;
    int x = 0;
    int counter = 0;
    int cars = 0;
    double vans = 0;
    int motorbikes = 0;
    
    Scanner in = new Scanner(System.in);

    //Constructor to instantiate the car park
    public WestminsterCarParkManager(int parkingSpaces) {
        this.parkingSpaces = parkingSpaces;
        parkingList = new ArrayList<>();
        this.ii = parkingSpaces;
    }
    
    //the add method to add a vehicle to parking ArrayList
    public void addVehicle(Vehicle vehicle) {
        if (parkingList.size() < parkingSpaces) {
            parkingList.add(vehicle);
            System.out.println(parkingList.get(x).getVehicle() + " is added");
            // As van occupies 2 spaces this if statement will simply add the van to the next space
            if (parkingList.get(x).getVehicle().equals("Van")) {
                parkingList.add(vehicle);
                System.out.println("Van occupies 2 spaces");
                x++;
            }
            x++;
            System.out.println("There are " + (parkingSpaces - parkingList.size()) + " space(s) free");
            System.out.println();
        } else {
            System.out.println("No more spaces in the parking lot");
            System.out.println();
        }
    }

    //A specific method to add a car to parking lot
    public void addCar() {
        System.out.println("Please enter the ID Plate of your vehicle");
        String idPlate = in.next();
        System.out.println("Please enter the brand");
        String brand = in.next();
        System.out.println("Please enter the entry time and date (dd/mm/yyyy hh:mm)");
        System.out.print("Day: ");
        int day = in.nextInt();
        System.out.print("Month: ");
        int month = in.nextInt();
        System.out.print("Year: ");
        int year = in.nextInt();
        System.out.print("Hour: ");
        int hour = in.nextInt();
        System.out.print("Minute: ");
        int minute = in.nextInt();
        DateTime entryDateTime = new DateTime(day, month, year, hour, minute); //stores date and time in variable
        System.out.println("Please enter the number of doors");
        int noOfDoors = in.nextInt();
        System.out.println("Please enter the colour");
        String colour = in.next();
        Car c = new Car(idPlate, brand, entryDateTime, noOfDoors, colour);
        this.addVehicle(c); //car added to parking ArrayList
    }
    
    //A specific method to add a van to parking lot
    public void addVan() {
        System.out.println("Please enter the ID Plate of your vehicle");
        String idPlate = in.next();
        System.out.println("Please enter the brand");
        String brand = in.next();
        System.out.println("Please enter the entry time and date (dd/mm/yyyy hh:mm)");
        System.out.print("Day: ");
        int day = in.nextInt();
        System.out.print("Month: ");
        int month = in.nextInt();
        System.out.print("Year: ");
        int year = in.nextInt();
        System.out.print("Hour: ");
        int hour = in.nextInt();
        System.out.print("Minute: ");
        int minute = in.nextInt();
        DateTime entryDateTime = new DateTime(day, month, year, hour, minute); 
        System.out.println("Please enter the cargo volume");
        int cargoVolume = in.nextInt();
        Van v = new Van(idPlate, brand, entryDateTime, cargoVolume);
        this.addVehicle(v); // van added to ArrayList
    }
    
    //A specific method to add a motorbike to parking lot
    public void addMotorbike() {
        System.out.println("Please enter the ID Plate of your vehicle");
        String idPlate = in.next();
        System.out.println("Please enter the brand");
        String brand = in.next();
        System.out.println("Please enter the entry time and date (dd/mm/yyyy hh:mm)");
        System.out.print("Day: ");
        int day = in.nextInt();
        System.out.print("Month: ");
        int month = in.nextInt();
        System.out.print("Year: ");
        int year = in.nextInt();
        System.out.print("Hour: ");
        int hour = in.nextInt();
        System.out.print("Minute: ");
        int minute = in.nextInt();
        DateTime entryDateTime = new DateTime(day, month, year, hour, minute);
        System.out.println("Please enter the engine size");
        double engineSize = in.nextDouble();
        Motorbike m = new Motorbike(idPlate, brand, entryDateTime, engineSize);
        this.addVehicle(m); // motorbike added to ArrayList
    }

    //the mehtod to remove a vehicle from the parking lot
    public void removeVehicle() {
        boolean isParked = false;
        System.out.println("Please enter the ID Plate of the vehicle you wish to remove:");
        String removeIdPlate = in.next();
        int entryHour = 0;
        int i = 0;
        do {
            //user enters ID Plate and if it matches to the vehicle then it will be removed
            if (parkingList.get(i).getIdPlate().equals(removeIdPlate)) {
                if (parkingList.get(i).getVehicle().equals("Van") && parkingList.get(i).getIdPlate().equals(removeIdPlate)) {
                    entryHour = parkingList.get(i).getEntryDateTime().getHour();
                    parkingList.remove(i);
                    vans = vans--;
                    x--;
                } else if (parkingList.get(i).getVehicle().equals("Car") && parkingList.get(i).getIdPlate().equals(removeIdPlate)) {
                    entryHour = parkingList.get(i).getEntryDateTime().getHour();
                    cars = cars--;
                } else if (parkingList.get(i).getVehicle().equals("Motorbike") && parkingList.get(i).getIdPlate().equals(removeIdPlate)) {
                    entryHour = parkingList.get(i).getEntryDateTime().getHour();
                    motorbikes = motorbikes--;
                }
                //user enters the exit hour in order to calculate the ticket cost
                System.out.println("Insert the hour to calculate your final ticket cost:");
                int hour = in.nextInt();
                System.out.println(parkingList.get(i).getVehicle() + " has left and paid a charge of £" + this.ticketChargeCalculation(hour, entryHour));
                parkingList.remove(i);
                x--;
                isParked = true;
            }
            i++;
        } while (i < parkingList.size());
        //this occurs if the ID plate does not match anything in the ArrayList
        if (isParked == false) {
            System.out.println("ID Plate is unrecognised. Please try again");
            this.removeVehicle();
        }
        //this is to indicate how many spaces are now available
        System.out.println("There are now " + (parkingSpaces - parkingList.size()) + " space(s) free");
        System.out.println();
    }

    //this method will print all vehicles and their details in the parking lot
    public void printParkingList() {
        //this will order all vehicles in parking lot according to entry date and time
        Collections.sort(parkingList);
        for (int i = 0; i < parkingList.size(); i++) {
            if (parkingList.get(i).getVehicle().equals("Car")) {
                System.out.println("Entry date and time: " + parkingList.get(i).getEntryDateTime()
                        + " Vehicle: " + parkingList.get(i).getVehicle());
                System.out.println(parkingList.get(i).toString());
                cars++;
            } else if (parkingList.get(i).getVehicle().equals("Van")) {
                System.out.println("Entry date and time: " + parkingList.get(i).getEntryDateTime()
                        + " Vehicle: " + parkingList.get(i).getVehicle());
                System.out.println(parkingList.get(i).toString());
                System.out.println("Van has occupied 2 spaces");
                vans = (vans + 1) / 2;
                i++;
            } else if (parkingList.get(i).getVehicle().equals("Motorbike")) {
                System.out.println("Entry date and time: " + parkingList.get(i).getEntryDateTime()
                        + " Vehicle: " + parkingList.get(i).getVehicle());
                System.out.println(parkingList.get(i).toString());
                motorbikes++;
            }
        }
        System.out.println("There are " + (ii - parkingList.size()) + " spaces free");
        System.out.println();
    }

    //this method will print statistics about the percentage of each vehicle parked,
    //the vehicle parked the longest and the last vehicle parked
    public void printStats() {
        double carsPercentage;
        double vansPercentage;
        double motorbikesPercentage;
        double totalVehiclesParked = parkingList.size();
        System.out.println("Insert Hour to find who parked the longest:");
        int hour = in.nextInt();
        carsPercentage = (cars / totalVehiclesParked) * 100;
        vansPercentage = (vans / totalVehiclesParked) * 100;
        motorbikesPercentage = (motorbikes / totalVehiclesParked) * 100;
        System.out.println("The percentage of cars currently parked is: " + carsPercentage + "%");
        System.out.println("The percentage of vans currently parked is: " + vansPercentage + "%");
        System.out.println("The percentage of motorbikes currently parked is: " + motorbikesPercentage + "%");
        System.out.println();
        System.out.println("The vehicle parked the longest is: " + this.longestVehicleStay(hour));
        System.out.println("The vehicle that parked last is: " + this.lastVehicleParked());
        System.out.println();
    }

    //the user enters the date in order to print all vehicles parked on that specific day
    public void specificDayParkingList() {
        System.out.println("Please enter the date (dd/mm/yyyy)");
        System.out.print("Day: ");
        int day = in.nextInt();
        System.out.print("Month: ");
        int month = in.nextInt();
        System.out.print("Year: ");
        int year = in.nextInt();
        int i = 0;
        boolean isThere = false;
        do {
            if ((parkingList.get(i).getEntryDateTime().getDay() == day)
                    && (parkingList.get(i).getEntryDateTime().getMonth() == month)
                    && (parkingList.get(i).getEntryDateTime().getYear() == year)) {
                System.out.println("Vehicle: " + parkingList.get(i).getVehicle());
                System.out.println("Entry date and time: " + parkingList.get(i).getEntryDateTime());
                System.out.println(parkingList.get(i).toString());
                isThere = true;
            }
            i++;
        } while (i < parkingList.size());
        //this will check if there are no vehicles on that specific day
        if (isThere == false) {
            System.out.println("No vehicle(s) parked in that day");
            System.out.println();
        }
        System.out.println();
    }

    //this will print all vehicles alongside the potential ticket charges they pay after the user 
    //enters the hour to calculate the costs
    public void printTicketCharges() {
        Collections.sort(parkingList);
        System.out.println("Please enter the hour to calculate ticket costs per parked vehicle: ");
        int hour = in.nextInt();
        int entryHour;
        for (int i = 0; i < parkingList.size(); i++) {
            if (parkingList.get(i).getVehicle().equals("Car")) {
                entryHour = parkingList.get(i).getEntryDateTime().getHour();
                System.out.println("Vehicle: " + parkingList.get(i).getVehicle());
                System.out.println("ID: " + parkingList.get(i).getIdPlate());
                System.out.println("Entry date and time: " + parkingList.get(i).getEntryDateTime());
                System.out.println("They are currently charged £" + this.ticketChargeCalculation(hour, entryHour));
            } else if (parkingList.get(i).getVehicle().equals("Van")) {
                entryHour = parkingList.get(i).getEntryDateTime().getHour();
                System.out.println("Vehicle: " + parkingList.get(i).getVehicle());
                System.out.println("ID: " + parkingList.get(i).getIdPlate());
                System.out.println("Entry date and time: " + parkingList.get(i).getEntryDateTime());
                System.out.println("They are currently charged £" + this.ticketChargeCalculation(hour, entryHour));
            } else if (parkingList.get(i).getVehicle().equals("Motorbike")) {
                entryHour = parkingList.get(i).getEntryDateTime().getHour();
                System.out.println("Vehicle: " + parkingList.get(i).getVehicle());
                System.out.println("ID: " + parkingList.get(i).getIdPlate());
                System.out.println("Entry date and time: " + parkingList.get(i).getEntryDateTime());
                System.out.println("They are currently charged £" + this.ticketChargeCalculation(hour, entryHour));
            }
            System.out.println();
        }
    }

    //this procedure calculates the ticket charge per vehicle
    public double ticketChargeCalculation(int hour, int entryHour) {
        final double parkingCharge = 3.00;
        final double additionalCharge = 1.00;
        final double maxCharge = 30.00;
        double total = 0.0;

        int diff = hour - entryHour;
        if (diff <= 3 && diff > 0) {
            total = diff * parkingCharge;
        } else if (diff > 3) {
            total = (3 * parkingCharge) + ((diff - 3) * additionalCharge);
        } else if (diff < 0) {
            total = maxCharge;
        }
        return total;
    }

    //this procedure returns the vehicle parked last according to entry date and time
    public String lastVehicleParked() {
        String lastVehicle;
        int i = 0;
        lastVehicle = "Vehicle: " + parkingList.get(i).getVehicle() + " ID: " + parkingList.get(i).getIdPlate()
                + " Entry date and time: " + parkingList.get(i).getEntryDateTime();
        return lastVehicle;
    }

    //this procedure returns the vehicle that parked the longest
    public String longestVehicleStay(int hour) {
        String longestVehicleStay = " ";
        int longest = 0;
        for (int i = 0; i < parkingList.size(); i++) {
            int diff = hour - parkingList.get(i).getEntryDateTime().getHour();
            if (diff > longest) {
                longest = diff;
                longestVehicleStay = "Vehicle: " + parkingList.get(i).getVehicle() + " ID: " + parkingList.get(i).getIdPlate()
                        + " Entry date and time: " + parkingList.get(i).getEntryDateTime() + " This vehicle stayed for " + diff + " hours";
            }
        }
        return longestVehicleStay;
    }

    //this is the menu interface for th user to access the methods and print lists
    public boolean runMenu() {
        boolean exit = false;
        System.out.println("To add a new vehicle press 1");
        System.out.println("To remove a vehicle press 2");
        System.out.println("To print the parking spaces press 3");
        System.out.println("To print parking list in a specific day press 4");
        System.out.println("To print statistics press 5");
        System.out.println("To print all ticket charges per vehicle press 6");
        System.out.println("To exit press 7");

        int choice = in.nextInt();
        int length = parkingSpaces;
        switch (choice) {
            case 1:
                //this if statement is to prevent further user input if the car park is full
                if (counter < length) {
                    System.out.println("Press 1 if you want to add a Car");
                    System.out.println("Press 2 if you want to add a Van");
                    System.out.println("Press 3 if you want to add a Motorbike");
                    int vehicleChoice = in.nextInt();
                    in.nextLine();
                    switch (vehicleChoice) {
                        case 1:
                            // it is a car
                            this.addCar();
                            counter++;
                            break;
                        case 2:
                            // it is a van
                            this.addVan();
                            counter = counter + 2;
                            break;
                        case 3:
                            // it is a motorbike
                            this.addMotorbike();
                            counter++;
                            break;
                    }
                } else {
                    System.out.println("There is no space left");
                    System.out.println();
                }
                break;
            case 2:
                this.removeVehicle();
                counter--;
                break;
            case 3:
                this.printParkingList();
                break;
            case 4:
                this.specificDayParkingList();
                break;
            case 5:
                this.printStats();
                break;
            case 6:
                this.printTicketCharges();
                break;
            case 7:
                exit = true;
                break;
            default:
                System.out.println("Invalid entry. Please try again");
                System.out.println();
                break;
        }
        return exit;
    }

    public static void main(String[] args) {
        // this creates parking lot
        System.out.println("Car Park Management System");
        CarParkManager cpms = new WestminsterCarParkManager(20); //max: 20 spaces
        boolean exit = false;
        while (!exit) {
            exit = cpms.runMenu();
        }
    }
}
