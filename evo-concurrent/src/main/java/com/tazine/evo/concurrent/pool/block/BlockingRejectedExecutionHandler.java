package com.tazine.evo.concurrent.pool.block;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 自定义拒绝策略：阻塞式地将任务添加至工作队列中
 *
 * @author jiaer.ly
 * @date 2020/03/26
 */
public class BlockingRejectedExecutionHandler implements RejectedExecutionHandler {

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.err.println("拒绝方法：" + Thread.currentThread().getName());
        if (!executor.isShutdown()) {
            try {
                // 因为 ThreadPoolExecutor.execute() 最终调用的是 BlockingQueue 的非阻塞的 offer 方法
                executor.getQueue().put(r);
            } catch (InterruptedException e) {
                // 发生异常时继续 execute()，有任务执行完的话就可以放进去了，没有进相当于轮询
                executor.execute(r);
                //e.printStackTrace();
            }
        }
    }
}
