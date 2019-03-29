package com.example3.p40_getUglyNumber;

/**
 * 面试题49: 丑数
 * 	题目:：把只包含质因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，
 * 		  因为它包含质因子7。 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 * 	
 * 	和第一种思路相比，第二种思路不需要在非丑树的整数上进行任何计算，速度明显提升，但是需要一点空间s损耗
 * @author 万少波
 *
 */
public class UglyNumber {
	public static void main(String[] args) {
		System.out.println(System.currentTimeMillis());
		System.out.println(getUglyNumber1(1500));
		System.out.println(System.currentTimeMillis());
		System.out.println(getUglyNumber2(1500));
		System.out.println(System.currentTimeMillis());
	}
	
	/**
	 * 方式1:逐个判断每个整数是不是丑树，直观但不够高效
	 * @param number
	 * @return
	 */
	static int getUglyNumber1(int number){
		if(number <= 0)
			return -1;
		int numberCount = 0;
		int uglyFound = 0;
		while(uglyFound < number){
			++numberCount;
			if(isUgly(numberCount)){
				++uglyFound;
			}
		}
		return numberCount;
	}
	static boolean isUgly(int number){
		if(number == 0)
			return false;
		while(number % 2 == 0)
			number /= 2;
		while(number % 3 == 0)
			number /= 3;
		while(number % 5 == 0)
			number /= 5;
		return number == 1 ? true : false;
	}
	
	/**
	 * 方式2:创建数组保存已经找到的丑树，以空间换时间
	 *   思路:丑树是另一个丑数乘2,3,5的结果,关键确保数组里面的丑数是排好序的，假设当前最大丑数为M，下一个丑树肯定是前面某一个丑数乘以2，3，5的结果
	 *   		但是不必需的，因为以有丑树是按顺序存放在数组中的，对于成语乘以2而言，肯定存在某个丑数，排在它前面的乘2小于已有最大丑数，排在它后面的
	 *   		乘2大于已有最大丑数
	 * @param number
	 * @return
	 */
	static int getUglyNumber2(int number){
		if(number <= 0)
			return -1;
		int[] uglyNumArr = new int[number];
		int multiply2 = 0;
		int multiply3 = 0;
		int multiply5 = 0;
		int index = 1;
		uglyNumArr[0] = 1;
		while(index < number){
			uglyNumArr[index] = getTriMin(uglyNumArr[multiply2]*2,uglyNumArr[multiply3]*3, uglyNumArr[multiply5]*5);
			while(uglyNumArr[multiply2]*2 <= uglyNumArr[index])
				multiply2 ++ ;
			while(uglyNumArr[multiply3]*3 <= uglyNumArr[index])
				multiply3 ++ ;
			while(uglyNumArr[multiply5]*5 <= uglyNumArr[index])
				multiply5 ++ ;
			index++;

		}
		return uglyNumArr[uglyNumArr.length-1];
	}
	
	static int getTriMin(int a , int b , int c){
		int temp = a < b ? a : b;
		return temp<c?temp:c;
	}
}
