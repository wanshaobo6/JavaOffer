package com.example3.p63_getNumberOfK;

/**
 * 题目三: 数组中数值和下标相等的元素
 * 	    假设一个单调递增的数组里的每个元素都是整数并且是唯一的。请编程实现一个函数，找出数组中任意
 * 	  一个数值等于其下标的元素。例如，在数组{-3,-1,1,3,5}中，数字3和它的下标相等。
 *     思路：暴力法简单，O(n)的效率也可以接受，但直觉告诉我可以答案是O(logn)，因为题目说了，单调递增。
 * @author 万少波
 *
 */
public class GetNumberSameAsIndex {
	public static void main(String[] args) {
		int[] numArr = {-3,-1,1,4,3};
		try {
			System.out.println(getNumberSameAsIndex(null));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	static int getNumberSameAsIndex(int[] numArr) throws Exception{
		if(numArr == null || numArr.length == 0)
			throw new Exception("NUllArray Exception");
		int left = 0;
		int right = numArr.length-1;
		while(left <= right){
			int middle = (left+right) >> 1;  //书中:left+(right-left)>> 1  变形后意思一样  
			if(middle == numArr[middle])
				return middle;
			if(middle < numArr[middle])
				right = middle-1;
			else
				left = middle +1;
			
		}
		throw new Exception("Not Found");
	}
}
