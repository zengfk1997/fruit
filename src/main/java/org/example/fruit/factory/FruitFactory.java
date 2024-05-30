package org.example.fruit.factory;

import org.example.fruit.config.FruitProperties;
import org.example.fruit.entity.Fruit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Constructor;
import java.math.BigDecimal;
import java.util.Map;

/**
 *
 * @author zengfanke
 * @date 2024/5/30
 * @description 水果工厂类
 */
@Component
public class FruitFactory {
    @Autowired
    private FruitProperties fruitProperties;

    /**
     * 获取水果实体
     * @param fruitClass 具体水果的class
     * @param number 数量
     * @return 水果实体
     */
    public Fruit genFruitBean(Class<? extends Fruit> fruitClass, double number) throws Exception {
        Map<String, String> fruitMap = fruitProperties.getFruitPriceMap();
        String price = fruitMap.get(fruitClass.getSimpleName());
        if (price == null || price.isEmpty()) {
            return null;
        }
        Constructor<?> constructor = fruitClass.getConstructor(BigDecimal.class, Double.class);
        return (Fruit) constructor.newInstance(new BigDecimal(price), number);
    }

    /**
     * 获取水果实体
     * @param fruitClass 具体水果的class
     * @param number 数量
     * @param discount 折扣
     * @return 水果实体
     */
    public Fruit genFruitBean(Class<? extends Fruit> fruitClass, double number, double discount) throws Exception{
        Map<String, String> fruitMap = fruitProperties.getFruitPriceMap();
        String price = fruitMap.get(fruitClass.getSimpleName());
        if (price == null || price.isEmpty()) {
            return null;
        }
        Constructor<?> constructor = fruitClass.getConstructor(BigDecimal.class, Double.class, BigDecimal.class);
        return (Fruit) constructor.newInstance(new BigDecimal(price), number, new BigDecimal(discount));
    }
}
