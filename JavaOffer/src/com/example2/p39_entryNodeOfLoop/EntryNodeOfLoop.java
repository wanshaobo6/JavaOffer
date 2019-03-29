package com.example2.p39_entryNodeOfLoop;

import com.example2.p34_findKthToTail.ListNode;

/**
 * 题目:如果一个链表中包含环，如何找出环的入口节点？例如，1->2->3->4->5->6->3 环的入口节点是节点3 
 * @author 万少波  p
 *
 *	思路一:1.确定一个链表中包含环 ？ 定义两个指针  从头指针出发，一个指针一次走一步，另一个一次走两步 。 
 *			如果走得快的指针追上了走的慢的指针  那么链表就包含环
 *		2.如何找到环的入口？  还是利用两个指针  定义p1,p2指向链表的头节点 ， 如果环中有n个节点   则指
 *			针p1在链表伤向前移动n步骤  然后两个指针以相同速度向前移动  , 当第二个指针入口节点时候  第一个指针也指向了入口节点
 *		3.如何求出入口节点长度？  判断是否有环时候定义了两个指针 相遇时候表明存在环  两个相遇得节点
 *			一定在环中然后固定一个指针移动另一个   一边移动一边计数  再次相遇时候就可以得到环中节点数
 *
 * 思路二:
	 * 首先判断链表是否有环，通过设置两个快慢指针，让快指针每次走两步，慢指针一次走一步、
	 * 如果快指针追上了慢指针，那么说明此链表存在环。如果走的快的节点的next为null，说明此链表没有环
	 * <p>
	 * 当相遇时，慢指针在环中走了k步，设环外长度为x，环的长度为n，则快指针一共走了x+m*n步。
	 * m是快指针在环中走的圈数，慢指针一共走了x+k步
	 * 因为快指针是慢指针的二倍，所以可以得到 2(x+k)=x+m*n+k; 化简可得x=m*n-k，慢指针在圈中还剩的步数为n-k步
	 *
	 * @param pHead
	 * @return
 */
public class EntryNodeOfLoop {
	
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
		listNode5.m_pNext = listNode4;
		System.out.println(entryNodeOfLoop(pListHead).m_nValue);
		System.out.println(entryNodeOfLoop1(pListHead).m_nValue);
	}
	
	/**方式1: 理解简单实现相对难
	 * 判断是否存在环
	 * @param pHead
	 * @return
	 */
	static ListNode entryNodeOfLoop(ListNode pHead){
		if(pHead == null)
			return null;
		//判断是否有环并计算环的节点个数
		ListNode slowPoint = pHead;	//一次移动一步
		ListNode fastPoint = pHead;  //一次移动两步
		int loopLenth = 1;
		
		while(fastPoint!= null && fastPoint.m_pNext != null){
			fastPoint = fastPoint.m_pNext.m_pNext;
			slowPoint = slowPoint.m_pNext;
			if(fastPoint == slowPoint){
				//存在环 计算环长度
				while(fastPoint.m_pNext != slowPoint){
					fastPoint = fastPoint.m_pNext;
					loopLenth++;
				}
				return meetingNode(pHead,loopLenth);
			}
		}
		return null;
	}
	/**
	 * 计算相遇点   
	 * @param pHead
	 * @param loopLenth
	 * @return
	 */
	static ListNode meetingNode(ListNode pHead, int loopLenth) {
		// TODO Auto-generated method stub
		ListNode sIndex = pHead;
		ListNode eIndex = null;
		
		for(int i = 0 ; i < loopLenth ; i++) {
			if(sIndex.m_pNext != null){
				sIndex = sIndex.m_pNext;
			}else{
				return null;
			}
		}
		
		eIndex = pHead;
		while(eIndex != sIndex){
			sIndex = sIndex.m_pNext;
			eIndex = eIndex.m_pNext;
		}
		return sIndex;
	}
	
	/**
	 * 方式2: 理解难  但是实现相对简单
	 * 	 
	 * @param pHead
	 * @return
	 */
	static ListNode entryNodeOfLoop1(ListNode pHead){
		if(pHead == null)
			return null;
		ListNode slowPoint = pHead;
		ListNode fastPoint = pHead;
		while(fastPoint != null && fastPoint.m_pNext != null){
			slowPoint = slowPoint.m_pNext;
			fastPoint = fastPoint.m_pNext.m_pNext;
			if(slowPoint == fastPoint){
				//相遇之后 fastPoint回到头结点同步前进
				fastPoint = pHead;
				while(fastPoint != slowPoint){
					fastPoint = fastPoint.m_pNext;
					slowPoint = slowPoint.m_pNext;
				}
				if(slowPoint == fastPoint)
					return slowPoint;
			}
		}
		return null;
	}
	
}
