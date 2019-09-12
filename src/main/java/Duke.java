import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
/**
 * Represents the entire Duke Personal assistant.
 */
public class Duke {

    /**
     * Main function of Duke.
     * @param args
     */
        public static void main(String[] args) {
        PrintableStrings.printWelcome();

            //Parser input_commands = new Parser();
            while (true) { // keep program running
                new Parser();

                    try {
                        Saver.Saver(TaskList.saveList());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
    }



