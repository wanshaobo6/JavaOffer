package com.example.p48_String;

public class TestString {
	public static void main(String[] args) {
		testConstStringMemory();
	}
	/**
	 * ����String�ַ���
	 * String��Ĵ洢��ͨ��final���ε�char[]��������Ž���� ��https://www.cnblogs.com/ytjava/p/7360109.html
	 */
	public static void testConstStringMemory(){
		/*String hello1 = "hello world";
		String hello2 = "hello world";
		System.out.println(hello1 == hello2);
		//ÿ�ζ�String�����޸� ����������һ����ʱ�Ķ��� ����̫��Ӱ��Ч��
		hello1 += "!!!";
		System.out.println(hello1 == hello2);
		
		StringBuffer hello3 = new StringBuffer("hello world");
		StringBuffer hello4 = hello3;
		System.out.println(hello3 == hello4);
		hello3.append("!!!");
		System.out.println(hello3 == hello4);
		System.out.println(hello3);
		System.out.println(hello4);*/
		
		String text = new String("hello");
		modifyString(text);
		System.out.println(text);  //hello
		
		people people1 = new people("Jack");
		modifyPeople(people1);
		System.out.println(people1);  //rose
		
		people people3 = new people("Jack");
		newPeople(people3);
		System.out.println(people3);  //rose
	}
	
	 static void newPeople(people people2) {
		// TODO Auto-generated method stub
		 people2 = new people("rose");
	}
	static void modifyPeople(people people) {
		// TODO Auto-generated method stub
		  people.setName("rose");
		
	}
	static void modifyString(String text){
		text= "world";
	}
	
	static class people{
		private String name;
		
		
		
		public String toString() {
			return "people [name=" + name + "]";
		}

		public people() {
		}

		public people(String name) {
			super();
			this.name = name;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
		
	}
}
