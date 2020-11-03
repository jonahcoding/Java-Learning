package com.shinrin.java;

/*
--------------------
一、数组：
	多个相同数据类型的元素和一定顺序排列的集合。
二、数组相关概念：
	数组名、元素、下标、长度。
三、特点：
	1.有序排列。
 	2.数组是引用类型，元素可以是基本数据类型，也可以是引用数据类型。
 	3.数组内存空间连续。
 	4.数组长度固定，一经初始化无法修改。
四、分类：
	一维数组：数组元素为基本数据类型或引用
	二维数组：数组元素为数组
五、一维数组使用：
	1.声明、初始化
	2.数组元素默认初始化。
	3.调用指定位置元素
	4.遍历数组
	5.获取数组长度
	6.数组内存解析。
  
--------------------
 */

public class ArrayOneDimensional {
	public static void main(String[] args) {
		//1.1.静态初始化
		int[] ids;
		ids = new int[] {1,2,3,4};
		//int[] ids = {1,2,3,4};
		//1.2.动态初始化 
		String[] heros = new String[5];
		
		//2.数组元素默认初始化
		//整型：0
		//浮点型：0.0
		//字符型：0 或 '\u0000'
		//boolean：false
		
		//3.下标访问
		heros[0] = "Teemo";
		heros[1] = "Yasuo";
		heros[2] = "Jinx";
		heros[3] = "Jax";
		heros[4] = "Jarven4th";
		
		//4.长度 / 5.遍历
		System.out.println("数组长度是：" + heros.length);
		System.out.print("打印数组元素：");
		for (int i = 0; i < heros.length; i++) {
			System.out.print(heros[i] + " ");//String元素默认值为null
		}
		System.out.println();
		
		//6.内存解析
		//堆：数组、对象
		//栈：局部变量
		
		
	}
}
