package com.example2.p99_combinationOfString;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *   
 * ������38��չ:���ַ�����������
 * @author ���ٲ�
 *
 */
public class CombinationOfString {
	public static void main(String[] args) {
		combination1("abc");
	}
	
	
	/**
	 * ��������ַ����������ַ�������ͬ���������n���ַ�������n���ַ��ܹ��ɳ���Ϊ1����ϡ�����Ϊ2����ϡ���
	 * ������Ϊn����ϡ�����n���ַ��ĳ�Ϊm(1<=m<=n)����ϵ�ʱ�򣬲��÷�ұ����˼�룬��������ֽ��С����
	 * ��Ȼ�����õݹ�ؽ����ЩС���⡣�����ȡ��˼·�ǣ�����n���ַ��ֳ������֣���һ���ַ�������������ַ���
	 * ���ѵ�һ���ַ��Ž���������һ����ʣ����ַ���ѡȡm-1���ַ��������ѵ�һ���ַ��Ž���������һ����
	 * ʣ���n-1���ַ���ѡȡm���ַ�������൱�ڰ���n���ַ���ɳ���Ϊm����ϵ�����ֽ�����������⣬�ֱ���n-1
	 * ���ַ����г�Ϊm-1������Լ���n-1���ַ����г�Ϊm����ϡ������������ⶼ�����õݹ�ط�ʽ�����
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
	
	
	
	/**�����Ʒ�
	 * ����:abc   ����abc�����Կ���Ϊ0,1  ������ʾ�벻��ʾ �������ö����ƴ��� 
	 * @param chs
	 */
	static void combination(char[] chs){
			int len = chs.length;
			int nbits = 1 << len;
			for (int i = 0; i < nbits; ++i) {
				int t;
				for (int j = 0; j < len; j++) {
					t = 1 << j;
					if ((t & i) != 0) { // �����㣬ͬΪ1ʱ�Ż���1
						System.out.print(chs[j]);
					}
				}
				System.out.println();
			}
	}
}
