package com.example3.p53_findFirstCommonNode;

/**
 * 面试题52:两个链表的第一个公共节点
 *   题目:输入两个链表,找出它们的第一个公共节点.
 *   
 *   1.蛮力法：时间复杂度为o(n*m)
 *   2.创建两个栈 ， 先将两个链表放到不同栈中去，然后出栈时去除最后相同的两个节点就是第一个公共节点
 *   			时间复杂度o(n+m) 空间复杂度o(m+n)
 *   3.长链先行多于短链长度，然后找到第一个相同的节点
 * @author 万少波
 *
 */
public class FindFirstCommonNode {
	public static void main(String[] args) {
	ListNode p1 = new ListNode(1);
	ListNode p2 = new ListNode(2);
	ListNode p3 = new ListNode(3);
	ListNode p4 = new ListNode(4);
	ListNode p5 = new ListNode(5);
	ListNode p6 = new ListNode(6);
	ListNode p7 = new ListNode(7);
	p1.m_pNext = p2;
	p2.m_pNext = p3;
	p3.m_pNext = p6;
	p6.m_pNext = p7;
	p4.m_pNext = p5;
	p5.m_pNext = p6;
	System.out.println(findFirstCommonNode(p1,p4).m_nKey);
}
	
	/**
	 * 方式1:从其特点出发 时间复杂度o(n+m) 不需要辅助空间
	 * @param pNode1
	 * @param pNode2
	 * @return
	 */
	static ListNode findFirstCommonNode(ListNode pNode1 , ListNode pNode2){
		int pNode1Len = getListLen(pNode1);
		int pNode2Len = getListLen(pNode2);
		int lengthDif = pNode1Len - pNode2Len;
		
		ListNode pLongerList = pNode1;
		ListNode pShortList = pNode2;
		if(lengthDif < 0){
			lengthDif = -lengthDif;
			pLongerList = pNode2;
			pShortList = pNode1;
		}
		//首先让更长链表的指针移动lengthDif次数
		for (int i = 0; i < lengthDif; i++) {
			pLongerList = pLongerList.m_pNext;
		}
		//同步移动，如果相等则返回
		while(pLongerList!=null && pShortList!= null && pLongerList != pShortList){
			pLongerList = pLongerList.m_pNext;
			pShortList = pShortList.m_pNext;
		}
		return pLongerList;
	}
	
	//获取链表的长度
	static int getListLen(ListNode pNode){
		int length = 0;
		while(pNode != null){
			length ++ ;
			pNode = pNode.m_pNext;
		}
		return length;
	}
	static class ListNode{
		int m_nKey;
		ListNode m_pNext;

		public ListNode(int m_nKey) {
			super();
			this.m_nKey = m_nKey;
		}
		
		
	}
}
