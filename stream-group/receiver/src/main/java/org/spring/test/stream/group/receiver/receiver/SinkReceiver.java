package org.spring.test.stream.group.receiver.receiver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

import java.util.Date;

/**
 * @Author: 谭洋
 * @Date: 2019/10/9 20:02
 */
@EnableBinding(value = {Sink.class})
public class SinkReceiver {

    private static final Logger logger = LoggerFactory.getLogger(SinkReceiver.class);

    @StreamListener(Sink.INPUT)
    public void receive(Date date) {
        logger.info(date.toString());
    }

    /*@StreamListener(Sink.INPUT)
    public void receive(String message) {
        logger.info(message);
    }*/

}
