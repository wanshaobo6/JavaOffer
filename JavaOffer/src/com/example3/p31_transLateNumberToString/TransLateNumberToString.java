package com.example3.p31_transLateNumberToString;

/**
 * ������46:�����ַ�����ַ��� 
 * 		��Ŀ:����һ�����֣����ǰ������¹����������Ϊ�ַ�����0����ɡ�a����a����1����ɡ�b����b����������11����ɡ�l����l����Сд�ġ�L����L������������
 * 			25����ɡ�z����z����һ�����ֿ����ж�����롣���磺12258��5�ֲ�ͬ�ķ��룬�ֱ��ǡ�bccfi������bwfi������bczi����bczi�� ��
 * 			��mcfi����mcfi�� �� ��mzi����mzi��������ʵ��һ����������������һ�������ж����ֲ�ͬ�ķ��뷽����
 * @author ���ٲ�
 *
 */
public class TransLateNumberToString {
	public static void main(String[] args) {
		int[] numArr = {1,2,3,1,2,2,3,3,1};
		System.out.println(transLateNumberToString(numArr));
		System.out.println(getTranslationCount(123122331));
	}
	
	/**
	 *  ����:��������������Ľ�ĵݷ��� :���Ƕ��庯��f(i)��ʾ�ӵ�iλ���ֿ�ʼ�Ĳ�ͬ�������Ŀ,��ô������ĵݹ鷽��ʽΪf(i) = f(i+1) + g(i,i+1)*f(i+2)
	 * @param numArr
	 * @return
	 */
	static int transLateNumberToString(int[] numArr){
		if(numArr == null || numArr.length == 0)
			return 0;
		int[] transLateMethodCount = new int[numArr.length];
		transLateMethodCount[transLateMethodCount.length-1] = 1;  //ֻ��һ�����ֹ���һ�ַ��뷽��
		if(numArr.length == 1)
			return transLateMethodCount[numArr.length-1];
		transLateMethodCount[numArr.length-2] = 1;
		if(isMortThan25(numArr[transLateMethodCount.length-2], numArr[transLateMethodCount.length-1]) == 1)
			transLateMethodCount[numArr.length-2] = 2;
		for (int i = numArr.length - 3; i >= 0; i--) {
			transLateMethodCount[i] = transLateMethodCount[i+1] + isMortThan25(numArr[i]
									, numArr[i+1])*transLateMethodCount[i+2];
		}
		return transLateMethodCount[0];
	}

	private static int isMortThan25(int first , int last) {
		// TODO Auto-generated method stub
		if((first*10 + last) <= 25)
			return 1;
		return 0;
	}
	
	/**
	 *    ���Ͻⷨ
	 * @param number
	 * @return
	 */
	static int getTranslationCount(int number){
		if(number < 0)
			return 0;
		char[] numChars = String.valueOf(number).toCharArray();
		return getTranslationCount(numChars);
	}

	private static int getTranslationCount(char[] numChars) {
		// TODO Auto-generated method stub
		int length = numChars.length;
		int[] counts = new int[numChars.length];
		int count = 0 ;
		
		for (int i = length-1; i >= 0; --i) {
			int j = numChars[i];
			if(i<length-1)
				count = counts[i+1];
			else
				count = 1;
			if(i < length-1){
				int digital1 = numChars[i] - '0';
				int digital2 = numChars[i+1] - '0';
				int converted =  digital1*10 + digital2;
				if(converted >= 10 && converted <= 25){
					if(i < length-2)
						count += counts[i+2];
					else
						count += 1;
				}
			}
			counts[i] = count;
		}
		count = counts[0];
		return count;
	}
}
