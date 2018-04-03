package cn.bugu.vickrey.domain;

import java.io.Serializable;
import java.math.BigDecimal;

public class Discount implements Serializable {
    private Integer discountId;

    private Integer repurchaseRound;

    private Integer remainRound;

    private BigDecimal discountRate;

    private static final long serialVersionUID = 1L;

    public Integer getDiscountId() {
        return discountId;
    }

    public void setDiscountId(Integer discountId) {
        this.discountId = discountId;
    }

    public Integer getRepurchaseRound() {
        return repurchaseRound;
    }

    public void setRepurchaseRound(Integer repurchaseRound) {
        this.repurchaseRound = repurchaseRound;
    }

    public Integer getRemainRound() {
        return remainRound;
    }

    public void setRemainRound(Integer remainRound) {
        this.remainRound = remainRound;
    }

    public BigDecimal getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(BigDecimal discountRate) {
        this.discountRate = discountRate;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", discountId=").append(discountId);
        sb.append(", repurchaseRound=").append(repurchaseRound);
        sb.append(", remainRound=").append(remainRound);
        sb.append(", discountRate=").append(discountRate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}