package com.shinrin.sparsearray;

/*
----------------------------------------
稀疏数组：
    1.创建原始二维数组
    2.获取原始数组异值个数sum。
    3.创建稀疏数组(sum+1)*3
    4.稀疏数组赋值（第一元素记录原始行、列、异值数）
    5.打印稀疏数组
    6.复原原始二维数组
----------------------------------------
 */
public class SparseArray {
    public static void main(String[] args) {
        //创建棋盘，放置棋子：0为空，1为白，2为黑。
        int chessArr[][] = new int[11][11];
        chessArr[1][2] = 1;
        chessArr[2][3] = 2;
        chessArr[4][5] = 2;

        System.out.println("原始棋盘数组：");
        for (int[] row: chessArr) {
            for (int data: row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

        //1.获取棋盘非0数据的个数
        int sum = 0;
        for (int i = 0; i < chessArr.length; i++) {
            for (int j = 0; j < chessArr[i].length; j++) {
                if (chessArr[i][j] != 0){
                    sum++;
                }
            }
        }
        //2.创建稀疏数组
        int sparseArr[][] = new int[sum+1][3];
        //稀疏数组第一个元素记录原数组行列数以及棋子个数。
        sparseArr[0][0] = chessArr.length;
        sparseArr[0][1] = chessArr[0].length;
        sparseArr[0][2] = sum;
        //稀疏数组棋子元素赋值
        int count = 0;
        for (int i = 0; i < chessArr.length; i++) {
            for (int j = 0; j < chessArr[0].length; j++) {
                if (chessArr[i][j] != 0){
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr[i][j];
                }
            }
        }
        //3.输出稀疏数组
        System.out.println("稀疏数组：");
        for (int i = 0; i < sparseArr.length; i++) {
            System.out.printf("%d\t%d\t%d\t\n",sparseArr[i][0],sparseArr[i][1],sparseArr[i][2]);
        }
        System.out.println();
        //4.复原数组
        int[][] newChessArr = new int[sparseArr[0][0]][sparseArr[0][1]];
        for (int i = 1; i < sparseArr.length; i++) {
            newChessArr[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }
        //5.打印复原数组
        System.out.println("复原原始数组：");
        for (int[] row: chessArr) {
            for (int data: row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
    }
}
