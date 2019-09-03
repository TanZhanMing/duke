import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * The class used to write data from the Task array list and store it in a 'duke.txt' file.
 */

public class FileWriting {

    /**
     * Used to check for an existing 'data' directory and 'temp.txt' file.
     * If not present, create the missing directory or file.
     * If present, delete the existing file and create a new file.
     * After that, it iterates through all the details of the task
     * and stores them in the 'temp.txt' file.
     * Lastly, it replaces the existing 'duke.txt' file and deletes
     * the 'temp.txt' file.
     *
     * @param taskList  Used to store task object information.
     * @throws IOException For cases where the file or directory could not
     * be created due to permissions.
     */


    public static void writeToFile(ArrayList<Task> taskList) throws IOException {

        File directory = new File("data");
        if (!directory.exists()) {
            directory.mkdir();
        }

        File tmp = new File("data/temp.txt");
        if (!tmp.createNewFile()) {
            Files.delete(Paths.get("data/temp.txt"));
            tmp.createNewFile();
        }

        FileWriter fw = new FileWriter("data/temp.txt", true);
        Iterator<Task> taskIterator = taskList.iterator();
        while (taskIterator.hasNext()) {
            fw.write(taskIterator.next().getDetails() + System.lineSeparator());
        }
        fw.close();

        Files.copy(Paths.get("data/temp.txt"), Paths.get("data/duke.txt"), StandardCopyOption.REPLACE_EXISTING);
        Files.delete(Paths.get("data/temp.txt"));
    }
}
