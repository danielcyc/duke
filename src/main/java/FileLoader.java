import java.io.*;

public class FileLoader {
    public static TaskList Load () throws IOException {
        TaskList output = new TaskList(); // init task list
        // The name of the file to open.
        String fileName = "file1.txt";
        // This will reference one line at a time
        String line = null;
        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader(fileName);
            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while((line = bufferedReader.readLine()) != null) {
                //System.out.println(line);
                String input = line;

               if (input.startsWith("[T]")) {
                    String entry = input.substring(7);
                    Task item = new Task(entry);
                    item.setType("T");
                    if (input.contains("\u2713")) {
                        item.markAsDone();
                    }
                    output.add(item);
                } else if (input.startsWith("[D]")) {
                    String description = input.substring(input.lastIndexOf("[D]")+7, input.lastIndexOf(" (by:"));
                    String byDay = input.substring(input.lastIndexOf(" (by: ") + 6, input.lastIndexOf(")"));
                    Deadline item = new Deadline(description, byDay);
                   if (input.contains("\u2713")) {
                       item.markAsDone();
                   }
                   output.add(item);
                } else if (input.startsWith("[E]")) {
                    String description = input.substring(input.lastIndexOf("[E]") + 7, input.lastIndexOf(" (at: "));
                    String time = input.substring(input.lastIndexOf(" (at: ") + 6, input.lastIndexOf(")"));
                    Event item = new Event(description, time);
                   if (input.contains("\u2713")) {
                       item.markAsDone();
                   }
                    output.add(item);
               }
            }
            // Always close files.
            bufferedReader.close();
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '" +
                            fileName + "'");
        }
        catch(IOException ex) {
            System.out.println(
                    "Error reading file '"
                            + fileName + "'");
            // Or we could just do this:
            // ex.printStackTrace();
        }
        return output;}
}

