package concurrency;

public class ThreadTest {
    public static void main(String[] args) {
        Thread t = new Thread1();
        t.start();
    }
}

class Thread1 extends Thread{
    public void send() throws InterruptedException { wait();}
    public void receive(){notify();}
}