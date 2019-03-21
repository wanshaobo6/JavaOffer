package com.example2;

import java.util.Arrays;

public class StringPlus {
	public static void main(String[] args) {
		String a = "9312321321323456";
		String b = "9312321321323456";
		System.out.println(plus(a,b));
	}
	
	static String plus(String stringOne , String stringTwo){
		if(stringOne == null || stringOne.length() == 0 || stringOne == null || stringOne.length() == 0)
			return "";
		char[] charOne = stringOne.toCharArray();
		char[] charTwo = stringOne.toCharArray();
		int charOneLen = charOne.length;
		int charTwoLen = charOne.length;
		int longerCharLen = charOneLen>=charTwoLen?charOneLen:charTwoLen;
		char[] result = new char[longerCharLen+1];
		
		//相同长度
		int addbitToken = 0;
		for(int i=longerCharLen-1 ; i >=0 ; i--){
			int sum = charOne[i]  - '0' + charTwo[i] - '0' + addbitToken;
			addbitToken = 0;
			if(sum >= 10){
				//如果和大于10
				result[i+1] = (char) ('0'+sum - 10);
				addbitToken = 1;
			}else{
				result[i+1] = (char) ('0'+sum);
			}
		}
		if(addbitToken == 1){
			result[0] = '1';
		}
		return new String(result);
	}
}
