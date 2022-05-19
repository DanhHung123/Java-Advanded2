package Thread;

class One {
    synchronized void display(int num) {
        System.out.printf("" + num);
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e) {
            System.out.println("Interrupted");
        }
        System.out.println("done");
    }
}

class Two extends Thread {
    int number;
    One objOne;
    public Two (One one_num, int num) {
        objOne = one_num;
        number = num;
    }
    public void run() {
        objOne.display(number);
    }
}

class SynchMethod {
    public static void main(String[] args) {
        One objOne = new One();
        int digit = 10;
        Two objSynch1 = new Two(objOne,digit++);
        Two objSynch2 = new Two(objOne,digit++);
        Two objSynch3 = new Two(objOne,digit++);
        objSynch1.start();
        objSynch2.start();
        objSynch3.start();
    }
}
