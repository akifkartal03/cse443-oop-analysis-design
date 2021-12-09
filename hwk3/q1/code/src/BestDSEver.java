import java.util.ArrayList;

public class BestDSEver {
    private ArrayList<Object> arrayList;

    public BestDSEver() {
        arrayList = new ArrayList<>();
    }

    void insert(Object o) {
        arrayList.add(o);
    }

    void remove(Object o) {
        arrayList.remove(o);
    }

    Object get(int index) {
        return arrayList.get(index);
    }
}
