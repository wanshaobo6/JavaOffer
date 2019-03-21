package com.example2.p27_numberString;
/**
 * /**
 * 表示数值的字符串
 * <p>
 * 判断一个字符串是否表示数值，如+100,5e2，-123，-1E-16都是，12e，1e3.14，+-5,1.2.3,12e+5.4都不是。
 * 提示：表示数值的字符串遵循模式A[.[B]][e|EC] 或者 .B[e|EC];A,B,C表示整数，|表示或。[]表示可有可无。
 * <p>
 * 此题也没有没什么特殊思路，就按照A[.[B]][e|EC] 或者 .B[e|EC];A,B,C这两种模式 一直扫描匹配下即可。
 * @author 万少波
 *
 */
public class NumberString {
	public static void main(String[] args) {
		System.out.println(isNumeric("+100".toCharArray()));
		System.out.println(isNumeric("5e2".toCharArray()));
		System.out.println(isNumeric("-123".toCharArray()));
		System.out.println(isNumeric("3.1416".toCharArray()));
		System.out.println(isNumeric("-1E-16".toCharArray()));
		System.out.println(isNumeric(".6".toCharArray()));
		System.out.println(isNumeric("6.".toCharArray()));
		System.out.println(isNumeric("12e".toCharArray()));
		System.out.println(isNumeric("1a3.14".toCharArray()));
		System.out.println(isNumeric("1.2.3".toCharArray()));
		System.out.println(isNumeric("+-5".toCharArray()));
		System.out.println(isNumeric("12e+5.4".toCharArray()));
	}
	
	private static int inx;
	
	  public static boolean isNumeric(char[] str) {
	        if(str==null || str.length==0){
	            return false;
	        }
	        inx = 0;
	        boolean flag = scanInteger(str);
	        //判断小数部分
	        if(inx<str.length && str[inx]=='.'){
	            inx = inx+1;
	            flag = scanUInteger(str)||flag;     //解释a,见代码下方
	        }
	        //判断指数部分
	        if(inx<str.length && (str[inx]=='e' || str[inx]=='E')){
	            inx = inx+1;
	            flag = flag&&scanInteger(str);
	        }
	        return flag&& inx>=str.length;
	    }

	    //判断是否是整数
	    public static boolean scanInteger(char[] str){
	        if(inx<str.length &&(str[inx]=='+' || str[inx]=='-')){
	            inx = inx+1;
	        }
	        return scanUInteger(str);
	    }

	    //判断是否是无符号整数
	    public static boolean scanUInteger(char[] str){
	        int inx1=inx;
	        while(inx<str.length && str[inx]>='0' && str[inx]<='9'){
	           inx = inx + 1;
	        }
	        return inx>inx1;
	    }
}