package com.sf.lottery;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.sf.lottery.common.IdGenerator;
import com.sf.lottery.utils.Tools;

public class Test {
	
	public void a(){
		IdGenerator tt = new IdGenerator();
		
		ExecutorService es = Executors.newCachedThreadPool();
		for(int i=50; i>0; --i){
			es.execute(() -> {
				try {
					for(int j=100000; j>0; --j){
						System.out.println(tt.createId());
						Thread.sleep(1);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			});
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		for(int i=100; i>0; --i) System.out.println(Tools.getRandomNum(5, 10));
		
	}
	
}
