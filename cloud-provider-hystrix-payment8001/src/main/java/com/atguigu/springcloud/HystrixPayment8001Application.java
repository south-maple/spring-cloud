package com.atguigu.springcloud;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;

/**
 * @author South Maple
 * @date 2021-1-27 13:30:52
 */
@SpringBootApplication
@EnableCircuitBreaker   // SpringCloud中使用断路器，需要加上此注解
public class HystrixPayment8001Application {
    public static void main(String[] args) {
        SpringApplication.run(HystrixPayment8001Application.class, args);
    }

    /**
     * 此配置是为了服务监控而配置，与服务器容错本身无关，springcloud升级后的坑
     * ServletRegistrationBean因为springboot的默认路径不是/hystrix.stream
     * 只要在自己的项目里配置上下文的servlet就可以了
     */
    @Bean
    public ServletRegistrationBean getservlet() {
        HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean<HystrixMetricsStreamServlet> registrationBean = new ServletRegistrationBean<>(streamServlet);
        registrationBean.setLoadOnStartup(1);
        registrationBean.addUrlMappings("/hystrix.stream");
        registrationBean.setName("HystrixMetricsStreamServlet");
        return registrationBean;
    }
}
