package org.spring.test.eureka_client.control;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: tanyang
 * @Date: 2019/8/15 12:17
 */
@RestController
public class FromController {

    @Value("${from}")
    private String from;

    @RequestMapping(value = "/from")
    public String getFrom() {
        return from;
    }
}
