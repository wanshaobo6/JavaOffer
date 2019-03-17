package com.example2.p24_RegexpMatch;

/**
 * 题目:  请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，
 * 		而'*'表示它前面的字符可以出现任意次（包含0次）。 在本题中，匹配是指字符串的所有字符匹配整个模式。
 * 		例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配.
 * 
 * 
 * @author 万少波
 *
 */
public class RegexpMatch {
	
	public static void main(String[] args) {
		System.out.println(match("abccccbab","abc*cb.b"));
	}
	
	static boolean match(String str , String regexp){
		if(str == null || str.length() == 0 ||  regexp == null || regexp.length() == 0 )
			return false;
		char[] strChar = str.toCharArray();
		char[] regexpChar = regexp.toCharArray();
		return matchCore(strChar,0,regexpChar,0);
	}
	
	 static boolean matchCore(char[] strChar, int strIndex, char[] regexpChar, int regexpIndex) {
		// TODO Auto-generated method stub
		 
		 
		 if(strChar.length == strIndex && regexpChar.length == regexpIndex)
			 return true;
		 if(strIndex>=strChar.length || regexpIndex>=regexpChar.length)
			 return false;
		 boolean result = false;
		 //当第一个字符是*的时候 并且上一个字符串匹配时 字符串和模式三种组合(1,0),(1,2),(0,2)
		 if(strChar[strIndex] == regexpChar[regexpIndex] && regexpIndex+1<regexpChar.length && regexpChar[regexpIndex+1] == '*'){
			 result =  matchCore(strChar,strIndex+1,regexpChar,regexpIndex) || matchCore(strChar,strIndex+1,regexpChar,regexpIndex+2) ||
					  matchCore(strChar,strIndex,regexpChar,regexpIndex+2);
		 }else if(strChar[strIndex] != regexpChar[regexpIndex] && regexpIndex+1<regexpChar.length && regexpChar[regexpIndex+1] == '*'){
			 result =  matchCore(strChar,strIndex,regexpChar,regexpIndex+2);
		 }else if(strChar[strIndex] == regexpChar[regexpIndex] || regexpChar[regexpIndex] == '.'){
			 result = matchCore(strChar,strIndex+1,regexpChar,regexpIndex+1);
		 }
		return result;
	}
	
}
