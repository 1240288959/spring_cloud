package org.spring.test.eureka_client.control;


import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

@RestController
public class ComputeController {
    private final Logger logger = Logger.getLogger(getClass());

    @Autowired
    private DiscoveryClient client;

    @Value("${spring.application.name}")
    private String serviceId;

    @Value("${server.port}")
    private String port;

    @GetMapping("/add")
    public Integer add(int a, int b) {
        InetAddress address = null;
        try {
            address = Inet4Address.getLocalHost();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        /*List<String> services = client.getServices();
        int order = client.getOrder();
        List<ServiceInstance> instances = client.getInstances("compute-service");
        ServiceInstance instance = instances.get(order);*/

        int r = a + b;
        logger.info("/add, host:" + address.getHostAddress() + ", port:" + port + ", service_id:" +
                serviceId + ", result:" + r);
        return r;
    }
}
