package com.example.kafkaProducerTest;

import com.example.kafkaProducerTest.domain.TestSerializerDomain;
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
        TestSerializerDomain testUser = new TestSerializerDomain();
        testUser.setUserId(1);
        testUser.setName("仲澤義広");
        testUser.setNote("テストテスト");
        producer.kafkaProducer("kafkaTest", testUser);
    }

}
