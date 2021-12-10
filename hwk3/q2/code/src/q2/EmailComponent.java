package q2;

import java.util.Iterator;

/***
 * Abstract class for composite pattern
 */
public abstract class EmailComponent {
    private String owner;
    private String address;

    /***
     * Two parameter constructor
     * @param owner owner of email
     * @param address email address
     */
    public EmailComponent(String owner, String address) {
        this.owner = owner;
        this.address = address;
    }

    /***
     * add element to the composite tree.
     * @param emailComponent element to be add
     */
    public void add(EmailComponent emailComponent) {
        throw new UnsupportedOperationException();
    }

    /***
     * remove element to the composite tree.
     * @param emailComponent element to be remove
     */
    public void remove(EmailComponent emailComponent) {
        throw new UnsupportedOperationException();
    }
    /***
     * get element
     * @param i index
     * @return element at index i
     */
    public EmailComponent getChild(int i) {
        throw new UnsupportedOperationException();
    }

    /***
     * returns owner of email
     * @return owner of email
     */
    public String getOwner() {
        return owner;
    }

    /***
     * return email address of email
     * @return email address of email
     */
    public String getAddress() {
        return address;
    }

    /***
     * print email info
     */
    public void print() {
        throw new UnsupportedOperationException();
    }

    /***
     * return an iterator to iterate trough structure.
     * @return an iterator to iterate trough structure.
     */
    public Iterator createIterator() {
        throw new UnsupportedOperationException();
    }
}
