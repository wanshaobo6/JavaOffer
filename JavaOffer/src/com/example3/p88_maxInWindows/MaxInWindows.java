package com.example3.p88_maxInWindows;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 面试题59: 队列的最大值
 *   题目一：给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 *   例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在
 *   6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}；
 *   
 *   思考: 1 若使用蛮力法 假设滑动窗口大小为k，n长度的数组，时间复杂度o(kn)
 *   	   2 一个滑动窗口可看成一个队列,但是我们不把每个数值都存入队列，只是把可能成为滑动敞口最大值的数值存入一个两端开口的队列
 *   		对于2,3,4,2,6,2,5,1 来说，2进入队列,滑动窗口为 2 ;  3进入队列,2不可能成为最大值 , 滑动窗口2出队列 3人队列 ; 
 *   		依次4,4 2,6,6 2,6 2 5,2 5 1  , 注意最后每步都需要进行窗口外数值剔除,所以存入滑动窗口最好是数组的下表
 *   
 *   
 *   @author 万少波
 *   
 *
 */
public class MaxInWindows {
	
	public static void main(String[] args) {
		int[] numArr = {2,3,4,2,6,2,5,1};
		System.out.println(getMaxInWindows(numArr, 3));
	}
	
	static List<Integer> getMaxInWindows(int[] numArr , int windowSize){
		if(numArr == null || numArr.length == 0 || windowSize <= 0 || windowSize > numArr.length)
			return null;
		List<Integer> maxInWinList = new ArrayList();
		Deque<Integer> slideWin = new LinkedList();
		//首先定位第一个滑动窗口
		for (int i = 0; i < windowSize; i++) {
			while(!slideWin.isEmpty() && numArr[slideWin.peekLast()] <= numArr[i])
			{
				slideWin.removeLast();
			}
			slideWin.offer(i);
		}
		maxInWinList.add(numArr[slideWin.getFirst()]);
		//遍历剩下的元素
		for (int i = windowSize; i < numArr.length; i++) {
			while(!slideWin.isEmpty() && numArr[slideWin.peekLast()] <= numArr[i])
			{
				slideWin.removeLast();
			}
			if(!slideWin.isEmpty() && i - slideWin.getFirst() >= windowSize){ // 元素在窗口之外
				slideWin.removeFirst();
			}
			slideWin.offer(i);
			maxInWinList.add(numArr[slideWin.getFirst()]);
		}
		return maxInWinList;
	}
}
