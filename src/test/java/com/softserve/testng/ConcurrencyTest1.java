package com.softserve.testng;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ConcurrencyTest1 {
	private Map<String, String> data;

	@BeforeClass
	void setUp() throws Exception {
		data = new HashMap<String, String>();
	}

	@AfterClass
	void tearDown() throws Exception {
		data = null;
	}

	//@Test(threadPoolSize = 2, invocationCount = 3, invocationTimeOut = 10000)
	@Test(threadPoolSize = 3, invocationCount = 3, invocationTimeOut = 10000)
	public void testMapOperations() throws Exception {
		//
		long id = Thread.currentThread().getId();
		String ids = String.valueOf(id);
		//
		data.put("thread id: " + ids, "  " + ids + " time: "+ String.valueOf(System.currentTimeMillis()));
		data.put("thread id: " + ids + "-2", "  " + ids);
		data.put("thread id: " + ids + "-3", "  " + ids);
		//
		for (Map.Entry<String, String> entry : data.entrySet()) {
			System.out.println(entry);
			//Thread.sleep(1);
		}
		data.clear();
	}
}