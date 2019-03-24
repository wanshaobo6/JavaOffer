package com.example3.p00_example1;

/**
 * ��Ŀ:����һ������8�����ֵ�����,�ж���û�п��ܰ���8�����ֱַ�ŵ��������8�������ϣ�ʹ����������������Ե����ϵ�4������ĺ���ȡ�
 * @author ���ٲ�
 *
 */
public class example_cube {
	public static void main(String[] args) {
		int[] nums = {1,2,3,4,5,6,7,8};
		int[] result = check(nums, 0);
		System.out.println();
	}
	
	//�鿴�Ƿ��������
	static int[] checkPossible(int[] sideLen){
		if(sideLen.length != 8)
			return null;
		if((sideLen[0]+sideLen[1]+sideLen[2]+sideLen[3]) == (sideLen[4]+sideLen[5]+sideLen[6]+sideLen[7]) &&
			(sideLen[0]+sideLen[2]+sideLen[4]+sideLen[6]) == (sideLen[1]+sideLen[3]+sideLen[5]+sideLen[7]) && 
			(sideLen[0]+sideLen[1]+sideLen[4]+sideLen[5]) == (sideLen[2]+sideLen[3]+sideLen[6]+sideLen[7])  
			)
			return sideLen;
		return null;
	}

	//��������ȫ����  ���ж��Ƿ��������
	static int[] check(int[] sides , int start){
		if(start >= sides.length){
			return checkPossible(sides);
		}
		for (int i = start; i < sides.length; i++) {
			swap(start,i,sides);
			int[] returnSides = check(sides,start+1);
			if(returnSides != null){
				return returnSides;
			}
			swap(start,i,sides);
		}
		return null;
	}
	//��������
	private static void swap(int start, int i, int[] sides) {
		// TODO Auto-generated method stub
		int swap = sides[start];
		sides[start] = sides[i];
		sides[i] = swap;
	}
}
