package com.example3.p84_reverseString;

/**
 * 题目二: 左旋转字符串
 * 		题目二：字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
 * 		    请定义一个函数实现字符串左旋转操作的功能。比如输入字符串"abcdefg"和数
 * 		    字2，该函数将返回左旋转2位得到的结果"cdefgab"。
 * 
 * 思路: 和上一题的旋转类似,上一次通过两次旋转例如hello world变成了 world hello , 可以应用到这题中
 * @author 万少波
 *
 */
public class LeftRotateString {
	public static void main(String[] args) {
		String str = "abcdefg";
		System.out.println(leftRotateString(str, 2));
	}
	static String leftRotateString(String str , int index){
		if(str == null || str.length() <=0 || index >= str.length() || index < 1)
			return null;
		char[] charArr = str.toCharArray();
		//旋转前面一小部分
		ReverseString.reverse(charArr, 0, index-1);
		ReverseString.reverse(charArr,index, str.length()-1);
		//旋转全部
		ReverseString.reverse(charArr,0, str.length()-1);
		return new String(charArr);
	}
}
