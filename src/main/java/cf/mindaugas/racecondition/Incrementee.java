package cf.mindaugas.racecondition;

public class Incrementee {

    private Object key = new Object();
    private long l;

    public Incrementee(long l) {
        this.l = l;
    }

    public long getValue() {
//        synchronized (key) {
//            return l;
//        }
        return l;
    }

    public void incrementValue() {
//        synchronized (key) {
//            l = l + 1;
//        }
        l = l + 1;
    }
}
