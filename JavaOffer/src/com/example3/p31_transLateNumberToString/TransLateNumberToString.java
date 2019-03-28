package com.example3.p31_transLateNumberToString;

/**
 * 面试题46:把数字翻译成字符串 
 * 		题目:给定一个数字，我们按照如下规则把它翻译为字符串：0翻译成“a”“a”，1翻译成“b”“b”，……，11翻译成“l”“l”（小写的“L”“L”），……，
 * 			25翻译成“z”“z”。一个数字可能有多个翻译。例如：12258有5种不同的翻译，分别是“bccfi”、“bwfi”、“bczi”“bczi” 、
 * 			“mcfi”“mcfi” 和 “mzi”“mzi”。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 * @author 万少波
 *
 */
public class TransLateNumberToString {
	public static void main(String[] args) {
		int[] numArr = {1,2,3,1,2,2,3,3,1};
		System.out.println(transLateNumberToString(numArr));
		System.out.println(getTranslationCount(123122331));
	}
	
	/**
	 *  技巧:分析出关于问题的解的递方程 :我们定义函数f(i)表示从第i位数字开始的不同翻译的数目,那么该问题的递归方程式为f(i) = f(i+1) + g(i,i+1)*f(i+2)
	 * @param numArr
	 * @return
	 */
	static int transLateNumberToString(int[] numArr){
		if(numArr == null || numArr.length == 0)
			return 0;
		int[] transLateMethodCount = new int[numArr.length];
		transLateMethodCount[transLateMethodCount.length-1] = 1;  //只有一个数字共有一种翻译方法
		if(numArr.length == 1)
			return transLateMethodCount[numArr.length-1];
		transLateMethodCount[numArr.length-2] = 1;
		if(isMortThan25(numArr[transLateMethodCount.length-2], numArr[transLateMethodCount.length-1]) == 1)
			transLateMethodCount[numArr.length-2] = 2;
		for (int i = numArr.length - 3; i >= 0; i--) {
			transLateMethodCount[i] = transLateMethodCount[i+1] + isMortThan25(numArr[i]
									, numArr[i+1])*transLateMethodCount[i+2];
		}
		return transLateMethodCount[0];
	}

	private static int isMortThan25(int first , int last) {
		// TODO Auto-generated method stub
		if((first*10 + last) <= 25)
			return 1;
		return 0;
	}
	
	/**
	 *    书上解法
	 * @param number
	 * @return
	 */
	static int getTranslationCount(int number){
		if(number < 0)
			return 0;
		char[] numChars = String.valueOf(number).toCharArray();
		return getTranslationCount(numChars);
	}

	private static int getTranslationCount(char[] numChars) {
		// TODO Auto-generated method stub
		int length = numChars.length;
		int[] counts = new int[numChars.length];
		int count = 0 ;
		
		for (int i = length-1; i >= 0; --i) {
			int j = numChars[i];
			if(i<length-1)
				count = counts[i+1];
			else
				count = 1;
			if(i < length-1){
				int digital1 = numChars[i] - '0';
				int digital2 = numChars[i+1] - '0';
				int converted =  digital1*10 + digital2;
				if(converted >= 10 && converted <= 25){
					if(i < length-2)
						count += counts[i+2];
					else
						count += 1;
				}
			}
			counts[i] = count;
		}
		count = counts[0];
		return count;
	}
}
