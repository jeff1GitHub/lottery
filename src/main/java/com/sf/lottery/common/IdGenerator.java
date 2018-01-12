package com.sf.lottery.common;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Component;

@Component
public class IdGenerator {
	/** 序号 */
	private final AtomicInteger serialNumber = new AtomicInteger(0);
	/** 上次生成Id时间 */
	private String beforCreateIdTime;
	
	/**
	 * 此方法每秒最多产生99999个Id值
	 * @return id
	 */
	public synchronized long createId() throws Exception {
		DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
		String time = timeFormatter.format(LocalDateTime.now());
		if(time.equals(beforCreateIdTime)){
			if(serialNumber.get() < 100000){
				long id = Long.parseLong(time) * 100000 + serialNumber.incrementAndGet();
				return id;
			}else{
				Thread.sleep(1000);
				return createId();
			}
		}else{
			this.beforCreateIdTime = time;
			this.serialNumber.set(0);
			long id = Long.parseLong(time) * 100000 + serialNumber.incrementAndGet();
			return id;
		}
	}
	
}
