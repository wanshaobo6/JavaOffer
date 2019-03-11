package com.example.p32_singleton;
/**
 * ʹ��synchronized������С�������ȣ��������
 * @author alienware
 *
 */
public class Optimize {
 
	public void doLongTimeTask(){
		try {
				System.out.println("��ǰ�̣߳�" + Thread.currentThread().getName() + 
					", ִ��ͬ������飬����ͬ���������в���");
				Thread.sleep(3000);
			System.out.println("��ǰ�߳̽�����" + Thread.currentThread().getName() +
					", ִ�����");
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public  void doOtherThing(){
		System.out.println("��ǰ�̣߳�" + Thread.currentThread().getName() + 
				", ִ��doOtherThing������ͬ���������в���");
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