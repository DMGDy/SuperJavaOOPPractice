public class UserInterface {
  private final DatabaseController dbcontroller;

  UserInterface(DatabaseController dbc) {
    this.dbcontroller = dbc;
  }

  public void start() {
    while(true) {
      displayMenu();
      String option = InputReader.inputString("Enter option: ");

      int rc = 0;
      switch(option) {
        case "add":
          rc = dbcontroller.addItem();
          if (rc == 0) {
            System.out.println("User account successfully added!");
          } else {
            System.out.println("Database is at maximum capacity!");
          }
          break;
        case "edit":
          String email = InputReader.inputString("Enter account email you wish to change: ");
          rc = dbcontroller.edit(email);
          if (rc == 0) {
            System.out.println("Provided email does not exist!");
          }
          break;
        case "delete":
          break;
        case "sort":
          break;
        case "show-item":
          break;
        case "show-all":
          dbcontroller.showAll();
          break;
        case "quit":
          InputReader.endReader();
          return;
      }

    }

  }

  private void displayMenu() {
      System.out.println("=====User Account Database Program=====");
      System.out.println("Options:");
      System.out.println("\tadd: Adds a new user account to database");
      System.out.println("\tedit: Edits an existing user account with the given email");
      System.out.println("\tdelete: Deletes an user account with the given email");
      System.out.println("\tsort: Sorts the database");
      System.out.println("\tshow-user: Displays the account with the given email");
      System.out.println("\tshow-all: Displays all user accounts inside database");
      System.out.println("\tquit: Quit the program");
  }

}
