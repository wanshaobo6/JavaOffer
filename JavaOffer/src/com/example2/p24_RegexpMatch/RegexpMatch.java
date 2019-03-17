package com.example2.p24_RegexpMatch;

/**
 * ��Ŀ:  ��ʵ��һ����������ƥ�����'.'��'*'��������ʽ��ģʽ�е��ַ�'.'��ʾ����һ���ַ���
 * 		��'*'��ʾ��ǰ����ַ����Գ�������Σ�����0�Σ��� �ڱ����У�ƥ����ָ�ַ����������ַ�ƥ������ģʽ��
 * 		���磬�ַ���"aaa"��ģʽ"a.a"��"ab*ac*a"ƥ�䣬������"aa.a"��"ab*a"����ƥ��.
 * 
 * 
 * @author ���ٲ�
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
		 //����һ���ַ���*��ʱ�� ������һ���ַ���ƥ��ʱ �ַ�����ģʽ�������(1,0),(1,2),(0,2)
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
