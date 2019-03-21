package com.example2.p69_stackPushPopOrder;

import java.util.Stack;

/**
 *  面试题31:栈的压入弹出序列
 * <p>
 * 输入两个整数序列，第一个序列表示栈的压入顺序，判断第二个序列是否为该栈的弹出序列。假设压入栈的所有数字均不相等。
 * 例如，压入序列为(1,2,3,4,5)，序列(4,5,3,2,1)是它的弹出序列，而(4,3,5,1,2)不是。
 * <p>
 * 对于一个给定的压入序列，由于弹出的时机不同，会出现多种弹出序列。
 * 如果是选择题，依照后进先出的原则，复现一下栈的压入弹出过程就很容易判断了。
 * 写成程序同样如此
 *
 *
 * @author 万少波
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
	 * 1.遍历pPush序列
	 *  1.1  在将每个pPush元素插入到一个辅助栈
	 * 	1.2  栈顶元素和当前指针指向的pPop元素不相等继续压栈
	 * 		相等的话循环辅助栈出栈 pPop指针前移 ， 直到当前辅助栈为空或者元素越界 或辅助栈为空 或  pPop指针不相等
	 * 2.如果最后辅助栈是空的并且pPop数组匹配完毕 返回true
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
			//不相等继续压栈
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
	 *  书中解法
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
			//栈为空或栈顶值不等于当前pop指针指向时   往栈中插入数据 
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