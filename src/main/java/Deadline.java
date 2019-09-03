import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

import static java.time.format.DateTimeFormatter.ofLocalizedDate;
import static java.time.format.DateTimeFormatter.ofPattern;

public class Deadline extends Task {

    protected String by;

    public Deadline(String description, String by) {
        super(description);
        this.by = by;
        this.type = "D";
    }

    @Override
    public String toString() {
        return super.toString() + " (by: " + by + ")";
    }
    public static LocalDateTime getBy(String input) throws InvalidDeadlineException{
        if (input.contains("/by")) {
            String text = input.substring(input.lastIndexOf("/by") + 4);
            System.out.println(text);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HHmm");
            LocalDateTime bytime = LocalDateTime.parse(text, formatter);

            return bytime;
        }
        else {
            System.out.println("problem");
            throw new InvalidDeadlineException();
        }
    }
    public static String getDescription(String input) throws InvalidDeadlineException{
        if(input.equals("deadline")) {
            throw new InvalidDeadlineException();
        }
        else {
            return input.substring(input.lastIndexOf("deadline")+9, input.lastIndexOf(" /by"));

        }
    }
}