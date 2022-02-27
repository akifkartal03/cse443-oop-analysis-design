package q2;

import java.util.Iterator;

/***
 * Leaf Email class.
 * Owner and address info comes from super class
 */
public class Email extends EmailComponent{
    /***
     * Two parameter constructor user super class constructor
     * @param owner owner of email
     * @param address email address
     */
    public Email(String owner, String address) {
        super(owner, address);
    }

    /***
     * print owner and address with demanded shape
     */
    @Override
    public void print() {
        System.out.println(getAddress() + " " + getOwner());
    }

    /***
     * null iterator
     * @return null iterator
     */
    @Override
    public Iterator createIterator() {
        return new NullIterator();
    }
}
