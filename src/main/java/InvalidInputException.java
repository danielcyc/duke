public class InvalidInputException extends Exception {
    InvalidInputException(){
        System.out.println(PrintableStrings.space + PrintableStrings.line +
                PrintableStrings.space+ "☹ OOPS!!! I'm sorry, but I don't know what that means :-(\n" +
                PrintableStrings.space + PrintableStrings.line );
    }
}
