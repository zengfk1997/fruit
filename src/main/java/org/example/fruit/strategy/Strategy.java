package org.example.fruit.strategy;

import java.math.BigDecimal;

/**
 *
 * @author zengfanke
 * @date 2024/5/30
 * @description 策略
 */
public interface Strategy {
    /**
     * 获取水果策略后的价额
     * @return BigDecimal
     */
    BigDecimal getDiscountPrice(BigDecimal price);
}
