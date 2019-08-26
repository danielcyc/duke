import java.util.Scanner;
public class Duke {
    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";

        String line = "___________________________________________________________________\n";
        String space = "    ";

        System.out.println("Hello from\n" + logo);

        System.out.println(space + line + space + "Hello! I'm Duke\n" +
                        space + "What can I do for you?\n"+
                            space + line);
        Scanner user_input = new Scanner(System.in);
        while (true) {
            String input = user_input.nextLine();
            if (input.equals("bye")) {
                System.out.println("\n" + space + line + space + "Bye. Hope to see you again soon!" + "\n" + space + line);
                break;
            } else {
                System.out.println("\n" + space + line + space + input + "\n" + space + line);
            }
        }

    }
}

