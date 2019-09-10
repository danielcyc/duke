import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Represents a Deadline. Has type D and a deadline time
 */
public class Deadline extends Task {
    protected String by;
    public Deadline(String description, String by) {
        super(description);
        this.by = by;
        this.type = "D";
    }

    /**
     * Returns a new string format with "(by: )" inserted at the end of the printout
     *
     * @return String of deadline.
     * @throws InvalidDeadlineException  If inputs for deadline is invalid.
     */

    @Override
    public String toString() {
        return super.toString() + " (by: " + by + ")";
    }

    /**
     * Returns LocalDateTime of the deadline.
     *
     * @param input  whole command by user
     * @return LocalDateTime of the deadline.
     * @throws InvalidDeadlineException  If inputs for deadline is invalid.
     */
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
    /**
     * Returns string of description of the deadline.
     *
     * @param input  whole command by user
     * @return string of description of the deadline
     * @throws InvalidDeadlineException  If inputs for deadline is invalid.
     */
    public static String getDescription(String input) throws InvalidDeadlineException{
        if(input.equals("deadline")) {
            throw new InvalidDeadlineException();
        }
        else {
            return input.substring(input.lastIndexOf("deadline")+9, input.lastIndexOf(" /by"));

        }
    }
}