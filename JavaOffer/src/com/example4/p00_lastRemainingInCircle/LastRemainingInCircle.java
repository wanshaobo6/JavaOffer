package com.example4.p00_lastRemainingInCircle;

import java.util.ArrayList;
import java.util.List;

/**
 * ������62:ԲȦ�����ʣ�µ�����
 * 	 ��Ŀ:0,1,2,...,n-1��n�������ų�һ��ԲȦ,������0��ʼÿ�δ����ԲȦ��ɾ����m�����֡�������ԲȦ��ʣ�µ����һ������
 * @author ���ٲ�
 *
 */
public class LastRemainingInCircle {
	public static void main(String[] args) {
		System.out.println(lastRemaining(5, 3));
	}
	
	/**
	 * ����ⷨ:��������ģ��ԲȦ
	 * 	 ʱ�临�Ӷ�o(mn) �ռ临�Ӷ�o(n)
	 * @param n
	 * @param m
	 * @return
	 */
	static int lastRemaining(int n , int m){
		if(n < 1 || m < 1)
			return -1;
		List<Integer> circle = new ArrayList();
		for (int i = 0; i < n; i++) {
			circle.add(i);
		}
		int index = 0;
		while(circle.size() != 1){
			index = (index+m-1)%circle.size();
			circle.remove(index);
			if(index == circle.size()-1)
				index = 0;
		}
		return circle.get(0);
	}
}
