package com.example2.p10_power;

/**
 /**
 * 数值的整数次方
 * <p>
 * 实现函数double power（double base，int exponent），求base的exponent次方。不能使用库函数，不需要考虑大数问题。
 * 可能我们的第一想法永远是利用循环进行求值，如果要考虑到0和负数，可以将指数先求绝对值，然后算出结果后取倒数。
 * 既然要求倒数，我们很自然的想到，有没有可能对0取倒数
 * 同时需要说明，0的零次方是没有意义的，返回0或者1都可以
 * 这样的话 我们可能需要循环指数-1次
 * <p>
 * 如果输入的指数是32.那么需要循环31次，我们换一种思路：
 * 我们的目标是求一个数字的32次方，如果我们知道它的16次方，那么只要在16次方的基础上在平方就可以了
 * 而16是8次方的平方，以此类推，求32次方只需要做5次乘法
 * 如果是奇数，则再多求一次乘法
 * @author 万少波
 *
 */
public class Power {
	
	public static void main(String[] args) {
		System.out.println(System.currentTimeMillis());
		System.out.println(pow1(5,-555555555));
		System.out.println(System.currentTimeMillis());
		System.out.println(System.currentTimeMillis());
		System.out.println(powerWithExponent(5,-555555555));
		System.out.println(System.currentTimeMillis());
	}
	
	/**
	 * 递归成一棵树 时间复杂度o(2的logn次方) 空间复杂度o(logn)   效率较差
	 * @param base
	 * @param exponent
	 * @return
	 */
	static double pow1(double base,int exponent){
		if(base == 0)
			return 0;
		if(exponent == 0)
			return 1;
		boolean negativeFlag = exponent < 0 ? true : false;
		if(negativeFlag){
			exponent = - exponent;
		}
		double result ;
		if(exponent % 2 == 0){
			//偶数
			result =  pow1(base,exponent>>1) * pow1(base,exponent>>1);
		}else{
			//奇数
			result =  pow1(base,(exponent-1)/2) * pow1(base,(exponent-1)/2)*base;
		}
		return negativeFlag ? 1/result : result;
	}
	
	/**
	 * 时间复杂度o(logn) 空间复杂度o(logn) 
	 * @param base
	 * @param exponent
	 * @return
	 */
	static double powerWithExponent(double base,int exponent){
		if(base == 0)
			return 0;
		if(exponent == 0)
			return 1;
		if(exponent == 1)
			return base;
		
		boolean negativeFlag = exponent < 0 ? true : false;
		if(negativeFlag){
			exponent = - exponent;
		}
		
		double result = powerWithExponent(base,exponent>>1);
		result *= result;
		if((exponent & 0x1) == 1){
			result *=base;
		}
		
		return negativeFlag ? 1/result : result;
	}
}
