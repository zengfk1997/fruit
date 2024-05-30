package org.example.fruit.entity;

import java.math.BigDecimal;

/**
 *
 * @author zengfanke
 * @date 2024/5/30
 * @description 芒果
 */
public class Mango extends BaseFruit{
    public Mango() {

    }

    public Mango(BigDecimal price, Double number) {
        super(price, new BigDecimal(number));
    }

    public Mango(BigDecimal price, Double number, BigDecimal discount) {
        super(price, new BigDecimal(number), discount);
    }

}
