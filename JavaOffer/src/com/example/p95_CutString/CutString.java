package com.example.p95_CutString;

/**
 * 把长度为n的绳子剪成m段（n>1,m>1），每段绳子的长度记为k[1],...k[m]，则每段绳子的长度的最大乘积是多少？例如身子长度为8时
 * 	，剪成2,3,3三段得到的乘积最大，为18。

 * @author hp
 *
 */
public class CutString {
	
	public static void main(String[] args) {
		System.out.println(CutString.maxProductAfterCutting_solution1(4));
		System.out.println(CutString.maxProductAfterCutting_solution2(4));
	}
	
	/**
	 *方法1：动态规划的思想
	*	   假设长度为n的绳子被剪成若干段后，各段长度的最大乘积为f(n)。一刀下去可能的位置有1 ,2，...，n-1，
	*	j将绳子分为长度为i和n-i的两段，则f(n)=max{f(i)*f(n-i)}，i=1,2,...,n-1。从上往下递归时可能会有很多重复的计算
	*	因此采用从下往上的方式，先计算f(2),f(3)，后面的就可以依次计算了。n=2时，只有一种剪法，f(2)=1*1=1，n=3时，只有剪成1
	*	,2，f(3)=1*2=2*1=2。
	*	写代码要注意：n=2时，因为必须要剪一刀，只能剪成1和1，所以最大乘积是1，
	*	但是初始化f(2)的时候，是为了计算n>3的情况，因此如果有长度为2的肯定至少剪了一刀，这时候长度为2的最大乘积是2，
	*	初始化f(3)也是同理。
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
	 * 如果按照如下策略来剪绳子，则得到各段绳子的长度的乘积将最大。当n>=5时，尽可能多剪长度为3的绳子，当剩下绳子长度为4时，剪成2*2的两段。
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
		//如果最后一段是4  则不能再减去3的绳子了
		if(length - timeOf3*3 == 1)
			timeOf3--;
		int timeOf2 = (length - timeOf3*3)/2;
		return (int) (Math.pow(3, timeOf3)*Math.pow(2, timeOf2));
	}
	
}
