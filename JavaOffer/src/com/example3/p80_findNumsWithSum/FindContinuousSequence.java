package com.example3.p80_findNumsWithSum;

/**
 * 题目二: 和为s的连续正数序列
 *   题目:输入一个正数s,打印出所有和为s的连续正数序列（至少含有两个数）。例如输入15，
 *   	由于1+2+3+4+5=4+5+6=7+8=15；所以打印出三个连续序列1~5,4~6,7~8;
 *   
 *   思路: 考虑用两个数字small和big分别表示序列的最小值和最大值,
 *   	若从small到big的序列大于s，则可以从序列中增大small 去掉比较小的值,
 *      若从small到big的序列小于s，则可以从序列中增大big  加上比较大的值，
 *      相等打印出来后增大big , 重复前面的过程直至small到(1+s)/2为止
 * @author 万少波
 *
 */
public class FindContinuousSequence {
	public static void main(String[] args) {
		findContinuousSequence(65535);
	}
	
	static void findContinuousSequence(int num){
		if(num < 3)
			return ;
		int small = 1;
		int big = 2;
		int curSum = small + big;
		int middle = (1 + num)/2;
		System.out.println("和为"+num+"的连续序列有:");
		while(small < middle){
			if(curSum == num)
				printSequence(small, big);
			while(curSum > num && small < middle){
				curSum -= small;
				small ++;
				if(curSum == num)
					printSequence(small, big);
			}
			big ++;
			curSum += big;
		}
	}
	
	static void printSequence (int small , int big){
		for (int i = small; i <= big; i++) 
			System.out.print(i+" ");
		System.out.println();
	}
}
