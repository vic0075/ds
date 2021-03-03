package excercises;

public class ThreadOrder {

    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = () -> {
            int i = 1;
            while (i < 100) {
                System.out.println(Thread.currentThread().getName() + ": " + i++);
            }
        };

        Thread t1 = new Thread(runnable, "t1");
        Thread t2 = new Thread(runnable, "t2");
        Thread t3 = new Thread(runnable, "t3");


        t1.start();
        t1.join();
        t2.join();
        t2.start();
        t3.join();
        t3.start();
    }

}
