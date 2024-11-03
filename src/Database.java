/* Database interface
 * - defines key methods to implement for a database
 */
public interface Database<T> {
  public void add();
  public void edit(String identifier);
  public void showItem(String identifier);
  public void showAll();
  public void sortAscending();
  public void sortDescending();
  public boolean isEmpty();
  public boolean isFull();
  public boolean containsItem(String identifier);
}
