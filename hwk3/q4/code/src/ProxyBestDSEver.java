import java.util.concurrent.locks.ReentrantLock;

/***
 * This is a proxy(vekil) of BestDSEver class in order to
 * control access to it and make it thread-safe.
 */
public class ProxyBestDSEver implements ThreadSafe{
    private BestDSEver service;
    private ReentrantLock mutex;

    public ProxyBestDSEver() {
        service = new BestDSEver();
        mutex = new ReentrantLock();
    }

    /***
     * insert an element as thread safe.
     * @param o element to be inserted
     */
    @Override
    public void insert(Object o) {
        mutex.lock(); //lock(m)
        try {
            service.insert(o);
        } finally {
            mutex.unlock(); //unlock(m)
        }
    }
    /***
     * remove an element as thread safe
     * @param o element to be removed
     */
    @Override
    public void remove(Object o) {
        mutex.lock(); //lock(m)
        try {
            service.remove(o);
        } finally {
            mutex.unlock(); //unlock(m)
        }
    }
    /***
     * get an element as thread safe
     * @param index index of element
     * @return element if present
     */
    @Override
    public Object get(int index) {
        mutex.lock(); //lock(m)
        try {
            return service.get(index);
        } finally {
            mutex.unlock(); //unlock(m)
        }
    }
}
