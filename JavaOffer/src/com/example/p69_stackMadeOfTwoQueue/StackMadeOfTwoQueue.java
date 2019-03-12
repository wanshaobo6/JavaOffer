package com.example.p69_stackMadeOfTwoQueue;

import java.util.LinkedList;
import java.util.Queue;
/**
 * ����������ʵ��ջ
 * <p>
 * (1�����ڲ��������ջ����ж��ǴӶ�β���У���˺�������ɡ�����һ��Ҫ��֤��һ�������ǿյ�
 *��2�����ڵ������������дӶ�ͷ��ʼ����ջ�Ӷ�β��ʼ��Ҫ��ȡ����βԪ�أ���Ҫ�ڶ������е�Э����
 * ����queue1��Ϊ�գ�queue2Ϊ�գ���queue1��ԭ������ȡ���ŵ�queue2�У�ͬʱ�жϣ���queue1�ĳ���Ϊ1ʱ����Ҫ����Ԫ�طŵ�queue2�У�����ֱ��ȡ����������ʱ�������ջ�ĵ�������
 * Ҳ����˵������һ��Ԫ�أ�����Ԫ�صĴ洢λ�þͻ�ӱ������ƶ�����һ�������С�
 * <p>
 * ���������У�queue��queue2һ������һ��Ϊ�ա��������ѡ��queue1��queue2�в�Ϊ�յ��Ǹ����в��루�����Ϊ�գ�����ѡ��һ����
 * ����ʱ����Ϊ�յĶ��г����һ�����е�����Ԫ������ȡ���ŵ���һ�������У����������һ��Ԫ��ȡ����������
 */
public class StackMadeOfTwoQueue {
	public static void main(String[] args) {
		MyStackMadeOfTwoQueue<Integer> myStack = new MyStackMadeOfTwoQueue();
		myStack.push(1);
		myStack.push(2);
		myStack.push(3);
		System.out.println(myStack.pop());
		System.out.println(myStack.pop());
		myStack.push(4);
		System.out.println(myStack.pop());
		System.out.println(myStack.pop());
		System.out.println(myStack.pop());
	}
}
/**
 * ���Բ�����pointָ��  ��Ϊһʱ��������һ������Ϊ�� ��������ȫ������һ���յĴ洢���� ����һ���ǿմ洢 
 *  * @author ���ٲ�
 *
 * @param <E>
 */
class MyStackMadeOfTwoQueue<E>{
	private Queue<E> queue1 = new LinkedList();
	private Queue<E> queue2 = new LinkedList();
	//���pointΪtrue��queue1�洢���� ����queue2�洢����
	private boolean point = true;
	public void push(E item){
		if(point)
			queue1.add(item);
		else
			queue2.add(item);
	}
	
	public E pop(){
		if(point){
			while(queue1.size()>0){
				if(queue1.size()==1){
					point = !point;
					return queue1.remove();
				}
				queue2.add(queue1.remove());
			}
		}else{
			while(queue2.size()>0){
				if(queue2.size()==1){
					point = !point;
					return queue2.remove();
				}
				queue1.add(queue2.remove());
			}
		}
		return null;
	}
	
}
