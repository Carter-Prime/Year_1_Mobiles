
import java.util.Scanner;

public class MessageThreeTimes {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Write a message:");
        String name = scanner.nextLine().toString();
        for(int i=0; i< 3;i++){
            System.out.println(name);
        }

    }
}
