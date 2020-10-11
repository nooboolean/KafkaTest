package com.example.kafkaProducerTest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.lang.invoke.MethodHandles;

@Component
public class Producer {

    private static final Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Autowired
    KafkaTemplate<String, String> template;

    public void kafkaProducer(String topic, String value){
        log.info("【SendingMessage】 Topic: #{} Value: #{}", topic, value);
        template.send(topic, value).addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
            @Override
            public void onSuccess(SendResult<String, String> result){
                log.info("SendResult: #{}", result);
            }

            @Override
            public void onFailure(Throwable ex) {
                log.error(ex.toString());
            }
        });
    }
}
