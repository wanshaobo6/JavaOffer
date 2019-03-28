package com.example3.p36_longestSubStringWithoutDuplication;

import java.util.Iterator;

/**
 *  面试题48:  最长不含重复字符的字符串
 *  	题目:  请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度
 * 			  假设字符串中只包含 'a' ~ 'z' 的字符
 * 		   	  例如，在字符串 "arabcacfr" 中，最长的不含重复字符的子字符串是 "acfr"，长度为 4
 * 
 * 主要思路：使用动态规划，记录当前字符之前的最长非重复子字符串长度f(i-1)，其中i为当前字符的位置。每次遍历当前字符时，分两种情况：
 *
 *1）  若当前字符第一次出现，则最长非重复子字符串长度f(i) = f(i-1)+1。 
 *2）  若当前字符不是第一次出现，则首先计算当前字符与它上次出现位置之间的距离d。
 *		若d大于f(i-1)，即说明前一个非重复子字符串中没有包含当前字符，则可以添加当前字符到前一个非重复子字符串中，
 *	 		所以，f(i) = f(i-1)+1。
 *		若d小于或等于f(i-1)，即说明前一个非重复子字符串中已经包含当前字符
 *           ，则不可以添加当前字符，所以，f(i) = d。
 *
 *关键点：动态规划，两个重复字符的距离
 * @author 万少波
 *
 */
public class LongestSubStringWithoutDuplication {
	public static void main(String[] args) {
		System.out.println(getLongestSubStringWithoutDuplication("arabdsdcacfrs"));
	}
	static int getLongestSubStringWithoutDuplication(String str){
		if(str == null)
			return -1;
		char[] charArray = str.toCharArray();
		int[] position = new int[26];
		//赋初值
		for (int i = 0; i < position.length; i++) {
			position[i] = -1;
		}
		int maxLen = 0;
		int curLen = 0;
		String longestStr = new String();
		StringBuilder strBuilder = new StringBuilder();
		for (int i = 0; i < charArray.length; i++) {
			int positionIndex = position[charArray[i]-'a'];
			// 若当前字符第一次出现，则最长非重复子字符串长度f(i) = f(i-1)+1。
			// 若d大于f(i-1)，即说明前一个非重复子字符串中没有包含当前字符，则可以添加当前字符到前一个非重复子字符串中，所以，f(i) = f(i-1)+1。
			if(positionIndex<0 || i-positionIndex > curLen){
				strBuilder.append(charArray[i]);
				curLen++;
			}
			else{
			//若d小于或等于f(i-1)，即说明前一个非重复子字符串中已经包含当前字符 ，则不可以添加当前字符，所以，f(i) = d。
				if(curLen > maxLen){
					longestStr = strBuilder.toString();
					maxLen = curLen;
				}
				strBuilder = new StringBuilder(new String(charArray, position[charArray[i]-'a'] +1, i-positionIndex));
				curLen = i-positionIndex;
			}
			position[charArray[i]-'a'] = i; 
		}
		if(curLen > maxLen){
			longestStr = strBuilder.toString();
			maxLen = curLen;
		}
		System.out.println(longestStr);
		return maxLen;
	}
}
