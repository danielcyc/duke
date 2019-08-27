import java.util.Arrays;
import java.util.Scanner;
public class Duke {
        public static void main(String[] args) {
        PrintableStrings.printWelcome();
        TaskList userlist = new TaskList(); // init task list
        Scanner user_input = new Scanner(System.in); // init scanner

        while (true) { // keep program running
            String input = user_input.nextLine(); // take in input
            if (input.equals("bye")) {
                PrintableStrings.printBye();
                break; // ends program
            }
            else if (input.equals("list")) {
                TaskList.printList();
            }
           else if (input.startsWith("done")) {
                String[] parts = input.split(" ");
                int index = Integer.parseInt(parts[1]) -1 ;
                userlist.getListIndex(index).markAsDone();

                System.out.print(PrintableStrings.space + PrintableStrings.line);
                System.out.println(PrintableStrings.space + "Nice! I've marked this task as done:\n" + PrintableStrings.space + "  ["
                        + userlist.getListIndex(index).getStatusIcon() + "] " + userlist.getListIndex(index).getDescription());
                System.out.print(PrintableStrings.space + PrintableStrings.line);

            }
            else if (input.startsWith("todo")){
                // do something
                //String[] parts = input.split(" ");
                String entry =input.substring(5);
                Task item = new Task(entry);
                item.setType("T");
                userlist.add(item);

                System.out.println(PrintableStrings.space + PrintableStrings.line + PrintableStrings.space + "Got it. I've added this task: \n" +
                        PrintableStrings.space + "  [" + item.getType() + "][" + item.getStatusIcon() + "] " + item.getDescription() + "\n" +
                                PrintableStrings.space + "Now you have " + userlist.getCounter() + " tasks in the list.\n" +
                        PrintableStrings.space + PrintableStrings.line);
            }
           /*else if (input.startsWith("deadline")){
                String[] parts = input.split(" |/by");
                String byDay = input.substring(input.lastIndexOf("/by") +1 );
                parts[0] = "";
                parts[parts.length-1] = "";
                String description = Arrays.toString(parts);

                Deadline item = new Deadline(description, byDay);
                userlist[counter] = item;


                System.out.print(PrintableStrings.space + PrintableStrings.line);
                System.out.println(PrintableStrings.space + "Got it. I've added this task: \n" + PrintableStrings.space + "  [" + userlist[counter].getStatusIcon() + "] " + userlist[counter].getDescription());
                System.out.println(PrintableStrings.space + "Now you have " + (counter+1) + " tasks in the list");
                System.out.print(PrintableStrings.space + PrintableStrings.line);
                counter += 1;

            }
            else if (input.startsWith("event")){
                String[] parts = input.split(" |/at");
                String byDay = input.substring(input.lastIndexOf("at") +1 );
                parts[0] = "";
                parts[parts.length-1] = "";
                String description = Arrays.toString(parts);

                Event item = new Event(description, byDay);
                userlist[counter] = item;



                System.out.print(PrintableStrings.space + PrintableStrings.line);
                System.out.println(PrintableStrings.space + "Got it. I've added this task: \n" + PrintableStrings.space + "  [" + userlist[counter].getStatusIcon() + "] " + userlist[counter].getDescription());
                System.out.println(PrintableStrings.space + "Now you have " + counter + " tasks in the list");
                System.out.print(PrintableStrings.space + PrintableStrings.line);
                counter += 1;

            }*/
            else
             {
                 Task item = new Task(input);
                 userlist.add(item);
                System.out.println(PrintableStrings.space + PrintableStrings.line + PrintableStrings.space + " added: " + item.getDescription() + "\n" + PrintableStrings.space + PrintableStrings.line);
            }
        }

    }
}

