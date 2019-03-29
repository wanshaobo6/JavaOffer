package com.example3.p40_getUglyNumber;

/**
 * ������49: ����
 * 	��Ŀ:����ֻ����������2��3��5��������������Ugly Number��������6��8���ǳ�������14���ǣ�
 * 		  ��Ϊ������������7�� ϰ�������ǰ�1�����ǵ�һ���������󰴴�С�����˳��ĵ�N��������
 * 	
 * 	�͵�һ��˼·��ȣ��ڶ���˼·����Ҫ�ڷǳ����������Ͻ����κμ��㣬�ٶ�����������������Ҫһ��ռ�s���
 * @author ���ٲ�
 *
 */
public class UglyNumber {
	public static void main(String[] args) {
		System.out.println(System.currentTimeMillis());
		System.out.println(getUglyNumber1(1500));
		System.out.println(System.currentTimeMillis());
		System.out.println(getUglyNumber2(1500));
		System.out.println(System.currentTimeMillis());
	}
	
	/**
	 * ��ʽ1:����ж�ÿ�������ǲ��ǳ�����ֱ�۵�������Ч
	 * @param number
	 * @return
	 */
	static int getUglyNumber1(int number){
		if(number <= 0)
			return -1;
		int numberCount = 0;
		int uglyFound = 0;
		while(uglyFound < number){
			++numberCount;
			if(isUgly(numberCount)){
				++uglyFound;
			}
		}
		return numberCount;
	}
	static boolean isUgly(int number){
		if(number == 0)
			return false;
		while(number % 2 == 0)
			number /= 2;
		while(number % 3 == 0)
			number /= 3;
		while(number % 5 == 0)
			number /= 5;
		return number == 1 ? true : false;
	}
	
	/**
	 * ��ʽ2:�������鱣���Ѿ��ҵ��ĳ������Կռ任ʱ��
	 *   ˼·:��������һ��������2,3,5�Ľ��,�ؼ�ȷ����������ĳ������ź���ģ����赱ǰ������ΪM����һ�������϶���ǰ��ĳһ����������2��3��5�Ľ��
	 *   		���ǲ�����ģ���Ϊ���г����ǰ�˳�����������еģ����ڳ������2���ԣ��϶�����ĳ��������������ǰ��ĳ�2С�������������������������
	 *   		��2��������������
	 * @param number
	 * @return
	 */
	static int getUglyNumber2(int number){
		if(number <= 0)
			return -1;
		int[] uglyNumArr = new int[number];
		int multiply2 = 0;
		int multiply3 = 0;
		int multiply5 = 0;
		int index = 1;
		uglyNumArr[0] = 1;
		while(index < number){
			uglyNumArr[index] = getTriMin(uglyNumArr[multiply2]*2,uglyNumArr[multiply3]*3, uglyNumArr[multiply5]*5);
			while(uglyNumArr[multiply2]*2 <= uglyNumArr[index])
				multiply2 ++ ;
			while(uglyNumArr[multiply3]*3 <= uglyNumArr[index])
				multiply3 ++ ;
			while(uglyNumArr[multiply5]*5 <= uglyNumArr[index])
				multiply5 ++ ;
			index++;

		}
		return uglyNumArr[uglyNumArr.length-1];
	}
	
	static int getTriMin(int a , int b , int c){
		int temp = a < b ? a : b;
		return temp<c?temp:c;
	}
}
