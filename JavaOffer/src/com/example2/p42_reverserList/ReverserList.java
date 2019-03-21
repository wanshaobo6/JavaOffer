package com.example2.p42_reverserList;

import com.example2.p34_findKthToTail.ListNode;

/**
 *��Ŀ:������24 ��ת����   
 *				����һ�����������������ͷ�ڵ㣬��ת�����������ת�������ͷ�ڵ�
 *			
 *�ܽ�:��������ʵ���������һ��ָ�����ʵ��  ��������2���������
 * @author ���ٲ�
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
	 * ��ʽ1   ����ָ��
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
	 * ��ʽ2 �ݹ�
	 * @param pHead
	 * @return
	 */
	static ListNode reverseListByRecursion(ListNode pHead){
		//ֻ�����жϵ�һ�δ�����Ƿ�Ϊ��
		if(pHead == null || pHead.m_pNext == null)
			return pHead;
		ListNode pNode = pHead;
		ListNode pNext = pHead.m_pNext;
		ListNode result = reverseListByRecursion(pNext);
		//�ı�pNextָ���ָ��
		pNext.m_pNext = pNode;
		//ʹpNodeָ��� ��ҪĿ���ǽ�ͷָ��ָ��� ���������
		pNode.m_pNext = null;
		return result;
	}
}
