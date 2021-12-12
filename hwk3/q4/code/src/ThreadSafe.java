/***
 * Simple interface for proxy class.
 */
public interface ThreadSafe {
    public void insert(Object o);
    public void remove(Object o);
    public Object get(int index);
}
