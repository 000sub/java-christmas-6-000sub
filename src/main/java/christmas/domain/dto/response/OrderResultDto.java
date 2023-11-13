package christmas.domain.dto.response;

import christmas.domain.OrderedItem;
import java.util.Collections;
import java.util.List;

public class OrderResultDto {
    private final List<OrderedItem> orderedItems;
    private final int amountBeforeDiscount;
    private final int date;

    public OrderResultDto(List<OrderedItem> orderedItems, int amountBeforeDiscount, int date) {
        this.orderedItems = orderedItems;
        this.amountBeforeDiscount = amountBeforeDiscount;
        this.date = date;
    }

    public List<OrderedItem> getOrderedItems() {
        return Collections.unmodifiableList(orderedItems);
    }

    public int getAmountBeforeDiscount() {
        return amountBeforeDiscount;
    }

    public int getDate() {
        return date;
    }
}
