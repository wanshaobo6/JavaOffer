package com.example3.p84_reverseString;

/**
 * ��Ŀ��: ����ת�ַ���
 * 		��Ŀ�����ַ���������ת�����ǰ��ַ���ǰ������ɸ��ַ�ת�Ƶ��ַ�����β����
 * 		    �붨��һ������ʵ���ַ�������ת�����Ĺ��ܡ����������ַ���"abcdefg"����
 * 		    ��2���ú�������������ת2λ�õ��Ľ��"cdefgab"��
 * 
 * ˼·: ����һ�����ת����,��һ��ͨ��������ת����hello world����� world hello , ����Ӧ�õ�������
 * @author ���ٲ�
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
		//��תǰ��һС����
		ReverseString.reverse(charArr, 0, index-1);
		ReverseString.reverse(charArr,index, str.length()-1);
		//��תȫ��
		ReverseString.reverse(charArr,0, str.length()-1);
		return new String(charArr);
	}
}
