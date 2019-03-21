package com.example2.p69_stackPushPopOrder;

import java.util.Stack;

/**
 *  ������31:ջ��ѹ�뵯������
 * <p>
 * ���������������У���һ�����б�ʾջ��ѹ��˳���жϵڶ��������Ƿ�Ϊ��ջ�ĵ������С�����ѹ��ջ���������־�����ȡ�
 * ���磬ѹ������Ϊ(1,2,3,4,5)������(4,5,3,2,1)�����ĵ������У���(4,3,5,1,2)���ǡ�
 * <p>
 * ����һ��������ѹ�����У����ڵ�����ʱ����ͬ������ֶ��ֵ������С�
 * �����ѡ���⣬���պ���ȳ���ԭ�򣬸���һ��ջ��ѹ�뵯�����̾ͺ������ж��ˡ�
 * д�ɳ���ͬ�����
 *
 *
 * @author ���ٲ�
 *
 */
public class StackPushPopOrder {
	public static void main(String[] args) {
		int[] push = {1, 2, 3, 4, 5};
		int[] pop1 = {4, 5, 3, 2, 1};
		int[] pop2 = {4, 3, 5, 1, 2};
		System.out.println(isPopOrder(push, pop1));
		System.out.println(isPopOrder(push, pop2));
		System.out.println(isPopOrder1(push, pop1));
		System.out.println(isPopOrder1(push, pop2));
	}
	
	/** 
	 * 1.����pPush����
	 *  1.1  �ڽ�ÿ��pPushԪ�ز��뵽һ������ջ
	 * 	1.2  ջ��Ԫ�غ͵�ǰָ��ָ���pPopԪ�ز���ȼ���ѹջ
	 * 		��ȵĻ�ѭ������ջ��ջ pPopָ��ǰ�� �� ֱ����ǰ����ջΪ�ջ���Ԫ��Խ�� ����ջΪ�� ��  pPopָ�벻���
	 * 2.��������ջ�ǿյĲ���pPop����ƥ����� ����true
	 * @param pPush
	 * @param pPop
	 * @return
	 */
	static boolean isPopOrder(int[] pPush , int[] pPop){
		if(pPush == null || pPop == null)
			return false;
		Stack<Integer> pPushStack = new Stack();
		int pPopPoint = 0;
		for (int i = 0; i < pPush.length; i++) {
			if(pPopPoint >= pPop.length)
				return false;
			pPushStack.push(pPush[i]);
			//����ȼ���ѹջ
			if(pPushStack.peek() != pPop[pPopPoint]){
				continue;
			}
			while(pPopPoint<pPop.length && !pPushStack.isEmpty() && pPushStack.peek() == pPop[pPopPoint]){
				pPushStack.pop();
				pPopPoint++;
			}
			
		}
		if(pPushStack.isEmpty() && pPopPoint == pPop.length)
			return true;
		return false;
	}
	
	/**
	 *  ���нⷨ
	 * @param pPush
	 * @param pPop
	 * @return
	 */
	static boolean isPopOrder1(int[] pPush , int[] pPop){
		if(pPush == null ||  pPop == null  || pPush.length != pPop.length)
			return false;
		boolean bPossible = false;
		int pNextPush = 0;
		int pNextPop = 0;
		Stack<Integer> stackData = new Stack();
		while(pNextPop < pPop.length){
			//ջΪ�ջ�ջ��ֵ�����ڵ�ǰpopָ��ָ��ʱ   ��ջ�в������� 
			while(stackData.isEmpty() || stackData.peek() != pPop[pNextPop]){
				if(pNextPush >= pPush.length)
					break;
				stackData.push(pPush[pNextPush]);
				pNextPush++;
			}
			
			if(stackData.peek() != pPop[pNextPop])
				break;
			stackData.pop();
			pNextPop++;
		}
		if(stackData.isEmpty() && pNextPop == pPop.length)
			bPossible = true;
		return bPossible;
	}
}