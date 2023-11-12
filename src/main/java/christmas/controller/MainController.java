package christmas.controller;

import christmas.domain.request.MenuRequestDto;
import christmas.view.InputView;
import christmas.view.OutputView;
import java.util.List;

public class MainController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void start() {
        inputView.printInitMessage();
        int date = inputView.readDate();
        List<MenuRequestDto> menus = inputView.readMenu();
    }
}
