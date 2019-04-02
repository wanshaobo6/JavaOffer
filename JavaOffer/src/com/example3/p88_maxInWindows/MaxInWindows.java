package com.example3.p88_maxInWindows;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * ������59: ���е����ֵ
 *   ��Ŀһ������һ������ͻ������ڵĴ�С���ҳ����л�����������ֵ�����ֵ��
 *   ���磬�����������{2,3,4,2,6,2,5,1}���������ڵĴ�С3����ôһ������
 *   6���������ڣ����ǵ����ֵ�ֱ�Ϊ{4,4,6,6,6,5}��
 *   
 *   ˼��: 1 ��ʹ�������� ���軬�����ڴ�СΪk��n���ȵ����飬ʱ�临�Ӷ�o(kn)
 *   	   2 һ���������ڿɿ���һ������,�������ǲ���ÿ����ֵ��������У�ֻ�ǰѿ��ܳ�Ϊ�����������ֵ����ֵ����һ�����˿��ڵĶ���
 *   		����2,3,4,2,6,2,5,1 ��˵��2�������,��������Ϊ 2 ;  3�������,2�����ܳ�Ϊ���ֵ , ��������2������ 3�˶��� ; 
 *   		����4,4 2,6,6 2,6 2 5,2 5 1  , ע�����ÿ������Ҫ���д�������ֵ�޳�,���Դ��뻬�����������������±�
 *   
 *   
 *   @author ���ٲ�
 *   
 *
 */
public class MaxInWindows {
	
	public static void main(String[] args) {
		int[] numArr = {2,3,4,2,6,2,5,1};
		System.out.println(getMaxInWindows(numArr, 3));
	}
	
	static List<Integer> getMaxInWindows(int[] numArr , int windowSize){
		if(numArr == null || numArr.length == 0 || windowSize <= 0 || windowSize > numArr.length)
			return null;
		List<Integer> maxInWinList = new ArrayList();
		Deque<Integer> slideWin = new LinkedList();
		//���ȶ�λ��һ����������
		for (int i = 0; i < windowSize; i++) {
			while(!slideWin.isEmpty() && numArr[slideWin.peekLast()] <= numArr[i])
			{
				slideWin.removeLast();
			}
			slideWin.offer(i);
		}
		maxInWinList.add(numArr[slideWin.getFirst()]);
		//����ʣ�µ�Ԫ��
		for (int i = windowSize; i < numArr.length; i++) {
			while(!slideWin.isEmpty() && numArr[slideWin.peekLast()] <= numArr[i])
			{
				slideWin.removeLast();
			}
			if(!slideWin.isEmpty() && i - slideWin.getFirst() >= windowSize){ // Ԫ���ڴ���֮��
				slideWin.removeFirst();
			}
			slideWin.offer(i);
			maxInWinList.add(numArr[slideWin.getFirst()]);
		}
		return maxInWinList;
	}
}
