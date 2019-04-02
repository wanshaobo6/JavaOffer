package com.example3.p75_findNumsAppearOnce;

/**
 * ��Ŀ��:������Ψһһ��ֻ����һ�ε�����
 *   �����г���һ������ֻ����һ��֮�⣬�������ֶ����������Σ����ҳ���ֻֻ����һ�ε�����
 *  
 *  ˼·:��λ����ļ�¼�����һ�����ֳ������Ρ������Ķ����Ʊ�ʾ��ÿһλҲ����������,��������������г������ε����ֵ�
 *    �����Ʊ�ʾ��ÿһλ���ֱ����������ôÿһλ�ĺͶ��ܱ�3����
 * @author ���ٲ�
 *
 */
public class FindNumsAppearOnce2 {
	public static void main(String[] args) {
		int[] numArr = {1,2,1,2,1,2,3,5,5,5};
		System.out.println(findNumberAppearingOnce(numArr));
	}
	
	/**
	 *  ʱ�临�Ӷ�Ϊo(n) ֻ��Ҫһ��32�ĸ�������
	 * @param numArr
	 * @return
	 */
	static int findNumberAppearingOnce(int[] numArr) {
		if(numArr == null || numArr.length <= 0)
			return -1;
		int[] sum = new int[32];
		for (int i = 0; i < numArr.length; i++) {
			int bitMask = 1;
			for (int j = 31; j >=0; j--) {
				int bit = numArr[i] & bitMask;
				if(bit != 0)
					sum[j] += 1;
				bitMask = bitMask << 1;
			}
		}
		
		int result = 0;
		for (int i = 0; i < sum.length; i++) {
			result = result << 1;
			result = sum[i] % 3 | result;
		}
		return result;
	}
}
