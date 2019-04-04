package com.example3.p94_prinyProbability;

/**
 *  ������60: n�����ӵĵ���
 *  		��n���������ڵ��ϣ����е����ӳ��ϵ�һ��ĵ���֮��Ϊs������n����ӡ��s���п��ܵ�ֵ���ֵĸ��ʡ�
 *  
 *  ˼·:����齫�Ķ�֪��������һ��6���棬ÿ�����϶���һ����������Ӧ��������1�� 6֮���һ�����֡����ԣ�n
 *  	�����ӵĵ����͵���СֵΪn�����ֵΪ6n����ˣ�һ��ֱ�۵�˼·���Ƕ���һ������Ϊ6n-n+1�����飬��ΪS��
 *  	�������ֵĴ������浽�����S-n��Ԫ������⣬���ǻ�֪��n�����ӵ����е�����������6^n��һ������ͳ��
 *  	��ÿһ�������ֵĴ���֮�����ֻҪ��ÿһ�������ֵĴ�������n^6���͵õ��˶�Ӧ�ĸ��ʡ�
 *  
 * @author ���ٲ�
 *
 */
public class PrintProbability {
	public static void main(String[] args) {
		System.out.println(System.currentTimeMillis());
	//	printProbability(15);
		System.out.println(System.currentTimeMillis());
		System.out.println(System.currentTimeMillis());
		printProbability1(15);
		System.out.println(System.currentTimeMillis());
	}
	
	static final int Single_MaxValue = 6;

	/**
	 * �ⷨһ:���ڵݹ������ӵ�����ʱ��Ч�ʲ�����
	 * @param n
	 */
	static void printProbability(int n){
		if(n < 1)
			return ;
		int maxValue = Single_MaxValue * n;
		int[] pProbabilities = new int[maxValue-n+1];
		probability(n,pProbabilities);
		
		int totalCondition = (int) Math.pow(10, n); //�����ܴ���
		for (int i = 0; i < pProbabilities.length; i++) {
			System.out.println(i+n+"��ĸ���:"+pProbabilities[i]+"/"+totalCondition);
		}
	}
    static void probability(int n, int[] pProbabilities) {
		for (int i = 1; i <= Single_MaxValue; i++) {
			probability(n , n , i , pProbabilities);
		}
	}
    static void probability(int n , int layer,int sum , int[] pProbabilities){
    	if(layer == 1){
    		pProbabilities[sum-n] ++;
    	}else{
    		for (int i = 1; i <= Single_MaxValue; i++) {
    			probability(n , layer-1 , sum+i , pProbabilities);
    		}
    	}
    }
    
    /**
     * �ⷨ��: ����ѭ�������ӵ�����ʱ�����ܺ�
     * 		��һ���е�һ�������еĵ�n�������е�n�����ֱ�ʾ���Ӻ�Ϊn���ֵĴ�����
     * 		����һ��ѭ���У����Ǽ���һ���µ����ӣ���ʱ��Ϊn�����ӳ��ֵĴ���Ӧ��
     * 		����һ��ѭ�������ӵ�����Ϊn-1,n-2,n-3,n-4,n-5,n-6�Ĵ����ܺ͡�
     * @param n
     */
    static void printProbability1(int n){
    	if(n < 1)
    		return ;
    	int[][] pProbaility = new int[2][Single_MaxValue*n+1];
    	int fFlag = 0;
    	//��һ���������ݳ�ʼ��Ϊ1
    	for (int i = 1; i <= Single_MaxValue; i++) {
			pProbaility[fFlag][i] = 1; 
		}
    	//���������������
    	for(int i = 2; i <= n; i++) {
    		for (int m = 0; m < i; m++) {
    			pProbaility[1-fFlag][m] = 0;
			}
    		for (int j = i; j <= i*Single_MaxValue; j++) {
    			pProbaility[1-fFlag][j] = 0;
    			for (int k = 1; j-k > 0 && k <= Single_MaxValue; k++) {
    				pProbaility[1-fFlag][j] += pProbaility[fFlag][j-k];
				}
			}
    		fFlag = 1 - fFlag;
		}
    	int totalCondition = (int) Math.pow(10, n); //�����ܴ���
		for (int i = n; i < n*Single_MaxValue+1; i++) {
			System.out.println(i+"��ĸ���:"+pProbaility[fFlag][i]+"/"+totalCondition);
		}
    }
}
