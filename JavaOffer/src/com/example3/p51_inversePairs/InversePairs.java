package com.example3.p51_inversePairs;

import com.example.utils.SortUtils;

/**
 * ������51: �����е������
 * 	�������е��������֣����ǰ��һ�����ִ��ں�������֣����������������һ�������
 * ����һ�����飬�����������е�����Ե�����
 * ���磬������ {7��5��6��4} �У�һ������ 5 ������ԣ��ֱ��� (7��6)��(7��5)��(7��4)��(6��4)��(5��4)
 * 
 *    �鲢�������ȶ�������Ҳ��һ��ʮ�ָ�Ч��������������ȫ���������Ե�����һ�����ܶ�����̫�java��Arrays.sort()
 * ������һ����ΪTimSort�������㷨�����ǹ鲢������Ż��汾�������ĵ�ͼ�пɿ�����ÿ�κϲ�������ƽ��ʱ�临�Ӷ�ΪO(n)��
 * ����ȫ�����������Ϊ|log2n|���ܵ�ƽ��ʱ�临�Ӷ�ΪO(nlogn)�����ң��鲢�������ã����ƽ��ʱ�临�ӶȾ�ΪO(nlogn)��
 * 
 * 	˼·:��Ҫ����Թ鲢��������ճ̶� , Ӧ��ע�⵽�鲢���򽻻�ʱ��ǰ��������ں������,�ʹ������������ұ߱ȸ���С���������Ժ͸�����ϳ�������
 * @author ���ٲ�
 *
 */
public class InversePairs {
	public static void main(String[] args) {
		 int []arr =  {7,5,6,4};
		 int[] arr2 = {6,202,100,301,38,8,1};
		 System.out.println(inversePairs(arr2));
		 SortUtils.showArray(arr2);
	}
	
	/**
	 * ��ʽ1:
	 * ʱ�临�Ӷ�o(nlogn)  ������Ҫһ������Ϊn�ĸ����ռ�
	 * @param numArr
	 * @return
	 */
	static int inversePairs(int[] numArr){
		if(numArr == null || numArr.length ==0)
			return -1;
		int[] temp = new int[numArr.length];//������ǰ���Ƚ���һ�����ȵ���ԭ���鳤�ȵ���ʱ���飬����ݹ���Ƶ�����ٿռ�
		return inversePairsSort(numArr,0,numArr.length-1, temp);
	}

	private static int inversePairsSort(int[] numArr, int left, int right, int[] temp) {
		// TODO Auto-generated method stub
		int total = 0;
		if(left < right){
			int middle = (left+right)/2;
			total += inversePairsSort(numArr, left, middle, temp);
			total += inversePairsSort(numArr, middle+1, right, temp);
			total += inversePairsMerge(numArr, left, middle,  right, temp); 
		}
		return total;
	}

	private static int inversePairsMerge(int[] numArr, int left,int middle , int right, int[] temp) {
		// TODO Auto-generated method stub
		int sum = 0;
		int i = left;	//������ָ��
		int j = middle+1;	//������ָ��
		int t = 0; //��ʱ����ָ��
		while (i<=middle && j <=right){
			if(numArr[i] >= numArr[j]){
				sum += right - j+1;
				temp[t++] = numArr[i++];
			}else{
				temp[t++] = numArr[j++];
			}
		}
		//�������ʣ��
		while(i <= middle){
			temp[t++] = numArr[i++];
		}
		//�ұ���С��ʣ������ν
		while(j <= right){
			 temp[t++] = numArr[j++];
		}
		   t = 0;
	        //��temp�е�Ԫ��ȫ��������ԭ������
	        while(left <= right){
	        	numArr[left++] = temp[t++];
	        }
	    return sum;
	}
}
