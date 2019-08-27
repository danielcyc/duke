import java.util.Arrays;
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

        Task[] userlist = new Task[100];
        int counter = 0; // counts number of items in list

        Scanner user_input = new Scanner(System.in);
        while (true) { // keep program running
            String input = user_input.nextLine(); // take in input
            if (input.equals("bye")) {
                System.out.println( space + line + space + "Bye. Hope to see you again soon!" + "\n" + space + line);
                break;
            }
            else if (input.equals("list")) {

                System.out.print(space + line + space +"Here are the tasks in your list: \n");
                for (int i = 0; i < counter; i++){
                    System.out.print(space + (i+1) + ".["+ userlist[i].getStatusIcon() + "] " + userlist[i].getDescription() + "\n");
                }
                System.out.println(space + line);
                //print out counter and list

            }
            else if (input.startsWith("done")) {
                String[] parts = input.split(" ");
                int index = Integer.parseInt(parts[1]) -1 ;
                userlist[index].markAsDone();
                System.out.print(space + line);
                System.out.println(space + "Nice! I've marked this task as done:\n" + space + "  [" + userlist[index].getStatusIcon() + "] " + userlist[index].getDescription());
                System.out.print(space + line);

            }
            else if (input.startsWith("todo")){
                // do something

            }
            else if (input.startsWith("deadline")){
                String[] parts = input.split(" |/by");
                String byDay = input.substring(input.lastIndexOf("/by") +1 );
                parts[0] = "";
                parts[parts.length-1] = "";
                String description = Arrays.toString(parts);

                Deadline item = new Deadline(description, byDay);
                userlist[counter] = item;


                System.out.print(space + line);
                System.out.println(space + "Got it. I've added this task: \n" + space + "  [" + userlist[counter].getStatusIcon() + "] " + userlist[counter].getDescription());
                System.out.println(space + "Now you have " + (counter+1) + " tasks in the list");
                System.out.print(space + line);
                counter += 1;

            }
            else if (input.startsWith("event")){
                String[] parts = input.split(" |/at");
                String byDay = input.substring(input.lastIndexOf("at") +1 );
                parts[0] = "";
                parts[parts.length-1] = "";
                String description = Arrays.toString(parts);

                Events item = new Events(description, byDay);
                userlist[counter] = item;



                System.out.print(space + line);
                System.out.println(space + "Got it. I've added this task: \n" + space + "  [" + userlist[counter].getStatusIcon() + "] " + userlist[counter].getDescription());
                System.out.println(space + "Now you have " + counter + " tasks in the list");
                System.out.print(space + line);
                counter += 1;

            }
            else
             {
                 Task item = new Task(input);
                 userlist[counter] = item;
                counter += 1;
                System.out.println(space + line + space + " added: " + item.getDescription() + "\n" + space + line);
            }
        }

    }
}

