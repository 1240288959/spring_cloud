package org.spring.test.streamhello.receiver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.handler.annotation.SendTo;

/**
 * @Author: 谭洋
 * @Date: 2019/9/6 17:24
 */
@EnableBinding({Source.class, Sink.class})
public class SinkReceiver {

    private Logger log = LoggerFactory.getLogger(SinkReceiver.class);

    @StreamListener(Sink.INPUT)
    @SendTo(Source.OUTPUT)
    public Object processInput(String message) {
        log.info("Input Stream Receiver:{}", message);
        return message;
    }

    @StreamListener(Source.OUTPUT)
    public void processOutPut(String message) {
        log.info("Output Stream Receiver:{}", message);
    }
}
