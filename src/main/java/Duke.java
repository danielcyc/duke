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

        String[] userlist = new String[100];
        int counter = 0;

        Scanner user_input = new Scanner(System.in);
        while (true) {
            String input = user_input.nextLine(); // take in input
            if (input.equals("bye")) {
                System.out.println( space + line + space + "Bye. Hope to see you again soon!" + "\n" + space + line);
                break;
            } else if (input.equals("list")) {

                System.out.print(space + line);
                for (int i = 0; i < counter; i++){
                    System.out.print(space + " " + (i+1) + ". "+ userlist[i] + "\n");
                }
                System.out.print(space + line);
                //print out counter and list

            } else {
                userlist[counter] = input;
                counter += 1;
                System.out.println(space + line + space + " added: " + input + "\n" + space + line);
            }
        }

    }
}

