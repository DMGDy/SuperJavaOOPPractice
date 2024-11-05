/* Class intended to handle user interfacint (displaying menu/handling input)
 * calls its DatabaseController object on the appropiate user chosen option
 */
public class UserInterface {
  private final DatabaseController dbcontroller;

  UserInterface(DatabaseController dbc) {
    this.dbcontroller = dbc;
  }

  /* public method called by application class
     * handles input reading from console and determining what
     * method to call on Database Controller object
   */
  public void start() {
    while(true) {
      // first, show menu options on what user can do
      displayMenu();

      // read the selected option the user entered
      String option = InputReader.inputString("Enter option: ");

      // return code for Database controller method calls to display status
      int rc = 0;
      // switch/case on entered option 
      switch(option) {
        case "add":
          rc = dbcontroller.addItem();
          if (rc == 0) {
            System.out.println("User account successfully added!");
          } else {
            System.out.println("Database is at maximum capacity!");
          }
          break;
        // update should have its own scope to have a local 'email' String
        case "update": {
          String email = InputReader.inputString("Enter account email you wish to change: ");
          rc = dbcontroller.edit(email);
          switch(rc) {
            case(0):
              System.out.println("Password for account updated successfully!");
              break;
            case(-1):
              System.out.printf("Account with that email\"%s\" does not exist!\n",email);
              break;
            case(-2):
              System.out.println("Database currently contains no user accounts to update!");
          }
          break;
        }
        // delete has its own scope as well to avoid use of a local variable 
        case "delete": {
          String email = InputReader.inputString("Enter account email you wish to delete: ");
          rc = dbcontroller.edit(email);
          switch(rc) {
            case(0):
              System.out.printf("Account with email \"%s\" successfully deleted.\n",email);
              break;
            case(-1):
              System.out.printf("Account with that email\"%s\" does not exist!\n",email);
              break;
            case(-2):
              System.out.println("Database currently contains no user accounts to delete!");
          }
          break;
        }
        case "show-account": {
          String email = InputReader.inputString("Enter account email you wish to see display: ");
          rc = dbcontroller.edit(email);
          switch(rc) {
            case(0):
              break;
            case(-1):
              System.out.printf("Account with that email\"%s\" does not exist!\n",email);
              break;
            case(-2):
              System.out.println("Database currently contains no user accounts to show!");
          }
          break;
        }
        case "show-all":
          rc = dbcontroller.showAll();
          if(rc==-1) {
            System.out.println("Databse currently contains no user accounts to show!");
          }
          break;
        case "quit":
          InputReader.endReader();
          return;
        //otherwise option provided by user is undefined, let user know and retry input
        default:
          System.out.printf("Unknown option \"%s\" provided. Please enter a valid menu option.",option);
          break;
      }

    }

  }

  /* method to show all user options and what they do, 
   *  - called by public start() method
   */
  private void displayMenu() {
      System.out.println("=====User Account Database Program=====");
      System.out.println("Options:");
      System.out.println("\tadd: Adds a new user account to database");
      System.out.println("\tupdate: Updates an existing user's account password with the provided email");
      System.out.println("\tdelete: Deletes an user account with the given email");
      System.out.println("\tshow-account: Displays the account with the given email");
      System.out.println("\tshow-all: Choose how accounts will be sorted when displayed, then display all accounts inside database");
      System.out.println("\tquit: Quit the program");
  }

}
