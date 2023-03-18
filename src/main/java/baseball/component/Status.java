package baseball.component;

public enum Status {
    STRIKE("스트라이크"),
    BALL("볼"),
    NOTHING("낫싱");

    public String getMeaning() {
        return meaning;
    }

    private final String meaning;

    Status(String meaning) {
        this.meaning = meaning;
    }
}
