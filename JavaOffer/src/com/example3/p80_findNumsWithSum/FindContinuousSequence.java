package com.example3.p80_findNumsWithSum;

/**
 * ��Ŀ��: ��Ϊs��������������
 *   ��Ŀ:����һ������s,��ӡ�����к�Ϊs�������������У����ٺ���������������������15��
 *   	����1+2+3+4+5=4+5+6=7+8=15�����Դ�ӡ��������������1~5,4~6,7~8;
 *   
 *   ˼·: ��������������small��big�ֱ��ʾ���е���Сֵ�����ֵ,
 *   	����small��big�����д���s������Դ�����������small ȥ���Ƚ�С��ֵ,
 *      ����small��big������С��s������Դ�����������big  ���ϱȽϴ��ֵ��
 *      ��ȴ�ӡ����������big , �ظ�ǰ��Ĺ���ֱ��small��(1+s)/2Ϊֹ
 * @author ���ٲ�
 *
 */
public class FindContinuousSequence {
	public static void main(String[] args) {
		findContinuousSequence(65535);
	}
	
	static void findContinuousSequence(int num){
		if(num < 3)
			return ;
		int small = 1;
		int big = 2;
		int curSum = small + big;
		int middle = (1 + num)/2;
		System.out.println("��Ϊ"+num+"������������:");
		while(small < middle){
			if(curSum == num)
				printSequence(small, big);
			while(curSum > num && small < middle){
				curSum -= small;
				small ++;
				if(curSum == num)
					printSequence(small, big);
			}
			big ++;
			curSum += big;
		}
	}
	
	static void printSequence (int small , int big){
		for (int i = small; i <= big; i++) 
			System.out.print(i+" ");
		System.out.println();
	}
}
