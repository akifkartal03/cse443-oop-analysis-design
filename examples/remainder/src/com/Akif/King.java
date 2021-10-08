package com.Akif;

public class King extends Character implements Runnable{

    @Override
    public void fight() {
        run();
    }

    @Override
    public void run() {
        try {
            weapon.useWeapon();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {

        }
    }
}
