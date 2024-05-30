package org.example.fruit.entity;

import lombok.Data;

import java.math.BigDecimal;

/**
 *
 * @author zengfanke
 * @date 2024/5/30
 * @description 水果基类
 */
@Data
public class BaseFruit implements Fruit{
    /**
     * 水果价格/斤
     */
    protected BigDecimal price;

    /**
     * 水果斤数
     */
    protected BigDecimal number;

    /**
     * 水果折扣
     */
    protected BigDecimal discount;

    public BaseFruit() {

    }

    public BaseFruit(BigDecimal price, BigDecimal number) {
        this.price = price;
        this.number = number;
        this.discount = BigDecimal.ONE;
    }

    public BaseFruit(BigDecimal price, BigDecimal number, BigDecimal discount) {
        this.price = price;
        this.number = number;
        this.discount = discount;
    }

    /**
     * @return 水果的总价
     */
    @Override
    public BigDecimal getPrice(){
        return this.price.multiply(this.number).multiply(this.discount);
    }

}
