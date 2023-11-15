package christmas.domain;

import static christmas.domain.Constants.CURRENT_MONTH;
import static christmas.domain.Constants.CURRENT_YEAR;
import static christmas.domain.MenuCategory.BEVERAGE;
import static christmas.exception.Exceptions.INVALID_ORDER_MESSAGE;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

public class Order {
    private static final int MAX_ORDER_QUANTITY = 20;

    private final LocalDate visitDate;
    private final List<OrderedItem> orderedItems;

    private Order(LocalDate visitDate, List<OrderedItem> orderedItems) {
        this.visitDate = visitDate;
        this.orderedItems = orderedItems;
        validate();
    }

    public static Order of(int date, List<OrderedItem> orderedItems) {
        return new Order(LocalDate.of(CURRENT_YEAR.getValue(), CURRENT_MONTH.getValue(), date), orderedItems);
    }

    private void validate() {
        if (hasDuplicatedItem() || hasOnlyBeverages() || hasMoreThanMaxQuantity()) {
            throw new IllegalArgumentException(INVALID_ORDER_MESSAGE.getMessage());
        }
    }

    private boolean hasDuplicatedItem() {
        return getUniqueMenuCount(orderedItems) != orderedItems.size();
    }

    private boolean hasMoreThanMaxQuantity() {
        return getTotalQuantity(orderedItems) > MAX_ORDER_QUANTITY;
    }

    private boolean hasOnlyBeverages() {
        return getBeverageQuantity(orderedItems) == getTotalQuantity(orderedItems);

    }

    private int getUniqueMenuCount(List<OrderedItem> orderedItems) {
        return (int) orderedItems.stream().distinct().count();
    }


    private int getTotalQuantity(List<OrderedItem> orderedItems) {
        return orderedItems.stream()
                .mapToInt(OrderedItem::getQuantity)
                .reduce(0, Integer::sum);
    }


    private int getBeverageQuantity(List<OrderedItem> orderedItems) {
        return (int) orderedItems.stream()
                .filter(item -> item.getMenu().getCategory().equals(BEVERAGE))
                .count();
    }

    public int getQuantityOfCategory(MenuCategory category) {
        return orderedItems.stream()
                .filter(item -> item.getMenu().getCategory().equals(category))
                .map(OrderedItem::getQuantity)
                .reduce(0, Integer::sum);
    }

    public int getTotalAmount() {
        return orderedItems.stream()
                .map(OrderedItem::getTotalPrice)
                .reduce(0, Integer::sum);
    }

    public List<OrderedItem> getOrderedItems() {
        return Collections.unmodifiableList(orderedItems);
    }

    public LocalDate getVisitDate() {
        return visitDate;
    }
}
