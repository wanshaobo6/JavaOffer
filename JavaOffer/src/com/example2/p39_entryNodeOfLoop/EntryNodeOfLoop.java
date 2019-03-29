package com.example2.p39_entryNodeOfLoop;

import com.example2.p34_findKthToTail.ListNode;

/**
 * ��Ŀ:���һ�������а�����������ҳ�������ڽڵ㣿���磬1->2->3->4->5->6->3 ������ڽڵ��ǽڵ�3 
 * @author ���ٲ�  p
 *
 *	˼·һ:1.ȷ��һ�������а����� �� ��������ָ��  ��ͷָ�������һ��ָ��һ����һ������һ��һ�������� �� 
 *			����ߵÿ��ָ��׷�����ߵ�����ָ��  ��ô����Ͱ�����
 *		2.����ҵ�������ڣ�  ������������ָ��  ����p1,p2ָ�������ͷ�ڵ� �� ���������n���ڵ�   ��ָ
 *			��p1����������ǰ�ƶ�n����  Ȼ������ָ������ͬ�ٶ���ǰ�ƶ�  , ���ڶ���ָ����ڽڵ�ʱ��  ��һ��ָ��Ҳָ������ڽڵ�
 *		3.��������ڽڵ㳤�ȣ�  �ж��Ƿ��л�ʱ����������ָ�� ����ʱ��������ڻ�  ���������ýڵ�
 *			һ���ڻ���Ȼ��̶�һ��ָ���ƶ���һ��   һ���ƶ�һ�߼���  �ٴ�����ʱ��Ϳ��Եõ����нڵ���
 *
 * ˼·��:
	 * �����ж������Ƿ��л���ͨ��������������ָ�룬�ÿ�ָ��ÿ������������ָ��һ����һ����
	 * �����ָ��׷������ָ�룬��ô˵����������ڻ�������ߵĿ�Ľڵ��nextΪnull��˵��������û�л�
	 * <p>
	 * ������ʱ����ָ���ڻ�������k�����軷�ⳤ��Ϊx�����ĳ���Ϊn�����ָ��һ������x+m*n����
	 * m�ǿ�ָ���ڻ����ߵ�Ȧ������ָ��һ������x+k��
	 * ��Ϊ��ָ������ָ��Ķ��������Կ��Եõ� 2(x+k)=x+m*n+k; ����ɵ�x=m*n-k����ָ����Ȧ�л�ʣ�Ĳ���Ϊn-k��
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
	
	/**��ʽ1: ����ʵ�������
	 * �ж��Ƿ���ڻ�
	 * @param pHead
	 * @return
	 */
	static ListNode entryNodeOfLoop(ListNode pHead){
		if(pHead == null)
			return null;
		//�ж��Ƿ��л������㻷�Ľڵ����
		ListNode slowPoint = pHead;	//һ���ƶ�һ��
		ListNode fastPoint = pHead;  //һ���ƶ�����
		int loopLenth = 1;
		
		while(fastPoint!= null && fastPoint.m_pNext != null){
			fastPoint = fastPoint.m_pNext.m_pNext;
			slowPoint = slowPoint.m_pNext;
			if(fastPoint == slowPoint){
				//���ڻ� ���㻷����
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
	 * ����������   
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
	 * ��ʽ2: �����  ����ʵ����Լ�
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
				//����֮�� fastPoint�ص�ͷ���ͬ��ǰ��
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
