package com.Akif;

import java.util.ArrayList;
import java.util.Iterator;

public class CompositeEmail extends EmailComponent{
    ArrayList<EmailComponent> emailComponents = new ArrayList<>();
    public CompositeEmail(String owner, String address) {
        super(owner, address);
    }

    @Override
    public void add(EmailComponent emailComponent) {
        emailComponents.add(emailComponent);
    }

    @Override
    public void remove(EmailComponent emailComponent) {
        emailComponents.remove(emailComponent);
    }

    @Override
    public EmailComponent getChild(int i) {
        return emailComponents.get(i);
    }

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

    @Override
    public Iterator createIterator() {
        return new CompositeIterator(emailComponents.iterator());
    }
}
