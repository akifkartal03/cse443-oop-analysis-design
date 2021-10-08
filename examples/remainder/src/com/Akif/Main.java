package com.Akif;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

    public static void main(String[] args) {
	    /*King player1 = new King();
        player1.setWeapon(new Knife());
        Queen player2 = new Queen();
        player2.setWeapon(new BowAndArrow());
        Troll player3 = new Troll();
        player3.setWeapon(new Axe());
        player1.fight();
        player2.fight();
        player3.fight();
        Integer a = 5;
        a++;
        System.out.println(a);*/
        ReentrantLock mutex = new ReentrantLock();
        Condition empty= mutex.newCondition();
        Condition full = mutex.newCondition();
        int capacity = 10;
        AtomicInteger buffer = new AtomicInteger(capacity);
        AtomicInteger power = new AtomicInteger(100);
        ThreadData commonData = new ThreadData(buffer,mutex,full,empty,capacity,power);
        Thread producerOttomanWoman = new Thread(new OttomanWoman(commonData));
        producerOttomanWoman.setName("Ottoman Woman Fatma");
        King player1 = new King();
        player1.setWeapon(new BowAndArrow(commonData));
        Thread consumerKing = new Thread(player1);
        consumerKing.setName("King");
        Queen player2 = new Queen();
        player2.setWeapon(new BowAndArrow(commonData));
        Thread consumerQueen = new Thread(player2);
        consumerQueen.setName("Queen");



        producerOttomanWoman.start();
        consumerKing.start();
        consumerQueen.start();

    }
}
