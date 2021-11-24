package com.example.ksrabbit;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class Runner implements CommandLineRunner {

    private final Receiver receiver;
    private final RabbitTemplate rabbitTemplate;

    public Runner(Receiver receiver, RabbitTemplate rabbitTemplate) {
        this.receiver = receiver;
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("\n\n\n\n>>>>>>>>");
        System.out.println("\n\n\n\n");

        System.out.println("Sendind message ...");

        for (int i = 0; i < 1000; i++) {
            rabbitTemplate.convertAndSend(KsRabbitApplication.topicExchangeName,
                    "foo.bar.baz", "Hellllo from rabbitmq count " + i);
            receiver.getCountDownLatch().await(10000, TimeUnit.MILLISECONDS);
        }

        System.out.println("\n\n\n\n<<<<<<<<");
    }
}
