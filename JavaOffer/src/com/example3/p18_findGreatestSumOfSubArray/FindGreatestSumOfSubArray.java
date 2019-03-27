package com.example3.p18_findGreatestSumOfSubArray;

/**
 *   面试题42: 连续子数组的最大和
 *   	题目:输入一个整型数组，数组里有正数也有负数。数组中一个或连续的多个整数组成一个子数组。
 *  		 求所有子数组的和的最大值。要求时间复杂度为O(n)。例如输入的数组为{1,-2,3,10,-4,7,2,-5}，
 *   		 和最大的子数组为{3,10,-4,7,2}，因此输出为该子数组的和18。
 *   
 *       如果用排列方式枚举所有的可能的结果 ， 最快也需要o(n2)
 * @author 万少波
 *
 */
public class FindGreatestSumOfSubArray {
	public static void main(String[] args) {
		int[] numArray = {1,-2,3,10,-4,7,2,-5};
		System.out.println(findGreatestSumOfSubArray(numArray));
	}
	
	/**
	 * 2.动态规划思想。状态方程 ： max( dp[ i ] )  = getMax(  max( dp[ i -1 ] ) + arr[ i ] ,arr[ i ] ) 。
	 * 	上面式子的意义是：我们从头开始遍历数组，遍历到数组元素 arr[ i ] 时，连续的最大的和 可能为 max( dp[ i -1 ] ) + arr[ i ] 
	 * ，也可能为 arr[ i ] ，做比较即可得出哪个更大，取最大值。时间复杂度为 n
	 */
	static int findGreatestSumOfSubArray(int[] numArray){
		int sum = numArray[0];
		int max = numArray[0];
		for (int i = 1; i < numArray.length; i++) {
			sum = getMax(sum+numArray[i] , numArray[i]);
			if(sum > max)
				max  = sum;
		}
		return max;
	}
	//获取最大值
	static int getMax(int a , int b){
		return a>b?a:b;
	}
}
