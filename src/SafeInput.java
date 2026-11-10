import java.util.Scanner;

public class SafeInput {
    /**
     * @param pipe   a Scanner opened to read from System.in
     * @param prompt prompt for the user
     * @return a String response that is not zero length
     */
    public static String getNonZeroLenString(Scanner pipe, String prompt) {
        String retString = ""; // Set this to zero length. Loop runs until it isn't
        do {
            System.out.print("\n" + prompt + ": "); // show prompt add space
            retString = pipe.nextLine();
            if (retString.length() == 0)
            {
                System.out.println("\nYou must enter some characters!");
            }
        }
        while (retString.length() == 0);
        return retString;
    }

    /**
     * Get an int value with no constraints
     *
     * @param pipe   - Scanner instance to read the data System.in in most cases
     * @param prompt - input prompt msg should not include range info
     * @return - unconstrained int value
     */
    public static int getInt(Scanner pipe, String prompt) {
        int retVal = 0;
        String trash = "";
        boolean done = false;
        do {
            System.out.print("\n" + prompt + ":");
            if (pipe.hasNextInt()) {
                retVal = pipe.nextInt();
                pipe.nextLine();
                done = true;
            } else {
                trash = pipe.nextLine();
                System.out.println("You must enter an integer " + trash);
            }
        } while (!done);
        return retVal;
    }

    /**
     * Get a double value with no constraints
     *
     * @param pipe   - Scanner instance to read the data System.in in most cases
     * @param prompt - input prompt msg should not include range info
     * @return - unconstrained double value
     */
    public static double getDouble(Scanner pipe, String prompt) {
        double retVal = 0.0;
        String trash = "";
        boolean done = false;
        do {
            System.out.print("\n" + prompt + ":");
            if (pipe.hasNextDouble()) {
                retVal = pipe.nextDouble();
                pipe.nextLine();
                done = true;
            } else {
                trash = pipe.nextLine();
                System.out.println("You must enter a double " + trash);
            }
        } while (!done);
        return retVal;
    }

    /**
     * Get an integer value from the user within a specified inclusive low-high range
     *
     * @param pipe   - Scanner to use for input
     * @param prompt - User prompt
     * @param low    - low value for the range
     * @param high   - high value for the range
     * @return an int value provided by the user within the specified range
     */
    public static int getRangedInt(Scanner pipe, String prompt, int low, int high) {
        int retVal = 0;
        String trash = "";
        boolean done = false;

        do {
            System.out.print("\n" + prompt + "[" + low + " - " + high + "]: ");
            if (pipe.hasNextInt()) {
                retVal = pipe.nextInt();
                pipe.nextLine();
                if (retVal >= low && retVal <= high) {
                    done = true;
                } else {
                    System.out.println("\nNumber is out of range [" + low + " - " + high + "] not: " + retVal);
                }
            } else {
                {
                    trash = pipe.nextLine();
                    System.out.println("You must enter a valid number " + trash);
                }
            }
        }
        while (!done);
        return retVal;
    }

    /**
     * Get a double value from the user within a specified inclusive low-high range
     *
     * @param pipe   - Scanner to use for input
     * @param prompt - User prompt
     * @param low    - low value for the range
     * @param high   - high value for the range
     * @return a double value provided by the user within the specified range
     */
    public static double getRangedDouble(Scanner pipe, String prompt, double low, double high) {
        double retVal = 0.0;
        String trash = "";
        boolean done = false;

        do {
            System.out.print("\n" + prompt + "[" + low + " - " + high + "] : ");
            if (pipe.hasNextDouble()) {
                retVal = pipe.nextDouble();
                pipe.nextLine();
                if (retVal >= low && retVal <= high) {
                    done = true;
                } else {
                    System.out.println("\nNumber is out of range [" + low + " - " + high + "] : " + retVal);
                }
            } else {
                trash = pipe.nextLine();
                System.out.println("You must enter a valid number");
            }
        }
        while (!done);
        return retVal;
    }

    /**
     * Get a Yes or No confirmation from the user
     *
     * @param pipe   - Scanner to use for input
     * @param prompt - prompt the user for a yes or no response
     * @return - true if the user enters y or Y, false if the user enters n or N
     */
    public static boolean getYNConfirm(Scanner pipe, String prompt) {
        String response = "";
        do {
            System.out.print("\n" + prompt + "(Y/N): ");
            response = pipe.nextLine();
            if (!response.equalsIgnoreCase("Y") && !response.equalsIgnoreCase("N")) {
                System.out.println("You must enter either Y or N!");
            }
        }
        while (!response.equalsIgnoreCase("Y") && !response.equalsIgnoreCase("N"));
        return response.equalsIgnoreCase("Y");
    }

/**
 * Get a string that matches a RegEx pattern! This is a very powerful method
 * @param pipe - Scanner instance to read the data System.in in most cases
 * @param prompt - prompt for user
 * @param regExPattern - java style RegEx pattern to constrain the input
 * @return - a String that matches the RegEx pattern supplied
 */
public static String getRegExString (Scanner pipe, String prompt, String regExPattern)
{
    String response = "";
    boolean gotAval = false;
    do
    {
        System.out.print("\n" + prompt + ":");
        response = pipe.nextLine().trim();
        if (response.matches(regExPattern))
        {
            gotAval = true;
        } else
        {
            System.out.println("\n" + response + " must match the pattern " + regExPattern);
            System.out.println("Try again!");
        }
    } while (!gotAval);
      return response;
}
}
