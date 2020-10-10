package com.shinrin.java;

/*
--------------------
一、二维数组使用：
1.声明、初始化
2.数组元素默认初始化。
3.调用指定位置元素
4.遍历数组
5.获取数组长度
6.数组内存解析。
  
--------------------
 */

public class ArrayTwoDimensional {
	public static void main(String[] args) {
		//静态初始化
		int[][] arr1 = new int[][]{{1,1},{1,2},{1,3}};
		//动态初始化
		String[][] arr2 = new String[3][2];
		String[][] arr3 = new String[3][];
		
		int[][] arr4 = new int[][] {{1,2,3},{4,5},{6,7,8}};
		int[][] arr5 = {{1,2,3},{4,5},{6,7,8}};
		
		System.out.println(arr2[2][1]);
		System.out.println(arr4[2][1]);
		
		//二维数组长度
		System.out.println("二维数组arr5的长度是：" + arr5.length);//3
		
		//遍历二维数组
		System.out.println("打印二维数组arr5：");
		for (int i = 0; i < arr5.length; i++) {
			for (int j = 0; j < arr5[i].length; j++) {
				System.out.print(arr5[i][j] + " ");
			}
		}
		System.out.println();
		
		String[][] arr6 = new String[3][5];
		//二维数组元素默认初始值
		//外层数组元素：地址值
		//内层数组元素：
		System.out.println(arr6[0]);//外层元素地址值
		System.out.println(arr6[1][1]);//内层元素null
	}
}
