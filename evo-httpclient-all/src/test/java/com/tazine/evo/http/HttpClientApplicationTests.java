package com.tazine.evo.http;

import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class HttpClientApplicationTests {

	@Test
	public void contextLoads() {
		System.out.println("hello world");
	}

	@Test
	public void okHttpTest() throws Exception {
		okHttp();
	}

	private void okHttp() throws InterruptedException {
		String url = "http://www.baidu.com";
		OkHttpClient client = new OkHttpClient();
		Request request = new Request.Builder()
			.url(url)
			.get()  //默认为GET请求，可以不写
			.build();
		final Call call = client.newCall(request);
		call.enqueue(new Callback() {
			@Override
			public void onFailure(Call call, IOException e) {
				log.error("onFailure: " + e);
			}

			@Override
			public void onResponse(Call call, Response response) throws IOException {
				log.info("OnResponse: " + response.body().toString());
				System.out.println(response.body().string());
			}
		});
		System.out.println("haha");
		Thread.sleep(10000);
	}
}
