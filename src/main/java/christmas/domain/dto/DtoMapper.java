package christmas.domain.dto;

import christmas.domain.EventResult;
import christmas.domain.Order;
import christmas.domain.OrderedItem;
import christmas.domain.dto.request.OrderedItemRequestDto;
import christmas.domain.dto.response.EventResultDto;
import christmas.domain.dto.response.OrderResultDto;
import java.util.HashMap;
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
