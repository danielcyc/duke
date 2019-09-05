import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Duke {
        public static void main(String[] args) {
        PrintableStrings.printWelcome();
        TaskList userlist = new TaskList(); // init task list
        Scanner user_input = new Scanner(System.in); // init scanner
            try {
                userlist = FileLoader.Load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            while (true) { // keep program running
                try {
                    String input = user_input.nextLine(); // take in input

                    if (input.equals("bye")) {
                        PrintableStrings.printBye();
                        break; // ends program
                    } else if (input.equals("list")) {
                        TaskList.printList();
                    } else if (input.startsWith("done")) {
                        String[] parts = input.split(" ");
                        int index = Integer.parseInt(parts[1]) - 1;
                        userlist.getListIndex(index).markAsDone();

                        System.out.print(PrintableStrings.space + PrintableStrings.line +
                                PrintableStrings.space + "Nice! I've marked this task as done:\n" +
                                PrintableStrings.space + userlist.getListIndex(index) + "\n" +
                                PrintableStrings.space + PrintableStrings.line);
                    }
                    else if (input.startsWith("delete")){
                        int index = Integer.parseInt(input.substring(7)) - 1;
                        userlist.remove(index);
                    }

                    else if (input.startsWith("todo")) {
                        //String[] parts = input.split(" ");
                        if (input.equals("todo")) {
                            throw new InvalidTodoException();
                        }
                        String entry = input.substring(5);
                        Task item = new Task(entry);
                        item.setType("T");
                        userlist.add(item);
                        System.out.println(
                                PrintableStrings.space + PrintableStrings.line +
                                        PrintableStrings.space + "Got it. I've added this task: \n " +
                                        PrintableStrings.space + item + "\n" +
                                        PrintableStrings.space + "Now you have " + userlist.size() + " tasks in the list.\n" +
                                        PrintableStrings.space + PrintableStrings.line);
                    } else if (input.startsWith("deadline")) {
                        String description = Deadline.getDescription(input);
                        LocalDateTime byDay = Deadline.getBy(input);
                        System.out.println(byDay);
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HHmm");
                        String strDate = formatter.format(byDay);
                        Deadline item = new Deadline(description, strDate);
                        userlist.add(item);
                        System.out.println(
                                PrintableStrings.space + PrintableStrings.line +
                                        PrintableStrings.space + "Got it. I've added this task: \n " +
                                        PrintableStrings.space + item + "\n" +
                                        PrintableStrings.space + "Now you have " + userlist.size() + " tasks in the list.\n" +
                                        PrintableStrings.space + PrintableStrings.line);
                        //String[] parts = input.split(" /by | ");
                        //System.out.println(Arrays.toString(parts));
                        //System.out.println(d);
                        //String description = "";
                    /*for (int i = 1; i < parts.length-1; i++  ){
                        description += parts[i];
                        if (i == parts.length -2) {
                            continue;
                        }
                        else {
                            description += " ";
                        }
                    }*/
                        //System.out.println(description);
                        //String d = String.join("|", parts);
                        //String description = String.join(" ", parts); //Arrays.toString(parts);
                        //System.out.println(d);
                    } else if (input.startsWith("event")) {
                        String description = input.substring(input.lastIndexOf("event") + 6, input.lastIndexOf(" /at"));
                        String time = input.substring(input.lastIndexOf("/at") + 4);
                        //System.out.println(time);

                        Event item = new Event(description, time);
                        userlist.add(item);

                        System.out.println(
                                PrintableStrings.space + PrintableStrings.line +
                                        PrintableStrings.space + "Got it. I've added this task: \n " +
                                        PrintableStrings.space + item + "\n" +
                                        PrintableStrings.space + "Now you have " + userlist.size()
 + " tasks in the list.\n" +
                                        PrintableStrings.space + PrintableStrings.line);


                    } else {
                    /* Task item = new Task(input);
                     userlist.add(item);
                    System.out.println(PrintableStrings.space + PrintableStrings.line + PrintableStrings.space + " added: " + item.getDescription() + "\n" + PrintableStrings.space + PrintableStrings.line);
                    */
                        throw new InvalidInputException();
                    }

                    try {
                        Saver.Saver(TaskList.saveList());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }


                }

                catch (InvalidTodoException | InvalidDeadlineException | InvalidInputException e) {
                }

                catch (InvalidDeadlineException e) {
                }

                catch(InvalidInputException e) {
                }
                catch (Exception e) {
                    //new DukeExceptionHandler(e);
                    System.out.println(PrintableStrings.space + PrintableStrings.line +
                            PrintableStrings.space+ "☹ OOPS!!! That's an invalid input! Please try again.\n" +
                            PrintableStrings.space + PrintableStrings.line );
                }
            }
    }
}


