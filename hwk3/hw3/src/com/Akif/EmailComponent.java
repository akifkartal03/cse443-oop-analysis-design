package com.Akif;

import java.util.Iterator;

public abstract class EmailComponent {
    private String owner;
    private String address;

    public EmailComponent(String owner, String address) {
        this.owner = owner;
        this.address = address;
    }

    public void add(EmailComponent emailComponent) {
        throw new UnsupportedOperationException();
    }
    public void remove(EmailComponent emailComponent) {
        throw new UnsupportedOperationException();
    }
    public EmailComponent getChild(int i) {
        throw new UnsupportedOperationException();
    }
    public String getOwner() {
        return owner;
    }
    public String getAddress() {
        return address;
    }
    public void print() {
        throw new UnsupportedOperationException();
    }
    public Iterator createIterator() {
        throw new UnsupportedOperationException();
    }
}
