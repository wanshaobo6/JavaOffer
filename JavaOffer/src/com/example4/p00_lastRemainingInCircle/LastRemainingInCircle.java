package com.example4.p00_lastRemainingInCircle;

import java.util.ArrayList;
import java.util.List;

/**
 * 面试题62:圆圈中最后剩下的数字
 * 	 题目:0,1,2,...,n-1这n个数字排成一个圆圈,从数字0开始每次从这个圆圈里删除第m个数字。求出这个圆圈里剩下的最后一个数字
 * @author 万少波
 *
 */
public class LastRemainingInCircle {
	public static void main(String[] args) {
		System.out.println(lastRemaining(5, 3));
	}
	
	/**
	 * 经典解法:环形链表模拟圆圈
	 * 	 时间复杂度o(mn) 空间复杂度o(n)
	 * @param n
	 * @param m
	 * @return
	 */
	static int lastRemaining(int n , int m){
		if(n < 1 || m < 1)
			return -1;
		List<Integer> circle = new ArrayList();
		for (int i = 0; i < n; i++) {
			circle.add(i);
		}
		int index = 0;
		while(circle.size() != 1){
			index = (index+m-1)%circle.size();
			circle.remove(index);
			if(index == circle.size()-1)
				index = 0;
		}
		return circle.get(0);
	}
}
