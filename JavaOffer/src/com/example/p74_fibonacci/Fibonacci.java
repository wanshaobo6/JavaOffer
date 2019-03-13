package com.example.p74_fibonacci;
/**
 * 쳲���������
 * ��Ϊ���ĵݹ���Ŀ��쳲�������Ҷ�����̫İ�����������ֻ�õݹ飬����ɺܴ��ʱ��Ϳռ����ģ����Եݹ鲢������õİ취��ʱ�临�Ӷ�Ϊo(2^n)
 * ����Ҫ�����ظ������԰Ѽ��������ֵ�洢�������Ͳ����ٽ����ظ�����ģ������Ļ�ʱ�临�Ӷ�ΪO(n)9
 * ���ǻ������õȱ����еĹ�ʽ���м��㣬ʱ�临�Ӷ�ΪO(nlogn)
 * ��򵥵ģ���������ͨ�ʽ���м��㣬ʵ��O(1)��ʱ�临�Ӷ�
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
	 *�ݹ�ʵ�ִ���ʱ��ռ����� Ч�ʺܵ� ���Թٲ���ϲ��
	 *ʱ�临�Ӷ�o(2^n)
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
	 * ��ͨѭ��
	 * ʱ�临�Ӷ�o(n) �ռ临�Ӷ�o(1) 
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
	 * ����������ѧ��ʽ������⡣����˷����֣����õݹ�����ʱ�临�Ӷ�o(logn)  ���ǲ���ʵ��
	 * [ f(n)  f(n-1) ] = [ 1  1 ] ^ n-1   (��n>2)       =>    nΪż�� an = a 2/n * a 2/n
	 * [f(n-1) f(n-2) ]   [ 1  0 ]						 =>    nΪ���� an = a (n-1)/2 * a (n-1)/2 *n
	 * ֤��:
	 * [ f(n)  f(n-1) ] = [ f(n-1)+f(n-2)  f(n-1)] = [ f(n-1)  f(n-2)] * [1 1]
	 * [f(n-1) f(n-2) ]   [ f(n-2)+f(n-3)  f(n-2)]   [ f(n-2)  f(n-3)]   [1 0]
	 * �õ����ϵ���ʽ������
	 * [ f(n)  f(n-1) ] = [ f(2)  f(1)] * [1 1]^n-2 = [1 1]^n-1
	 * [f(n-1) f(n-2) ]   [ f(1)  f(0)]   [1 0]       [1 0]
	 */
	public static long fibonacci3(int n){
		int[][] start = {{1, 1}, {1, 0}};
		return matrixPow(start, n - 1)[0][0];
	}
	
	/**
	 * �����n����
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
		if((n & 1) == 0){ //λ�������ж��Ƿ���ż��
			return matrixMultiply(matrixPow(start,n >> 1),matrixPow(start,n >> 1)); //λ�������
		}else{
			/*return matrixMultiply(matrixMultiply(matrixPow(start,(n-1)/2),matrixPow(start,(n-1)/2)),start);*/
			return matrixMultiply(start, matrixPow(start, n - 1));
		}
		
		
	}
	/**
	 * ����˷�
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
