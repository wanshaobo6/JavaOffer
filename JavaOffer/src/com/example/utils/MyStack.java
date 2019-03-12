package com.example.utils;

import java.util.Arrays;

/**
 * Java����ʵ��ջ
 * @author ���ٲ�
 *
 * @param <E>
 */
public class MyStack<E> {
	//����һ������
	private Object[] elementData;
	
	//����ָ��ջ����ָ��
	private int top;
	
	//����Ԫ����������������
	private final static int capacityIncrement = 10;
	
	//����Ԫ����������������
	private  int initCapacity = 5;
	
	public MyStack() {
		elementData = new Object[initCapacity];
		top = 0;
	}
	
	/**
	 * ����ջ�ĳ���
	 * @return
	 */
	public int length(){
		return top;
	}
	
	/**
	 * ����ջ��Ԫ��  ������ջ
	 * @return
	 */
	public E peek(){
		if(top<1){
			return null;
		}
		return (E) elementData[top-1];
	}
	
	/**
	 * ����ջ��Ԫ�� ��ջ
	 * @return
	 */
	public E pop(){
		E item= peek();
		if(item==null)
			return null;
		elementData[top-1] = null;
		top--;
		return item;
	}
	
	/**
	 * ѹջ
	 * @param item
	 */
	public void push(E item){
		ensureCapacity(top);
		elementData[top] = item;
		top++;
	}
	
	/**
	 * �ж����������Ƿ�������������������ռ�
	 */
	private synchronized void ensureCapacity(int size){
		int nowCapacity = elementData.length;
		//����
		if(nowCapacity==size){
			nowCapacity += capacityIncrement;
			elementData = Arrays.copyOf(elementData, nowCapacity);
		}
	}
	
	public static void main(String[] args) {
		MyStack<Integer> myStack = new MyStack();
	}
}
