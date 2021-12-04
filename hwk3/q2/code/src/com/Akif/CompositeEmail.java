package com.Akif;

import java.util.ArrayList;
import java.util.Iterator;

/***
 * This is a composite class
 * with add, remove and get methods.
 */
public class CompositeEmail extends EmailComponent{
    ArrayList<EmailComponent> emailComponents = new ArrayList<>();
    public CompositeEmail(String owner, String address) {
        super(owner, address);
    }

    /***
     * add new element to the group
     * @param emailComponent element to be add
     */
    @Override
    public void add(EmailComponent emailComponent) {
        emailComponents.add(emailComponent);
    }

    /***
     * remove element from group
     * @param emailComponent element to be remove
     */
    @Override
    public void remove(EmailComponent emailComponent) {
        emailComponents.remove(emailComponent);
    }

    /***
     * get element
     * @param i index
     * @return element at index i
     */
    @Override
    public EmailComponent getChild(int i) {
        return emailComponents.get(i);
    }

    /***
     * print whole elements(emails)
     */
    @Override
    public void print() {
        System.out.println("------------------------------------------------");
        System.out.println("Owner: "+getOwner());
        System.out.println("------------------------------------------------");
        Iterator iterator = emailComponents.iterator();
        while (iterator.hasNext()) {
            EmailComponent emailComponent = (EmailComponent) iterator.next();
            emailComponent.print();
        }
        System.out.println("------------------------------------------------");
    }

    /***
     * create a composite iterator to traverse composite tree.
     * @return
     */
    @Override
    public Iterator createIterator() {
        return new CompositeIterator(emailComponents.iterator());
    }
}
