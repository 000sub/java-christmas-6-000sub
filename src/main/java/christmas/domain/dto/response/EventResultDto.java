package christmas.domain.dto.response;

import christmas.domain.GiftItem;
import java.util.List;
import java.util.Map;

public class EventResultDto {
    private final Map<String, Integer> rewardDetails;
    private final List<GiftItem> gifts;
    private final int totalRewardAmount;
    private final int expectedPayAmount;
    private final String badgeName;

    public EventResultDto(Map<String, Integer> rewardDetails, List<GiftItem> gifts, int totalRewardAmount,
                          int expectedPayAmount, String badgeName) {
        this.rewardDetails = rewardDetails;
        this.gifts = gifts;
        this.totalRewardAmount = totalRewardAmount;
        this.expectedPayAmount = expectedPayAmount;
        this.badgeName = badgeName;
    }

    public Map<String, Integer> getRewardDetails() {
        return rewardDetails;
    }

    public List<GiftItem> getGifts() {
        return gifts;
    }

    public int getTotalRewardAmount() {
        return totalRewardAmount;
    }

    public int getExpectedPayAmount() {
        return expectedPayAmount;
    }

    public String getBadgeName() {
        return badgeName;
    }
}
