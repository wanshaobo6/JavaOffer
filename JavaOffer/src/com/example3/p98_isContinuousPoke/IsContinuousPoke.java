package com.example3.p98_isContinuousPoke;

import java.util.Arrays;

/**
 * 面试题61: 扑克牌中的顺子
 * 题目：随机抽取扑克牌中的5张牌，判断是不是顺子，即这5张牌是不是连续的。其中A看成1，
 * 		J看成11，Q看成12，K看成13，大小王可以看成任何需要的数字。
 *
 *分析1：这道题的意思很明确，我们玩扑克的过程中，也经常碰到这样的情况。我们先看看在现
 *		实生活中，我们是怎么样处理的，我想大部分人都是这样做的：先把5张牌从小到大进行
 *		排序，然后直接判断。而如果碰到大小王，我们会除去大小王之后排序，然后判断不相邻
 *		的两个数字之间的“距离“，如果该距离<=大小王的数量相等，那么OK，依然是顺子。此外
 *		，我们还要考虑，除0外其余数字不能重复出现，对应到现实的扑克牌中即对子不是顺子。
 *		为了处理方便，我们把大小王看成0，0可以替代1-13的任何数字。
 * @author 万少波
 *
 */
public class IsContinuousPoke {
	public static void main(String[] args) {
		int[] numArr = {1,2,0,0,5};
		System.out.println(isContinuous(numArr));
	}
	static boolean isContinuous(int[] numArr){
		if(numArr == null || numArr.length < 1)
			return false;
		Arrays.sort(numArr);
		
		int numberOfZero = 0;
		int numberOfGape = 0;
		
		//统计数组中0的个数
		for (int i = 0; i < numArr.length && numArr[i] == 0; i++) 
			numberOfZero++;
		
		//统计数组中间隔数
		int small = numberOfZero;
		int big = small +1;
		while(big < numArr.length){
			//两个数字相等，有对子，不可能是顺子
			if(numArr[big] == numArr[small])
				return false;
			numberOfGape += numArr[big] - numArr[small] -1;
			small = big;
			big ++ ;
		}
		return numberOfGape > numberOfZero ? false : true;
	}
}
