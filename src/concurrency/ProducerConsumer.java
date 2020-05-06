package concurrency;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class Producer extends Thread {
    BlockingQueue queue;
    int noOfRuns;
    public Producer(BlockingQueue queue, int noOfRuns) {
        this.queue = queue;
        this.noOfRuns = noOfRuns;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i <= noOfRuns; i++) {
                synchronized (queue) {
                    while (queue.size() > 0) {
                        queue.wait();
                    }
                    queue.add(i);
                    System.out.println("Produced: " + i);
                    queue.notify();
                    Thread.sleep(1000);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}

class Consumer extends Thread {
    BlockingQueue queue;
    int noOfRuns;
    public Consumer(BlockingQueue queue, int noOfRuns) {
        this.queue = queue;
        this.noOfRuns = noOfRuns;
    }

    @Override
    public void run() {
        int out = 0;
        while (out < noOfRuns) {
            try {
                synchronized (queue) {
                    while (queue.isEmpty()) {
                        queue.wait();
                    }
                    out = (Integer) queue.poll();
                    System.out.println("Consumed: " + out);
                    queue.notify();
                    Thread.sleep(1000);
//                    if (out == 3) {
//                        break;
//                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class ProducerConsumer {
    public static void main(String[] args) {
        int capacity = 4;
        BlockingQueue queue = new ArrayBlockingQueue(capacity);
        Producer p = new Producer(queue, 3);
        Consumer c = new Consumer(queue, 3);
        p.start();
        c.start();
    }
}
