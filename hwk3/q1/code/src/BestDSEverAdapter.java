import java.util.concurrent.locks.ReentrantLock;

public class BestDSEverAdapter extends BestDSEver {
    private ReentrantLock mutex;

    public BestDSEverAdapter() {
        super();
        mutex = new ReentrantLock();
    }

    @Override
    void insert(Object o) {
        mutex.lock(); //lock(m)
        try {
            super.insert(o);
        } finally {
            mutex.unlock(); //unlock(m)
        }
    }

    @Override
    void remove(Object o) {
        mutex.lock(); //lock(m)
        try {
            super.remove(o);
        } finally {
            mutex.unlock(); //unlock(m)
        }
    }

    @Override
    Object get(int index) {
        mutex.lock(); //lock(m)
        try {
            return super.get(index);
        } finally {
            mutex.unlock(); //unlock(m)
        }
    }
}
