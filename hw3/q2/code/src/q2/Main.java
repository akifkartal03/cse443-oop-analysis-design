package q2;

import java.util.Iterator;

/***
 * Test drive class
 */
public class Main {

    /***
     * main method of program
     * @param args params
     */
    public static void main(String[] args) {
        //group emails
        EmailComponent group1 = new CompositeEmail("GTU Ceng All", "allcengstudents@gtu.edu.tr");
        EmailComponent group2 = new CompositeEmail("GTU Meng All", "allmengstudents@gtu.edu.tr");
        EmailComponent group3 = new CompositeEmail("GTU CSE344", "all344students@gtu.edu.tr");

        //all emails
        EmailComponent allEmails = new CompositeEmail("GTU All mails", "allmails@gtu.edu.tr");

        // add single emails(leaf) to the groups
        group1.add(new Email("Akif Kartal", "akif.kartal2017@gtu.edu.tr"));
        group1.add(new Email("Djuro RADUSINOVIC", "djuro2017@gtu.edu.tr"));
        group1.add(new Email("Mustafa TOKGÖZ", "mustafa.tokgoz2017@gtu.edu.tr"));
        group1.add(new Email("Muhammed Emin KARAKAYA", "m.karakaya2018@gtu.edu.tr"));
        group1.add(new Email("Mehdi KURTCEBE", "m.kurtcebe2018@gtu.edu.tr"));
        group1.add(new Email("Sinan SARI", "sinan.sari2016@gtu.edu.tr"));
        group1.add(new Email("Alp Eser", "hboubati@gtu.edu.tr"));

        // add single emails(leaf) to the groups
        group2.add(new Email("Ugur Sahin", "biontech2017@gtu.edu.tr"));
        group2.add(new Email("Mustafa Dinçer", "mustafa.prod2017@gtu.edu.tr"));
        group2.add(new Email("Selin Akın", "selin_cons2018@gtu.edu.tr"));
        group2.add(new Email("Kenan Kurt", "yusuf2018@gtu.edu.tr"));

        // add single emails(leaf) to the groups
        group3.add(new Email("Salih Reader", "database@gtu.edu.tr"));
        group3.add(new Email("Ahmet Writer", "priority@gtu.edu.tr"));
        group3.add(new Email("Mehmet Cigarette", "give@gtu.edu.tr"));
        group3.add(new Email("Ozan Smoker", "leave@gtu.edu.tr"));
        group3.add(new Email("Sinan Philosopher", "dining@gtu.edu.tr"));
        group3.add(new Email("Fatih Uyuyan Berber", "cse344_forever@gtu.edu.tr"));

        //add a group into another group
        group1.add(group3);

        //add all groups to the all email group
        allEmails.add(group1);
        allEmails.add(group2);

        //add a leaf email to the all email group
        allEmails.add(new Email("Sinem Yılmaz", "sinem2013@gtu.edu.tr"));

        //print elements using print method
        allEmails.print();


    }

    /***
     * print all emails using composite iterator
     * @param allEmails head of tree(composite)
     */
    public static void printAll(EmailComponent allEmails) {
        Iterator<EmailComponent> iterator = allEmails.createIterator();
        System.out.println("------------ALL Emails--------------");
        while (iterator.hasNext()) {
            EmailComponent mailComponent = iterator.next();
            try {
                mailComponent.print();
            } catch (UnsupportedOperationException ignored) {
            }
        }
    }
}
