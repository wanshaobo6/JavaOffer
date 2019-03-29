package com.example3.p43_findFirstNotRepeatNum;

/**
 * ������50: ��һ��ֻ����һ�ε��ַ�   �ó����ø����ռ�
 * 		��Ŀ:���ַ������ҳ���һ��ֻ����һ�ε��ַ��������롰abaccdeff��,�������b����
 * 	��ֱ���뷨:�������ַ��ͺ���ÿ���Ƚϣ�ʱ�临�Ӷ�o(n),������ķ���
 * @author ���ٲ�
 *
 */
public class FindFirstNotRepeatChar {
	public static void main(String[] args) {
		System.out.println(findFirstNotRepeatChar1("abaccdeff"));
	}
	/**
	 * ��ʽ1:����256*4 1�Ŀռ䣬��ʱ�临�ӶȽ�Ϊo(n) ֻ��������ascll�ַ�
	 * @param str
	 * @return
	 */
	static String findFirstNotRepeatChar1(String str){
		if(str == null || str.length() == 0)
			return null;
		//��ȫ��ascll�ַ�, Ϊ�䴴��һ������ ,ģ���ϣ��,ascll���Ӧÿ���ַ�λ��,ֵ��Ӧ���ִ���,Ĭ��Ϊ0
		int tableSize = 256;
		int[] hashTable = new int[tableSize];
		//�����ַ�
		char[] charArray = str.toCharArray();
		for (int i = 0; i < charArray.length; i++) {
			char curChar = charArray[i];
			hashTable[curChar] = hashTable[curChar]+1;
		}
		for (int i = 0; i < charArray.length; i++) {
			if(hashTable[charArray[i]] == 1){
				return new String(charArray,i,1);
			}
		}
		return null;
	}
	
	
}
