/**
 * Represents a savefile class
 */

import java.io.*;


public class Saver  {
    /**
     * Saves tasklist as a txt file.
     * @param output a combined printed list of all tasks
     * @throws IOException if input is invalid
     */
    public static void Saver(String output) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("/Users/daniel/Downloads/CS2113T/duke/file1.txt"));
        writer.write(output);
        writer.close();
    }
}
