package org.example.fruit.entity;

import java.math.BigDecimal;

/**
 *
 * @author zengfanke
 * @date 2024/5/30
 * @description 水果
 */
public interface Fruit {
    /**
     * 水果价格
     * @return BigDecimal
     */
    BigDecimal getPrice();
}
