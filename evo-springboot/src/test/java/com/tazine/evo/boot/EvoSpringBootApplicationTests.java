package com.tazine.evo.boot;

import com.tazine.evo.boot.beanext.NioCar;
import com.tazine.evo.boot.config.property.EvoProperties;
import com.tazine.evo.boot.config.property.TazineProperties;
import com.tazine.evo.boot.util.ContextUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class EvoSpringBootApplicationTests {

	@Autowired
	private EvoProperties evoProperties;

	@Autowired
	private TazineProperties tazineProperties;

	@Autowired
	private ContextUtil contextUtil;

	@Autowired
	private NioCar nioCar;

	@Test
	public void contextLoads() {
	}

	/**
	 * 测试属性注入-属性注入到类，
	 * 需要在 main 方法上注解 EnableConfigurationProperties
	 */
	@Test
	public void testProperty(){
		System.out.println(evoProperties.getModule());
		System.out.println(evoProperties.getValue());
		System.out.println(evoProperties.getNumber());
		System.out.println(evoProperties.getBignumber());
		System.out.println(evoProperties.getTest1());
		System.out.println(evoProperties.getTest2());
		System.out.println();
		System.out.println(tazineProperties.getEst());
		tazineProperties.getEmployee().forEach(System.out::println);
	}

	@Test
	public void testCtx(){
		ContextUtil.getBeanNamesForAnnotation(Service.class);
	}

	@Test
	public void factoryBeanTest(){
		nioCar.info();
	}
}
