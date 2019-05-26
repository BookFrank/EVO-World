package com.tazine.evo.boot;

import com.tazine.evo.boot.util.redlock.SimpRedLock;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 分布式锁测试
 *
 * @author frank
 * @date 2019/05/24
 */
@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class RedisLockTest {

    @Autowired
    private SimpRedLock simpRedLock;

    @Test
    public void testLockOne() {
        String prod = "IPhoneXI";

        new Thread(() -> processSecKill(prod)).start();
        new Thread(() -> processSecKill(prod)).start();
        new Thread(() -> processSecKill(prod)).start();
        new Thread(() -> processSecKill(prod)).start();
        new Thread(() -> processSecKill(prod)).start();

        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.err.println("main 线程执行完成");
    }

    private void processSecKill(String product) {
        String lockKey = "lock." + product;
        String lockVal = Thread.currentThread().getName() + "-" + product;

        log.info(lockKey + " ---------------");
        // 加锁
        while (!simpRedLock.lock(lockKey, lockVal)) {
            try {
                Thread.sleep(500);
                System.err.println("   " + lockVal + " 尝试获取锁");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("  " + lockVal + " 执行业务逻辑...");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        simpRedLock.unlock(lockKey, lockVal);
    }
}
