
public class TaskList {
    protected static Task[] list;
    protected static int counter;

    public TaskList (){
        this.list = new Task[100];
        this.counter = 0;
    }
    public void add(Task task){
        list[counter] = task;
        counter ++;
    }

    public static void printList(){
        System.out.print(PrintableStrings.space + PrintableStrings.line + PrintableStrings.space+ "Here are the tasks in your list: \n");
        for (int i = 0; i < counter; i++){
            //System.out.println(PrintableStrings.space  + list[i]);

            System.out.print(PrintableStrings.space + (i+1) + ". " + list[i]+ "\n");
        }
        System.out.println(PrintableStrings.space + PrintableStrings.line);
    }
    public static void println(int index){
        System.out.print(PrintableStrings.space + "["+ list[index].getType() + "] [" + list[index].getStatusIcon() + "] "+
                list[index].getDescription() + "\n");
    }

    public static Task getListIndex(int index) {
        return list[index];
    }

    public static int getCounter() {
        return counter;
    }
}
