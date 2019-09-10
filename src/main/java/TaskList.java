import java.util.ArrayList;
import java.util.List;

/**
 * Represents a task list
 */
public class TaskList {
    protected static List<Task> list;

    /**
     * initialises a tasklist as an array list
     */
    public TaskList (){
        this.list = new ArrayList<>();
        }

    /**
     * Adds an item into the task list
     * @param task a task to be added into the list
     */
    public void add(Task task){
        this.list.add(task);
    }

    /**
     * Prints the whole list of task out.
     */
    public static void printList(){
        System.out.print(PrintableStrings.space + PrintableStrings.line + PrintableStrings.space+ "Here are the tasks in your list: \n");
        for (int i = 0; i < list.size(); i++){
            //System.out.println(PrintableStrings.space  + list[i]);

            System.out.print(PrintableStrings.space + (i+1) + ". " + list.get(i)+ "\n");
        }
        System.out.println(PrintableStrings.space + PrintableStrings.line);
    }

    /**
     * Prints a specific line of the task list based on the index
     * @param index the index of the item to be printed.
     */
    public static void println(int index){
        System.out.print(PrintableStrings.space + "["+ list.get(index).getType() + "] [" + list.get(index).getStatusIcon() + "] "+
                list.get(index).getDescription() + "\n");
    }

    /**
     * Returns a string to be saved in the savefile.
     * @return String whole list of items on the tasklist
     */
    public static String saveList(){
        String Output = "";

        for (int i = 0; i < list.size(); i++){
            Output += list.get(i)+ "\n";
        }
        return Output;
    }

    /**
     * Returns the item based of the index
     *  @param index
     * @return Task
     */
    public static Task getListIndex(int index) {
        return list.get(index);
    }

    /**
     * Returns number of items in the list
     * @return int number of items in the list
     */
    public static int size() {
        return list.size();
    }

    /**
     * Removes the item from the task list of the specified index
     * @param index index of the item to be removed
     */
    public static void remove (int index) {
        Task item = list.get(index);
        list.remove(index);
        System.out.print(PrintableStrings.space + PrintableStrings.line +
                PrintableStrings.space + "Noted. I've removed this task:\n" +
                PrintableStrings.space + item + "\n" +
                PrintableStrings.space + PrintableStrings.line);
    }

    /**
     * Prints all occurrences of the keyword in the task list
     * @param keyword the word to be searched for
     */
    public static void find (String keyword){
        int counter = 1;
        System.out.println(PrintableStrings.space + PrintableStrings.line +
                PrintableStrings.space + "Here are the matching tasks in your list:");
        for (int i = 0; i < list.size(); i++){
            if (list.get(i).getDescription().contains(keyword)) {
                System.out.println(PrintableStrings.space + Integer.toString(counter) + "." + list.get(i));
                counter++;
            }
        }
        System.out.println(PrintableStrings.space + PrintableStrings.line);
    }
}
