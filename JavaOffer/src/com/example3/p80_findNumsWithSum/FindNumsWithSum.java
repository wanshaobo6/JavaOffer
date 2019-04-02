package com.example3.p80_findNumsWithSum;

/**
 * ������57: ��Ϊs������
 * 	 ��Ŀһ:  ����һ������������������һ�����֣��������в�����������
 * ʹ�����ǵĺ�������S,����ж�����ֵĺ͵���S�����������һ�Լ���
 * 
 *    ˼·��
 *      ��������ָ�룬һ��ָ���������Ԫ��p1��һ��ָ����������һ��Ԫ��p2��
 *     ����*p1��+ ��*p2�� > Sʱ��p2��ǰ�ƶ���
 *     ����*p1��+ ��*p2�� < Sʱ��p1����ƶ�
 *    ��*p1��+ ��*p2�� = Sʱ�����
 * @author ���ٲ�
 *
 */
public class FindNumsWithSum {
	
	public static void main(String[] args) {
		int[] numArr = {1,2,4,7,11,15};
		IntegerPoint num1 = new IntegerPoint();
		IntegerPoint num2 = new IntegerPoint();
		boolean result = findNumsWithSum(numArr , 26 , num1 , num2);
		if(result){
			System.out.println(num1 +"  "+num2);
		}
	}
	
	/**
	 * ʱ�临�Ӷ�o(n)
	 * @param numArr
	 * @param target
	 * @param num1
	 * @param num2
	 * @return
	 */
	static boolean findNumsWithSum(int[] numArr , int target, IntegerPoint num1 , IntegerPoint num2){
		boolean result = false;
		if(numArr == null || numArr.length <2)
			return result;
		int leftP = 0;
		int rightP = numArr.length-1;
		while(leftP < rightP){
			int sum = numArr[leftP] + numArr[rightP];
			if(target == sum){
				num1.num = numArr[leftP];
				num2.num = numArr[rightP];
				result = true;
				break;
			}else if(target > sum)
				leftP ++;
			else
				rightP -- ;
		}
		return result;
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
