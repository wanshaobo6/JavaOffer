package com.example2.p65_stackWithMin;

import java.util.Stack;

/**
 * ����min������ջ  ����ʵ�ַ�ʽ  ������ջ����Ϊ32123 ��minջ32111 
 * <p>
 * ����ջ�����ݽṹ�����ڸ�������ʵ��һ���ܹ��õ�ջ����СԪ�ص�min������
 * Ҫ���ڸ�ջ�У�����min��push��pop��ʱ�临�Ӷȶ���o(1)��
 *
 */
class StackWithMin2<T extends Comparable> {
	private Stack<T> stackData = new Stack();
	private Stack<T> stackMin = new Stack();

	public void push(T data) {
		stackData.push(data);
		if (stackMin.isEmpty()) {
			stackMin.push(data);
		} else {
			T temp = stackMin.peek();
			if (temp.compareTo(data) < 0) {
				stackMin.push(temp);
			} else {
				stackMin.push(data);
			}
		}
	}

	public T pop() {
		if (stackData.isEmpty()) {
			return null;
		}
		stackMin.pop();
		return stackData.pop();
	}

	public T min() {
		if (stackMin.isEmpty()) {
			return null;
		}
		return stackMin.peek();
	}

}

public class P165_StackWithMin {
	public static void main(String[] args) {
		StackWithMin2<Integer> stack = new StackWithMin2();
		stack.push(3);
		stack.push(4);
		stack.push(2);
		stack.push(1);
		System.out.println(stack.min());
		stack.pop();
		System.out.println(stack.min());
		stack.pop();
		System.out.println(stack.min());
		stack.pop();
		System.out.println(stack.min());
		stack.pop();
		System.out.println(stack.min());
	}
}
