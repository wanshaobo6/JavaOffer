package com.example2.p97_permutationOfString;

import java.util.Arrays;

/**
 * 面试题38:  字符串的排列
 * 		题目:输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,
 * 			则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。（输
 * 			入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母）
 * 
 * 		思路:1.把字符串分成两部分:一部分是字符串的第一个字符 ， 另一个字符以后的所有字符
 * 			 2.将第一个字符和他后面的逐个交换
 * 			 3.递归调用
 * @author 万少波
 *
 */
public class PermutationOfString {
	public static void main(String[] args) {
		PermutationOfString("abcasasasa");
		
	}
	
	static void PermutationOfString(String str){
		PermutationOfString(str.toCharArray() ,0);
	}
	
	static void PermutationOfString(char[] chars ,int index){
		if(chars == null || chars.length==0)
			return ;
		if(index>=chars.length)
			System.out.println(chars);
		for(int i = index ; i < chars.length ; i++){
			//注意点: 移位之后需要复原  不建议用副本进行操作 消耗大量空间
			//char[] charCopy = Arrays.copyOf(chars, chars.length);  
			char temp = chars[i];
			chars[i] = chars[index];
			chars[index] = temp;
			PermutationOfString(chars , index+1);
			temp = chars[i];
			chars[i] =  chars[index];
			chars[index] = temp;
		}
		
	}
	
}
