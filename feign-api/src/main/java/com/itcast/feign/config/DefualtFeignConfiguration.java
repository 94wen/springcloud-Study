package com.itcast.feign.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;

/**
 * @Author wen
 * @Data 2023/10/13 15:55
 */
public class DefualtFeignConfiguration {
    @Bean
    public Logger.Level feignLogLevel(){
        return Logger.Level.BASIC;
    }
}
