package com.data.hua.queue;

import java.util.Scanner;

public class ArrayQueueDemo {
    public static void main(String[] args) {

        /**
         * test
         */
        ArrayQueue arrayQueue = new ArrayQueue(3);
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        //?????????
        while (loop) {
            System.out.println("s: ???????");
            System.out.println("e: ???????");
            System.out.println("a: ????????");
            System.out.println("g: ???????");
            System.out.println("p: ?????????");
            key = scanner.next().charAt(0);
            switch (key) {
                case 's':
                    arrayQueue.showQueue();
                    break;
                case 'a':
                    System.out.println("??????????????");
                    int value = scanner.nextInt();
                    arrayQueue.addQueue(value);
                    break;
                case 'g':
                    try {
                        int res = arrayQueue.getData();
                        System.out.printf("???????????%d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'p':
                    try {
                        int res = arrayQueue.peek();
                        System.out.printf("???????????%d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;

            }
        }

        System.out.println("???????");
    }
}

/**
 * ????????????????
 */
class ArrayQueue {
    //?????????????????????????????????¦Â?????????????
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;

    //???????§Û?????
    public ArrayQueue(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        front = -1;
        rear = -1;
    }

    //?§Ø?????????
    public boolean isFull() {
        return rear == maxSize - 1;
    }

    //?§Ø??????????
    public boolean isEmpty() {
        return rear == front;
    }

    //?????????????
    public void addQueue(int n) {
        if (isFull()) {
            System.out.println("???????????????????");
            return;
        }
        rear++;
        arr[rear] = n;
    }

    //??????
    public int getData() {
        if (isEmpty()) {
            throw new RuntimeException("???????");
        }
        front++;
        return arr[front];
    }

    //????????
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("???????????????");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d] = %d\n", i, arr[i]);
        }
    }

    //??????§Ö??????
    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("???????????????");
        }
        return arr[front + 1];
    }

}