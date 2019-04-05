package com.example4.p04_maxDiff;

/**
 * 面试题63:股票的最大利润
 * 	题目:求买卖股票一次能获得的最大利润。例如，输入{9，11，8，5，7，12，16，14}，5的时候买入，16的时候卖出，则能获得最大利润11。
 * @author 万少波
 *
 */
public class MaxDiff {
	public static void main(String[] args) {
		int[] numArr = {9,11,8,5,7,12,16,14};
		System.out.println(maxDiff(numArr));
	}
	
	/**
	 * 时间复杂度o(n) 卖出价固定时，买入价越低获得的利润越大，也就是说扫描到数组中第i个数字时，
	 * 				只要我们能够记住之前的最大利润。就能算出能卖出的最大价
	 * @param numArr
	 * @return
	 */
	static int maxDiff(int[] numArr){
		if(numArr == null || numArr.length < 2)
			return -1;
		int min = numArr[0];
		int maxDiff = numArr[1] - min;
		for (int i = 2; i < numArr.length; i++) {
			if(numArr[i-1] < min)
				min = numArr[i-1];
			int curDiff = numArr[i] - min;
			if(curDiff > maxDiff)
				maxDiff = curDiff;
			
		}
		return maxDiff;
	}
}
