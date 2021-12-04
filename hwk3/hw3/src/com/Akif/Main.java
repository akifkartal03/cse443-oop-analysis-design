package com.Akif;

public class Main {

    public static void main(String[] args) {
        EmailComponent group1 = new CompositeEmail("GTU Ceng", "allcengstudents@gtu.edu.tr");
        EmailComponent group2 = new CompositeEmail("GTU Eeng", "alleengstudents@gtu.edu.tr");
        EmailComponent group3 = new CompositeEmail("GTU Meng", "allmengstudents@gtu.edu.tr");
        //all emails
        EmailComponent allEmails = new CompositeEmail("GTU All mails", "allmails@gtu.edu.tr");

        allEmails.add(group1);
        allEmails.add(group2);
        allEmails.add(group3);

        group1.add(new Email("Akif Kartal","akif.kartal2017@gtu.edu.tr"));
        group1.add(new Email("Djuro RADUSINOVIC","djuro2017@gtu.edu.tr"));
        group1.add(new Email("Mustafa TOKGÖZ","mustafa.tokgoz2017@gtu.edu.tr"));
        group1.add(new Email("Muhammed Emin KARAKAYA","m.karakaya2018@gtu.edu.tr"));
        group1.add(new Email("Mehdi KURTCEBE","m.kurtcebe2018@gtu.edu.tr"));

        group2.add(new Email("Fatih Uyuyan Berber","cse344_forever@gtu.edu.tr"));
        group2.add(new Email("Uğur Şahin","biontech2017@gtu.edu.tr"));
        group2.add(new Email("Mustafa Producer","mustafa.prod2017@gtu.edu.tr"));
        group2.add(new Email("Emin Consumer","emin_cons2018@gtu.edu.tr"));
        group2.add(new Email("Kenan Kurt","yusuf2018@gtu.edu.tr"));

        group3.add(new Email("Salih Reader","database@gtu.edu.tr"));
        group3.add(new Email("Ahmet Writer","priority@gtu.edu.tr"));
        group3.add(new Email("Mehmet Cigarette","give@gtu.edu.tr"));
        group3.add(new Email("Ozan Smoker","leave@gtu.edu.tr"));
        group3.add(new Email("Sinan Philosopher","dining@gtu.edu.tr"));

    }
}
