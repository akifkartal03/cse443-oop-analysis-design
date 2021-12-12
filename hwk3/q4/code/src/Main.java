/***
 * Test drive class for project
 */
public class Main {
    /***
     * Main function of the program.
     * @param args params
     */
    public static void main(String[] args) {
	    ThreadSafe buffer = new ProxyBestDSEver();
        Integer[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        buffer.insert(arr[0]);
        buffer.insert(arr[1]);
        buffer.insert(arr[2]);
        buffer.insert(arr[3]);
        Thread thread0 = new Thread() {
            public void run() {
                System.out.println("Thread0 -> get(0): " + buffer.get(0));
                System.out.println("Thread0 -> insert(Integer(4))");
                buffer.insert(arr[4]);
                System.out.println("Thread0 -> remove(Integer(4))");
                buffer.remove(arr[4]);

            }
        };
        Thread thread1 = new Thread() {
            public void run() {
                System.out.println("Thread1 -> insert(Integer(8))");
                buffer.insert(arr[8]);
                System.out.println("Thread1 -> remove(Integer(8))");
                buffer.remove(arr[8]);
                System.out.println("Thread1 -> get(1): " + buffer.get(1));
            }
        };
        Thread thread2 = new Thread() {
            public void run() {
                System.out.println("Thread2 -> remove(Integer(0))");
                buffer.remove(arr[0]);
                System.out.println("Thread2 -> get(0): " + buffer.get(0));
                System.out.println("Thread2 -> insert(Integer(5))");
                buffer.insert(arr[5]);
            }
        };
        thread0.start();
        thread1.start();
        thread2.start();
        System.out.println("Main Thread -> get(1): " + buffer.get(1));
        System.out.println("Main Thread -> insert(Integer(7))");
        buffer.insert(arr[7]);
        try {
            /*Make sure all threads have finished.*/
            thread0.join();
            thread1.join();
            thread2.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Good Bye...");

    }
}
