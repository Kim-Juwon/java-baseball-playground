package baseball.component;

import java.util.*;

public class Numbers {
    private List<Element> elements = new ArrayList<>();

    public static Numbers from(String stringNumber) {
        Numbers number = new Numbers();
        number.addElementsFrom(stringNumber);

        return number;
    }

    public List<Element> getElements() {
        return elements;
    }

    private void addElementsFrom(String numberString) {
        for (int i = 0; i < numberString.length(); i++) {
            elements.add(Element.of(numberString.charAt(i), i));
        }
    }

    public Hints compareAndGetHints(Numbers other) {
        return getHintsFrom(other.getElements());
    }

    private Hints getHintsFrom(List<Element> otherElements) {
        Map<Status, Integer> statusCountMap = new HashMap<>();
        elements.forEach(element -> {
            otherElements.stream()
                    .map(otherElement -> getStatusFrom(element, otherElement))
                    .filter(Objects::nonNull)
                    .forEach(status -> {
                        statusCountMap.put(status, statusCountMap.getOrDefault(status, 0) + 1);
                    });
        });

        List<Hint> hintList = new ArrayList<>();
        statusCountMap.forEach((key, value) -> {
            hintList.add(Hint.of(key, value));
        });

        return Hints.from(hintList);
    }

    private Status getStatusFrom(Element element1, Element element2) {
        if (element1.hasSameValueAndLocation(element2)) {
            return Status.STRIKE;
        }
        if (element1.hasSameValueAndDifferentLocation(element2)) {
            return Status.BALL;
        }

        return null;
    }
}
