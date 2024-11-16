import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


// implementing Database Interface with items of type User Account
public class UserAccountDatabase implements Database<UserAccount,String>{
  private HashMap<String,UserAccount> db;
  private final int MAX_CAP = 20;
  
  UserAccountDatabase() {
    db = new HashMap<String,UserAccount>();
  }

  @Override
  public void add() {
    // valid_email boolean to check whether user input is a valid email
    UserAccount ua = new UserAccount();

      
    String email = InputReader.inputString("Enter user email address: ");

    // keep getting reading an email while they are not valid
    while(ua.setEmail(email) != 0 || containsItem(email)) {
      email = InputReader.inputString("Please enter a valid and unique email: "); 
    }

    String first_name = InputReader.inputString("Enter first name: ");
    while(first_name.isBlank()) {
      first_name = InputReader.inputString("First name cannot be empty. Please enter a first name: ");
    }
    ua.setFirstName(first_name);

    String last_name = InputReader.inputString("Enter last name: ");
    while(last_name.isBlank()) {
      last_name = InputReader.inputString("Last name cannot be empty. Please enter a last name: ");
    }
    ua.setLastName(last_name);

    // password can optionally be blank or space characters
    ua.setPassword(InputReader.inputString("Enter a password:"));

    db.put(email,ua);
  }


  @Override
  public int updateItem(String email) {
    UserAccount account = db.get(email);
    account.setPassword(InputReader.inputString("Enter a new password for the account: "));
    return 0;
  }


  @Override
  public void showItem(String email) {
    db.get(email).displayUserAccount();
  }

  @Override
  public void removeItem(String email) {
    db.remove(email);
  }

  @Override
  public boolean isEmpty() {
    return (db.isEmpty());
  }

  @Override
  public boolean isFull() {
    return (db.size() == MAX_CAP);
  }

  // First, get all accounts into an array list
  // determine which field to sort by, create lambda function for sorting by that field
  @Override
  public void sortAscending(String field) {
    ArrayList<UserAccount> all_accounts = new ArrayList<>(db.values());
    switch(field){
      case "email": {
        all_accounts.sort((a,b)->{
          return Character.compare(a.getEmail().charAt(0),b.getEmail().charAt(0));
        });
        break;
      }
      case "first name": {
        all_accounts.sort((a,b)->{
          return Character.compare(a.getFirstName().charAt(0),b.getFirstName().charAt(0));
        });
        break;
      }
      case "last name": {
        all_accounts.sort((a,b)->{
          return Character.compare(a.getLastName().charAt(0),b.getLastName().charAt(0));
        });
        break;
      }
    }
    System.out.println("Showing sorted database:");
    for(UserAccount account: all_accounts) {
      account.displayUserAccount();
    }

  }

  /* Similar to sortAscending, mulitply the result of the compare
   * by -1 to sort in the oposite order
   *
   */
  @Override
  public void sortDescending(String field) {
    ArrayList<UserAccount> all_accounts = new ArrayList<>(db.values());
    switch(field){
      case "email": {
        all_accounts.sort((a,b)->{
          return -1 * Character.compare(a.getEmail().charAt(0),b.getEmail().charAt(0));
        });
        System.out.println("Showing sorted database:");
        for(UserAccount account: all_accounts) {
          account.displayUserAccount();
        }
        break;
      }
      case "first name": {
        all_accounts.sort((a,b)->{
          return -1 * Character.compare(a.getFirstName().charAt(0),b.getFirstName().charAt(0));
        });
        System.out.println("Showing sorted database:");
        for(UserAccount account: all_accounts) {
          account.displayUserAccount();
        }
        break;
      }
      case "last name": {
        all_accounts.sort((a,b)->{
          return -1*  Character.compare(a.getLastName().charAt(0),b.getLastName().charAt(0));
        });
        System.out.println("Showing sorted database:");
        for(UserAccount account: all_accounts) {
          account.displayUserAccount();
        }
        break;
      }
    }

    //sort the array by alphabetical order
    // use lambda function inside sort to 
    // TODO: sort db by ascending alphabet
  }
  /* Check if database has the provided email
   */
  @Override
  public boolean containsItem(String email) {
    return db.containsKey(email);
  }

  @Override
  public void showAll() {
    System.out.println("\t\tShowing Database");
    System.out.println("================================");
    for(Map.Entry<String,UserAccount> account: db.entrySet()) {
      account.getValue().displayUserAccount();
    System.out.println("================================");
    }
  }
  
  
}
