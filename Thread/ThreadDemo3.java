package Thread;

class ThreadDemo3 implements Runnable{
    String name;
    Thread objTh;
    ThreadDemo3 (String str) {
        name = str;
        objTh = new Thread(this,name);
        System.out.println("New Threads are starting: " + objTh);
        objTh.start();
    }
    public void run() {
        try {
            for (int count = 0; count < 2; count++) {
                System.out.println(name+":"+count);
                objTh.sleep(1000);
            }
        }catch (InterruptedException e) {
            System.out.println(name + "interrupted");
        }
        System.out.println(name + "exiting");
    }

    public static void main(String[] args) {
        ThreadDemo3 objNew1 = new ThreadDemo3("one");
        ThreadDemo3 objNew2 = new ThreadDemo3("two");
        ThreadDemo3 objNew3 = new ThreadDemo3("three");
        System.out.println("First thread is alive: " + objNew1.objTh.isAlive());
        System.out.println("Second thread is alive: " + objNew2.objTh.isAlive());
        System.out.println("Third thread is alive: " + objNew3.objTh.isAlive());
        try {
            System.out.println("In the main method, waiting for the threads to finish");
            objNew1.objTh.join();
            objNew2.objTh.join();
            objNew3.objTh.join();
        }catch (InterruptedException e){
            System.out.println("Main thread is interrupted");
            System.out.println("First thread is alive:" + objNew1.objTh.isAlive());
            System.out.println("Second thread is alive:" + objNew2.objTh.isAlive());
            System.out.println("Third thread is alive:" + objNew3.objTh.isAlive());
            System.out.println("Main thread is over and exiting");
        }
    }
}
