package com.example2.p14_printToMaxOfNDigit;

/**
 * 打印从1到最大的n位数
 * <p>
 *课外扩展:8bit型字符最多能够标识256个字符，而十进制数字只有0~9的10个数字，因此char型没有好好利用内存，有一些浪费，有没有更高效的方式
 * @author 万少波
 */
public class PrintToMaxOfNDigit {
	public static void main(String[] args) {
		//PrintToMaxOfNDigit_1(100);
		printToMaxOfDigits(2);
	}
	
	/**
	 *
	 * 如输入2，打印1,2......98,99
	 * 注意：本题需要考虑大数问题，用字符串解决大数问题是最好的解决方案之一
	 * 用字符串表示数字的时候，最直观的方法就是字符串里每个字符都是‘0’到‘9’之间的某一个字符，用来表示数字中的一位。因为最大的是n位的，
	 * 因此我们需要一个长度为n+1的字符串（字符串中最后一个是结束符号‘\0’。当实际数字不够n位的时候，在字符串的前半部分补0）。
	 * <p>
	 * 首先我们把字符串中的每一个数字都初始化为‘0’，然后每一次为字符串表示的数字加1，再打印出来。
	 * 故我们只需要做两件事：一是在字符串表达数字上模拟加法，二是把字符串表达的数字打印出来。
	 * <p>
	 * 在字符串表达数字上模拟加法，我们首先设置是否溢出标识，是否进位标识，以及取得字符数组长度，遍历这个字符数组，在末尾进行+1操作，
	 * 如果末尾字符在+1后变为不小于10的数字，我们将末尾减去10加上‘0’字符赋值为末位，进位标识设置为1，在循环次位时+1，
	 * 然后再判断是否为不小于10，是的话重复上面的步骤。
	 * 直到判断高位是不是不小于10，是的话字符数组溢出；
	 * 如果末尾字符在+1后是小于10的数字，直接加上‘0’赋值给末尾，跳出当前循环，返回没有溢出。
	 * <p> 
	 */
	static void PrintToMaxOfNDigit_1(int n){
		if(n<=0)
			return;
		char[] number = new char[n];
		initNumber(number,'0');
		while(increment(number)){
			printNumber(number);
		}
	}

	/**
	  * 在字符串表达的数字打印出来方法时，没有什么特别，直接利用for循环遍历输出字符数组，
	  * 但是要从高位第一个不是0的开始输出。
	 * @param number
	 */
	private static void printNumber(char[] number) {
		// TODO Auto-generated method stub
		if(number == null)
			return;
		boolean sFlag = false;
		for(int i=0 ; i< number.length ;i++){
			if(number[i] != '0')
				sFlag = true;
			if(sFlag){
				System.out.print(number[i]);
			}
		}
		System.out.println();
	}

	private static boolean increment(char[] number) {
		// TODO Auto-generated method stub
		if(number == null)
			return false;
		boolean overFlowFlag = false;  //溢出标识
		int nTakeOver = 0; //进位标识
		int nLength = number.length;
		for(int i = nLength-1 ; i>=0 ;i--){
			int nSum  = number[i] - '0' + nTakeOver;
			if(i == nLength-1)
				nSum++;
			if(nSum>=10){
				//位溢出
				if(i==0){
					//首位溢出
					return false;
				}else{
					//其他位溢出
					nSum -=10;
					nTakeOver = 1;
					number[i] = (char) ('0' + nSum);
				}
			}else{
				//没溢出
				number[i] = (char) ('0'+nSum);
				break;
			}
		}
		return true;
	}
	
	private static void initNumber(char[] number, char c) {
		// TODO Auto-generated method stub
		if(number == null)
			return ;
		for(int i=0;i<number.length ;i++){
			number[i] = c;
		}
	}
	
	/**
	 * 
	 * <p>
	 * 同时把问题转化为数字排列的解法，使用递归可以使代码简洁明了。
	 * 即：如果在所有的数字前面补0的话，就会发现n位所有的十进制数其实就是n个从0到9的全排列。
	 * 也就是说，我们把数字的每一位都从0到9排列一遍，就得到了所有的十进制数。在打印时，数字排在前面的0不打印。
	 * <p>
	 * 全排列递归实现最容易。数字的每一位都可能是0到9的一个数，然后设置下一位。递归结束的条件就是我们已经设置了数字的最后一位。
	 * @param n
	 */
	static void printToMaxOfDigits(int n){
		if(n<=0)
			return ;
		char[] number = new char[n];
		print1ToMaxOfNDigitsRecursively(number,n,0);
	}
	
	static void print1ToMaxOfNDigitsRecursively(char[] number , int length , int index){
		if(index == length){
			printNumber(number);
			return;
		}
		for(int i=0; i<=9 ;i++){
			number[index] = (char) ('0'+i);
			print1ToMaxOfNDigitsRecursively(number, length, index+1);
		}
	}
}
