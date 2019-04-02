package com.example3.p75_findNumsAppearOnce;

/**
 * ������56:���������ֳ��ֵ�����
 * 	��Ŀһ:һ�����������������������֮�⣬���������ֶ�������ż���Ρ���д�����ҳ�������ֻ����һ�ε����֡�
 * 		Ҫ��ʱ�临�Ӷ�O(n),�ռ临�Ӷ�O(1). 
 * 	
 * @author ���ٲ�
 *
 */
public class FindNumsAppearOnce {
	public static void main(String[] args) {
		IntegerPoint num1 = new IntegerPoint();
		IntegerPoint num2 = new IntegerPoint();
		int[] numArr = {2,4,3,6,3,2,5,5};
		findNumsAppearsOnce(numArr, num1, num2);
		System.out.println(num1.num +","+ num2.num);
	}
	
	static void findNumsAppearsOnce(int[] numArr,IntegerPoint num1 , IntegerPoint num2) {
		if(numArr == null || numArr.length <2)
			return ;
		//�����������е�����������Ľ��Ϊ��������ͬ���������
		int numExcursiveOr = 0;
		for (int i = 0; i < numArr.length; i++) {
			numExcursiveOr ^= numArr[i];
		}
		//�Ӻ���ǰ�ҳ���һ��bit1
		int bit1Index = findFirstBitIs1(numExcursiveOr);
		//������ֳ��������飬ÿ�����������һ��ֻ����һ�ε����֣���������λ��
		//�ֶ��ǳɶԳ�����Ϊ���ǵĵ�һ������1��bitλ��ͬ
		num1.num = num2.num = 0;
		for (int i = 0; i < numArr.length; i++) {
			if(isBit1(numArr[i], bit1Index)) {
				num1.num ^= numArr[i];
			}else {
				num2.num ^= numArr[i];
			}
		}
		
	}
	//�Ӻ���ǰ�ҳ���һ��1λ���ĸ�bitλ
	static int findFirstBitIs1(int num) {
		int bitIndex = 0;
		while((num & 1) == 0 && bitIndex <= 32) {
			num = num >> 1;
			bitIndex ++;
		}
		return bitIndex;
	}
	//�жϸ�����nλ�ǲ���1
	static boolean isBit1(int num , int n) {
		int orNum = 1;
		while(n > 0) {
			orNum = orNum << 1;
			n -- ;
		}
		return (num & orNum) == 0 ? false : true;
	}
	
	/**
	 * ģ��c�е�intָ��
	 * @author hp
	 *
	 */
	static class IntegerPoint{
		int num ;

		public IntegerPoint(int num) {
			super();
			this.num = num;
		}

		public IntegerPoint() {
		}

		@Override
		public String toString() {
			return num+"";
		} 
		
	}
}
