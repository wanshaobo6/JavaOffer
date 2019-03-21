package com.example2.p45_mergeTwoSortedList;

import com.example2.p34_findKthToTail.ListNode;

/**
 * 25:合并两个排序的链表
 * @author Administrator
 *
 */
public class MergeTwoSortedList {
	public static void main(String[] args) {
		ListNode pListHead = new ListNode(1);
		ListNode listNode1 = new ListNode(4);
		ListNode listNode2 = new ListNode(8);
		ListNode pListHead2 = new ListNode(2);
		ListNode listNode4 = new ListNode(56);
		ListNode listNode5 = new ListNode(132);
		pListHead.m_pNext = listNode1;
		listNode1.m_pNext = listNode2;
		pListHead2.m_pNext = listNode4;
		listNode4.m_pNext = listNode5;
		System.out.println(merge(pListHead,pListHead2));
	}
	static ListNode merge(ListNode pHead1 , ListNode pHead2) {
		if(pHead1 == null)
			return pHead2;
		else if(pHead2 == null)
			return pHead1;
		ListNode mergeHead  = null;
		if(pHead1.m_nValue<=pHead2.m_nValue){
			mergeHead = pHead1;
			pHead1 = pHead1.m_pNext;
		}else{
			mergeHead = pHead2;
			pHead2 = pHead2.m_pNext;
		}
		ListNode returnMergeHead = mergeHead;
		while(pHead1 != null && pHead2 != null) {
			if(pHead1.m_nValue<=pHead2.m_nValue) {
				mergeHead.m_pNext = pHead1;
				pHead1 = pHead1.m_pNext;
			}else {
				mergeHead.m_pNext = pHead2;
				pHead2 = pHead2.m_pNext;
			}
			mergeHead = mergeHead.m_pNext;
		}
		while(pHead1 != null) {
			mergeHead.m_pNext = pHead1;
			mergeHead = mergeHead.m_pNext;
			pHead1 = pHead1.m_pNext;
		}
		while(pHead2 != null) {
			mergeHead.m_pNext = pHead2;
			mergeHead = mergeHead.m_pNext;
			pHead2 = pHead2.m_pNext;
		}
		return returnMergeHead;
	}
	
	/**
	 *方式2:递归
	 * @param pHead1
	 * @param pHead2
	 * @return
	 */
	static ListNode mergeByRecursion(ListNode pHead1 , ListNode pHead2) {
		if(pHead1 == null)
			return pHead2;
		else if(pHead2 == null)
			return pHead1;
					
		ListNode mergedNode = null;
		if(pHead1.m_nValue < pHead2.m_nValue) {
			mergedNode = pHead1;
			mergedNode.m_pNext = mergeByRecursion(pHead1.m_pNext, pHead2);
		}else {
			mergedNode = pHead2;
			mergedNode.m_pNext = mergeByRecursion(pHead1, pHead2.m_pNext);
		}
		return mergedNode;
	}
}
