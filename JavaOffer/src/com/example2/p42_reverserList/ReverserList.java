package com.example2.p42_reverserList;

import com.example2.p34_findKthToTail.ListNode;

/**
 *题目:面试题24 反转链表   
 *				定义一个函数，输入链表的头节点，反转该链表并输出反转后的链表头节点
 *			
 *总结:单链表中实现特殊操作一个指针很难实现  可以试试2个甚至多个
 * @author 万少波
 *
 */
public class ReverserList {
	
	
	
	public static void main(String[] args) {
		ListNode pListHead = new ListNode(1);
		ListNode listNode1 = new ListNode(2);
		ListNode listNode2 = new ListNode(3);
		ListNode listNode3 = new ListNode(4);
		ListNode listNode4 = new ListNode(5);
		ListNode listNode5 = new ListNode(6);
		pListHead.m_pNext = listNode1;
		listNode1.m_pNext = listNode2;
		listNode2.m_pNext = listNode3;
		listNode3.m_pNext = listNode4;
		listNode4.m_pNext = listNode5;
		/*ListNode node = reverseList(pListHead);
		System.out.println(node);*/
		System.out.println(reverseListByRecursion(pListHead));
	}
	/**
	 * 方式1   三个指针
	 * @param pHead
	 * @return
	 */
	static ListNode reverseList(ListNode pHead){
		ListNode pNode = pHead;
		ListNode reverseNode = null;
		ListNode preNode = null;
		while(pNode != null){
			reverseNode = preNode;
			preNode = pNode;
			pNode = pNode.m_pNext;
			if(reverseNode != null && preNode != null){
				if(reverseNode == pHead)
					reverseNode.m_pNext = null;
				preNode.m_pNext = reverseNode;
			}
		}
		return preNode;
	}
	
	/**
	 * 方式2 递归
	 * @param pHead
	 * @return
	 */
	static ListNode reverseListByRecursion(ListNode pHead){
		//只用来判断第一次传入的是否为空
		if(pHead == null || pHead.m_pNext == null)
			return pHead;
		ListNode pNode = pHead;
		ListNode pNext = pHead.m_pNext;
		ListNode result = reverseListByRecursion(pNext);
		//改变pNext指针的指向
		pNext.m_pNext = pNode;
		//使pNode指向空 主要目的是将头指针指向空 避免产生环
		pNode.m_pNext = null;
		return result;
	}
}
