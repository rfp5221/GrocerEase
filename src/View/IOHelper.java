package View;

import Model.Console;
import Model.ValidationHelper;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class IOHelper {
  private static final Scanner keyboard = Console.keyboard;

  public static String readStringFromKeyboard(String prompt) {
    System.out.print(prompt + ": ");

    return keyboard.nextLine();
  }

  public static String readNonBlankStringFromKeyboard(String prompt) {
    String nonblankString;

    while (true) {
      nonblankString = readStringFromKeyboard(prompt);
      if (nonblankString.trim().isEmpty()) {
        System.out.println();
        System.out.println("Cannot be blank");
      } else {
        break;
      }
    }

    return nonblankString;
  }

  public static String strUserInputYorN(String prompt) {
    String userInput;
    while (!ValidationHelper.isValidYorN(userInput = readNonBlankStringFromKeyboard(prompt.trim() + " (Y|N)"))) {
      System.out.println("Invalid input");
    }
    return userInput;
  }

  public static boolean boolUserInputYorN(String prompt) {
    String userInput = strUserInputYorN(prompt.trim() + " ");
    return "y".equals(userInput.toLowerCase());
  }


  public static double userInputDouble(String prompt) {
    Double parsedToDouble = null;

    while (parsedToDouble == null) {
      String userInput = readStringFromKeyboard(prompt);
      parsedToDouble = ValidationHelper.tryParseDouble(userInput);
    }

    return parsedToDouble;
  }

  public static String readValidInputFromList(String prompt, String[] validValues, boolean caseInsensitive) {
    return readValidInputFromList(prompt, Arrays.asList(validValues), caseInsensitive);
  }

  public static String readValidInputFromList(String prompt, List<String> validValues, boolean caseInsensitive) {
    String userInput;

    // List the valid values in parens, to the right of the prompt
    String actualPrompt = String.format("%s (%s): ", prompt, String.join("/", validValues));

    // If the detailed prompt is too long, switch to just the regular prompt
    if (actualPrompt.length() > 79) {
      actualPrompt = prompt + ": ";
    }

    while (true) {
      System.out.print(actualPrompt);

      userInput = keyboard.nextLine();
      if (caseInsensitive) {
        userInput = userInput.toLowerCase();
      }
      for (String validValue : validValues) {
        String checkValue;
        if (caseInsensitive) {
          checkValue = validValue.toLowerCase();
        } else {
          checkValue = validValue;
        }
        if (userInput.equals(checkValue)) {
          return userInput;
        }
      }
      System.out.println("Enter a valid value!\n");
    }
  }


  public static String readYN(String prompt) {
    return IOHelper.readValidInputFromList(prompt, new String[]{"Y", "N"}, true);
  }

  public static boolean readYNBool(String prompt) {
    String userInput = IOHelper.readYN(prompt);
    if (userInput == null) {
      return false;
    }
    return (userInput.toLowerCase().equalsIgnoreCase("y"));
  }


  public static int userInputInt(String prompt) {
    Integer parsedToInt = null;

    while (parsedToInt == null) {
      String userInput = readStringFromKeyboard(prompt);
      parsedToInt = ValidationHelper.tryParseInt(userInput);
    }

    return parsedToInt;
  }

  /**
   * Prompt for user input, and validate in range
   * <p>
   * Repeatedly prompt the user for a character.<p>
   * Ensure that the character is within a range of characters
   * <p>(which is packed into a string)
   *
   * @param prompt Prompt, so the user knows what to type in
   * @param range  Valid characters allowed (e.g., "aeiou")
   * @return In-range character chosen by the user
   */
  public static char userInputChar(String prompt, String range) {

    char userChar = 0;
    while (!ValidationHelper.isCharInRange(userChar, range)) {
      String userInput = readStringFromKeyboard(prompt + " (" + range + ")");
      if (userInput.length() > 0) {
        userChar = userInput.charAt(0);
      }
    }

    return userChar;
  }

  public static String currency(double d) {
    return String.format("$%.2f", d);
  }

}


