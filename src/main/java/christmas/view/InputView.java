package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.domain.dto.request.DateDto;
import christmas.domain.dto.request.OrderedItemDto;
import java.util.Arrays;
import java.util.List;

public class InputView {

    private String readLine() {
        return Console.readLine();
    }

    public DateDto readDate() {
        printDateInputMessage();
        String userInput = readLine();
        return DateDto.create(userInput);
    }

    public List<OrderedItemDto> readMenu() {
        printMenuInputMessage();
        String userInput = readLine();
        return Arrays.stream(userInput.split(","))
                .map(String::trim)
                .map(OrderedItemDto::create)
                .toList();
    }

    public void printExceptionMessage(String message) {
        System.out.println(message);
    }


    public void printInitMessage() {
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
    }

    private void printDateInputMessage() {
        System.out.println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");
    }

    private void printMenuInputMessage() {
        System.out.println("주문하실 메뉴를 메뉴와 개수를 알려주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)");
    }
}
