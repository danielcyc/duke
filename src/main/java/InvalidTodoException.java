public class InvalidTodoException extends Exception{
    InvalidTodoException(){
        System.out.println(PrintableStrings.space + PrintableStrings.line +
                PrintableStrings.space+ "☹ OOPS!!! The description of a todo cannot be empty.\n" +
                PrintableStrings.space + PrintableStrings.line );
    }
}
