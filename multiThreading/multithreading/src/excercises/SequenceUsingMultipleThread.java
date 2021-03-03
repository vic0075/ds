package excercises;

import java.util.concurrent.atomic.AtomicInteger;

public class SequenceUsingMultipleThread {
    public static void main(String[] args) throws InterruptedException {
        AtomicInteger number = new AtomicInteger(1);

        Thread t1 = new Thread(new PrintSequence(1, number), "t1");
        Thread t2 = new Thread(new PrintSequence(2, number), "t2");
        Thread t3 = new Thread(new PrintSequence(0, number), "t3");

        t1.start();
        t1.join(200);
        t2.start();
        t2.join(20);
        t3.start();
    }
}

class PrintSequence implements Runnable {
    private final int reminder;
    private final AtomicInteger number;
    private static final int MAX = 10;

    public PrintSequence(int reminder, AtomicInteger number) {
        this.reminder = reminder;
        this.number = number;
    }

    @Override
    public void run() {
        synchronized (number) {
            while (number.get() < MAX) {
                System.out.println(Thread.currentThread().getName() + "--- " + number);
                while (number.get() < MAX && number.get() % 3 != reminder) {
                    System.out.println(Thread.currentThread().getName() + "=== " + number);
                    try {
                        number.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + ": " + number.getAndIncrement());
                number.notifyAll();
            }
        }
    }
}
