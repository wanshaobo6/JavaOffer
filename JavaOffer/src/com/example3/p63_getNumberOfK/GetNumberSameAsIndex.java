package com.example3.p63_getNumberOfK;

/**
 * ��Ŀ��: ��������ֵ���±���ȵ�Ԫ��
 * 	    ����һ�������������������ÿ��Ԫ�ض�������������Ψһ�ġ�����ʵ��һ���������ҳ�����������
 * 	  һ����ֵ�������±��Ԫ�ء����磬������{-3,-1,1,3,5}�У�����3�������±���ȡ�
 *     ˼·���������򵥣�O(n)��Ч��Ҳ���Խ��ܣ���ֱ�������ҿ��Դ���O(logn)����Ϊ��Ŀ˵�ˣ�����������
 * @author ���ٲ�
 *
 */
public class GetNumberSameAsIndex {
	public static void main(String[] args) {
		int[] numArr = {-3,-1,1,4,3};
		try {
			System.out.println(getNumberSameAsIndex(null));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	static int getNumberSameAsIndex(int[] numArr) throws Exception{
		if(numArr == null || numArr.length == 0)
			throw new Exception("NUllArray Exception");
		int left = 0;
		int right = numArr.length-1;
		while(left <= right){
			int middle = (left+right) >> 1;  //����:left+(right-left)>> 1  ���κ���˼һ��  
			if(middle == numArr[middle])
				return middle;
			if(middle < numArr[middle])
				right = middle-1;
			else
				left = middle +1;
			
		}
		throw new Exception("Not Found");
	}
}
