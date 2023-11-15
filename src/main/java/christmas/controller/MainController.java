package christmas.controller;

import static christmas.domain.dto.DtoMapper.convertDtosToOrderedItems;
import static christmas.domain.dto.DtoMapper.convertEventResultToDto;
import static christmas.domain.dto.DtoMapper.convertOrderToDto;

import christmas.domain.EventResult;
import christmas.domain.Order;
import christmas.domain.OrderedItem;
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
        Order order = getOrder(date);
        outputView.printOrderResult(convertOrderToDto(order));
        EventResult eventResult = new EventResult(order);
        outputView.printEventResult(convertEventResultToDto(eventResult));
    }

    private Order getOrder(int date) {
        return exceptionHandler.handle(() -> {
            List<OrderedItem> orderedItems = convertDtosToOrderedItems(inputView.readMenu());
            return Order.of(date, orderedItems);
        });
    }
}
