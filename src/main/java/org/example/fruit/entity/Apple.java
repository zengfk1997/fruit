package org.example.fruit.entity;

import java.math.BigDecimal;

/**
 *
 * @author zengfanke
 * @date 2024/5/30
 * @description 苹果
 */
public class Apple extends BaseFruit{
    public Apple() {

    }

    public Apple(BigDecimal price, Double number) {
        super(price, new BigDecimal(number));
    }

    public Apple(BigDecimal price, Double number, BigDecimal discount) {
        super(price, new BigDecimal(number), discount);
    }

}
