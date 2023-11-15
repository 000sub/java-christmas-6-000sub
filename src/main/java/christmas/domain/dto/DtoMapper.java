package christmas.domain.dto;

import christmas.domain.EventResult;
import christmas.domain.Order;
import christmas.domain.OrderedItem;
import christmas.domain.dto.request.DateDto;
import christmas.domain.dto.request.OrderedItemDto;
import christmas.domain.dto.response.EventResultDto;
import christmas.domain.dto.response.OrderResultDto;
import java.util.HashMap;
import java.util.List;

public class DtoMapper {
    private DtoMapper() {
    }

    public static int convertDtoToInt(DateDto dateDto) {
        return dateDto.getDate();
    }

    public static List<OrderedItem> convertDtosToOrderedItems(List<OrderedItemDto> orderedItemDtos) {
        return orderedItemDtos.stream()
                .map(DtoMapper::convertDtoToOrderedItem)
                .toList();
    }

    private static OrderedItem convertDtoToOrderedItem(OrderedItemDto orderedItemDto) {
        return new OrderedItem(orderedItemDto.getMenuName(), orderedItemDto.getQuantity());
    }

    public static OrderResultDto convertOrderToDto(Order order) {
        return new OrderResultDto(order.getOrderedItems(), order.getTotalAmount(),
                order.getVisitDate().getDayOfMonth());
    }

    public static EventResultDto convertEventResultToDto(EventResult eventResult) {
        HashMap<String, Integer> rewardDetailsDto = new HashMap<>();
        eventResult.getRewardDetails().entrySet().stream()
                .filter(entry -> entry.getValue() > 0)
                .forEach(entry -> rewardDetailsDto.put(entry.getKey().getDescription(), entry.getValue()));
        return new EventResultDto(rewardDetailsDto, eventResult.getGifts(),
                eventResult.getTotalRewardAmount(), eventResult.getExpectedPayAmount(),
                eventResult.getBadge().getName());
    }
}
