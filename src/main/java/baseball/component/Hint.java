package baseball.component;

public class Hint {
    private final Status status;
    private final int count;

    public Hint(Status status, int count) {
        this.status = status;
        this.count = count;
    }

    public Status getStatus() {
        return status;
    }

    public int getCount() {
        return count;
    }

    public static Hint of(Status status, int count) {
        return new Hint(status, count);
    }
}
