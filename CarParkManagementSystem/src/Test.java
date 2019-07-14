
import java.util.*;
public class Test {
    
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        DateTime dateTime = new DateTime(11,11,2011,12,12);
        System.out.println(dateTime);
        Car car1 = new Car("","",dateTime,0,"");
        car1.setIdPlate("wretw");
        car1.setBrand("dsfdcf");
        car1.setNoOfDoors(4);
        car1.setColor("red");
        //System.out.println(car1.getEntryDate() + " " + car1.getEntryTime());
        System.out.println(car1);
        System.out.println("Enter date");
        int day = s.nextInt();
        if (car1.getEntryDateTime().equals(day)){
            System.out.println("it works");  
        }
    }
}
