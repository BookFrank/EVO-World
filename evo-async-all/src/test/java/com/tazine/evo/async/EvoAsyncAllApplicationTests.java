package com.tazine.evo.async;

import com.tazine.evo.async.spring.AsyncService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 异步 Tests
 *
 * @author frank
 * @date 2018/09/15
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class EvoAsyncAllApplicationTests {

	@Autowired
	private AsyncService asyncService;

	@Test
	public void contextLoads() {
	}

	@Test
	public void syncTest(){
		asyncService.syncRun(1);
	}

	@Test
	public void asyncTest() throws InterruptedException {
		System.out.println("threadName : " + Thread.currentThread().getName());
		asyncService.asyncRun(1);
		System.out.println("threadName : " + Thread.currentThread().getName());

		Thread.currentThread().join();
	}
}
