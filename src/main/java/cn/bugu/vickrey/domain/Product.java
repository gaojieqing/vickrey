package cn.bugu.vickrey.domain;

import java.io.Serializable;
import java.math.BigDecimal;

public class Product implements Serializable {
    private Integer productId;

    private BigDecimal price;

    private Integer repurchaseRound;

    private static final long serialVersionUID = 1L;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getRepurchaseRound() {
        return repurchaseRound;
    }

    public void setRepurchaseRound(Integer repurchaseRound) {
        this.repurchaseRound = repurchaseRound;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", productId=").append(productId);
        sb.append(", price=").append(price);
        sb.append(", repurchaseRound=").append(repurchaseRound);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}