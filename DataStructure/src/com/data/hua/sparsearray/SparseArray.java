package com.data.hua.sparsearray;

/**
 * 稀疏数组
 */
public class SparseArray {
    public static void main(String[] args) {
        int chessArr1[][] = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        for (int[] row : chessArr1) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

        /**
         * 遍历二维数组，将非零值放入稀疏数组
         */
        int sum = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArr1[i][j] != 0) {
                    sum++;
                }
            }
        }

        int sparseArr[][] = new int[sum + 1][3];
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;
        int count = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArr1[i][j] != 0) {
                   count++;
                   sparseArr[count][0] = i;
                   sparseArr[count][1] = j;
                   sparseArr[count][2] = chessArr1[i][j];
                }
            }
        }

        //输出稀疏数组
        //方法一：使用两层for循环，外层遍历行，在行中遍历列
        System.out.println();
        System.out.println("得到的稀疏数组为************");
        for (int[] row: sparseArr){
            for (int data: row){
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

        System.out.println("*****************");
        //方法二：使用一个for循环，遍历每一行，输出每一行的每一列
        for (int i = 0;i<sparseArr.length;i++){
            System.out.printf("%d\t%d\t%d\t\n",sparseArr[i][0],sparseArr[i][1],sparseArr[i][2]);
        }

        //将稀疏数组恢复成原始的二维数组,先根据稀疏数组第一行的值创建二维数组，再根据后面的值赋给二维数组的对应位置
        int a = sparseArr[0][0];
        int b = sparseArr[0][1];
        int chessArr2 [][] = new int[a][b];
        for (int i = 1;i<sparseArr.length;i++){
                chessArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
            System.out.println();
        }

        //遍历恢复后的二维数组
        for (int[] row : chessArr1) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
    }
}
