package com.example3.p43_findFirstNotRepeatNum;

/**
 * 面试题50: 第一个只出现一次的字符   擅长运用辅助空间
 * 		题目:在字符串中找出第一个只出现一次的字符。如输入“abaccdeff”,则输出“b”。
 * 	最直观想法:遍历拿字符和后面每个比较，时间复杂度o(n),不理想的方法
 * @author 万少波
 *
 */
public class FindFirstNotRepeatChar {
	public static void main(String[] args) {
		System.out.println(findFirstNotRepeatChar1("abaccdeff"));
	}
	/**
	 * 方式1:消耗256*4 1的空间，将时间复杂度降为o(n) 只能适用于ascll字符
	 * @param str
	 * @return
	 */
	static String findFirstNotRepeatChar1(String str){
		if(str == null || str.length() == 0)
			return null;
		//若全是ascll字符, 为其创建一个数组 ,模拟哈希表,ascll码对应每个字符位置,值对应出现次数,默认为0
		int tableSize = 256;
		int[] hashTable = new int[tableSize];
		//遍历字符
		char[] charArray = str.toCharArray();
		for (int i = 0; i < charArray.length; i++) {
			char curChar = charArray[i];
			hashTable[curChar] = hashTable[curChar]+1;
		}
		for (int i = 0; i < charArray.length; i++) {
			if(hashTable[charArray[i]] == 1){
				return new String(charArray,i,1);
			}
		}
		return null;
	}
	
	
}
