package christmas.domain.dto;

import christmas.domain.Order;
import christmas.domain.OrderedItem;
import christmas.domain.dto.request.OrderedItemRequestDto;
import christmas.domain.dto.response.OrderResultDto;
import java.util.List;

public class DtoMapper {
    private DtoMapper() {
    }

    public static List<OrderedItem> convertDtosToOrderedItems(List<OrderedItemRequestDto> orderedItemRequestDtos) {
        return orderedItemRequestDtos.stream()
                .map(DtoMapper::convertDtoToOrderedItem)
                .toList();
    }

    private static OrderedItem convertDtoToOrderedItem(OrderedItemRequestDto orderedItemRequestDto) {
        return new OrderedItem(orderedItemRequestDto.getMenuName(), orderedItemRequestDto.getQuantity());
    }

    public static OrderResultDto convertOrderToDto(Order order) {
        return new OrderResultDto(order.getOrderedItems(), order.getTotalAmount(),
                order.getVisitDate().getDayOfMonth());
    }
}
