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
	 * 题目：给定单向链表和一个指定的结点，定义一个函数在O(1)时间删除该结点。
	 * 1.当我们删除一个节点时，并不一定要删除这个节点本身
	 * 2.考虑问题要全面，要想到删除的是尾部和首部的特殊情况
	 * @param pListNode
	 * @param pToBeDelete
	 */
	static <E>void deleteNode(ListNode<E> pListNode , ListNode<E>  pToBeDelete){
		if(pListNode == null || pToBeDelete == null)
			return ;
		if(pListNode == pToBeDelete){
			//删除的是首部
			
			//这个方式是错误的  因为这里的pListNode和调用方传入的为不同指针地址  修改了该方法中的pListNode地址不影响调用方传入的pListNode指针   
			/*pListNode = pListNode.m_pNext;*/
			//c语言或者c++中可以用双重指针实现修改头指针 这里我们假设遍历实现  所有元素前移
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
			//删除的尾部
			ListNode<E> tNode = pListNode;
			while(tNode.m_pNext != pToBeDelete){
				tNode = tNode.m_pNext;
			}
			tNode.m_pNext = null;
			pToBeDelete = null;
		}else{
			//删除的是中间部分
			ListNode<E> tNode = pToBeDelete.m_pNext;
			pToBeDelete.m_nValue = tNode.m_nValue;
			pToBeDelete.m_pNext = pToBeDelete.m_pNext.m_pNext;
			tNode = null;
		}
	}
	
	/**问题:删除链表中重复的结点
	 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
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
			//判断是否需要删除
			if(!needDelete){
				//不需要删除
				pPreNode = pNode;
				pNode = pNode.m_pNext;
			}else{
				//需要删除
				while(pNext!=null && pNext.m_nValue == value){
					pNext = pNext.m_pNext;
				}
				if(pHead == pNode)
					//起始重复节点为头结点
					pHead = pNext;
				else
					//非头结点
					pPreNode.m_pNext = pNext;
				pNode = pNext;
				
			}
		}
		return pHead;
	}
	
}
