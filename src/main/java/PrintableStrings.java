public class PrintableStrings {
    protected static String logo = " ____        _        \n"
            + "|  _ \\ _   _| | _____ \n"
            + "| | | | | | | |/ / _ \\\n"
            + "| |_| | |_| |   <  __/\n"
            + "|____/ \\__,_|_|\\_\\___|\n";
    protected static String line = "___________________________________________________________________\n";
    protected static String space = "    ";
    protected static void printBye(){
        System.out.println(space + line +
                space + "Bye. Hope to see you again soon!" + "\n" + space + line);
    }
    protected static void printWelcome(){
        System.out.println("Hello from\n" + logo);
        System.out.println(space + line + space + "Hello! I'm Duke\n" +
                space + "What can I do for you?\n"+
                space + line);
    }
    public PrintableStrings(){
    }
}

