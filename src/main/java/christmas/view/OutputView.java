package christmas.view;

import static christmas.view.ViewMessages.AMOUNT_FORMAT;
import static christmas.view.ViewMessages.EVENT_AND_DISCOUNT_AMOUNT_FORMAT;
import static christmas.view.ViewMessages.EVENT_RESULT_INIT_MESSAGE;
import static christmas.view.ViewMessages.MENU_NAME_AND_QUANTITY_FORMAT;
import static christmas.view.ViewMessages.NO_RESULT;

import christmas.domain.GiftItem;
import christmas.domain.OrderedItem;
import christmas.domain.dto.response.EventResultDto;
import christmas.domain.dto.response.OrderResultDto;
import java.util.List;
import java.util.Map;

public class OutputView {
    public void printOrderResult(OrderResultDto orderResultDto) {
        printDate(orderResultDto.getDate());
        printMenuItems(orderResultDto.getOrderedItems());
        printAmountBeforeDiscount(orderResultDto.getAmountBeforeDiscount());
    }

    private void printDate(int date) {
        System.out.printf(EVENT_RESULT_INIT_MESSAGE.getMessage(), date);
        System.out.println();
    }

    private void printMenuItems(List<OrderedItem> items) {
        System.out.println("<주문 메뉴>");
        items.forEach(item -> printMenuItem(item));
        System.out.println();
    }

    private void printMenuItem(OrderedItem item) {
        System.out.printf(MENU_NAME_AND_QUANTITY_FORMAT.getMessage(), item.getMenu().getName(),
                item.getQuantity());
    }

    private void printAmountBeforeDiscount(int amount) {
        printAmountWithFormat("<할인 전 총주문 금액>", amount, false);
    }

    public void printEventResult(EventResultDto eventResult) {
        printGifts(eventResult.getGifts());
        printRewards(eventResult.getRewardDetails());
        printAmountOfRewards(eventResult.getTotalRewardAmount());
        printExpectedPayAmount(eventResult.getExpectedPayAmount());
        printDecemberBadge(eventResult.getBadgeName());
    }

    private void printGifts(List<GiftItem> giftItems) {
        System.out.println("<증정 메뉴>");
        for (GiftItem giftItem : giftItems) {
            System.out.printf(MENU_NAME_AND_QUANTITY_FORMAT.getMessage(), giftItem.getMenu().getName(),
                    giftItem.getQuantity());
        }
        if (giftItems.isEmpty()) {
            System.out.println(NO_RESULT);
        }
        System.out.println();
    }

    private void printRewards(Map<String, Integer> rewardDetails) {
        System.out.println("<혜택 내역>");
        rewardDetails.entrySet()
                .forEach(entry -> System.out.printf(EVENT_AND_DISCOUNT_AMOUNT_FORMAT.getMessage(), entry.getKey(),
                        -entry.getValue()));
        if (rewardDetails.isEmpty()) {
            System.out.println(NO_RESULT);
        }
        System.out.println();
    }

    private void printAmountOfRewards(int amount) {
        printAmountWithFormat("<총혜택 금액>", amount, true);
    }

    private void printAmountWithFormat(String header, int amount, boolean shouldNegate) {
        System.out.println(header);
        if (shouldNegate) {
            amount *= -1;
        }
        System.out.printf(AMOUNT_FORMAT.getMessage(), amount);
        System.out.println();
    }

    private void printExpectedPayAmount(int amount) {
        printAmountWithFormat("<할인 후 예상 결제 금액>", amount, false);
    }

    private void printDecemberBadge(String badgeName) {
        System.out.println("<12월 이벤트 배지>");
        System.out.println(badgeName);
    }
}
