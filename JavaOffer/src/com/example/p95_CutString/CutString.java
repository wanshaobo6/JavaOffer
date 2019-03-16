package com.example.p95_CutString;

/**
 * �ѳ���Ϊn�����Ӽ���m�Σ�n>1,m>1����ÿ�����ӵĳ��ȼ�Ϊk[1],...k[m]����ÿ�����ӵĳ��ȵ����˻��Ƕ��٣��������ӳ���Ϊ8ʱ
 * 	������2,3,3���εõ��ĳ˻����Ϊ18��

 * @author hp
 *
 */
public class CutString {
	
	public static void main(String[] args) {
		System.out.println(CutString.maxProductAfterCutting_solution1(4));
		System.out.println(CutString.maxProductAfterCutting_solution2(4));
	}
	
	/**
	 *����1����̬�滮��˼��
	*	   ���賤��Ϊn�����ӱ��������ɶκ󣬸��γ��ȵ����˻�Ϊf(n)��һ����ȥ���ܵ�λ����1 ,2��...��n-1��
	*	j�����ӷ�Ϊ����Ϊi��n-i�����Σ���f(n)=max{f(i)*f(n-i)}��i=1,2,...,n-1���������µݹ�ʱ���ܻ��кܶ��ظ��ļ���
	*	��˲��ô������ϵķ�ʽ���ȼ���f(2),f(3)������ľͿ������μ����ˡ�n=2ʱ��ֻ��һ�ּ�����f(2)=1*1=1��n=3ʱ��ֻ�м���1
	*	,2��f(3)=1*2=2*1=2��
	*	д����Ҫע�⣺n=2ʱ����Ϊ����Ҫ��һ����ֻ�ܼ���1��1���������˻���1��
	*	���ǳ�ʼ��f(2)��ʱ����Ϊ�˼���n>3��������������г���Ϊ2�Ŀ϶����ټ���һ������ʱ�򳤶�Ϊ2�����˻���2��
	*	��ʼ��f(3)Ҳ��ͬ��
	*/
	public static int maxProductAfterCutting_solution1(int length){
		if(length<2)
			return 0;
		if(length==2)
			return 1;
		if(length==3)
			return 2;
		int[] product = new int[length+1];
		product[0] = 0;
		product[1] = 1;
		product[2] = 2;
		product[3] = 3;
		for(int i=4;i<=length;i++){
			int maxValue = 0;
			for(int j = 1;j<=i/2 ; j++){
				int currVal = product[j]*product[i-j];
				if(currVal>maxValue)
					maxValue = currVal;
			}
			product[i] = maxValue;
		}
		return product[length];
	}
	
	/**
	 * ����������²����������ӣ���õ��������ӵĳ��ȵĳ˻�����󡣵�n>=5ʱ�������ܶ������Ϊ3�����ӣ���ʣ�����ӳ���Ϊ4ʱ������2*2�����Ρ�
	 * @param length
	 * @return
	 */
	public static int maxProductAfterCutting_solution2(int length){
		if(length<2)
			return 0;
		if(length==2)
			return 1;
		if(length==3)
			return 2;
		int timeOf3 = length/3;
		//������һ����4  �����ټ�ȥ3��������
		if(length - timeOf3*3 == 1)
			timeOf3--;
		int timeOf2 = (length - timeOf3*3)/2;
		return (int) (Math.pow(3, timeOf3)*Math.pow(2, timeOf2));
	}
	
}
