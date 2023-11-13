package christmas.domain;

import static christmas.domain.Constants.MAX_ORDER_QUANTITY;
import static christmas.domain.MenuCategory.BEVERAGE;
import static christmas.exception.Exceptions.INVALID_ORDER_MESSAGE;

import java.util.Collections;
import java.util.List;

public class Order {
    private final int visitDate;
    private final List<OrderedItem> orderedItems;

    public Order(int visitDate, List<OrderedItem> orderedItems) {
        validate(orderedItems);
        this.visitDate = visitDate;
        this.orderedItems = orderedItems;
    }

    public static Order of(int date, List<OrderedItem> orderedItems) {
        return new Order(date, orderedItems);
    }

    private void validate(List<OrderedItem> orderedItems) {
        validateDuplicatedItem(orderedItems);
        validateTotalQuantity(orderedItems);
        validateOnlyBeverages(orderedItems);
    }

    private void validateDuplicatedItem(List<OrderedItem> orderedItems) {
        if (getUniqueMenuCount(orderedItems) != orderedItems.size()) {
            throw new IllegalArgumentException(INVALID_ORDER_MESSAGE.getMessage());
        }
    }

    private int getUniqueMenuCount(List<OrderedItem> orderedItems) {
        return (int) orderedItems.stream().distinct().count();
    }

    private void validateTotalQuantity(List<OrderedItem> orderedItems) {
        if (getTotalQuantity(orderedItems) > MAX_ORDER_QUANTITY.getValue()) {
            throw new IllegalArgumentException(INVALID_ORDER_MESSAGE.getMessage());
        }
    }

    private int getTotalQuantity(List<OrderedItem> orderedItems) {
        return orderedItems.stream()
                .map(OrderedItem::getQuantity)
                .reduce(0, Integer::sum);
    }

    private void validateOnlyBeverages(List<OrderedItem> orderedItems) {
        if (getBeverageQuantity(orderedItems) == getTotalQuantity(orderedItems)) {
            throw new IllegalArgumentException(INVALID_ORDER_MESSAGE.getMessage());
        }
    }

    private int getBeverageQuantity(List<OrderedItem> orderedItems) {
        return (int) orderedItems.stream()
                .filter(item -> item.getMenu().getCategory().equals(BEVERAGE))
                .count();
    }

    public int getTotalAmount() {
        return orderedItems.stream()
                .map(OrderedItem::getTotalPrice)
                .reduce(0, Integer::sum);
    }

    public List<OrderedItem> getOrderedItems() {
        return Collections.unmodifiableList(orderedItems);
    }

    public int getVisitDate() {
        return visitDate;
    }
}
