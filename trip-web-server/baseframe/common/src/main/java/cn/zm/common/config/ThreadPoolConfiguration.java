package cn.zm.common.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * 覆盖spring 默认线程池
 *
 * @author Mr_W
 */
@Configuration
@EnableAsync
public class ThreadPoolConfiguration <T> {

	@Value("${spring.application.name}")
	private String applicationName;

	@Bean("EducationThreadPool")
	@ConditionalOnMissingBean(name = "EducationThreadPool")
	public ThreadPoolTaskExecutor threadPoolTaskExecutor() {
		ThreadPoolTaskExecutor pool = new ThreadPoolTaskExecutor();
		// 核心数
		pool.setCorePoolSize(Runtime.getRuntime().availableProcessors() + 1);
		// 最大容量
		pool.setMaxPoolSize(Runtime.getRuntime().availableProcessors() * 2 + 2);
		// 队列容量
		pool.setQueueCapacity(50);
		pool.setThreadNamePrefix(applicationName + "-");
		return pool;
	}

}
