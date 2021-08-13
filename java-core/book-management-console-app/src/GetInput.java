
import java.util.Scanner;

/**
 * To prompt user to get their input while check its validity
 *
 * @author trduy
 */
public class GetInput {

    static final String ERROR_MSG_INT = "\nInvalid input. Please enter an integer value!\n";
    static final String ERROR_MSG_DOUBLE = "\nInvalid input. Please enter a double value!\n";

    public static int Integer(String prefixMsg) {
        int intVal = 0;

        Scanner getInput = new Scanner(System.in);

        while (true) {
            try {
                System.out.print(prefixMsg + ": ");
                intVal = Integer.parseInt(getInput.nextLine());
            } catch (NumberFormatException ex) {
                System.err.println(ERROR_MSG_INT);
                continue;
            }
            break;
        }

        return intVal;
    }

    public static int Integer(String prefixMsg, int min, int max) {
        int intVal = 0;

        Scanner getInput = new Scanner(System.in);

        while (true) {
            try {
                System.out.print(prefixMsg + ": ");
                intVal = Integer.parseInt(getInput.nextLine());
            } catch (NumberFormatException ex) {
                System.err.println(ERROR_MSG_INT);
                continue;
            }

            if (intVal < min || intVal > max) {
                System.err.format("\nInvalid input. Your input should be in valid range from %d to %d. Please try again!\n\n", min, max);
            } else {
                break;
            }
        }

        return intVal;
    }

    public static double Double(String prefixMsg) {
        double intVal = 0;

        Scanner getInput = new Scanner(System.in);

        while (true) {
            try {
                System.out.print(prefixMsg + ": ");
                intVal = Double.parseDouble(getInput.nextLine());
            } catch (NumberFormatException ex) {
                System.err.println(ERROR_MSG_DOUBLE);
                continue;
            }
            break;
        }

        return intVal;
    }

    public static double Double(String prefixMsg, double min, double max) {
        double doubleVal = 0;

        Scanner getInput = new Scanner(System.in);

        while (true) {
            try {
                System.out.print(prefixMsg + ": ");
                doubleVal = Double.parseDouble(getInput.nextLine());
            } catch (NumberFormatException ex) {
                System.err.println(ERROR_MSG_DOUBLE);
                continue;
            }

            if (doubleVal < min || doubleVal > max) {
                System.err.format("\nInvalid input. Your input should be in valid range from %.2f to %.2f Please try again!\n\n", min, max);
            } else {
                break;
            }
        }

        return doubleVal;
    }

    public static double Double(String prefixMsg, double min) {
        double doubleVal = 0;

        Scanner getInput = new Scanner(System.in);

        while (true) {
            try {
                System.out.print(prefixMsg + ": ");
                doubleVal = Double.parseDouble(getInput.nextLine());
            } catch (NumberFormatException ex) {
                System.err.println(ERROR_MSG_DOUBLE);
                continue;
            }

            if (doubleVal < min) {
                System.err.format("\nInvalid input. Your input should be larger than %.2f\n\n", min);
            } else {
                break;
            }
        }

        return doubleVal;
    }

    public static String String(String prefixMsg) {
        String stringValue;
        Scanner getInput = new Scanner(System.in);

        System.out.print(prefixMsg + ": ");
        stringValue = getInput.nextLine();

        return stringValue;
    }
}
