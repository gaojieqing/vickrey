package cn.bugu.vickrey.domain;

import java.io.Serializable;
import java.math.BigDecimal;

public class Deal implements Serializable {
    private Integer dealId;

    private Integer userId;

    private Integer productId;

    private Integer round;

    private BigDecimal dealPrice;

    private Integer isRepurchased;

    private static final long serialVersionUID = 1L;

    public Integer getDealId() {
        return dealId;
    }

    public void setDealId(Integer dealId) {
        this.dealId = dealId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getRound() {
        return round;
    }

    public void setRound(Integer round) {
        this.round = round;
    }

    public BigDecimal getDealPrice() {
        return dealPrice;
    }

    public void setDealPrice(BigDecimal dealPrice) {
        this.dealPrice = dealPrice;
    }

    public Integer getIsRepurchased() {
        return isRepurchased;
    }

    public void setIsRepurchased(Integer isRepurchased) {
        this.isRepurchased = isRepurchased;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", dealId=").append(dealId);
        sb.append(", userId=").append(userId);
        sb.append(", productId=").append(productId);
        sb.append(", round=").append(round);
        sb.append(", dealPrice=").append(dealPrice);
        sb.append(", isRepurchased=").append(isRepurchased);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}