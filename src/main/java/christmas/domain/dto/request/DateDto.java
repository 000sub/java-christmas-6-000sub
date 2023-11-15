package christmas.domain.dto.request;

import static christmas.exception.Exceptions.INVALID_DATE_MESSAGE;

public class DateDto {
    private static final int RANGE_START = 1;
    private static final int RANGE_END = 31;
    private final int date;

    private DateDto(int date) {
        this.date = date;
        validateRange();
    }

    public static DateDto create(String dateInput) {
        int parsedInput = parseInt(dateInput);
        return new DateDto(parsedInput);
    }

    private static int parseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(INVALID_DATE_MESSAGE.getMessage());
        }
    }

    private void validateRange() {
        if (date < RANGE_START || date > RANGE_END) {
            throw new IllegalArgumentException(INVALID_DATE_MESSAGE.getMessage());
        }
    }

    public int getDate() {
        return date;
    }
}
