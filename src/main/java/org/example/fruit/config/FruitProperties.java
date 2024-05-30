package org.example.fruit.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import java.util.Map;

/**
 *
 * @author zengfanke
 * @date 2024/5/30
 * @description 配置文件数据
 */
@Setter
@Getter
@Configuration
@ConfigurationProperties(prefix = "fruit")
public class FruitProperties {
    private Map<String, String> fruitPriceMap;
}