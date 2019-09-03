import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.IOException;
import java.util.ArrayList;

/**
 * A class to test the {@link InputParser} class
 */

public class InputParserTest {

    /**
     * Input in random strings to see which ones the {@link InputParser} class accepts
     * and compare the number of total Tasks in the Task array list.
     */

    @Test
    public void inputTest() throws IOException {

        ArrayList<Task> taskList = new ArrayList<>(100);
        InputParser inputParser = new InputParser(taskList);
        String input1 = "todo finish JUnit testing";
        String input2 = "random nonsense";
        String input3 = "deadline finish Project /by 20/04/2019";
        String input4 = "event game event /at 23-DEC-2020";
        String input5 = "bye";
        String input6 = "deadline will never surface /by 22/11/2039";
        String input7 = "more random nonsense";

        inputParser.determineAction(input1);
        inputParser.determineAction(input2);
        inputParser.determineAction(input3);
        inputParser.determineAction(input4);
        inputParser.determineAction(input5);
        inputParser.determineAction(input6);
        inputParser.determineAction(input7);

        assertEquals(4, taskList.size());
    }
}
