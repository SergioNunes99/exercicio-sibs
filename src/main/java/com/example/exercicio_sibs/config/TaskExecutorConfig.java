package com.example.exercicio_sibs.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

@Configuration
public class TaskExecutorConfig {

    //Configurar o taskExecutor
    @Bean(name = "taskExecutor")
    public TaskExecutor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        //nº de threads sempre prontas
        executor.setCorePoolSize(10);
        //nº máximo de threads na pool
        executor.setMaxPoolSize(30);
        //tamanho máximo da queue
        executor.setQueueCapacity(100);
        //prefixo para threads deste ThreadPoolTaskExecutor
        executor.setThreadNamePrefix("Async-");
        //tempo que threads acima do core pool size se mantêm átivas
        executor.setKeepAliveSeconds(60);
        //politica de rejeição, caso numero máximo de threads capacida máxima da queue sejam atingidos
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executor.initialize();

        return executor;
    }
}
