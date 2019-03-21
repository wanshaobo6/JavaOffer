package com.example2.p27_numberString;
/**
 * /**
 * ��ʾ��ֵ���ַ���
 * <p>
 * �ж�һ���ַ����Ƿ��ʾ��ֵ����+100,5e2��-123��-1E-16���ǣ�12e��1e3.14��+-5,1.2.3,12e+5.4�����ǡ�
 * ��ʾ����ʾ��ֵ���ַ�����ѭģʽA[.[B]][e|EC] ���� .B[e|EC];A,B,C��ʾ������|��ʾ��[]��ʾ���п��ޡ�
 * <p>
 * ����Ҳû��ûʲô����˼·���Ͱ���A[.[B]][e|EC] ���� .B[e|EC];A,B,C������ģʽ һֱɨ��ƥ���¼��ɡ�
 * @author ���ٲ�
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
	        //�ж�С������
	        if(inx<str.length && str[inx]=='.'){
	            inx = inx+1;
	            flag = scanUInteger(str)||flag;     //����a,�������·�
	        }
	        //�ж�ָ������
	        if(inx<str.length && (str[inx]=='e' || str[inx]=='E')){
	            inx = inx+1;
	            flag = flag&&scanInteger(str);
	        }
	        return flag&& inx>=str.length;
	    }

	    //�ж��Ƿ�������
	    public static boolean scanInteger(char[] str){
	        if(inx<str.length &&(str[inx]=='+' || str[inx]=='-')){
	            inx = inx+1;
	        }
	        return scanUInteger(str);
	    }

	    //�ж��Ƿ����޷�������
	    public static boolean scanUInteger(char[] str){
	        int inx1=inx;
	        while(inx<str.length && str[inx]>='0' && str[inx]<='9'){
	           inx = inx + 1;
	        }
	        return inx>inx1;
	    }
}