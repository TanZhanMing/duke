import java.io.IOException;
import java.util.ArrayList;

public class ModifyTaskList {

    Ui ui = new Ui();

    protected ModifyTaskList() {}

    protected void addToTaskList(ArrayList<Task> taskList, Task t, Duke.Action action) throws IOException {
        if (action == Duke.Action.ADD) {
            taskList.add(t);
            ui.taskAdded(taskList);
            FileWriting.writeToFile(taskList);
        }
    }
    protected void changeTaskList (ArrayList<Task> taskList, int taskNumber, Duke.Action action){
        if (action == Duke.Action.REMOVE) {
            try {
                ui.taskRemoved(taskList, taskNumber);
                taskList.remove(taskNumber);
                FileWriting.writeToFile(taskList);
            }
            catch (IndexOutOfBoundsException | IOException err){
                System.out.println("You only have " + taskList.size() + " tasks, please choose a number from that\n");
            }
        }
        if (action == Duke.Action.DONE){
            try {
                ui.taskDone(taskList, taskNumber);
                taskList.get(taskNumber).setDone();
                FileWriting.writeToFile(taskList);
            }
            catch (IndexOutOfBoundsException | IOException err){
                System.out.println("You only have " + taskList.size() + " tasks, please choose a number from that\n");
            }
        }
    }
}
