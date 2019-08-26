import java.util.Scanner;  // Import the Scanner class

public class echo {

    public static void input (String[] input) {
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter input");

        String user_input = myObj.nextLine();  // Read user input
        System.out.println("Input:" + user_input);  // Output user input
    }
}
