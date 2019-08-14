package org.spring.test.feign.hystrix;

import org.spring.test.feign.web.ComputeClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author: tanyang
 * @Date: 2019/8/14 15:10
 */
@Component
public class ComputeClientHystrix implements ComputeClient {
    @Override
    public Integer add(Integer a, Integer b) {
        return -9999;
    }
}
