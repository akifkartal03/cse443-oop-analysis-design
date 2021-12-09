import java.util.concurrent.locks.ReentrantLock;

/***
 * Rendered version of BestDSEver class to make thread-safe method call.
 */
public class BestDSEverAdapter extends BestDSEver {
    private ReentrantLock mutex;

    public BestDSEverAdapter() {
        super(); // create arraylist
        mutex = new ReentrantLock();
    }
    /***
     * insert an element thread-safe
     * @param o element to be inserted
     */
    @Override
    public void insert(Object o) {
        mutex.lock(); //lock(m)
        try {
            super.insert(o);
        } finally {
            mutex.unlock(); //unlock(m)
        }
    }
    /***
     * remove an element thread-safe
     * @param o element to be removed
     */
    @Override
    public void remove(Object o) {
        mutex.lock(); //lock(m)
        try {
            super.remove(o);
        } finally {
            mutex.unlock(); //unlock(m)
        }
    }
    /***
     * get an element thread-safe
     * @param index index of element
     * @return element if present
     */
    @Override
    public Object get(int index) {
        mutex.lock(); //lock(m)
        try {
            return super.get(index);
        } finally {
            mutex.unlock(); //unlock(m)
        }
    }
}
