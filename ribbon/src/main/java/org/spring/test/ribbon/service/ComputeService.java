package org.spring.test.ribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

/**
 * @author: tanyang
 * @Date: 2019/8/14 14:28
 */
@Service
public class ComputeService {

    @Autowired
    private RestTemplate restTemplate;

    private Logger logger = Logger.getLogger(ComputeService.class);

    @HystrixCommand(fallbackMethod = "addFallback")
    public String add() {
        logger.info("请求 http://compute-service/add?a=10&b=20");
        return restTemplate.getForEntity("http://compute-service/add?a=10&b=20", String.class).getBody();
    }

    public String addFallback() {
        return "error";
    }
}
