package cf.mindaugas.deadlock;

public class DeadlockRunner {

    public static void main(String[] args)
            throws InterruptedException {

        Deadlockable dl = new Deadlockable();

        Runnable r1 = () -> dl.a();
        Runnable r2 = () -> dl.b();

        Thread t1 = new Thread(r1);
        t1.start();

        Thread t2 = new Thread(r2);
        t2.start();

        t1.join();
        t2.join();
    }
}
