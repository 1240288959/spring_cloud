package org.spring.test.stream.group.sender.sender;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.core.MessageSource;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.GenericMessage;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: 谭洋
 * @Date: 2019/10/9 20:32
 */
@EnableBinding(value = {Source.class})
public class SinkSender {

    private static Logger logger = LoggerFactory.getLogger(SinkSender.class);

    @Bean
    @InboundChannelAdapter(value = Source.OUTPUT, poller = @Poller(fixedDelay = "5000"))
    public MessageSource<Date> timerMessageSource() {
        return new MessageSource<Date>() {
            @Override
            public Message receive() {
                Map<String, Object> map = new HashMap<>();
                map.put("partitionKey", 1);
                Message message = new GenericMessage<>(new Date(), map);
                return message;
            }
        };
    }

}
