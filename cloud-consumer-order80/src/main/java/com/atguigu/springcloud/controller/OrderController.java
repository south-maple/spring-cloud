package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entity.CommonResult;
import com.atguigu.springcloud.lb.LoadBalancer;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

/**
 * (Payment)表控制层
 *
 * @author SouthMaple
 * @since 2021-01-25 11:58:38
 */
@RestController
@RequestMapping("/consumer")
public class OrderController {
    // 单机模式下请求地址可以写死
    // private static final String PAYMENT_URL = "http://localhost:8001";
    // 集群模式，实现负载均衡
    private static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";
    @Resource
    private RestTemplate restTemplate;
    @Resource
    private LoadBalancer loadBalancer;
    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping("/payment/lb")
    public String testMyLB() {
        List<ServiceInstance> instanceList = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if (null == instanceList || instanceList.isEmpty()) {
            return null;
        }
        ServiceInstance instance = loadBalancer.instances(instanceList);
        URI uri = instance.getUri();
        return restTemplate.getForObject(uri + "/payment/lb", String.class);
    }

    @GetMapping("/payment/{id}")
    public CommonResult testRest(@PathVariable Long id) {
        CommonResult r = restTemplate.getForObject(PAYMENT_URL + "/payment/" + id, CommonResult.class);
        return r;
    }

    @GetMapping("/payment/getForEntity/{id}")
    public Object getForEntity(@PathVariable Long id) {
        ResponseEntity<CommonResult> entity = restTemplate.getForEntity(PAYMENT_URL + "/payment/" + id, CommonResult.class);
        return entity.getBody();
    }

}