package org.example.fruit.factory;

import org.example.fruit.strategy.Strategy;

import java.math.BigDecimal;

/**
 *
 * @author zengfanke
 * @date 2024/5/30
 * @description 策略工厂类
 */
public class StrategyFactory {
    /**
     * 获取策略
     * @param strategyClass 具体策略的class
     * @return 策略
     */
    public static BigDecimal discount(Class<? extends Strategy> strategyClass, BigDecimal price) throws Exception {
        Strategy strategy = strategyClass.newInstance();
        return strategy.getDiscountPrice(price);
    }
}
