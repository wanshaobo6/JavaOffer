package com.example2.p87_cloneComplexNodes;

import java.util.Arrays;

/**
 * 面试题35: 复制复杂链表
 * 	题目: 复杂链表的复制：请实现函数ComplexListNode* Clone(ComplexListNode* pHead)，复制
 *	   一个复杂链表。在复杂链表中，每个结点除了有一个m_pNext指针指向下一个结点外，还有一个
 * 	  m_pSibling 指向链表中的任意结点或者nullptr。
 * @author 万少波
 *
 */
public class CloneComplexNodes {
	
	public static void main(String[] args) {
		/**
		 * 经过查证，是因为内部类是动态的（无static关键字修饰），而main方法是静态的
		 * 		，普通的内部类对象隐含地保存了一个引用，指向创建它的外围类对象，所以要在s
		 * 		tatic方法（类加载时已经初始化）调用内部类的必须先创建外部类。即应该这样创建“ComplexListNode test
		 * 		 = new ComplexListNodes().new ComplexListNode();”其中ComplexListNodes为外部类，ComplexListNode为内部动态类；
		 * 		 如果将内部内修改为静态类，可以在main中直接创建内部类实例。
		 */
		ComplexListNode pRoot = new ComplexListNode(1);
		ComplexListNode node1 = new ComplexListNode(2);
		ComplexListNode node2 = new ComplexListNode(3);
		ComplexListNode node3 = new ComplexListNode(4);
		ComplexListNode node4 = new ComplexListNode(5);
		ComplexListNode node5 = new ComplexListNode(6);
/*		ComplexListNode node6 = new ComplexListNode(7);
		ComplexListNode node7 = new ComplexListNode(8);
		ComplexListNode node8 = new ComplexListNode(9);
		ComplexListNode node9 = new ComplexListNode(10);
		ComplexListNode node10 = new ComplexListNode(11);
		ComplexListNode node11 = new ComplexListNode(12);*/
		pRoot.m_pNext = node1;
		node1.m_pNext = node2;
		node1.m_pSibling = pRoot;
		node2.m_pNext = node3;
		node3.m_pNext = node4;
		node3.m_pSibling = node1;
		node4.m_pNext = node5;
/*		node5.m_pNext = node6;
		node6.m_pNext = node7;
		node7.m_pNext = node8;
		node8.m_pNext = node9;
		node9.m_pNext = node10;
		node10.m_pNext = node11;*/
		ComplexListNode clone = clone1(pRoot);
		System.out.println();
	}
	/**
	 * 方法一 (书中方法): 时间复杂度o(n)
	 * 	思想: 1. 先将链表在原链表基础上复制 比如 1->2->3  复制为1->1->2->2->3->3
	 * 		  2. 然后将克隆节点的nextSilbing节点指向 原来节点的nextsilbing的后面
	 * 		  3. 将该链表分离
	 * @param pHead
	 * @return
	 */
	static ComplexListNode clone1(ComplexListNode pHead){
		cloneNodes(pHead);
		connectSiblingNodes(pHead);
		return reConnectedNodes(pHead);
	}
	// 3. 将该链表分离  并返回
	private static ComplexListNode reConnectedNodes(ComplexListNode pHead) {
		// TODO Auto-generated method stub
		ComplexListNode pNode = pHead;
		ComplexListNode cloneHead  =  null;
		ComplexListNode cloneNode  =  null;
		if(pNode != null){
			cloneNode = cloneHead = pNode.m_pNext;
			pNode = cloneNode.m_pNext;
			//注意应加上这条使原链和复制链断开
			pHead.m_pNext = pNode;
		}
		while(pNode != null){
			cloneNode.m_pNext = pNode.m_pNext;
			cloneNode = cloneNode.m_pNext;
			pNode.m_pNext = cloneNode.m_pNext;
			pNode = pNode.m_pNext;
		}
		return cloneHead;
	}
	//2. 然后将克隆节点的nextSilbing节点指向 原来节点的nextsilbing的后面
	private static void connectSiblingNodes(ComplexListNode pHead) {
		// TODO Auto-generated method stub
		ComplexListNode tempNode = pHead;
		while(tempNode != null){
			ComplexListNode cloneNode = tempNode.m_pNext;
			if(tempNode.m_pSibling != null){
				cloneNode.m_pSibling = tempNode.m_pSibling.m_pNext;
			}
			tempNode = cloneNode.m_pNext;
		}
	}
	//1. 先将链表在原链表基础上复制 比如 1->2->3  复制为1->1->2->2->3->3
	private static void cloneNodes(ComplexListNode pHead) {
		// TODO Auto-generated method stub
		ComplexListNode tempNode = pHead;
		while(tempNode != null){
			ComplexListNode cloneNode = new ComplexListNode(tempNode.m_nvalue);
			cloneNode.m_pNext = tempNode.m_pNext;
			tempNode.m_pNext = cloneNode;
			tempNode = cloneNode.m_pNext;
		}
	}
	//------------------------------------------------------------------------------------------------------------------------------------------------------
	/**
	 * 方法二:时间复杂度o(n2)  
	 * @param pHead
	 * @return
	 */
	static ComplexListNode clone2(ComplexListNode pHead){
		if(pHead == null)
			return null;
		ComplexListNode tHead = pHead;
		ComplexListNode returnHead = new ComplexListNode(tHead.m_nvalue);
		ComplexListNode rtHead = returnHead;
		int[] pointTo  = new int[10];
		int increment = 10 ;
		pointTo[0] = (tHead.m_pSibling == null)? -1 : findSilibingIndex(pHead , tHead.m_pSibling);
		int point = 1;
		tHead = tHead.m_pNext;
		//串起主链  
		while(tHead != null){
			pointTo = ensureCapacity(pointTo,point,increment);
			if(tHead.m_pSibling == null){
				pointTo[point] = -1;
			}else{
				pointTo[point] = findSilibingIndex(pHead , tHead.m_pSibling);
			}
			point++;
			rtHead.m_pNext =  new ComplexListNode(tHead.m_nvalue);
			rtHead= rtHead.m_pNext;
			tHead = tHead.m_pNext;
		}
		//串上兄弟链
		rtHead = returnHead;
		for (int i = 0; i < point; i++) {
			if(pointTo[i] == -1)
			{
				rtHead = rtHead.m_pNext;
				continue;
			}
			rtHead.m_pSibling = findPointedSibling(pointTo[i],returnHead);
			rtHead = rtHead.m_pNext;
		}
		return returnHead;
	}
	/**
	 * 找出复制后的链表中节点序号为i的节点
	 * @param i
	 * @param returnHead
	 * @return
	 */
	private static ComplexListNode findPointedSibling(int i, ComplexListNode returnHead) {
		// TODO Auto-generated method stub
		int index = 0;
		ComplexListNode tempNode = returnHead;
		while(tempNode != null && index != i){
			tempNode = tempNode.m_pNext;
			index++;
		}
		return tempNode;
	}
	/**
	 * 寻找tHead下一个节点的位置
	 * @param pointTo
	 * @param m_pSibling
	 * @return
	 */
	private static int findSilibingIndex(ComplexListNode pHead, ComplexListNode m_pSibling) {
		// TODO Auto-generated method stub
		int index = 0;
		while(pHead != m_pSibling){
			pHead= pHead.m_pNext;
			index++;
		}
		return index;
	}
	/**
	 *确保数组的容量足够
	 * @param pointTo
	 * @param point
	 * @param increment
	 */
	private static int[] ensureCapacity(int[] pointTo, int point, int increment) {
		// TODO Auto-generated method stub
		int arrLen = pointTo.length;
		if(point >= arrLen){
			//扩容
			arrLen += increment;
			pointTo = Arrays.copyOf(pointTo, arrLen);
		}
		return pointTo;
	}
	static class ComplexListNode{
		int m_nvalue;
		ComplexListNode m_pNext;
		ComplexListNode m_pSibling;

		public ComplexListNode(int m_nvalue) {
			this.m_nvalue = m_nvalue;
		}
		
		@Override
		public String toString() {
			return "ComplexListNode [m_nvalue=" + m_nvalue + ", m_pNext=" + m_pNext + ", m_pSibling=" + m_pSibling
					+ "]";
		}
	}
}
