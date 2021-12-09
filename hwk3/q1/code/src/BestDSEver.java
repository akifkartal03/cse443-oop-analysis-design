import java.util.ArrayList;

/***
 * Simple representation of the obscure data structure: BestDSEver
 */
public class BestDSEver {
    private ArrayList<Object> arrayList;

    public BestDSEver() {
        arrayList = new ArrayList<>();
    }

    /***
     * insert an element
     * @param o element to be inserted
     */
    void insert(Object o) {
        arrayList.add(o);
    }

    /***
     * remove an element
     * @param o element to be removed
     */
    void remove(Object o) {
        arrayList.remove(o);
    }

    /***
     * get an element
     * @param index index of element
     * @return element if present
     */
    Object get(int index) {
        return arrayList.get(index);
    }
}
