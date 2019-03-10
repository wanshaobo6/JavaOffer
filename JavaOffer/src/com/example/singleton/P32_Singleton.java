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
 * 饿汉式
 * 特点：线程安全，在类初始化执行到静态属性时就分配了资源，会有资源浪费问题
 */
	class Singleton1 {
	
		private Singleton1(){}
		
		private final static Singleton1 singleton1 = new Singleton1();
		
		public static Singleton1 getInstance(){
			return singleton1;
		}
	}
		
/**
 * 懒汉式
 * 特点：非线程安全，在第一次获取实例方法时分配内存，实现了懒加载
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
 * 懒汉式变形，支持线程安全模式
 * 特点：在第一次获取实例方法时分配内存，实现了懒加载。线程安全，但synchronized而造成的阻塞致使效率低，而且很多的阻塞都是没必要的。
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
 * 在懒汉式变形基础上减少了锁的粒度
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
 * 双检锁DCL，支持多线程-懒汉式
 * 特点：线程安全；多进行一次if判断，加入volatile修饰,优点是只有在第一次实例化时加锁，之后不会加锁，提升了效率，缺点写法复杂
 * 不加入volatile，可能出现第一个if判断不为null，但还并未执行构造函数的情况，因为java编译器会进行指令重排;
 * volatile的两大作用:
 * 1防止编译器对被修饰变量相关代码进行指令重排；2读写操作都不会调用工作内存而是直接取主存，保证了内存可见性
 * 指令重排：
 * instance = new Singleton5()可主要分为三步：1分配内存，2调用构造函数，3instance指向被分配的内存（此时instance不为null了）
 * 正常顺序为123，指令重排可能执行顺序为132，会造成已不为null但未执行构造函数的问题
 * 内存可见性：
 * 如果字段是被volatile修饰的，Java内存模型将在写操作后插入一个写屏障指令，在读操作前插入一个读屏障指令。
 * 这意味着：1一旦完成写入，任何访问这个字段的线程将会得到最新的；2在写入前，任何更新过的数据值是可见的，因为内存屏障会把之前的写入值都刷新到缓存。
 * 因此volatile可提供一定的线程安全，但不适用于写操作依赖于当前值的情况，如自增，自减
 * 简单来说，volatile适合这种场景：一个变量被多个线程共享，线程直接给这个变量赋值。
 * 还能在双检锁上进行优化，引入一个局部变量
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
 * 版本六：静态内部类，支持多线程-懒汉式
 * 特点：利用静态内部类（只有在出现它的引用时才被加载），完成懒加载；final保证线程安全;
 * final的作用:
 * 1. 在构造函数内对一个final域的写入，与随后把这个被构造对象的引用赋值给一个引用变量，这两个操作之间不能重排序。
 * 2. 初次读一个包含final域的对象的引用，与随后读这个final域，这两个操作之间不能重排序。
 * 扩展：static变量初始化遵循以下规则:
 * 1.静态变量会按照声明的顺序先依次声明并设置为该类型的默认值，但不赋值为初始化的值。
 * 2.声明完毕后,再按声明的顺序依次设置为初始化的值，如果没有初始化的值就跳过。
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
 * 版本七：通过枚举实现
 * 一个完美的单例需要做到：单例，懒加载，线程安全，防止反序列化产生新对象，防止反射攻击
 * 枚举完全符合上述所有要求，而且实现代码及其简单
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