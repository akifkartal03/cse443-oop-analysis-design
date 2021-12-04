package com.Akif;

import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        EmailComponent group1 = new CompositeEmail("GTU Ceng All", "allcengstudents@gtu.edu.tr");
        EmailComponent group2 = new CompositeEmail("GTU Meng All", "allmengstudents@gtu.edu.tr");
        EmailComponent group3 = new CompositeEmail("GTU CSE344", "all344students@gtu.edu.tr");
        //all emails
        EmailComponent allEmails = new CompositeEmail("GTU All mails", "allmails@gtu.edu.tr");



        group1.add(new Email("Akif Kartal","akif.kartal2017@gtu.edu.tr"));
        group1.add(new Email("Djuro RADUSINOVIC","djuro2017@gtu.edu.tr"));
        group1.add(new Email("Mustafa TOKGÖZ","mustafa.tokgoz2017@gtu.edu.tr"));
        group1.add(new Email("Muhammed Emin KARAKAYA","m.karakaya2018@gtu.edu.tr"));
        group1.add(new Email("Mehdi KURTCEBE","m.kurtcebe2018@gtu.edu.tr"));
        group1.add(new Email("Sinan SARI","sinan.sari2016@gtu.edu.tr"));
        group1.add(new Email("Alp Eser","hboubati@gtu.edu.tr"));


        group2.add(new Email("Uğur Şahin","biontech2017@gtu.edu.tr"));
        group2.add(new Email("Mustafa Dinçer","mustafa.prod2017@gtu.edu.tr"));
        group2.add(new Email("Selin Akın","selin_cons2018@gtu.edu.tr"));
        group2.add(new Email("Kenan Kurt","yusuf2018@gtu.edu.tr"));

        group3.add(new Email("Salih Reader","database@gtu.edu.tr"));
        group3.add(new Email("Ahmet Writer","priority@gtu.edu.tr"));
        group3.add(new Email("Mehmet Cigarette","give@gtu.edu.tr"));
        group3.add(new Email("Ozan Smoker","leave@gtu.edu.tr"));
        group3.add(new Email("Sinan Philosopher","dining@gtu.edu.tr"));
        group3.add(new Email("Fatih Uyuyan Berber","cse344_forever@gtu.edu.tr"));

        group1.add(group3);
        allEmails.add(group1);
        allEmails.add(group2);
        allEmails.add(new Email("Sinem Yılmaz","sinem2013@gtu.edu.tr"));
        allEmails.print();
        //printAll(allEmails);

    }
    public static void printAll(EmailComponent allEmails) {
        Iterator<EmailComponent> iterator = allEmails.createIterator();
        System.out.println("------------ALL MENUs--------------");
        while (iterator.hasNext()) {
            EmailComponent mailComponent = iterator.next();
            try {
                mailComponent.print();
            } catch (UnsupportedOperationException ignored) {}
        }
    }
}
