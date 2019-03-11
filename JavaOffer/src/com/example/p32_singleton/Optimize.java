package com.example.p32_singleton;
/**
 * 使用synchronized代码块减小锁的粒度，提高性能
 * @author alienware
 *
 */
public class Optimize {
 
	public void doLongTimeTask(){
		try {
				System.out.println("当前线程：" + Thread.currentThread().getName() + 
					", 执行同步代码块，对其同步变量进行操作");
				Thread.sleep(3000);
			System.out.println("当前线程结束：" + Thread.currentThread().getName() +
					", 执行完毕");
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public  void doOtherThing(){
		System.out.println("当前线程：" + Thread.currentThread().getName() + 
				", 执行doOtherThing，对其同步变量进行操作");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	public static void main(String[] args) {
		final Optimize otz = new Optimize();
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				otz.doLongTimeTask();
			}
		},"t1");
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				otz.doOtherThing();
			}
		},"t2");
		t1.start();
		t2.start();
		
	}
	
	
}