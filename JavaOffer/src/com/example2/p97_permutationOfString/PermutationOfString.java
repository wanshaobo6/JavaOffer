package com.example2.p97_permutationOfString;

import java.util.Arrays;

/**
 * ������38:  �ַ���������
 * 		��Ŀ:����һ���ַ���,���ֵ����ӡ�����ַ������ַ����������С����������ַ���abc,
 * 			���ӡ�����ַ�a,b,c�������г����������ַ���abc,acb,bac,bca,cab��cba������
 * 			��һ���ַ���,���Ȳ�����9(�������ַ��ظ�),�ַ�ֻ������Сд��ĸ��
 * 
 * 		˼·:1.���ַ����ֳ�������:һ�������ַ����ĵ�һ���ַ� �� ��һ���ַ��Ժ�������ַ�
 * 			 2.����һ���ַ�����������������
 * 			 3.�ݹ����
 * @author ���ٲ�
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
			//ע���: ��λ֮����Ҫ��ԭ  �������ø������в��� ���Ĵ����ռ�
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
