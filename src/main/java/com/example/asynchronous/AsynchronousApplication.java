package com.example.asynchronous;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@SpringBootApplication
@EnableAsync
public class AsynchronousApplication {

    public static void main(String[] args) {
        SpringApplication.run(AsynchronousApplication.class, args);
    }

    @Bean(name = "threadExecutor")
    public Executor threadExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
//        executor.setCorePoolSize(1);
//        executor.setMaxPoolSize(1);
//        executor.setQueueCapacity(500);
//        executor.initialize();
        return executor;
    }
}
