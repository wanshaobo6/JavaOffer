package com.example3.p80_findNumsWithSum;

/**
 * 面试题57: 和为s的数字
 * 	 题目一:  输入一个递增的排序的数组和一个数字，在数组中查找两个数，
 * 使得它们的和正好是S,如果有多对数字的和等于S，就任意输出一对即可
 * 
 *    思路：
 *      设置两个指针，一个指向数组的首元素p1，一个指向数组的最后一个元素p2，
 *     当（*p1）+ （*p2） > S时，p2向前移动，
 *     当（*p1）+ （*p2） < S时，p1向后移动
 *    （*p1）+ （*p2） = S时，输出
 * @author 万少波
 *
 */
public class FindNumsWithSum {
	
	public static void main(String[] args) {
		int[] numArr = {1,2,4,7,11,15};
		IntegerPoint num1 = new IntegerPoint();
		IntegerPoint num2 = new IntegerPoint();
		boolean result = findNumsWithSum(numArr , 26 , num1 , num2);
		if(result){
			System.out.println(num1 +"  "+num2);
		}
	}
	
	/**
	 * 时间复杂度o(n)
	 * @param numArr
	 * @param target
	 * @param num1
	 * @param num2
	 * @return
	 */
	static boolean findNumsWithSum(int[] numArr , int target, IntegerPoint num1 , IntegerPoint num2){
		boolean result = false;
		if(numArr == null || numArr.length <2)
			return result;
		int leftP = 0;
		int rightP = numArr.length-1;
		while(leftP < rightP){
			int sum = numArr[leftP] + numArr[rightP];
			if(target == sum){
				num1.num = numArr[leftP];
				num2.num = numArr[rightP];
				result = true;
				break;
			}else if(target > sum)
				leftP ++;
			else
				rightP -- ;
		}
		return result;
	}
	
	/**
	 * 模拟c中的int指针
	 * @author hp
	 *
	 */
	static class IntegerPoint{
		int num ;

		public IntegerPoint(int num) {
			super();
			this.num = num;
		}

		public IntegerPoint() {
		}

		@Override
		public String toString() {
			return num+"";
		} 
		
	}
}
