package com.example.p74_fibonacci;
/**
 * 斐波那契数列
 * 作为最经典的递归题目，斐波那契大家都不会太陌生，但是如果只用递归，会造成很大的时间和空间消耗，所以递归并不是最好的办法，时间复杂度为o(2^n)
 * 我们要避免重复，可以把计算出来的值存储起来，就不用再进行重复计算的，这样的话时间复杂度为O(n)9
 * 我们还可以用等比数列的公式进行计算，时间复杂度为O(nlogn)
 * 最简单的，还可以用通项公式进行计算，实现O(1)的时间复杂度
 * 
 * 
 **/
public class Fibonacci {
	
	public static void main(String[] args) {
		System.out.println(System.currentTimeMillis());
		System.out.println(fibonacci2(13));
		System.out.println(System.currentTimeMillis());
		System.out.println(System.currentTimeMillis());
		System.out.println(fibonacci3(13));
		System.out.println(System.currentTimeMillis());
	}
	
	/**
	 *递归实现大量时间空间消耗 效率很低 面试官不会喜欢
	 *时间复杂度o(2^n)
	 * @param n
	 * @return
	 */
	public static long fibonacci1(int n){
		if(n<=0){
			return 0;
		}
		if(n==1){
			return 1;
		}
		return fibonacci1(n-1)+fibonacci1(n-2);
	}
	
	/**
	 * 普通循环
	 * 时间复杂度o(n) 空间复杂度o(1) 
	 * @param n
	 * @return
	 */
	public static long fibonacci2(int n){
		if(n<=0){
			return 0;
		}
		if(n==1){
			return 1;
		}
		long fibMinusOne = 0;
		long fibMinusTwo = 1;
		long fibN = 1;
		for(int i=2 ; i<=n ;i++){
			 fibMinusTwo = fibMinusOne+fibMinusTwo;
			 fibMinusOne = fibN;
			 fibN = fibMinusTwo;
		}
		return fibN;
	}
	
	/**
	 * 借助如下数学公式解决问题。矩阵乘法部分，可用递归解决，时间复杂度o(logn)  但是不够实用
	 * [ f(n)  f(n-1) ] = [ 1  1 ] ^ n-1   (当n>2)       =>    n为偶数 an = a 2/n * a 2/n
	 * [f(n-1) f(n-2) ]   [ 1  0 ]						 =>    n为奇书 an = a (n-1)/2 * a (n-1)/2 *n
	 * 证明:
	 * [ f(n)  f(n-1) ] = [ f(n-1)+f(n-2)  f(n-1)] = [ f(n-1)  f(n-2)] * [1 1]
	 * [f(n-1) f(n-2) ]   [ f(n-2)+f(n-3)  f(n-2)]   [ f(n-2)  f(n-3)]   [1 0]
	 * 得到如上递推式，所以
	 * [ f(n)  f(n-1) ] = [ f(2)  f(1)] * [1 1]^n-2 = [1 1]^n-1
	 * [f(n-1) f(n-2) ]   [ f(1)  f(0)]   [1 0]       [1 0]
	 */
	public static long fibonacci3(int n){
		int[][] start = {{1, 1}, {1, 0}};
		return matrixPow(start, n - 1)[0][0];
	}
	
	/**
	 * 矩阵的n次幂
	 * @param start
	 * @param n
	 * @return
	 */
	public static int[][] matrixPow(int[][] start, int n) {
	/*	if(n==1)
			return start;
		if(n%2 == 0){
			return matrixMultiply(matrixPow(start,n/2),matrixPow(start,n/2));
		}else{
			return matrixMultiply(matrixMultiply(matrixPow(start,(n-1)/2),matrixPow(start,(n-1)/2)),start);
		}*/
		if(n==1)
			return start;
		if((n & 1) == 0){ //位运算与判断是否是偶数
			return matrixMultiply(matrixPow(start,n >> 1),matrixPow(start,n >> 1)); //位运算减半
		}else{
			/*return matrixMultiply(matrixMultiply(matrixPow(start,(n-1)/2),matrixPow(start,(n-1)/2)),start);*/
			return matrixMultiply(start, matrixPow(start, n - 1));
		}
		
		
	}
	/**
	 * 矩阵乘法
	 * @param x
	 * @param y
	 * @return
	 */
	public static int[][] matrixMultiply(int[][] x , int[][] y){
		int xColums ;
		int yRows ;
		if(x == null || x.length == 0 || y == null || y.length == 0 || (xColums = x[0].length)!= (yRows =y.length)){
			return null;
		}
		int xRows  = x.length;
		int yColums  = y[0].length;
		int[][] matrixResult = new int[xRows][yColums];
		for(int i = 0; i < xRows ; i++){
			for(int j = 0 ; j < yColums ; j++){
				int currValue = 0;
				for(int k=0;k<xColums;k++){
					currValue += x[i][k] * y[k][j];
				}
				matrixResult[i][j] = currValue;
			}
		}
		return matrixResult;
	}
}
