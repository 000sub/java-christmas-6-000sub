package christmas.controller;

import christmas.domain.request.MenuRequestDto;
import christmas.exception.ExceptionHandler;
import christmas.view.InputView;
import christmas.view.OutputView;
import java.util.List;

public class MainController {

    private final InputView inputView;
    private final OutputView outputView;
    private final ExceptionHandler exceptionHandler;

    public MainController() {
        inputView = new InputView();
        outputView = new OutputView();
        exceptionHandler = new ExceptionHandler(inputView);
    }

    public void start() {
        inputView.printInitMessage();
        int date = exceptionHandler.handle(() -> inputView.readDate());
        List<MenuRequestDto> menus = exceptionHandler.handle(() -> inputView.readMenu());
    }
}
