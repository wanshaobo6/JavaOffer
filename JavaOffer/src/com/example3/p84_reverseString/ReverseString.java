package com.example3.p84_reverseString;

/**
 * ������58: ��ת�ַ���
 * 
 * ��ת����˳��
 *����һ��Ӣ�ľ��ӣ���ת�����е��ʵ�˳�򣬵��������ַ���˳�򲻱䡣Ϊ������������ź���ͨ��ĸһ���������������ַ�����I am a student.�����������student. a am I����
 * 
 *����˼·��
 * 1.��һ����ת�����е������ַ������硰I am a student.����תΪ��.tneduts a ma I�����ڶ����ٷ�תÿ�������е��ַ����õ����Ľ���� 
 * 2.�����Ŀ����ʹ��һ�����������о���/���ʵķ�ת�����������е��������ת�������Ƚ����������ӵķ�תȻ���ÿ�����ʽ��з�ת��
 * @author ���ٲ�
 *
 */
public class ReverseString {
	
	public static void main(String[] args) {
		String tStr = "I am a student.";
		System.out.println(reverseSentense(tStr));
	}
	
	 static String reverseSentense(String str){
		 if(str == null )
			 return null;
		 char[] charArr = str.toCharArray();
		 //��ת�����ַ�
		 reverse(charArr, 0, charArr.length-1);
		 //��ת�������
		 int start = 0;
		 int end = 0;
		 while(start < charArr.length){
			 if(charArr[start] == ' '){
				 start ++ ;
				 end ++;
			 }else if(charArr[end] == ' ' || end == charArr.length-1){
				 reverse(charArr, start,end-1);
				 start = ++end;
			 }else
				 end ++;
		 }
		 return new String(charArr);
	 }
	 static void reverse(char[] charArr , int begin , int end){
		 if(charArr == null  || begin > end)
			 return ;
		 while(begin < end){
			 char swap = charArr[begin];
			 charArr[begin] = charArr[end];
			 charArr[end] = swap;
			 begin ++;
			 end --;
		 }
	}
}
