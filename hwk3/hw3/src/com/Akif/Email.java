package com.Akif;

import java.util.Iterator;

public class Email extends EmailComponent{

    public Email(String owner, String address) {
        super(owner, address);
    }

    @Override
    public void print() {
        System.out.println(getAddress() + " " + getOwner());
    }

    @Override
    public Iterator createIterator() {
        return new NullIterator();
    }
}
