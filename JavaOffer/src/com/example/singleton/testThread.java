package com.example.singleton;

import java.util.HashSet;
import java.util.Set;

/**
 * ��������ʽ�����Ĳ���ȫ
 * @author ���ٲ�
 *
 */
public class testThread implements Runnable{
	private Set<Singleton2> Singleton2s = new HashSet();
	
	

	public Set<Singleton2> getSingleton2s() {
		return Singleton2s;
	}

	public void setSingleton2s(Set<Singleton2> singleton2s) {
		Singleton2s = singleton2s;
	}

	public void run() {
		// TODO Auto-generated method stub
		Singleton2s.add(Singleton2.getInstance());
	}
	
	public static void main(String[] args) {
		testThread t = new testThread();
		new Thread(t).start();
		new Thread(t).start();
		new Thread(t).start();
		new Thread(t).start();
		new Thread(t).start();
		new Thread(t).start();
		new Thread(t).start();
		new Thread(t).start();
		new Thread(t).start();
		new Thread(t).start();
		new Thread(t).start();
		new Thread(t).start();
		new Thread(t).start();
		new Thread(t).start();
		
		System.out.println(t.getSingleton2s());
	}
}
