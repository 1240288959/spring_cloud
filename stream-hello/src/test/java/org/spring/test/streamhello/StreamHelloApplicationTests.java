package org.spring.test.streamhello;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StreamHelloApplicationTests {

    @Autowired
    private Sink sink;

    @Autowired
    private Source source;

    @Test
    public void sink() {
        sink.input().send(MessageBuilder.withPayload("From SinkSender").build());
    }

    @Test
    public void source() {
        source.output().send(MessageBuilder.withPayload("From SourceSender").build());
    }

    @Test
    public void contextLoads(){
    }
}
