package com.example.p69_queueMadeOfTwoStack;

import com.example.utils.MyStack;

/**
 * ������ջʵ�ֶ���
 * <p>
 * ��1�����ڲ��������ջ����ж��ǴӶ�β���У����һ�д���Ϳ������push()
 * ��2�����ڵ��������������Ƚ��ȳ��Ӷ�ͷ��ʼ����ջ����ȳ��Ӷ�β��ʼ��
 * Ҫ��ȡ����ͷԪ�أ��͵���Ҫ�ڶ���ջstack2��Э��������ʱ��stack1��Ԫ������ȡ���ŵ�stack2��
 * ��ʱstack2���е�����˳������������еĵ���˳�򡣶������Ҫ���룬�ŵ�stack1�м��ɡ�
 * �ܽ�:stack1������룬stack2���𵯳������stack2Ϊ���ˣ���stack1��Ԫ�����ε�������ŵ�stack2�У�֮���stack2���е�������
 *
 */
public class queueMadeOfTwoStack {
	public static void main(String[] args) {
		MyQueueMadeOfTwoStack<Integer> queue = new MyQueueMadeOfTwoStack();
		queue.push(11);
		queue.push(2);
		queue.push(3);
		System.out.println("queue.pop() = " + queue.pop());
		System.out.println("queue.pop() = " + queue.pop());
		System.out.println("queue.pop() = " + queue.pop());
	}

}
class MyQueueMadeOfTwoStack<E>{
	private MyStack<E> stack1 = new MyStack();
	private MyStack<E> stack2 = new MyStack();
	
	public void push(E item){
		stack1.push(item);
	}
	
	public E pop(){
		if(stack2.length() <=0){
			while(stack1.length()>0){
				E item = stack1.pop();
				stack2.push(item);
			}
		}
		return stack2.pop();
	}
}
