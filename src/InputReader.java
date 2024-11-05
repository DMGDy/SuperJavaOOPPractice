import java.util.Scanner;

// Class to manage lifetime of static Scanner object for reading stdin/console 
public class InputReader {
  
  private static final Scanner scanner = new Scanner(System.in);

  static boolean readYesNo() {
    return scanner.nextLine().toLowerCase().charAt(0) == 'y';
  }

  static String inputString() {
    return scanner.nextLine();
  }
  
  //overloaded method to optionally display message
  static String inputString(String message) {
    System.out.printf("%s",message);
    return scanner.nextLine();
  }


  // close scanner, no longer needed
  static void endReader() {
    scanner.close();
  }

}
