package com.example.utils;

import java.util.Arrays;

/**
 * Java数组实现栈
 * @author 万少波
 *
 * @param <E>
 */
public class MyStack<E> {
	//定义一个数组
	private Object[] elementData;
	
	//定义指向栈顶的指针
	private int top;
	
	//定义元素容量扩充增加量
	private final static int capacityIncrement = 10;
	
	//定义元素容量扩充增加量
	private  int initCapacity = 5;
	
	public MyStack() {
		elementData = new Object[initCapacity];
		top = 0;
	}
	
	/**
	 * 返回栈的长度
	 * @return
	 */
	public int length(){
		return top;
	}
	
	/**
	 * 返回栈顶元素  但不退栈
	 * @return
	 */
	public E peek(){
		if(top<1){
			return null;
		}
		return (E) elementData[top-1];
	}
	
	/**
	 * 返回栈顶元素 退栈
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
	 * 压栈
	 * @param item
	 */
	public void push(E item){
		ensureCapacity(top);
		elementData[top] = item;
		top++;
	}
	
	/**
	 * 判断数组容器是否已满，若已满则扩充空间
	 */
	private synchronized void ensureCapacity(int size){
		int nowCapacity = elementData.length;
		//扩容
		if(nowCapacity==size){
			nowCapacity += capacityIncrement;
			elementData = Arrays.copyOf(elementData, nowCapacity);
		}
	}
	
	public static void main(String[] args) {
		MyStack<Integer> myStack = new MyStack();
	}
}
