package Thread;

public class MultipleThreads extends Thread{
    String name;

    public void run() {
        while (true) {
            name = Thread.currentThread().getName();
            System.out.println(name);
            try {
                Thread.sleep(500);
            }catch (InterruptedException e) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        MultipleThreads t1 = new MultipleThreads();
        MultipleThreads t2 = new MultipleThreads();
        t1.setName("Thread2");
        t2.setName("Thread3");
        t1.start();
        t2.start();
        System.out.println("Number of threads running: " + Thread.activeCount());
    }
}
