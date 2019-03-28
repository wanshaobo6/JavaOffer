package com.example3.p27_minNumberConsistOfArray;

import java.util.Arrays;
import java.util.Comparator;

import com.example.utils.SortUtils;

/**
 *  面试题45: 把数组排成最小的数
 *     题目:
 *     	 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 *     		例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。 
 *     思路1: 根据排列组合，n个数字共有n!个排列,时间复杂度过高
 *     思路2: 确定一个排序规则,要比较两个数字,也就是给出两个数字m和n , 如果mn< nm我们应该打出mn , 一个非常直观的解决问题就是把数字解决成字符串。
 *     		对字符串进行排序，即可实现
 *     
 *     证明比较规则的有效性
 *     首先我们需要证明之前定义的比较两个数字大小的规则是有效的。一个有效的比较需要三个条件：1.自反性，即a等于a；2.对称性，即如果a大于b，则b小于a；3.传递性，即如果a小于b，b小于c，则a小于c。现在分别予以证明。

		1.      
		自反性。显然有aa=aa，所以a=a。
		2.       对称性。如果a小于b，则ab<ba，所以ba>ab。因此b大于a。
		3.       传递性。如果a小于b，则ab<ba。当a和b用十进制表示的时候分别为l位和m位时，ab=a×10m+b，ba=b×10l+a。所以a×10m+b<b×10l+a。于是有a×10m-a<b×10l –b，即a(10m -1)<b(10l-1)。所以a/(10l -1)<b/(10m -1)。
		如果b小于c，则bc<cb。当c表示成十进制时为m位。和前面证明过程一样，可以得到b/(10m -1)<c/(10n -1)。
		所以a/(10l -1)< c/(10n -1)。于是a(10n -1)<c(10l -1)，所以a×10n +c<c×10l +a，即ac<ca。
		所以a小于c。
		
		在证明了我们排序规则的有效性之后，我们接着证明算法的正确性。我们用反证法来证明。
		我们把n个数按照前面的排序规则排好顺序之后，表示为A1A2A3…An。我们假设这样排出来的两个数并不是最小的。即至少存在两个x和y（0<x<y<n），交换第x个数和地y个数后，A1A2…Ay…Ax…An<A1A2…Ax…Ay…An。
		由于A1A2…Ax…Ay…An是按照前面的规则排好的序列，所以有Ax<Ax+1<Ax+2<…<Ay-2<Ay-1<Ay。
		由于Ay-1小于Ay，所以Ay-1Ay<AyAy-1。我们在序列A1A2…Ax…Ay-1Ay…An交换Ay-1和Ay，有A1A2…Ax…Ay-1Ay…An<A1A2…Ax…AyAy-1…An（这个实际上也需要证明。感兴趣的读者可以自己试着证明）。我们就这样一直把Ay和前面的数字交换，直到和Ax交换为止。于是就有A1A2…Ax…Ay-1Ay…An<A1A2…Ax…AyAy-1…An<A1A2…Ax…AyAy-2Ay-1…An<…< A1A2…AyAx…Ay-2Ay-1…An。
		同理由于Ax小于Ax+1，所以AxAx+1<Ax+1Ax。我们在序列A1A2…AyAxAx+1…Ay-2Ay-1…An仅仅只交换Ax和Ax+1，有A1A2…AyAxAx+1…Ay-2Ay-1…An<A1A2…AyAx+1Ax…Ay-2Ay-1…An。我们接下来一直拿Ax和它后面的数字交换，直到和Ay-1交换为止。于是就有A1A2…AyAxAx+1…Ay-2Ay-1…An<A1A2…AyAx+1Ax…Ay-2Ay-1…An<…< A1A2…AyAx+1Ax+2…Ay-2Ay-1Ax…An。
		所以A1A2…Ax…Ay…An<A1A2…Ay…Ax…An。这和我们的假设的A1A2…Ay…Ax…An <A1A2…Ax…Ay…An相矛盾。
 * @author 万少波
 *
 */
public class MinNumberConsistOfArray {
	public static void main(String[] args) {
		int[] numArray = {3,32,321};
		printMinNumber(numArray);
	}
	/**
	 * 思路2:  时间复杂度o(nlogn)
	 * @param numArray
	 */
	static void printMinNumber(int[] numArray){
		if(numArray == null || numArray.length == 0)
			return ;
		//将整形数组变成字符串数组
		String[] numArrayStr = new String[numArray.length];
		for (int i = 0; i < numArrayStr.length; i++) {
			numArrayStr[i] = new String(String.valueOf(numArray[i]));
		}
		SortUtils.showArray(numArrayStr);
		//快速排序字符串  
		SortUtils.QuickSortGeneric(numArrayStr, 0, numArrayStr.length-1,new Comparator<String>() {

			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return Integer.valueOf(o1+o2) - Integer.valueOf(o2+o1);
			}
		});
		SortUtils.showArray(numArrayStr);
	}
}
