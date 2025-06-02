package com.itc.restclient.config;

import java.util.concurrent.Executor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
@EnableAsync
public class AsybcConfiguration {
	@Bean("CSVAsync")
	 Executor asyncConfiguration()
	{
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(15); // Minimum threads will run.
		executor.setMaxPoolSize(100); // Maximum threads will execute.
		executor.setQueueCapacity(4); // waiting threads 
		executor.setThreadNamePrefix("csvAsyncProcessor");
		executor.initialize();
		return executor;
	}
	
	/*
	 * 15 
	 * 15 jobs running
	 * 
	 * 
	 * 
	 * 
	 */
	
}
