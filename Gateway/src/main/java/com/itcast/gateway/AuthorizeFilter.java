package com.itcast.gateway;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @Author wen
 * @Data 2023/10/13 21:02
 */
@Order(-1) //过滤器排序
@Component
public class AuthorizeFilter implements GlobalFilter {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        //获取请求参数
        MultiValueMap<String, String> params = exchange.getRequest().getQueryParams();
        //获取authorization参数
        String auth = params.getFirst("authorization");
        //校验
        if ("admin".equals(auth)){
            //放行
            return chain.filter(exchange);
        }
        //拦截，禁止访问
        exchange.getResponse().setStatusCode(HttpStatus.FORBIDDEN);
        //结束处理
        return exchange.getResponse().setComplete();
    }
}
