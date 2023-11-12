package christmas.view;

public class OutputView {

    public void printInitMessage(int date){
        System.out.printf("12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!", 3);
        System.out.println();
    }

    public void printOrderMenus(){
        System.out.println("<주문 메뉴>");
    }

    public void printAmountBeforeDiscount(){
        System.out.println("<할인 전 총주문 금액>");
    }

    public void printGiftMenu(){
        System.out.println("<증정 메뉴>");
    }

    public void printRewards(){
        System.out.println("<혜택 내역>");
    }

    public void printAmountOfRewards(){
        System.out.println("<총혜택 금액>");
    }

    public void printExpectedPayAmount(){
        System.out.println("<할인 후 예상 결제 금액>");
    }
}
