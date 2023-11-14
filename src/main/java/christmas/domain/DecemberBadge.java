package christmas.domain;

import java.util.Arrays;

public enum DecemberBadge {
    SANTA("산타", 20000),
    TREE("트리", 10000),
    STAR("별", 5000),
    NONE("없음", 0);

    private final String name;
    private final int minimalRewardAmount;

    DecemberBadge(String name, int minimalRewardAmount) {
        this.name = name;
        this.minimalRewardAmount = minimalRewardAmount;
    }

    public static DecemberBadge from(int amount) {
        return Arrays.stream(DecemberBadge.values())
                .filter(decemberBadge -> decemberBadge.minimalRewardAmount <= amount)
                .findFirst()
                .orElse(NONE);
    }

    public String getName() {
        return name;
    }
}
