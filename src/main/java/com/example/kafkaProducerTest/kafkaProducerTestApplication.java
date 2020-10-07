package com.example.kafkaProducerTest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.lang.invoke.MethodHandles;

@SpringBootApplication
public class kafkaProducerTestApplication {

    private static final Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Autowired
    private Producer producer;

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(kafkaProducerTestApplication.class, args);
        try (ctx) {
            kafkaProducerTestApplication app = ctx.getBean(kafkaProducerTestApplication.class);
            app.run(args);
        } catch (Exception ex) {
            log.error(ex.toString());
        }
	}

	public void run (String[] args) throws Exception{
        producer.kafkaProducer("kafkaTest", "テストです");
    }

}
