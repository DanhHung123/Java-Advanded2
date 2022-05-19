package Thread;

public class ThreadDemo2 extends Thread{
    public static void main(String[] args) {
        ThreadDemo2 objTh = new ThreadDemo2();
        Thread t = new Thread(objTh);
        try {
            t.start();
            System.out.println("Number of threads running: " +
                    Thread.activeCount() );
            System.out.println("I am in the main and waiting for the thread to finish");
            objTh.join();
        }catch (InterruptedException e) {
            System.out.println("Main thread is interrupted");
        }
    }
}
