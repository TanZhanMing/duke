import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * A list of accepted date formats by me to parse user inputs through to recognise dates
 */

public class DateParser {

    private static SimpleDateFormat formatter1 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
    private static SimpleDateFormat formatter2 = new SimpleDateFormat("dd-MM-yyyy HH:mm");
    private static SimpleDateFormat formatter3 = new SimpleDateFormat("dd-MM-yyyy HHmm");
    private static SimpleDateFormat formatter4 = new SimpleDateFormat("dd-MM-yyyy");
    private static SimpleDateFormat formatter5 = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
    private static SimpleDateFormat formatter6 = new SimpleDateFormat("dd-MMM-yyyy HH:mm");
    private static SimpleDateFormat formatter7 = new SimpleDateFormat("dd-MMM-yyyy HHmm");
    private static SimpleDateFormat formatter8 = new SimpleDateFormat("dd-MMM-yyyy");
    private static SimpleDateFormat formatter9 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    private static SimpleDateFormat formatter10 = new SimpleDateFormat("dd/MM/yyyy HH:mm");
    private static SimpleDateFormat formatter11 = new SimpleDateFormat("dd/MM/yyyy HHmm");
    private static SimpleDateFormat formatter12 = new SimpleDateFormat("dd/MM/yyyy");
    private static SimpleDateFormat formatter13 = new SimpleDateFormat("dd/MMM/yyyy HH:mm:ss");
    private static SimpleDateFormat formatter14 = new SimpleDateFormat("dd/MMM/yyyy HH:mm");
    private static SimpleDateFormat formatter15 = new SimpleDateFormat("dd/MMM/yyyy HHmm");
    private static SimpleDateFormat formatter16 = new SimpleDateFormat("dd/MMM/yyyy");

    /**
     * Returns a Date object to the caller class by parsing through all listed formats.
     * It ignores all wrong format exceptions until the final one
     * where it returns a null value to signify an inability to match the String
     * given to any date format.
     * <p>
     *
     * @param date the string given by the user which might contain a date.
     * @return either a Date object or null value.
     */

    public static Date parseDate(String date) {

        try {
            return formatter1.parse(date);
        } catch (Exception ignored) {
        }
        try {
            return formatter2.parse(date);
        } catch (Exception ignored) {
        }try {
            return formatter3.parse(date);
        } catch (Exception ignored) {
        }try {
            return formatter4.parse(date);
        } catch (Exception ignored) {
        }try {
            return formatter5.parse(date);
        } catch (Exception ignored) {
        }try {
            return formatter6.parse(date);
        } catch (Exception ignored) {
        }try {
            return formatter7.parse(date);
        } catch (Exception ignored) {
        }
        try {
            return formatter8.parse(date);
        } catch (Exception ignored) {
        }
        try {
            return formatter9.parse(date);
        } catch (Exception ignored) {
        }try {
            return formatter10.parse(date);
        } catch (Exception ignored) {
        }try {
            return formatter11.parse(date);
        } catch (Exception ignored) {
        }try {
            return formatter12.parse(date);
        } catch (Exception ignored) {
        }try {
            return formatter13.parse(date);
        } catch (Exception ignored) {
        }try {
            return formatter14.parse(date);
        } catch (Exception ignored) {
        }
        try {
            return formatter15.parse(date);
        } catch (Exception ignored) {
        }try {
            return formatter16.parse(date);
        } catch (Exception ignored) {
            return null;
        }
    }
}
