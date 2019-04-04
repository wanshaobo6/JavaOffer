package com.example3.p94_prinyProbability;

/**
 *  面试题60: n个骰子的点数
 *  		把n个骰子仍在地上，所有的骰子朝上的一面的点数之和为s，输入n，打印出s所有可能的值出现的概率。
 *  
 *  思路:玩过麻将的都知道，骰子一共6个面，每个面上都有一个点数，对应的数字是1到 6之间的一个数字。所以，n
 *  	个骰子的点数和的最小值为n，最大值为6n。因此，一个直观的思路就是定义一个长度为6n-n+1的数组，和为S的
 *  	点数出现的次数保存到数组第S-n个元素里。另外，我们还知道n个骰子的所有点数的排列数6^n。一旦我们统计
 *  	出每一点数出现的次数之后，因此只要把每一点数出现的次数除以n^6，就得到了对应的概率。
 *  
 * @author 万少波
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
	 * 解法一:基于递归求骰子点数，时间效率不够高
	 * @param n
	 */
	static void printProbability(int n){
		if(n < 1)
			return ;
		int maxValue = Single_MaxValue * n;
		int[] pProbabilities = new int[maxValue-n+1];
		probability(n,pProbabilities);
		
		int totalCondition = (int) Math.pow(10, n); //计算总次数
		for (int i = 0; i < pProbabilities.length; i++) {
			System.out.println(i+n+"点的概率:"+pProbabilities[i]+"/"+totalCondition);
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
     * 解法二: 基于循环求骰子点数，时间性能好
     * 		第一轮中第一个数组中的第n个数组中第n个数字表示骰子和为n出现的次数，
     * 		在下一轮循环中，我们加上一个新的骰子，此时和为n的骰子出现的次数应等
     * 		于上一轮循环中骰子点数和为n-1,n-2,n-3,n-4,n-5,n-6的次数总和。
     * @param n
     */
    static void printProbability1(int n){
    	if(n < 1)
    		return ;
    	int[][] pProbaility = new int[2][Single_MaxValue*n+1];
    	int fFlag = 0;
    	//第一个骰子数据初始化为1
    	for (int i = 1; i <= Single_MaxValue; i++) {
			pProbaility[fFlag][i] = 1; 
		}
    	//填充其他骰子数据
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
    	int totalCondition = (int) Math.pow(10, n); //计算总次数
		for (int i = n; i < n*Single_MaxValue+1; i++) {
			System.out.println(i+"点的概率:"+pProbaility[fFlag][i]+"/"+totalCondition);
		}
    }
}
