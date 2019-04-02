package com.example3.p75_findNumsAppearOnce;

/**
 * 题目二:数组中唯一一次只出现一次的数字
 *   数组中除了一个数字只出现一次之外，其他数字都出现了三次，请找出那只只出现一次的数字
 *  
 *  思路:用位运算的记录。如果一个数字出现三次。那它的二进制表示的每一位也出现了三次,如果把数组中所有出现三次的数字的
 *    二进制表示的每一位都分别加起来，那么每一位的和都能被3整除
 * @author 万少波
 *
 */
public class FindNumsAppearOnce2 {
	public static void main(String[] args) {
		int[] numArr = {1,2,1,2,1,2,3,5,5,5};
		System.out.println(findNumberAppearingOnce(numArr));
	}
	
	/**
	 *  时间复杂度为o(n) 只需要一个32的辅助数组
	 * @param numArr
	 * @return
	 */
	static int findNumberAppearingOnce(int[] numArr) {
		if(numArr == null || numArr.length <= 0)
			return -1;
		int[] sum = new int[32];
		for (int i = 0; i < numArr.length; i++) {
			int bitMask = 1;
			for (int j = 31; j >=0; j--) {
				int bit = numArr[i] & bitMask;
				if(bit != 0)
					sum[j] += 1;
				bitMask = bitMask << 1;
			}
		}
		
		int result = 0;
		for (int i = 0; i < sum.length; i++) {
			result = result << 1;
			result = sum[i] % 3 | result;
		}
		return result;
	}
}
