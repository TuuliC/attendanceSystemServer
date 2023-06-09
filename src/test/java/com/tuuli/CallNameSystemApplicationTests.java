package com.tuuli;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.xml.crypto.Data;
import java.sql.Timestamp;
import java.util.Date;

@SpringBootTest
class CallNameSystemApplicationTests {

	@Test
	void contextLoads() {
		// 获取当前时间戳，精确到秒
		System.out.println("new Timestamp(new Date().getTime()) = " + new Timestamp(new Date().getTime()));
	}

}
