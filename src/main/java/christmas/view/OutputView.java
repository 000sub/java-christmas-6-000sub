package christmas.view;

import christmas.domain.OrderedItem;
import christmas.domain.dto.response.OrderResultDto;
import java.util.List;

public class OutputView {
    public void printOrderResult(OrderResultDto orderResultDto) {
        printDate(orderResultDto.getDate());
        printOrderMenus(orderResultDto.getOrderedItems());
        printAmountBeforeDiscount(orderResultDto.getAmountBeforeDiscount());
    }

    private void printDate(int date) {
        System.out.printf("12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!", date);
        System.out.println();
    }

    public void printOrderMenus(List<OrderedItem> orderedItems) {
        System.out.println("<주문 메뉴>");
        for (OrderedItem orderedItem : orderedItems) {
            System.out.printf("%s %d개", orderedItem.getMenu().getName(), orderedItem.getQuantity());
            System.out.println();
        }
    }

    public void printAmountBeforeDiscount(int amount) {
        System.out.println("<할인 전 총주문 금액>");
        System.out.printf("-%,d", amount);
        System.out.println();
    }

    public void printGiftMenu() {
        System.out.println("<증정 메뉴>");
    }

    public void printRewards() {
        System.out.println("<혜택 내역>");
    }

    public void printAmountOfRewards() {
        System.out.println("<총혜택 금액>");
    }

    public void printExpectedPayAmount() {
        System.out.println("<할인 후 예상 결제 금액>");
    }
}
