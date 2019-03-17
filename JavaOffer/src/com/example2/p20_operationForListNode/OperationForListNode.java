package com.example2.p20_operationForListNode;

import com.example.p63_constructBinaryTree.BinaryTreeNode;

public class OperationForListNode {
	public static void main(String[] args) {
		ListNode<Integer> pListNode = new ListNode(1);
		ListNode<Integer> ListNode1 = new ListNode(2);
		ListNode<Integer> ListNode2 = new ListNode(2);
		ListNode<Integer> ListNode3 = new ListNode(2);
		ListNode<Integer> ListNode4 = new ListNode(5);
		pListNode.m_pNext = ListNode1;
		ListNode1.m_pNext = ListNode2;
		ListNode2.m_pNext = ListNode3;
		ListNode3.m_pNext = ListNode4;
		System.out.println(pListNode);
		pListNode = deleteDuplication_3(pListNode);
		System.out.println(pListNode);
	}
	
	/**
	 * ��Ŀ���������������һ��ָ���Ľ�㣬����һ��������O(1)ʱ��ɾ���ý�㡣
	 * 1.������ɾ��һ���ڵ�ʱ������һ��Ҫɾ������ڵ㱾��
	 * 2.��������Ҫȫ�棬Ҫ�뵽ɾ������β�����ײ����������
	 * @param pListNode
	 * @param pToBeDelete
	 */
	static <E>void deleteNode(ListNode<E> pListNode , ListNode<E>  pToBeDelete){
		if(pListNode == null || pToBeDelete == null)
			return ;
		if(pListNode == pToBeDelete){
			//ɾ�������ײ�
			
			//�����ʽ�Ǵ����  ��Ϊ�����pListNode�͵��÷������Ϊ��ָͬ���ַ  �޸��˸÷����е�pListNode��ַ��Ӱ����÷������pListNodeָ��   
			/*pListNode = pListNode.m_pNext;*/
			//c���Ի���c++�п�����˫��ָ��ʵ���޸�ͷָ�� �������Ǽ������ʵ��  ����Ԫ��ǰ��
			while(pToBeDelete.m_pNext != null){
				pToBeDelete.m_nValue =  pToBeDelete.m_pNext.m_nValue;
				if(pToBeDelete.m_pNext.m_pNext == null)
				{
					pToBeDelete.m_pNext = null;
					break;
				}
				pToBeDelete = pToBeDelete.m_pNext;
			}
		}else if(pToBeDelete.m_pNext == null){
			//ɾ����β��
			ListNode<E> tNode = pListNode;
			while(tNode.m_pNext != pToBeDelete){
				tNode = tNode.m_pNext;
			}
			tNode.m_pNext = null;
			pToBeDelete = null;
		}else{
			//ɾ�������м䲿��
			ListNode<E> tNode = pToBeDelete.m_pNext;
			pToBeDelete.m_nValue = tNode.m_nValue;
			pToBeDelete.m_pNext = pToBeDelete.m_pNext.m_pNext;
			tNode = null;
		}
	}
	
	/**����:ɾ���������ظ��Ľ��
	 * ��һ������������У������ظ��Ľ�㣬��ɾ�����������ظ��Ľ�㣬�ظ��Ľ�㲻��������������ͷָ�롣 ���磬����1->2->3->3->4->4->5 �����Ϊ 1->2->5
	 */
	public static <E>ListNode<E> deleteDuplication_3(ListNode<E> pHead) {
		if(pHead == null)
			return null;
		ListNode<E> pPreNode = null;
		ListNode<E> pNode = pHead;
		while(pNode != null){
			E value = pNode.m_nValue; 
			ListNode<E> pNext = pNode.m_pNext;
			boolean needDelete = false;
			if(pNext!=null && pNext.m_nValue == value)
				needDelete = true;
			//�ж��Ƿ���Ҫɾ��
			if(!needDelete){
				//����Ҫɾ��
				pPreNode = pNode;
				pNode = pNode.m_pNext;
			}else{
				//��Ҫɾ��
				while(pNext!=null && pNext.m_nValue == value){
					pNext = pNext.m_pNext;
				}
				if(pHead == pNode)
					//��ʼ�ظ��ڵ�Ϊͷ���
					pHead = pNext;
				else
					//��ͷ���
					pPreNode.m_pNext = pNext;
				pNode = pNext;
				
			}
		}
		return pHead;
	}
	
}
