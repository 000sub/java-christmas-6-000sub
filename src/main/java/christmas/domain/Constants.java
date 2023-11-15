package christmas.domain;

public enum Constants {
    CURRENT_YEAR(2023),
    CURRENT_MONTH(12);
    
    private final int value;

    Constants(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
