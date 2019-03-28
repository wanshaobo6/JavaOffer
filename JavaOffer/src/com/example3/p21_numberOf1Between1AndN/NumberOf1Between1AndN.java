package com.example3.p21_numberOf1Between1AndN;

/**
 *  ������43�� 1~n������1���ֵĴ���
 *  	��Ŀ��
 * 			����һ������n�����1��n��n��������ʮ���Ʊ�ʾ��1���ֵĴ�������������12����1��12��Щ�����а���1��������1�� 10, 11��12��1һ��������5�Ρ�
 * @author ���ٲ�
 *
 */
public class NumberOf1Between1AndN {
	public static void main(String[] args) {
		System.out.println(getNumberOf1Between1AndN1(12));
		System.out.println(NumberOf1Between1AndN_Solution(12));
	}
	/**��ʽ1:  ʱ�临�Ӷ�o(nlogn)
	 * 		������ʱ�临�Ӷ�  �������õ�offer�е���
	 * @param n
	 * @return
	 */
	static int getNumberOf1Between1AndN1(int n){
		int sum = 0;
		for (int i = 1; i <=n; i++) {
			sum += numberOf1(i);
		}
		return sum;
	}
	static int numberOf1(int num){
		int total1 = 0;
		while(num != 0){
			if(num % 10 == 1)
				total1 ++;
			num = num / 10;
		}
		return total1;
	}
	/**
	 * ��ʽ2   �����ֹ������������ʱ��Ч�� �� �������Թٶ�Ŀһ��
	 * 		����:1~21345��1���ֵĴ���
	 * 			1.��21345�ֳ�����  1-1345 �� 1346-21345
	 * 			2.�������Ϊ���ֵ�1����  �����λ��1����ֵĴ����Ǻ����λ����
	 * 									�����������ֵ���10^4��
	 * 			3.�������λ������4λ ��ÿλ����ȡֵ0-9 ��Ϊ��һ��������2 ������2*ʣ��λ��*10^λ��-1 ��(����1346-11345 ,
	 * 				 ��һ��4δ����1�Ĵ���Ϊ10^3 , �ڶ���Ϊ10*10^2)
	 * 			4.ʣ�²��ֵݹ���� 
	 * @param n
	 * @return
	 */
	static  int NumberOf1Between1AndN_Solution(int n)
	    {
	       if(n<1)
	       {
	            return 0;
	       }
	        int count = 0;
	        int base = 1;
	        int round = n;
	    while(round>0)
	    {
	        int weight = round%10;
	        round/=10;
	        count += round*base;
	        if(weight==1) 
	        { 
	            count+=(n%base)+1;
	        }
	        else if(weight>1)
	         {
	            count+=base; 
	         }
	        base*=10;
	    }
	    return count;
	   }
}
