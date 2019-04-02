package com.example3.p84_reverseString;

/**
 * 面试题58: 翻转字符串
 * 
 * 翻转单词顺序
 *输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。例如输入字符串“I am a student.”，则输出“student. a am I”。
 * 
 *解题思路：
 * 1.第一步翻转句子中的所有字符，例如“I am a student.”翻转为“.tneduts a ma I”，第二部再翻转每个单词中的字符，得到最后的结果。 
 * 2.这个题目可以使用一个函数来进行句子/单词的翻转，在主函数中调用这个翻转函数首先进行整个句子的翻转然后对每个单词进行翻转。
 * @author 万少波
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
		 //翻转所有字符
		 reverse(charArr, 0, charArr.length-1);
		 //翻转逐个单词
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
