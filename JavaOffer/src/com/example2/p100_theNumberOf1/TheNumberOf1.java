package com.example2.p100_theNumberOf1;

  /**
	*实现一个函数，输入一个int型整数，输出该数字在计算机中二进制表示形式的1的个数。
	* 例如9->1001,输出2；-3->11111111111111111111111111111101,输出31。
	* <p>
	* 思路：这道题主要考察二进制和位运算，总体思路就是想判断二进制数字的最后一位是不是1，接着将输入整数右移一位，再依次判断
	* 但是这样的话会有一个问题是，如果输入是负数，会一直陷入死循环
	* 为了避免死循环，我们可以不右移数字n，首先把n和1做与运算，判断最低位是不是1，然后把1左移一位，再和n做与运算，就能判断n的次低位是不是1
 	* 这样的话，循环次数等于整数二进制的位数，32位的整数需要循环32次，下面的算法中，整数二进制有几个1就只需要循环几次 
    */
public class TheNumberOf1 {
	public static void main(String[] args) {
		System.out.println(numberOf1_1(9));
		System.out.println(numberOf1_2(9));
		System.out.println(numberOf1_2(9));
	}
	
	/**
	 * 遇到负数无法解决
	 * @param n
	 * @return
	 */
	public static int numberOf1_1(int n){
		int count = 0;
		while(n!=0){
			if((n&1) == 1){
				count++;
			}
			//乘除比位运算效率低很多，所以这里可以用/2但是不推荐
			n = n>>1;
		}
		return count;
	}
	
	/**
	 * 改进版本 不移动n 改为移动flag
	 * @param n
	 * @return
	 */
	public static int numberOf1_2(int n){
		int count = 0;
		int flag = 1;
		while(flag != 0){
			if((n&flag) != 0){
				count++;
			}
			flag = flag << 1;
		}
		return count;
	}
	
	/**
	 *   把一个整数减去1，再和原整数做与运算 ，就会把该整数最右边的1变成0.那么一个整数
	 * 那么一个整数的二进制有多少个1就可以进行次这样的运算
	 * @param n
	 * @return
	 */
	public static int numberOf1_3(int n){
		int count = 0;
		while(n != 0){
			count++;
			n = (n-1)&n;
		}
		return count;
	}

}
