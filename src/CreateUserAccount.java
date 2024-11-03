public class CreateUserAccount {
  public static void main(String[] args) {
    UserAccountDatabase uadb = new UserAccountDatabase();
    DatabaseController dbc = new DatabaseController(uadb);

    UserInterface ui = new UserInterface(dbc);
    ui.start();

  }
}
