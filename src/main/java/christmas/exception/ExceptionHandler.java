package christmas.exception;

import christmas.view.InputView;
import java.util.function.Supplier;

public class ExceptionHandler {

    private final InputView inputView;

    public ExceptionHandler(InputView inputView) {
        this.inputView = inputView;
    }

    public <T> T handle(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                inputView.printExceptionMessage(e.getMessage());
            }
        }
    }
}
