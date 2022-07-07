package cn.zm.common.utils;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

public class ConcurrentUtils{
    /**
     * 获取并发任务执行器
     * @param supplier
     * @param threadPoolTaskExecutor
     * @return
     */
    public static CompletableFuture getFuture(Supplier supplier, ThreadPoolTaskExecutor threadPoolTaskExecutor) {
        CompletableFuture future = CompletableFuture.supplyAsync(supplier, threadPoolTaskExecutor);
        return future;
    }
}
