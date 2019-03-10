package com.example.singleton;

public class P32_Singleton {
	public static void main(String[] args) {
		Singleton1 singleton1 = Singleton1.getInstance();
		Singleton2 singleton2 = Singleton2.getInstance();
		Singleton3 singleton3 = Singleton3.getInstance();
		Singleton4 singleton4 = Singleton4.getInstance();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Singleton7.Jack);
	}
}

/**
 * ����ʽ
 * �ص㣺�̰߳�ȫ�������ʼ��ִ�е���̬����ʱ�ͷ�������Դ��������Դ�˷�����
 */
	class Singleton1 {
	
		private Singleton1(){}
		
		private final static Singleton1 singleton1 = new Singleton1();
		
		public static Singleton1 getInstance(){
			return singleton1;
		}
	}
		
/**
 * ����ʽ
 * �ص㣺���̰߳�ȫ���ڵ�һ�λ�ȡʵ������ʱ�����ڴ棬ʵ����������
 */
	class Singleton2 {
		private static Singleton2 singleton2 = null;

		private Singleton2() {
		}

		public static Singleton2 getInstance(){
			if (singleton2 == null) {
				singleton2 = new Singleton2();
			}
			return singleton2;
		}
	}
		
/**
 * ����ʽ���Σ�֧���̰߳�ȫģʽ
 * �ص㣺�ڵ�һ�λ�ȡʵ������ʱ�����ڴ棬ʵ���������ء��̰߳�ȫ����synchronized����ɵ�������ʹЧ�ʵͣ����Һܶ����������û��Ҫ�ġ�
 */
	class Singleton3 {
		private static Singleton3 singleton3 = null;
	
		private Singleton3() {
		}
	
		public static synchronized Singleton3 getInstance() {
			if (singleton3 == null) {
				singleton3 = new Singleton3();
			}
			return singleton3;
		}
	}
/**
 * 
 * ������ʽ���λ����ϼ�������������
 *
 */
	class Singleton4 {
		private static Singleton4 singleton4 = null;
		
		private Singleton4() {
		}
	
		public static  Singleton4 getInstance() {
			synchronized(Singleton4.class){
				if (singleton4 == null) {
					singleton4 = new Singleton4();
				}
			}
			return singleton4;
		}
	}
/**
 * ˫����DCL��֧�ֶ��߳�-����ʽ
 * �ص㣺�̰߳�ȫ�������һ��if�жϣ�����volatile����,�ŵ���ֻ���ڵ�һ��ʵ����ʱ������֮�󲻻������������Ч�ʣ�ȱ��д������
 * ������volatile�����ܳ��ֵ�һ��if�жϲ�Ϊnull��������δִ�й��캯�����������Ϊjava�����������ָ������;
 * volatile����������:
 * 1��ֹ�������Ա����α�����ش������ָ�����ţ�2��д������������ù����ڴ����ֱ��ȡ���棬��֤���ڴ�ɼ���
 * ָ�����ţ�
 * instance = new Singleton5()����Ҫ��Ϊ������1�����ڴ棬2���ù��캯����3instanceָ�򱻷�����ڴ棨��ʱinstance��Ϊnull�ˣ�
 * ����˳��Ϊ123��ָ�����ſ���ִ��˳��Ϊ132��������Ѳ�Ϊnull��δִ�й��캯��������
 * �ڴ�ɼ��ԣ�
 * ����ֶ��Ǳ�volatile���εģ�Java�ڴ�ģ�ͽ���д���������һ��д����ָ��ڶ�����ǰ����һ��������ָ�
 * ����ζ�ţ�1һ�����д�룬�κη�������ֶε��߳̽���õ����µģ�2��д��ǰ���κθ��¹�������ֵ�ǿɼ��ģ���Ϊ�ڴ����ϻ��֮ǰ��д��ֵ��ˢ�µ����档
 * ���volatile���ṩһ�����̰߳�ȫ������������д���������ڵ�ǰֵ����������������Լ�
 * ����˵��volatile�ʺ����ֳ�����һ������������̹߳����߳�ֱ�Ӹ����������ֵ��
 * ������˫�����Ͻ����Ż�������һ���ֲ�����
 */
	class Singleton5 {
		private volatile static Singleton5 singleton5 = null;
		
		private Singleton5() {
		}
	
		public static  Singleton5 getInstance() {
			if(singleton5 == null){
				synchronized(Singleton5.class){
					if (singleton5 == null) {
						singleton5 = new Singleton5();
					}
				}
			}
			return singleton5;
		}
	}
/**
 * �汾������̬�ڲ��֧࣬�ֶ��߳�-����ʽ
 * �ص㣺���þ�̬�ڲ��ֻࣨ���ڳ�����������ʱ�ű����أ�����������أ�final��֤�̰߳�ȫ;
 * final������:
 * 1. �ڹ��캯���ڶ�һ��final���д�룬����������������������ø�ֵ��һ�����ñ���������������֮�䲻��������
 * 2. ���ζ�һ������final��Ķ�������ã����������final������������֮�䲻��������
 * ��չ��static������ʼ����ѭ���¹���:
 * 1.��̬�����ᰴ��������˳������������������Ϊ�����͵�Ĭ��ֵ��������ֵΪ��ʼ����ֵ��
 * 2.������Ϻ�,�ٰ�������˳����������Ϊ��ʼ����ֵ�����û�г�ʼ����ֵ��������
 */
	class Singleton6{
		private Singleton6(){}
		public static Singleton6 getInstance(){
			return SingletonHolder.instance;
		}
		private static class SingletonHolder{
			public static final Singleton6 instance = new Singleton6();
		}
	}
	
/**
 * �汾�ߣ�ͨ��ö��ʵ��
 * һ�������ĵ�����Ҫ�����������������أ��̰߳�ȫ����ֹ�����л������¶��󣬷�ֹ���乥��
 * ö����ȫ������������Ҫ�󣬶���ʵ�ִ��뼰���
 */
	enum Singleton7{
		Jack("i am Jack")
		;
		private String name ;
		
		private Singleton7() {
		}
		
		private Singleton7(String name) {
			System.out.println("I Born");
			this.name = name;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		} 
		
	}