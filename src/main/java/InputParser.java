import java.io.IOException;
import java.util.ArrayList;

/**
 * The class used to handle the logic for user inputs
 */

public class InputParser {

    private ArrayList<Task> taskList;
    private ModifyTaskList modifyTaskList = new ModifyTaskList();

    /**
     * The constructor for the InputParser class.
     * @param taskList  Used to store task object information.
     */

    protected InputParser(ArrayList<Task> taskList) {
        this.taskList = taskList;
    }

    /**
     * Used to determine which method from the {@link ModifyTaskList} class to call
     * depending on the first word from the input.
     *
     * @param input  The input from the user.
     * @see ModifyTaskList
     */

    protected void determineAction(String input) throws IOException {

        int taskNumber;
        String by;
        String desc;
        String at;
        String firstWord;

        firstWord = input.split(" ")[0];
        switch (firstWord) {

        case "bye":
            break;

        case "todo":
            try {
                desc = input.split(" ", 2)[1];
            } catch (IndexOutOfBoundsException err) {
                System.out.println("OOPS!!! The description of a todo cannot be empty.\n");
                break;
            }
            ToDo toDo = new ToDo(desc);
            modifyTaskList.addToTaskList(taskList, toDo, Duke.Action.ADD);
            break;


        case "deadline":
            try {
                by = input.split(" /by ")[1];
                desc = input.split(" /by ")[0].split(" ", 2)[1];
            } catch (IndexOutOfBoundsException err) {
                System.out.println("OOPS!!! Incorrect description for event; remember to use the /by keyword.\n");
                break;
            }
            Deadline d = new Deadline(desc, by);
            modifyTaskList.addToTaskList(taskList, d, Duke.Action.ADD);
            break;

        case "event":
            try {
                at = input.split(" /at ")[1];
                desc = input.split(" /at ")[0].split(" ", 2)[1];
            } catch (IndexOutOfBoundsException err) {
                System.out.println("OOPS!!! Incorrect description for event; remember to use the /at keyword.\n");
                break;
            }
            Event e = new Event(desc, at);
            modifyTaskList.addToTaskList(taskList, e, Duke.Action.ADD);
            break;

        case "list":
            System.out.println("Here are the tasks in your list:");
            for (int a = 0; a < taskList.size(); a++) {
                System.out.println((a + 1) + ". " + taskList.get(a).toString());
            }
            System.out.println();
            break;

        case "done":
            try {
                taskNumber = Integer.parseInt(input.split(" ")[1]);
            } catch (NumberFormatException err) {
                System.out.println("OOPS!!! Please enter a valid number\n");
                break;
            } catch (IndexOutOfBoundsException err) {
                System.out.println("You only have " + taskList.size() + " tasks, please choose a number from that\n");
                break;
            }
            modifyTaskList.changeTaskList(taskList, taskNumber - 1, Duke.Action.DONE);
            break;

        case "delete":
            try {
                taskNumber = Integer.parseInt(input.split(" ")[1]);
            } catch (NumberFormatException err) {
                System.out.println("OOPS!!! Please enter a valid number\n");
                break;
            } catch (IndexOutOfBoundsException err) {
                System.out.println("You only have " + taskList.size() + " tasks, please choose a number from that\n");
                break;
            }
            modifyTaskList.changeTaskList(taskList, taskNumber - 1, Duke.Action.REMOVE);
            break;

        case "find":
            try {
                desc = input.split(" ")[1];
                int findCounter = 0;
                System.out.println("Here are the matching tasks in your list:");
                for (int a = 0; a < taskList.size(); a++) {
                    if (taskList.get(a).description.contains(desc)){
                        findCounter++;
                        System.out.println(findCounter + ". " + taskList.get(a).toString());
                    }
                }
                System.out.println();
                break;
            } catch (IndexOutOfBoundsException err) {
                System.out.println("OOPS!!! Incorrect format for the 'find' command.\n");
                break;
            }

        default:
            System.out.println("OOPS!!! I'm sorry, but I don't know what that means\n");
            break;
        }
    }
}
