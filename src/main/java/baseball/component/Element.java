package baseball.component;

public class Element {
    private final char value;
    private final int location; // index

    private Element(char value, int location) {
        this.value = value;
        this.location = location;
    }

    public static Element of(char value, int location) {
        return new Element(value, location);
    }

    public char getValue() {
        return value;
    }

    public int getLocation() {
        return location;
    }

    public boolean hasSameValueAndLocation(Element element) {
        return value == element.getValue()
                && location == element.getLocation();
    }

    public boolean hasSameValueAndDifferentLocation(Element element) {
        return value == element.getValue()
                && location != element.getLocation();
    }
}
