package org.example.fruit.service;

import org.example.fruit.entity.Apple;
import org.example.fruit.entity.Fruit;
import org.example.fruit.entity.Mango;
import org.example.fruit.entity.Strawberry;
import org.example.fruit.factory.FruitFactory;
import org.example.fruit.factory.StrategyFactory;
import org.example.fruit.strategy.FullReductionStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;

@Service
public class FruitCostService {
    @Autowired
    private FruitFactory factory;

    /**
     * 校验参数有效性
     * @param params 参数数组
     */
    private void checkParameter(double... params) {
        for (double v : params) {
            if (v < 0) {
                throw new RuntimeException("数量仅为正数，不能为负数");
            }
        }
    }

    private BigDecimal totalPrice(Fruit...fruit){
        return Arrays.stream(fruit).map(Fruit::getPrice).reduce(BigDecimal.ZERO, BigDecimal::add).setScale(2, RoundingMode.HALF_UP);
    }

    /**
     * 第一个问题
     * 购买苹果和草莓总金额
     * @param appleNum 苹果斤数
     * @param strawberryNum 草莓斤数
     * @return 总价格
     */
    public BigDecimal firstQuestion(double appleNum, double strawberryNum) throws Exception {
        checkParameter(appleNum, strawberryNum);
        return totalPrice(factory.genFruitBean(Apple.class, appleNum),
                factory.genFruitBean(Strawberry.class, strawberryNum));
    }

    /**
     * 第二个问题
     * 购买苹果、草莓和芒果总金额
     * @param appleNum 苹果斤数
     * @param strawberryNum 草莓斤数
     * @param mangoNum 芒果重量
     * @return 总价格
     */
    public BigDecimal secondQuestion(double appleNum, double strawberryNum, double mangoNum) throws Exception {
        checkParameter(appleNum, strawberryNum, mangoNum);
        return totalPrice(factory.genFruitBean(Apple.class, appleNum),
                factory.genFruitBean(Strawberry.class, strawberryNum),
                factory.genFruitBean(Mango.class, mangoNum));
    }

    /**
     * 第三个问题
     * 购买苹果、有折扣草莓和芒果总金额
     * @param appleNum 苹果斤数
     * @param strawberryNum 草莓斤数
     * @param mangoNum 芒果斤数
     * @param strawberryDiscount 草莓折扣
     * @return 总金额
     */
    public BigDecimal thirdQuestion(double appleNum, double strawberryNum, double mangoNum,
                                                     double strawberryDiscount) throws Exception {
        checkParameter(appleNum, strawberryNum, mangoNum);
        return totalPrice(factory.genFruitBean(Apple.class, appleNum),
                factory.genFruitBean(Strawberry.class, strawberryNum, strawberryDiscount),
                factory.genFruitBean(Mango.class, mangoNum));
    }

    /**
     * 第四个问题
     * 购买苹果、草莓和芒果,有促销满减方案
     * @param appleNum 苹果斤数
     * @param strawberryNum 草莓斤数
     * @param mangoNum 芒果斤数
     * @return BigDecimal 总金额
     */
    public BigDecimal fourthQuestion(double appleNum, double strawberryNum, double mangoNum) throws Exception {
        checkParameter(appleNum, strawberryNum, mangoNum);
        return StrategyFactory.discount(FullReductionStrategy.class,
                totalPrice(factory.genFruitBean(Apple.class, appleNum),
                factory.genFruitBean(Strawberry.class, strawberryNum),
                factory.genFruitBean(Mango.class, mangoNum)));
    }

}
