package com.example.utils;

/**
 * Javaʵ�ֵ�����Ĳ���
 * @author ���ٲ�
 *
 */


public class MyLinkedList {
	//�����ͷ����
	private Node head = null;
	
	
	/**
	 * �������в�������
	 *
	 * @param data �������ݵ�����
	 */
	private void addNode(int data) {
		Node node = new Node(data);
		//���ͷ�ڵ�Ϊ�� ����ָ��node
		if(head == null){
			head = node;
			return ; 
		}
		
		//ͷ�ڵ㲻Ϊ�շ���β�ڵ�
		Node temp = head;
		while(temp.next != null){
			temp = temp.next;
		}
		temp.next = node;
	}
	
	/**
	 * ��������ɾ���ڵ�
	 *
	 * @param index ɾ����index���ڵ�
	 * @return Boolean
	 */
	private Boolean deleteNode(int index) {
		if(head == null || index < 1 || index>length()){
			return false;
		}
		Node temp = head;
		//ɾ������ͷ���
		if(index == 1){
			head = head.next;
			temp = null;
			return true;
		}
		//ɾ���Ĳ���Ϊͷ��� �����tempֻ��Ҫ��ɾ������һ�����
		int currIndex = 2;
		while(currIndex != index){
			temp = temp.next;
			currIndex++;
		}
		temp.next = temp.next.next;
		return true;
	}
	
	/**
	 * ����������
	 *
	 * @return ������
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
	 * ��ӡ����
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
	 * ��β��ͷ���������
	 * ����һ����ͷ��β��ʼ��������ÿ����һ����㣬�Ѹý�����һ��ջ�У��������������� ��ջ�������������ֵ��
	 * �÷�������ֻ��Ҫ����һ�Σ�ȴ��Ҫά��һ�������ջ�ռ�
	 * ��ʱ�Ϳ����뵽�ݹ飬��Ϊ�ݹ�ı��ʾ���һ��ջ�ṹ��
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
