import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Time time1 = new Time();
        Time time2 = new Time();
        Time duration;

        time1.read("Enter time 1", scanner);
        time2.read("Enter time 2", scanner);
        
        if (time1.lessThan(time2)) {
 //           duration = time2.subtract(time1);
            System.out.print("Starting time was ");
            time1.display();
        } else {
 //           duration = time1.subtract(time2);
            System.out.print("Starting time was ");
            time2.display();
        }
        
        System.out.print("Duration was ");
   //     duration.display();
    }
}