package com.example.p69_queueMadeOfTwoStack;

import com.example.utils.MyStack;

/**
 * 用两个栈实现队列
 * <p>
 * （1）对于插入操作，栈与队列都是从队尾进行，因此一行代码就可以完成push()
 * （2）对于弹出操作，队列先进先出从队头开始，而栈后进先出从队尾开始，
 * 要想取到队头元素，就得需要第二个栈stack2的协助：弹出时将stack1的元素依次取出放到stack2中
 * 此时stack2进行弹出的顺序就是整个队列的弹出顺序。而如果需要插入，放到stack1中即可。
 * 总结:stack1负责插入，stack2负责弹出，如果stack2为空了，将stack1的元素依次弹出并存放到stack2中，之后对stack2进行弹出操作
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
