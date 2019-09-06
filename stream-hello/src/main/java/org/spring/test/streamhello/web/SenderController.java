package org.spring.test.streamhello.web;

import org.spring.test.streamhello.receiver.SinkReceiver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: 谭洋
 * @Date: 2019/9/6 16:22
 */
@RestController
public class SenderController {

    @Autowired
    private Sink sink;

    @Autowired
    private Source source;

    @GetMapping("/send")
    public String send() {
        String msg = "hello stream ...";
        // 将需要发送的消息封装为Message对象
        Message message = MessageBuilder
                .withPayload(msg.getBytes())
                .build();
        sink.input().send(message);
        source.output().send(message);
        return "";
    }
}
