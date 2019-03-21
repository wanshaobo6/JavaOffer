package com.example2.p65_stackWithMin;

public class test {
	public static void main(String[] args) {
		/*StackWithMin<Integer> myStack = new StackWithMin();
		for (int i = 0; i < 20; i++) {
			int val = (int) (Math.random()*100+1);
			System.out.println("val"+val);
			myStack.push(val);
			System.out.println("min"+myStack.min());
		}
		myStack.push(1);
		System.out.println(myStack.min());
		myStack.push(1);
		System.out.println(myStack.min());
		myStack.pop();
		System.out.println(myStack.min());
		myStack.pop();
		System.out.println(myStack.min());*/
		
		StackWithMin<People> myStack = new StackWithMin();
		People people1 = new People();
		people1.setName("bobo");
		people1.setAge(21);
		People people2 = new People();
		people2.setName("dabobo");
		people2.setAge(22);
		myStack.push(people2);
		System.out.println(myStack.min());
		myStack.push(people1);
		System.out.println(myStack.min());
		myStack.pop();
		System.out.println(myStack.min());
	}

}
