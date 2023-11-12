package christmas.domain;

import static christmas.domain.MenuCategory.APPETIZER;
import static christmas.domain.MenuCategory.BEVERAGE;
import static christmas.domain.MenuCategory.DESSERT;
import static christmas.domain.MenuCategory.MAIN;

import java.util.Arrays;

public enum MenuItem {
    MUSHROOM_SOUP("양송이수프", 6000, APPETIZER),
    TAPAS("타파스", 5500, APPETIZER),
    CAESAR_SALAD("시저샐러드", 8000, APPETIZER),
    T_BONE_STEAK("티본스테이크", 55000, MAIN),
    BARBECUE_LIP("바비큐립", 54000, MAIN),
    SEAFOOD_PASTA("해산물파스타", 35000, MAIN),
    CHRISTMAS_PASTA("크리스마스파스타", 25000, MAIN),
    CHOCOLATE_CAKE("초코케이크", 15000, DESSERT),
    ICE_CREAM("아이스크림", 5000, DESSERT),
    ZERO_COKE("제로콜라", 3000, BEVERAGE),
    RED_WINE("레드와인", 60000, BEVERAGE),
    CHAMPAGNE("샴페인", 25000, BEVERAGE);


    private final String menuName;
    private final int price;
    private final MenuCategory category;

    MenuItem(String menuName, int price, MenuCategory category) {
        this.menuName = menuName;
        this.price = price;
        this.category = category;
    }

    public static MenuItem fromMenuName(String menuName) {
        return Arrays.stream(MenuItem.values())
                .filter(item -> item.menuName.equals(menuName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException());
    }
}
