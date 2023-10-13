package cn.itcast.user.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @Author wen
 * @Data 2023/10/11 20:42
 */
@Data
@Component
@ConfigurationProperties(prefix="pattern")
public class PatternProperties {
    private String dateformat;
}
