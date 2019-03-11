package com.example.p51_replaceSpaces;

import java.util.Arrays;

/**
 * ʵ��һ�����������ַ����е�ÿ���ո��滻�ɡ�%20����
 * ͨ������ͳ�취�������ַ��ĳ�����n����ÿ���ո��ַ�����Ҫ�ƶ�����O(n)���ַ�����˶Ժ���O(n)���ո��ַ��������ܵ�ʱ��Ч����O(n2)
 * ��ǰ��ķ����У����Ƿ��������еĺܶ��ַ����ƶ��˺ܶ�Σ��ܲ��ܼ����ƶ��Ĵ����أ����ǻ�һ��˼·���Ѵ�ǰ����滻�ɴӺ���ǰ�滻
 * �����ȱ���һ���ַ������������ܹ�ͳ�Ƴ��ַ����пո�������������Լ�����滻֮���ַ������ܵĳ��ȡ�
 * ÿ�滻һ���ո񣬳�������2������滻�Ժ���ַ����ĳ��ȵ���ԭ���ĳ��ȼ���2���Կո����Ŀ
 * ���Ǵ��ַ����ĺ��濪ʼ���ƺ��滻������׼������ָ�룬P1��P2.�����ַ�������棩
 * P1ָ��ԭʼ�ַ�����ĩβ����P2ָ���滻֮����ַ�����ĩβ��
 * ������������ǰ�ƶ�ָ��P1,�������ָ����ַ����Ƶ�P2ָ���λ�ã�ֱ��������һ���ո�Ϊֹ��
 * ������һ���ո�֮�󣬰�P1��ǰ�ƶ�һ����P2֮ǰ�����ַ�����%20�������ڡ�%20���ĳ���Ϊ3��ͬʱҲҪ��P2��ǰ�ƶ�3��
 * ������ǰ���ƣ�ֱ�������ڶ����ո�
 * ����һ��һ���������ٰ�P1��ǰ�ƶ�1�񣬲���P2��ǰ�ƶ�3����롱%20����
 * ��ʱP1��P2ָ��ͬһ��λ�ã��������еĿո��Ѿ��滻��ϡ�
 * @author ���ٲ�
 *
 */
public class ReplaceSpaces {
	
	public static void main(String[] args) {
		String str = "We are happy.";
		System.out.println("replaceBlank(str) = " + replaceBlack1(str));
	}
	
	public static String replaceBlack1(String str){
		//�ǿ��ж�
		if(str == null || str.length() == 0){
			return str;
		}
		//�����ַ���������ַ�������
		int length = str.length();
		int newLength = str.length();
		char[] strChars = str.toCharArray();
		for (char c : strChars) {
			if(c == 32){
				newLength += 2;
			}
		}
		//����newStrCharsΪ������ʣ��strChars
		char[] newStrChars = new char[newLength];
		for (int i = 0; i < strChars.length; ++i) {
			newStrChars[i] = strChars[i];
		}
		//ָ������ָ�� ���ƾ��ַ���
		int newPoint = newLength-1;
		for(int oldPoint = length-1;oldPoint>=0;oldPoint--){
			if(newStrChars[oldPoint] == 32){
				newStrChars[newPoint] = '0';
				newStrChars[newPoint-1] = '2';
				newStrChars[newPoint-2] = '%';
				newPoint -= 3;
				continue;
			}else{
				newStrChars[newPoint] = newStrChars[oldPoint];
				newPoint--;
			}
		}
		return Arrays.toString(newStrChars);
	}
}
