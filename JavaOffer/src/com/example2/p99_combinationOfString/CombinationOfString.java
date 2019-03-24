package com.example2.p99_combinationOfString;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *   
 * 面试题38扩展:求字符的所有排列
 * @author 万少波
 *
 */
public class CombinationOfString {
	public static void main(String[] args) {
		combination1("abc");
	}
	
	
	/**
	 * 下面假设字符串中所有字符都不相同。如果输入n个字符，则这n个字符能构成长度为1的组合、长度为2的组合、。
	 * 。长度为n的组合。在求n个字符的长为m(1<=m<=n)的组合的时候，采用分冶法的思想，将大问题分解成小问题
	 * ，然后再用递归地解决这些小问题。本题采取的思路是：把这n个字符分成两部分：第一个字符和其余的所有字符。
	 * 若把第一个字符放进组合里，则下一步在剩余的字符里选取m-1个字符。若不把第一个字符放进组合里，则下一步在
	 * 剩余的n-1个字符里选取m个字符。这就相当于把求n个字符组成长度为m的组合的问题分解成两个子问题，分别求n-1
	 * 个字符串中长为m-1的组合以及求n-1个字符串中长为m的组合。这两个子问题都可以用递归地方式解决。
	 * @param str
	 */
	static void combination1(String str){
		char[] chars = str.toCharArray();
		Stack<String> stack = new Stack();
		for (int i = 1; i <= chars.length; i++) {
			combination1(chars , 0 , i , stack);
		}
	}
	
	private static void combination1(char[] chars , int start, int eleLen ,	Stack<String> stack) {
		// TODO Auto-generated method stub
		if(eleLen == 0 ){
			for (String str : stack) {
				System.out.print(str);
			}
			System.out.println();
			return ;
		}
		if(start < chars.length){
			stack.push(chars[start]+"");
			combination1(chars , start+1 , eleLen-1 ,stack);
			stack.pop();
			combination1(chars , start+1 , eleLen , stack);
		}
	}

	static void combination(String str){
		combination(str.toCharArray());
	}
	
	
	
	/**二进制法
	 * 例如:abc   其中abc都可以可以为0,1  代表显示与不显示 所以利用二进制代替 
	 * @param chs
	 */
	static void combination(char[] chs){
			int len = chs.length;
			int nbits = 1 << len;
			for (int i = 0; i < nbits; ++i) {
				int t;
				for (int j = 0; j < len; j++) {
					t = 1 << j;
					if ((t & i) != 0) { // 与运算，同为1时才会是1
						System.out.print(chs[j]);
					}
				}
				System.out.println();
			}
	}
}
