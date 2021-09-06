import java.util.Scanner;
import java.util.InputMismatchException;

public class TimeDemo {
    public static void main(String args[]) {
        try {
            System.out.println("Enter seconds passed since midnight: ");
            Scanner reader = new Scanner(System.in);

            int secondsPassedSinceMidnight = reader.nextInt();

            Time timeA = new Time(secondsPassedSinceMidnight);
            for (int i = 0; i < 10; i++) {
                timeA.tick();
                System.out.println(timeA.toString());
            }

            System.out.println("Enter hours, minutes and seconds: ");
            Scanner reader2 = new Scanner(System.in);

            int[] integers = new int[3];
            for (int i = 0; i < 3; i++) {
                integers[i] = reader2.nextInt();
            }

            Time timeB = new Time(integers[0], integers[1], integers[2]);
            for (int i = 0; i < 10; i++) {
                timeB.tick();
                System.out.println(timeB.toString());
            }

            System.out.println("The sum of time between the first and second time (after ticks)");
            System.out.println(timeA.addTime(timeB).toString());

            Time timeC = timeA.substracTime(timeB);

            System.out.println("The difference of the time between the first and second time (after ticks)");
            System.out.println(timeC.toString());
            reader.close();
            reader2.close();
        } catch (InputMismatchException e) {
            System.out.println("Please only write numbers.");
        } catch (Exception e) {
            System.out.println("Some unexplained error has occured.");
        }

    }
}
