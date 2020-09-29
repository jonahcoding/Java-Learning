package com.shinrin.exer;

/*
--------------------
杨辉三角：
	1.第n行有n个元素。
	2.每一行首尾元素为1。
	3.第三行开始，非首尾元素满足：arr[i][j] = arr[i-1][j-1] + arr[i-1][j];
  
--------------------
*/

public class YangHuiTriangle {

	public static void main(String[] args) {
		//声明初始化
		int[][] yanghui = new int[10][];
		//赋值
		for (int i = 0; i < yanghui.length; i++) {
			yanghui[i] = new int[i+1];
			yanghui[i][0] = 1;
			yanghui[i][i] = 1;
			if(i > 1) {
				for (int j = 1; j < yanghui[i].length-1; j++) {
					yanghui[i][j] = yanghui[i-1][j-1] + yanghui[i-1][j];
				}
			}
		} 
		//打印
		for (int i = 0; i < yanghui.length; i++) {
			for (int j = 0; j < yanghui[i].length; j++) {
				
				System.out.print(yanghui[i][j] + " ");
			}
			System.out.println();
		}
	}
}
