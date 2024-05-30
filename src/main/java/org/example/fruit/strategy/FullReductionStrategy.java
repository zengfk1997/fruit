package org.example.fruit.strategy;

import java.math.BigDecimal;

/**
 * packageName org.fruit.discount
 *
 * @author zengfanke
 * @date 2024/5/30
 * @description 满减策略
 */
public class FullReductionStrategy implements Strategy {
    @Override
    public BigDecimal getDiscountPrice(BigDecimal price) {
        return price.compareTo(BigDecimal.valueOf(100)) >= 0 ? price.subtract(BigDecimal.valueOf(10)) : price;
    }
}
