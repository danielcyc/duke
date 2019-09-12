/**
 * Represents an invalid todo input by the user exception. Prints out a string to tell
 * user input for todo command is invalid
 */
public class InvalidTodoException extends Exception{
    InvalidTodoException(){
        System.out.println(PrintableStrings.space + PrintableStrings.line +
                PrintableStrings.space+ "OOPS!!! The description of a todo cannot be empty.\n" +
                PrintableStrings.space + PrintableStrings.line );
    }
}
