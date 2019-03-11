package com.example.utils;

/**
 * Java实现单链表的操作
 * @author 万少波
 *
 */


public class MyLinkedList {
	//链表的头引用
	private Node head = null;
	
	
	/**
	 * 向链表中插入数据
	 *
	 * @param data 插入数据的内容
	 */
	private void addNode(int data) {
		Node node = new Node(data);
		//如果头节点为空 则将其指定node
		if(head == null){
			head = node;
			return ; 
		}
		
		//头节点不为空放入尾节点
		Node temp = head;
		while(temp.next != null){
			temp = temp.next;
		}
		temp.next = node;
	}
	
	/**
	 * 根据索引删除节点
	 *
	 * @param index 删除第index个节点
	 * @return Boolean
	 */
	private Boolean deleteNode(int index) {
		if(head == null || index < 1 || index>length()){
			return false;
		}
		Node temp = head;
		//删除的是头结点
		if(index == 1){
			head = head.next;
			temp = null;
			return true;
		}
		//删除的不是为头结点 这里的temp只想要被删除的上一个结点
		int currIndex = 2;
		while(currIndex != index){
			temp = temp.next;
			currIndex++;
		}
		temp.next = temp.next.next;
		return true;
	}
	
	/**
	 * 计算链表长度
	 *
	 * @return 链表长度
	 */
	private int length() {
		if(head == null){
			return 0;
		}
		int len = 1;
		Node temp = head;
		while(temp.next != null){
			temp = temp.next;
			len++;
		}
		return len;
	}
	
	/**
	 * 打印链表
	 */
	private void print() {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.getData() + "\t");
			temp = temp.next;
		}
		System.out.println();
	}
	
	/**
	 * 从尾到头输出单链表
	 * 方法一：从头到尾开始遍历链表，每经过一个结点，把该结点放入一个栈中，遍历完整个编标后 从栈顶楷书输出结点的值。
	 * 该方法尽管只需要遍历一次，却需要维护一个额外的栈空间
	 * 这时就可以想到递归，因为递归的本质就是一个栈结构。
	 */
	private void PrintListReversingly_Iteratively(Node node){
		if(node != null){
			PrintListReversingly_Iteratively(node.next);
			System.out.print(node.getData() + "\t");
		}
	}
	
	private class Node{
		Node next = null;
		private int data ;
		
		public Node(int data) {
			super();
			this.data = data;
		}
		
		public int getData() {
			return data;
		}
		public void setData(int data) {
			this.data = data;
		}
		
	}
	
	public static void main(String[] args) {
		MyLinkedList list = new MyLinkedList();
		list.addNode(5);
		list.addNode(6);
		list.addNode(7);
		list.addNode(10);
		list.print();
		list.PrintListReversingly_Iteratively(list.head);
	}
}
