package com.example;

//import com.example.rs.v1.DemoClient;
//import com.example.rs.v1.DemoResource;

import org.junit.ClassRule;
import org.junit.Test;
import org.testcontainers.containers.GenericContainer;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
@ContextConfiguration(/*initializers = DemoApplicationTests.Docker.class,*/ classes = {DemoApplication.class} /*value = "DemoApplication"*/)
@RunWith(SpringRunner.class)
public class UnicornTests {

	@Value("${local.server.port}")
	protected int port;

    @ClassRule
    public static GenericContainer postgres = new GenericContainer("postgres:9.6-alpine").withExposedPorts(5432);

    @ClassRule
    public static GenericContainer app = new GenericContainer("springio/unicorn:latest")/*.withExposedPorts(5432)*/;


    @Test
	public void contextLoads() {
//		DemoResource sut = DemoClient.builder()
//                .url("http://localhost:" + port + "/api/v1")
//                .build();

        //System.out.println(port);
//        System.out.println(sut.info().get());

	}

//	public static class Docker implements ApplicationContextInitializer<ConfigurableApplicationContext> {
//
//        @Override
//        public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
//            // TODO: add mapped port to spring context
//        }
//    }

}
