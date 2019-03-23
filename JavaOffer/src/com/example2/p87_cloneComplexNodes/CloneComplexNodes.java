package com.example2.p87_cloneComplexNodes;

import java.util.Arrays;

/**
 * ������35: ���Ƹ�������
 * 	��Ŀ: ��������ĸ��ƣ���ʵ�ֺ���ComplexListNode* Clone(ComplexListNode* pHead)������
 *	   һ�����������ڸ��������У�ÿ����������һ��m_pNextָ��ָ����һ������⣬����һ��
 * 	  m_pSibling ָ�������е����������nullptr��
 * @author ���ٲ�
 *
 */
public class CloneComplexNodes {
	
	public static void main(String[] args) {
		/**
		 * ������֤������Ϊ�ڲ����Ƕ�̬�ģ���static�ؼ������Σ�����main�����Ǿ�̬��
		 * 		����ͨ���ڲ�����������ر�����һ�����ã�ָ�򴴽�������Χ���������Ҫ��s
		 * 		tatic�����������ʱ�Ѿ���ʼ���������ڲ���ı����ȴ����ⲿ�ࡣ��Ӧ������������ComplexListNode test
		 * 		 = new ComplexListNodes().new ComplexListNode();������ComplexListNodesΪ�ⲿ�࣬ComplexListNodeΪ�ڲ���̬�ࣻ
		 * 		 ������ڲ����޸�Ϊ��̬�࣬������main��ֱ�Ӵ����ڲ���ʵ����
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
	 * ����һ (���з���): ʱ�临�Ӷ�o(n)
	 * 	˼��: 1. �Ƚ�������ԭ��������ϸ��� ���� 1->2->3  ����Ϊ1->1->2->2->3->3
	 * 		  2. Ȼ�󽫿�¡�ڵ��nextSilbing�ڵ�ָ�� ԭ���ڵ��nextsilbing�ĺ���
	 * 		  3. �����������
	 * @param pHead
	 * @return
	 */
	static ComplexListNode clone1(ComplexListNode pHead){
		cloneNodes(pHead);
		connectSiblingNodes(pHead);
		return reConnectedNodes(pHead);
	}
	// 3. �����������  ������
	private static ComplexListNode reConnectedNodes(ComplexListNode pHead) {
		// TODO Auto-generated method stub
		ComplexListNode pNode = pHead;
		ComplexListNode cloneHead  =  null;
		ComplexListNode cloneNode  =  null;
		if(pNode != null){
			cloneNode = cloneHead = pNode.m_pNext;
			pNode = cloneNode.m_pNext;
			//ע��Ӧ��������ʹԭ���͸������Ͽ�
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
	//2. Ȼ�󽫿�¡�ڵ��nextSilbing�ڵ�ָ�� ԭ���ڵ��nextsilbing�ĺ���
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
	//1. �Ƚ�������ԭ��������ϸ��� ���� 1->2->3  ����Ϊ1->1->2->2->3->3
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
	 * ������:ʱ�临�Ӷ�o(n2)  
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
		//��������  
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
		//�����ֵ���
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
	 * �ҳ����ƺ�������нڵ����Ϊi�Ľڵ�
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
	 * Ѱ��tHead��һ���ڵ��λ��
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
	 *ȷ������������㹻
	 * @param pointTo
	 * @param point
	 * @param increment
	 */
	private static int[] ensureCapacity(int[] pointTo, int point, int increment) {
		// TODO Auto-generated method stub
		int arrLen = pointTo.length;
		if(point >= arrLen){
			//����
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
