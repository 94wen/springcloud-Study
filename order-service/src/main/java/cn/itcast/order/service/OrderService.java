package cn.itcast.order.service;


import cn.itcast.order.mapper.OrderMapper;
import cn.itcast.order.pojo.Order;
import com.itcast.feign.clients.UserClient;
import com.itcast.feign.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;
//    @Autowired
//    private RestTemplate restTemplate;

    @Autowired
    private UserClient userClient;

    public Order queryOrderById(Long orderId) {
        // 1.查询订单
        Order order = orderMapper.findById(orderId);
        // 2.用feign
        User user = userClient.findById(order.getUserId());
        // 4.返回
        order.setUser(user);
        return order;
    }
//    public Order queryOrderById(Long orderId) {
//        // 1.查询订单
//        Order order = orderMapper.findById(orderId);
//        // 2.利用restTemplate发送http请求，查询用户
//        User user = restTemplate.getForObject(url,User.class);
//        // 4.返回
//        order.setUser(user);
//        return order;
//    }
}
