package com.example3.p63_getNumberOfK;

/**
 * 题目二:0~n-1中丢失的数字
 *  	一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0~n-1之内。
 *   在范围0~n-1内的n个数字中有且只有一个数字不再该数组中，请找出这个数字。
 * 
 * 
 * @author 万少波
 *
 */
public class GetMissingNumber {
	public static void main(String[] args) {
		int[] n = {0,2,3,4,5};
		int[] n1 = {1,2,3,4,5};
		int[] n2 = {0,1,2,3,4,5,6};
		System.out.println(getMissingNumber2(n));
	}
	
	/**
	 * 方式1:基于二分查找递归算法
	 * @param numArr
	 * @return
	 */
	static int getMissingNumber1(int[] numArr){
		if(numArr == null || numArr.length<0)
			return -1;
		return getMissingNumber(numArr, 0, numArr.length-1);
	}
	static int getMissingNumber(int[] numArr , int start , int end){
		if(start > end)
			return -1;
		int middleIndex = (start+end) >> 1;
		int middleData = numArr[middleIndex];
		if(middleData != middleIndex){
			if(middleIndex == 0 || numArr[middleIndex]-numArr[middleIndex-1]!=1  )
				return middleIndex;
			end = middleIndex-1;
		}
		else{
			start = middleIndex+1;
		}
		if(start == numArr.length)
			return numArr.length;
		return getMissingNumber(numArr,start,end);
	}
	
	/**
	 * 方式2:基于二分查找循环算法
	 * @param numArr
	 * @return
	 */
	static int getMissingNumber2(int[] numArr){
		if(numArr == null || numArr.length<0)
			return -1;
		int left = 0;
		int right = numArr.length-1;
		while(left <= right){
			int middle = (left+right) >> 1;
			if(middle != numArr[middle]){
				if(middle == 0 || numArr[middle-1] == middle-1)
					return middle;
				right = middle-1;
			}else
				left = middle+1;
		}
		if(left == numArr.length)
			return numArr.length;
		return -1;
	}
}
