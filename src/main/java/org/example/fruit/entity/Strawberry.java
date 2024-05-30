package org.example.fruit.entity;

import java.math.BigDecimal;

/**
 *
 * @author zengfanke
 * @date 2024/5/30
 * @description 草莓
 */
public class Strawberry extends BaseFruit{
    public Strawberry() {

    }

    public Strawberry(BigDecimal price, Double number) {
        super(price, new BigDecimal(number));
    }

    public Strawberry(BigDecimal price, Double number, BigDecimal discount) {
        super(price, new BigDecimal(number), discount);
    }

}
