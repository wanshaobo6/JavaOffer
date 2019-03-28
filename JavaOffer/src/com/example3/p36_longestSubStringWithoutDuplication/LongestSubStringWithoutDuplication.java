package com.example3.p36_longestSubStringWithoutDuplication;

import java.util.Iterator;

/**
 *  ������48:  ������ظ��ַ����ַ���
 *  	��Ŀ:  ����ַ������ҳ�һ����Ĳ������ظ��ַ������ַ��������������ַ����ĳ���
 * 			  �����ַ�����ֻ���� 'a' ~ 'z' ���ַ�
 * 		   	  ���磬���ַ��� "arabcacfr" �У���Ĳ����ظ��ַ������ַ����� "acfr"������Ϊ 4
 * 
 * ��Ҫ˼·��ʹ�ö�̬�滮����¼��ǰ�ַ�֮ǰ������ظ����ַ�������f(i-1)������iΪ��ǰ�ַ���λ�á�ÿ�α�����ǰ�ַ�ʱ�������������
 *
 *1��  ����ǰ�ַ���һ�γ��֣�������ظ����ַ�������f(i) = f(i-1)+1�� 
 *2��  ����ǰ�ַ����ǵ�һ�γ��֣������ȼ��㵱ǰ�ַ������ϴγ���λ��֮��ľ���d��
 *		��d����f(i-1)����˵��ǰһ�����ظ����ַ�����û�а�����ǰ�ַ����������ӵ�ǰ�ַ���ǰһ�����ظ����ַ����У�
 *	 		���ԣ�f(i) = f(i-1)+1��
 *		��dС�ڻ����f(i-1)����˵��ǰһ�����ظ����ַ������Ѿ�������ǰ�ַ�
 *           ���򲻿�����ӵ�ǰ�ַ������ԣ�f(i) = d��
 *
 *�ؼ��㣺��̬�滮�������ظ��ַ��ľ���
 * @author ���ٲ�
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
		//����ֵ
		for (int i = 0; i < position.length; i++) {
			position[i] = -1;
		}
		int maxLen = 0;
		int curLen = 0;
		String longestStr = new String();
		StringBuilder strBuilder = new StringBuilder();
		for (int i = 0; i < charArray.length; i++) {
			int positionIndex = position[charArray[i]-'a'];
			// ����ǰ�ַ���һ�γ��֣�������ظ����ַ�������f(i) = f(i-1)+1��
			// ��d����f(i-1)����˵��ǰһ�����ظ����ַ�����û�а�����ǰ�ַ����������ӵ�ǰ�ַ���ǰһ�����ظ����ַ����У����ԣ�f(i) = f(i-1)+1��
			if(positionIndex<0 || i-positionIndex > curLen){
				strBuilder.append(charArray[i]);
				curLen++;
			}
			else{
			//��dС�ڻ����f(i-1)����˵��ǰһ�����ظ����ַ������Ѿ�������ǰ�ַ� ���򲻿�����ӵ�ǰ�ַ������ԣ�f(i) = d��
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
