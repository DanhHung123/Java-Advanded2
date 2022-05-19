package Thread;

class Chopstick {
    boolean available;
    Chopstick() {
        this.available = true;
    }
    public synchronized void takeUp() {
        while (!available) {
            try {
                System.out.println("Waiting to eat...");
                wait();
            }catch (InterruptedException e) { }
        }
        available = false;
    }
    public synchronized void putDown() {
        available = true;
    }


    // code snippet 8
    public synchronized void putDown2() {
        available = true;
        notify();
    }
}

class Philosopher extends Thread {
    Chopstick left;
    Chopstick right;
    int ID;
    public Philosopher(Chopstick left, Chopstick right, int ID) {
        this.left = left;
        this.right = right;
        this.ID = ID + 1;
    }
    public void eat() {
        left.takeUp();
        right.takeUp();
        System.out.println(ID + " :The Philosopher is Dining");
    }

    public void think() {
        left.putDown();
        right.putDown();
        System.out.println(ID + " :The Philosopher is Thinking");
    }
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
            think();
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e) {

            }
        }
    }
}
public class DiningDemo {
    public static void main(String[] args) {
        int i;
        Philosopher[] philosopher = new Philosopher[5];
        Chopstick[] chopstick = new Chopstick[5];
        for (i = 0;i<5;i++){
            chopstick[i] = new Chopstick();
        }
        for (i = 0;i<5;i++){
            philosopher[i] = new Philosopher(chopstick[i], chopstick[(i+1)%5],i);
        }
        for (i = 0;i<5;i++){
            philosopher[i].start();
        }
    }
}
