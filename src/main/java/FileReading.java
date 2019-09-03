import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * The class used to check for existing file data and to load it into the Task array list
 */

public class FileReading {

    /**
     * Used to check for an existing 'data' directory and 'duke.txt' file.
     * If not present, create the missing directory or file.
     * If present, call the loadFile contents method.
     *
     * @param taskList  Used to store task object information.
     * @throws IOException For cases where the file or directory could not
     * be created due to permissions.
     */

    public static void checkFileExists(ArrayList<Task> taskList) throws IOException {
        File directory = new File("data");
        if (! directory.exists()){
            directory.mkdir();
        }
        File f = new File("data/duke.txt");
        if (!f.createNewFile()){loadFileContents(taskList, f);}
    }

    /**
     * Loads all the data from an existing 'duke.txt' into the task array list.
     *
     * @param taskList  Used to store task object information.
     * @param f File path.
     * @throws FileNotFoundException For cases where the method is called without a file present.
     */

    public static void loadFileContents(ArrayList<Task> taskList, File f) throws FileNotFoundException {
        String fullLine;
        String type;
        String done;
        String desc;
        String time = "";
        Scanner s = new Scanner(f);

        while (s.hasNextLine()) {
            fullLine = s.nextLine();
            String[] strArr = fullLine.split(" @ ");
            type = strArr[0];
            desc = strArr[1];
            done = strArr[2];
            if (type.equals("D") | type.equals("E")) {
                time = strArr[3];
            }

            switch (type) {
            case "T":
                ToDo toDo = new ToDo(desc);
                taskList.add(toDo);
                if (done.equals("true")) {
                    taskList.get(taskList.size() - 1).setDone();
                }
                break;

            case "D":
                Deadline d = new Deadline(desc, time);
                taskList.add(d);
                if (done.equals("true")) {
                    taskList.get(taskList.size() - 1).setDone();
                }
                break;

            case "E":
                Event e = new Event(desc, time);
                taskList.add(e);
                if (done.equals("true")) {
                    taskList.get(taskList.size() - 1).setDone();
                }
                break;
            }
        }
        s.close();
    }

}
