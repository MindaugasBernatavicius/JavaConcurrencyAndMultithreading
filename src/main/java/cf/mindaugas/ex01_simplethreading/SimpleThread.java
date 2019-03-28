package cf.mindaugas.ex01_simplethreading;

public class SimpleThread {
    public static void main(String[] args){

        Runnable runnableBlock0 = () -> {
            System.out.println("Im running in: " + Thread.currentThread().getName() +
                            "w/ priority: " + Thread.currentThread().getPriority());
        };

        Runnable runnableBlock1 = () -> {
            for(int i = 0; i < 100; i++)
                System.out.println("rb2" + i);
        };

        Thread t0 = new Thread(runnableBlock0);
        t0.start();
//        t0.run();

        Thread t1 = new Thread(runnableBlock1);
        t1.start();

        for(int i = 0; i < 100; i++)
            System.out.println("main" + i);
    }
}
