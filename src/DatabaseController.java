public class DatabaseController {
  private final Database db;

  public DatabaseController(Database db) {
    this.db = db;
  }

  public int addItem() {
    if(!db.isFull()) {
      db.add();
      return 0;
    } else { return -1; }
  }

  public void showAll() {
    db.showAll();
  }

  public int edit(String identifier) {
    if(db.containsItem(identifier)) { return -1; }
    else { 
      db.edit(identifier);
      return 0;
    }
  }



}
