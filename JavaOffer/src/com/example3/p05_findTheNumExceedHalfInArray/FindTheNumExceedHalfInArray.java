package com.example3.p05_findTheNumExceedHalfInArray;

/**
 * ������39; �����г��ִ�������һ�������
 * 	��Ŀ��������һ�����ֳ��ֵĴ����������鳤�ȵ�һ�룬���ҳ�������֡���������һ������Ϊ 9 ������
 * 		{1,2,3,2,2,2,5,4,2}���������� 2 �������г����� 5 �Σ��������鳤�ȵ�һ�룬������ 2.
 * 
 * 
 * @author ���ٲ�
 *
 */
public class FindTheNumExceedHalfInArray {
	public static void main(String[] args) {
		int[] nums = {2,1};
		System.out.println(partition(nums, 0, nums.length-1));
		/*try {
			System.out.println(moreThanHalfNum1(nums));
			System.out.println(moreThanHalfNum2(nums));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}
	
	/**
	 *��ʽ1 : ����partition������ʱ�临�Ӷ�Ϊo(n)���㷨  T(n) = T(n/2) + n
	 *			������λ����ʱ�临�Ӷ�Ϊo(n)��https://blog.csdn.net/q503267755/article/details/52016847?utm_source=blogkpcl2
	 *			
	 * ˼��:���ڿ�������,��������г��ִ�������һ�������,�������λ�����ǳ���һ�������,�����������ƽ����ð�ݣ��鲢����ȴ�ų���������������һ�����ĵĶ���o(n2)��
	 * 		ʱ�临�Ӷ�, �ܿ���������������������ѡ��һλ����Ȼ��������������ֵ�˳��ʹ��ѡ�е�����ߵ�����С�ڸ������ұߵĴ��ڸ��������ǡ��ѡ���±�Ϊn/2������
	 * 		��λ�����������ƶ�˳������ �ݹ�
	 * @param numArr
	 * @return
	 * @throws Exception 
	 */
	static int moreThanHalfNum1(int[] numArr) throws Exception{
		checkInvalidArray(numArr); //����������Ч��
		int start = 0;
		int end = numArr.length-1;
		int middle = end >> 1;
		int index = partition(numArr , start , end);
		while(index != middle){
			if(index>middle){
				end = index -1;
				index = partition(numArr , start , end);
			}else{
				start = index + 1;
				index = partition(numArr , start , end);
			}
		}
		
		checkMoreThanHalf(numArr,numArr[index]);//����������ǲ��ǳ���һ���
		return numArr[index];
	}
	
	//-----------------------------------------------------------------------------------------------------------------------------------
	/**
	 * ��ʽ2:���������ص�   ʱ�临�Ӷ�o(n)
	 * 		˼��:���������������������ֺͳ���һ���������ֵ��������� ���ʣ�µĻ��ǳ���һ��������
	 * 	 ʵ��:�����ڱ��������ʱ�򱣴�����ֵ:һ���������е�һ�����֣�һ���ǳ��ֵĴ���,��������һ�����ֵ�ʱ������ǰһ����ͬ�����+1,����ͬ������һ,
	 * 			����Ϊ0ʱ��������һ��ʨ�ӣ����Ѵ�����Ϊ1
	 * @param numArr
	 * @return
	 * @throws Exception 
	 */
	static int moreThanHalfNum2(int[] numArr) throws Exception{
		checkInvalidArray(numArr); //����������Ч��
		int result = numArr[0];
		int times = 1;
		for (int i = 0; i < numArr.length; i++) {
			if(times == 0){
				result = numArr[i];
				times = 1;
			}else if(result == numArr[i]){
				times++;
			}else
				times --;
		}
		checkMoreThanHalf(numArr,result);//����������ǲ��ǳ���һ���
		return result;
	}
	
	  private static void checkMoreThanHalf(int[] numArr, int num) throws Exception {
		// TODO Auto-generated method stub
		int times = 0;
		for (int j = 0; j < numArr.length; j++) {
			if(numArr[j] == num)
				times++;
		}
		if(times*2 <= num){
			throw new Exception("��Ч������ �޳���һ�������");
		}
	}

	static int partition(int[] numArr, int start, int end) {
		// TODO Auto-generated method stub
		if(start >= end  || numArr == null  ||  numArr.length<2 )
			return end;
		int stdPoint = start;
		int std = numArr[start];
		start += 1;
		while( start<end ){
			//�ҵ���һ��С�ڵ����ڱ���Ԫ��
			while(start<end && numArr[end]>=std)
				end -- ;
			//�ҵ���һ�����ڵ����ڱ���Ԫ��
			while(start<end && std>numArr[start])
				start ++ ;
			if(start<end){
				//��������
				int swap = numArr[start];
				numArr[start] = numArr[end];
				numArr[end] = swap;
			}
		}
		if(std > numArr[start]){
			numArr[stdPoint] = numArr[start];
			numArr[start] = std;
		}
		if(stdPoint+1 == start && numArr.length!=2)
			return stdPoint;
		return start;
	}

	static void checkInvalidArray(int[] numArr) throws Exception {
		// TODO Auto-generated method stub
		if(numArr == null || numArr.length <= 0)
			throw new Exception("��Ч������");
	}
	
}
