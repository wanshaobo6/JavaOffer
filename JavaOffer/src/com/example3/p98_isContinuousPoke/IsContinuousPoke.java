package com.example3.p98_isContinuousPoke;

import java.util.Arrays;

/**
 * ������61: �˿����е�˳��
 * ��Ŀ�������ȡ�˿����е�5���ƣ��ж��ǲ���˳�ӣ�����5�����ǲ��������ġ�����A����1��
 * 		J����11��Q����12��K����13����С�����Կ����κ���Ҫ�����֡�
 *
 *����1����������˼����ȷ���������˿˵Ĺ����У�Ҳ������������������������ȿ�������
 *		ʵ�����У���������ô������ģ�����󲿷��˶����������ģ��Ȱ�5���ƴ�С�������
 *		����Ȼ��ֱ���жϡ������������С�������ǻ��ȥ��С��֮������Ȼ���жϲ�����
 *		����������֮��ġ����롰������þ���<=��С����������ȣ���ôOK����Ȼ��˳�ӡ�����
 *		�����ǻ�Ҫ���ǣ���0���������ֲ����ظ����֣���Ӧ����ʵ���˿����м����Ӳ���˳�ӡ�
 *		Ϊ�˴����㣬���ǰѴ�С������0��0�������1-13���κ����֡�
 * @author ���ٲ�
 *
 */
public class IsContinuousPoke {
	public static void main(String[] args) {
		int[] numArr = {1,2,0,0,5};
		System.out.println(isContinuous(numArr));
	}
	static boolean isContinuous(int[] numArr){
		if(numArr == null || numArr.length < 1)
			return false;
		Arrays.sort(numArr);
		
		int numberOfZero = 0;
		int numberOfGape = 0;
		
		//ͳ��������0�ĸ���
		for (int i = 0; i < numArr.length && numArr[i] == 0; i++) 
			numberOfZero++;
		
		//ͳ�������м����
		int small = numberOfZero;
		int big = small +1;
		while(big < numArr.length){
			//����������ȣ��ж��ӣ���������˳��
			if(numArr[big] == numArr[small])
				return false;
			numberOfGape += numArr[big] - numArr[small] -1;
			small = big;
			big ++ ;
		}
		return numberOfGape > numberOfZero ? false : true;
	}
}
