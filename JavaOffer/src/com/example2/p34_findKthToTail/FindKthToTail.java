package com.example2.p34_findKthToTail;


public class FindKthToTail {
	public static void main(String[] args) {
		ListNode pListHead = new ListNode(1);
		ListNode listNode1 = new ListNode(2);
		ListNode listNode2 = new ListNode(3);
		ListNode listNode3 = new ListNode(4);
		ListNode listNode4 = new ListNode(5);
		pListHead.m_pNext = listNode1;
		listNode1.m_pNext = listNode2;
		listNode2.m_pNext = listNode3;
		listNode3.m_pNext = listNode4;
		System.out.println(pListHead);
		System.out.println(FindKthToTail(pListHead,0));
	}
	
	static ListNode FindKthToTail(ListNode pListHead , int k){
		if(pListHead == null || k <= 0)
			return null;
		ListNode pAhead = pListHead;
		ListNode pBehind = null;
		for (int i = 0; i < k-1; i++) {
			if(pAhead.m_pNext != null){
				pAhead = pAhead.m_pNext;
			}else{
				return null;
			}
		}
		
		pBehind = pListHead;
		while(pAhead.m_pNext != null){
			pAhead = pAhead.m_pNext;
			pBehind = pBehind.m_pNext;
		}
		return pBehind;
	}
}
