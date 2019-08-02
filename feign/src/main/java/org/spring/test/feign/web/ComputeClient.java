package org.spring.test.feign.web;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("compute-service")
public interface ComputeClient {

    @RequestMapping(method = RequestMethod.GET, value = "/add")
    Integer add(@RequestParam("a") Integer a, @RequestParam("b") Integer b);
}
