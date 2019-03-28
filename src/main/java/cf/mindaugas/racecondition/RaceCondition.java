package cf.mindaugas.racecondition;

public class RaceCondition {

    public static void main(String[] args) throws InterruptedException {

        Incrementee incr = new Incrementee(0L);

        Runnable r = () -> {
            for (int i = 0 ; i < 1_000 ; i++) {
                incr.incrementValue();
            }
        };

        Thread[] threads = new Thread[1_000];
        for (int i = 0 ; i < threads.length ; i++) {
            threads[i] = new Thread(r);
            threads[i].start();
        }

        for (int i = 0 ; i < threads.length ; i++) {
            threads[i].join();
        }

        System.out.println("Value = " + incr.getValue());
    }
}
