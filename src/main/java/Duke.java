import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * The main class for Duke.
 */

public class Duke {

    public enum Action {
        ADD,
        REMOVE,
        DONE,
        FIND
    }

    public static void main(String[] args) throws IOException {

        Ui ui = new Ui();
        ArrayList<Task> taskList = new ArrayList<>(100);
        InputParser inputParser = new InputParser(taskList);
        Scanner scan = new Scanner(System.in);
        String input = "";

        try {
            FileReading.checkFileExists(taskList);
        }  catch (IOException e) {
            System.out.println("Oops. something went wrong with the duke.txt file");
        }

        ui.sayGreeting();

        while (!input.equals("bye")) {
            input = scan.nextLine();
            inputParser.determineAction(input);
        }

        ui.sayGoodbye();
    }
}
