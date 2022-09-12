package com.data.hua.sparsearray;

/**
 * ϡ������
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
         * ������ά���飬������ֵ����ϡ������
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

        //���ϡ������
        //����һ��ʹ������forѭ�����������У������б�����
        System.out.println();
        System.out.println("�õ���ϡ������Ϊ************");
        for (int[] row: sparseArr){
            for (int data: row){
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

        System.out.println("*****************");
        //��������ʹ��һ��forѭ��������ÿһ�У����ÿһ�е�ÿһ��
        for (int i = 0;i<sparseArr.length;i++){
            System.out.printf("%d\t%d\t%d\t\n",sparseArr[i][0],sparseArr[i][1],sparseArr[i][2]);
        }

        //��ϡ������ָ���ԭʼ�Ķ�ά����,�ȸ���ϡ�������һ�е�ֵ������ά���飬�ٸ��ݺ����ֵ������ά����Ķ�Ӧλ��
        int a = sparseArr[0][0];
        int b = sparseArr[0][1];
        int chessArr2 [][] = new int[a][b];
        for (int i = 1;i<sparseArr.length;i++){
                chessArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
            System.out.println();
        }

        //�����ָ���Ķ�ά����
        for (int[] row : chessArr1) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
    }
}