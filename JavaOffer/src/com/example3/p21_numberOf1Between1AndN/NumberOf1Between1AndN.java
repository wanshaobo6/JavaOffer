package com.example3.p21_numberOf1Between1AndN;

/**
 *  面试题43： 1~n整数中1出现的次数
 *  	题目：
 * 			输入一个整数n，求从1到n这n个整数的十进制表示中1出现的次数。例如输入12，从1到12这些整数中包含1的数字有1， 10, 11和12；1一共出现了5次。
 * @author 万少波
 *
 */
public class NumberOf1Between1AndN {
	public static void main(String[] args) {
		System.out.println(getNumberOf1Between1AndN1(12));
		System.out.println(NumberOf1Between1AndN_Solution(12));
	}
	/**方式1:  时间复杂度o(nlogn)
	 * 		不考虑时间复杂度  靠它想拿到offer有点难
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
	 * 方式2   从数字规律中明显提高时间效率 ， 能让面试官耳目一新
	 * 		例如:1~21345中1出现的次数
	 * 			1.将21345分成两段  1-1345 和 1346-21345
	 * 			2.分析最高为出现的1次数  如果首位是1则出现的次数是后面的位数次
	 * 									如果不是则出现的是10^4次
	 * 			3.除了最高位的其他4位 中每位都能取值0-9 因为第一个数字是2 所以是2*剩余位数*10^位数-1 次(例如1346-11345 ,
	 * 				 第一个4未出现1的次数为10^3 , 第二个为10*10^2)
	 * 			4.剩下部分递归求解 
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
