package com.bjsxt.test;

import org.apache.log4j.Logger;

public class TestLog4j {
	public static void main(String[] args) {
		//获取日志对象
		Logger logger = Logger.getLogger(TestLog4j.class);
		
		//五个日志级别分别对应5个输出方法，名与级别一致
		logger.fatal("系统崩溃");
		logger.error("发生错误");
		logger.warn("警告");
		logger.info("消息");
		logger.debug("调试");
		
	}
}
