import java.util.ArrayList;

public class UserAccount {
  private String first_name;
  private String last_name;
  private String email;
  private String password;

  private static ArrayList<String> known_emails = new ArrayList<String>();

  

  public void setFirstName(String name) {
    this.first_name = name;
  }

  public void setLastName(String name) {
    this.last_name = name;
  }

  public String getLastName() {
    return this.last_name;
  }

  public String getFirstName() {
    return this.first_name;
  }


  public int setEmail(String email) {

    // check if email is valid or not
    if(!validEmail(email)) {
      System.out.println("Please provide a propper email");
      return -1;
    }

    this.email = email;
    return 0;
  }
  
  /* private function to check if a given email is valid
  * split returns an array with the substrings as elements,
  * if more than 2 elements, means string was split more than once
  * therefore had more than 1 '@'
  * du@poop@gmail.com@
  * {"poop","gmail.com"}
  * additionally if emails do not start or end with '@'
  */ 
  private boolean validEmail(String email) {
    return !((email.split("@").length != 2) ||
       (email.charAt(email.length() - 1) == '@') ||
       (email.charAt(0) == '@'));
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getEmail() {
    return this.email;
  }

  public void displayUserAccount() {
    System.out.printf("Email: %s\n",this.email);
    System.out.printf("Name : %s %s\n",this.first_name, this.last_name);
    System.out.printf("Password: %s\n",this.password);
  }
  
}
