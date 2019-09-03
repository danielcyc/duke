
import java.io.*;

public class Saver  {
    public static void Saver(String output) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("/Users/daniel/Downloads/CS2113T/duke/file1.txt"));
        writer.write(output);
        writer.close();
    }
}
