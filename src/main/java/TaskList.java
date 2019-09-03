import java.util.ArrayList;
import java.util.List;

public class TaskList {
    protected static List<Task> list;

    public TaskList (){
        this.list = new ArrayList<>();
        }
    public void add(Task task){
        this.list.add(task);
    }

    public static void printList(){
        System.out.print(PrintableStrings.space + PrintableStrings.line + PrintableStrings.space+ "Here are the tasks in your list: \n");
        for (int i = 0; i < list.size(); i++){
            //System.out.println(PrintableStrings.space  + list[i]);

            System.out.print(PrintableStrings.space + (i+1) + ". " + list.get(i)+ "\n");
        }
        System.out.println(PrintableStrings.space + PrintableStrings.line);
    }
    public static void println(int index){
        System.out.print(PrintableStrings.space + "["+ list.get(index).getType() + "] [" + list.get(index).getStatusIcon() + "] "+
                list.get(index).getDescription() + "\n");
    }
    public static String saveList(){
        String Output = "";

        for (int i = 0; i < list.size(); i++){
            Output += list.get(i)+ "\n";
        }

        return Output;
    }

    public static Task getListIndex(int index) {
        return list.get(index);
    }

    public static int size() {
        return list.size();
    }
    public static void remove (int index) {
        Task item = list.get(index);
        list.remove(index);
        System.out.print(PrintableStrings.space + PrintableStrings.line +
                PrintableStrings.space + "Noted. I've removed this task:\n" +
                PrintableStrings.space + item + "\n" +
                PrintableStrings.space + PrintableStrings.line);

    }
}
