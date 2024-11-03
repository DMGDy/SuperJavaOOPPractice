import java.util.ArrayList;
import java.util.Iterator;


// implementing Database Interface with items of type User Account
public class UserAccountDatabase implements Database<UserAccount>{
  private ArrayList<UserAccount> db;
  private final int max_cap = 20;
  
  UserAccountDatabase() {
    this.db = new ArrayList<UserAccount>();
  }

  @Override
  public void add() {
    // valid_email boolean to check whether user input is a valid email
    UserAccount ua = new UserAccount();

      
    String email = InputReader.inputString("Enter user email address: ");

    // keep getting reading an email while they are not valid
    while(ua.setEmail(email) != 0 || containsItem(email)) {
      email = InputReader.inputString("Please enter a valid and unique email : "); 
    }

    ua.setFirstName(InputReader.inputString("Enter first name:"));
    ua.setLastName(InputReader.inputString("Enter last name:"));
    ua.setPassword(InputReader.inputString("Enter a password:"));

    this.db.add(ua);
  }

  @Override
  public void edit(String email) {
    Iterator<UserAccount> it = this.db.iterator();
    for(Iterator<UserAccount> account = this.db.iterator(); account.hasNext();) {

    }
  }

  @Override
  public void showItem(String email) {
    //TODO
  }

  @Override
  public boolean isEmpty() {
    return (this.db.size() == 0);
  }

  @Override
  public boolean isFull() {
    return (this.db.size() == 20);
  }

  @Override
  public void sortAscending() {
    // TODO: sort db by ascending alphabet
  }

  @Override
  public void sortDescending() {
    // TODO: sort db by descending alphabet
  }

  /* Check if database has the provided email
   */
  @Override
  public boolean containsItem(String email) {
    boolean exists = false;
    for(UserAccount account: this.db) {
      if(account.getEmail().equals(email)) {
        exists = true;
      }
    }

    return exists;
  }

  @Override
  public void showAll() {
    System.out.println("\t\tShowing Database");
    System.out.println("================================");
    for(UserAccount ua: this.db) {
      ua.displayUserAccount();
    System.out.println("================================");
    }
  }
  
  
}
