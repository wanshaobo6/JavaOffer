package com.example3.p75_findNumsAppearOnce;

/**
 * 面试题56:数组中数字出现的字数
 * 	题目一:一个整型数组里除了两个数字之外，其他的数字都出现了偶数次。请写程序找出这两个只出现一次的数字。
 * 		要求时间复杂度O(n),空间复杂度O(1). 
 * 	
 * @author 万少波
 *
 */
public class FindNumsAppearOnce {
	public static void main(String[] args) {
		IntegerPoint num1 = new IntegerPoint();
		IntegerPoint num2 = new IntegerPoint();
		int[] numArr = {2,4,3,6,3,2,5,5};
		findNumsAppearsOnce(numArr, num1, num2);
		System.out.println(num1.num +","+ num2.num);
	}
	
	static void findNumsAppearsOnce(int[] numArr,IntegerPoint num1 , IntegerPoint num2) {
		if(numArr == null || numArr.length <2)
			return ;
		//将数组中所有的数字亦或，最后的结果为两个不相同的数字亦或
		int numExcursiveOr = 0;
		for (int i = 0; i < numArr.length; i++) {
			numExcursiveOr ^= numArr[i];
		}
		//从后往前找出第一个bit1
		int bit1Index = findFirstBitIs1(numExcursiveOr);
		//将数组分成两个数组，每个数组各包含一个只出现一次的数字，其他的两位数
		//字都是成对出现因为他们的第一个出现1的bit位相同
		num1.num = num2.num = 0;
		for (int i = 0; i < numArr.length; i++) {
			if(isBit1(numArr[i], bit1Index)) {
				num1.num ^= numArr[i];
			}else {
				num2.num ^= numArr[i];
			}
		}
		
	}
	//从后往前找出第一个1位于哪个bit位
	static int findFirstBitIs1(int num) {
		int bitIndex = 0;
		while((num & 1) == 0 && bitIndex <= 32) {
			num = num >> 1;
			bitIndex ++;
		}
		return bitIndex;
	}
	//判断该数字n位是不是1
	static boolean isBit1(int num , int n) {
		int orNum = 1;
		while(n > 0) {
			orNum = orNum << 1;
			n -- ;
		}
		return (num & orNum) == 0 ? false : true;
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
