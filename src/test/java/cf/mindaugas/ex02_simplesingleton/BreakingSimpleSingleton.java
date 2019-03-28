package cf.mindaugas.ex02_simplesingleton;

import org.junit.jupiter.api.Test;

/*
* THIS DOES NOT BREAK SINGLETON,
* next ideas to try:
* - random sleep intervals side the threads
* - add random sleep inside the Singleton creation
* */

public class BreakingSimpleSingleton {

    Singleton s1, s2;
    @Test
    public void initMultipleSingletons() {

        Runnable r0 = () -> {
            try {
                Thread.sleep(0,1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            s1 = Singleton.getInstance(); };

        Runnable r1 = () -> {
            try {
                Thread.sleep(0,2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            s2 = Singleton.getInstance(); };

        for(int i = 0; i < 10000; i++){
            new Thread(r0).run();
            new Thread(r1).run();
            if(s1.equals(s2)){
                System.out.println(s1.hashCode() + "::" + s2.hashCode());
                s1.setNull();
                s2.setNull();
            } else
                System.out.println("Fak!");
        }
    }
}
