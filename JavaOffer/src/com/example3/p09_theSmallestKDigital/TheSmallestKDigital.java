package com.example3.p09_theSmallestKDigital;

import java.util.Arrays;

/**
 * 面试题40: 最小的k个数
 *    题目:输入n个整数,找出其中最小的k个数字,例如，输入4,5,1,6,2,7,3,8这8个数字,则最小的4个数字是1,2,3,4
 *    
 * @author 万少波
 *
 */
public class TheSmallestKDigital {
	public static void main(String[] args) {
		int[] numArr = {7,5,4,6,8,1,2,4,8,7,5,8,6,1,2,3};
		int[] arr = getTheSmallestKDigital1(numArr,7);
		System.out.println();
	}
	
	/**
	 * 解法1:时间复杂度o(n)  只有当我们可以修改输入的数组时可用
	 * @param numArr
	 * @return
	 */
	static int[] getTheSmallestKDigital1(int[] numArr , int k){
		if(numArr == null || numArr.length == 0 || k <= 0|| k > numArr.length )
			return null;
		int start = 0;
		int end = numArr.length-1;
		int index = partition(numArr,start,end);
		while(index != k){
			if(index < k){
				start = start+1;
				index = partition(numArr,start,end);
			}else{
				end = end -1;
				index = partition(numArr,start,end);
			}
		}
		return Arrays.copyOf(numArr, k);
	}
	static int partition(int[] numArr, int start, int end) {
		// TODO Auto-generated method stub
		if(start >= end  || numArr == null  ||  numArr.length<2 )
			return end;
		int stdPoint = start;
		int std = numArr[start];
		start += 1;
		while( start<end ){
			//找到第一个小于等于哨兵的元素
			while(start<end && numArr[end]>=std)
				end -- ;
			//找到第一个大于等于哨兵的元素
			while(start<end && std>numArr[start])
				start ++ ;
			if(start<end){
				//交换数据
				int swap = numArr[start];
				numArr[start] = numArr[end];
				numArr[end] = swap;
			}
		}
		if(std > numArr[start]){
			numArr[stdPoint] = numArr[start];
			numArr[start] = std;
		}
		if(stdPoint+1 == start && numArr.length!=2)
			return stdPoint;
		return start;
	}
}
