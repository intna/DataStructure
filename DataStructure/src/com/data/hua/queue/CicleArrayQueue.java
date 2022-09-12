package com.data.hua.queue;

import java.util.Scanner;

public class CicleArrayQueue {
    public static void main(String[] args) {
        System.out.println("测试数组模拟环形队列的案例");
        CicleArray arrayQueue = new CicleArray(3);
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        //输出一个菜单
        while (loop) {
            System.out.println("s: 显示队列");
            System.out.println("e: 退出程序");
            System.out.println("a: 添加数据");
            System.out.println("g: 取出数据");
            System.out.println("p: 查看头部数据");
            key = scanner.next().charAt(0);
            switch (key) {
                case 's':
                    arrayQueue.showQueue();
                    break;
                case 'a':
                    System.out.println("请输入要添加的数");
                    int value = scanner.nextInt();
                    arrayQueue.addQueue(value);
                    break;
                case 'g':
                    try {
                        int res = arrayQueue.getData();
                        System.out.printf("取出的数据是%d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'p':
                    try {
                        int res = arrayQueue.peek();
                        System.out.printf("头部的数据是%d\n", res);
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


        }
}

class CicleArray {
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;

    public CicleArray(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        front = 0;
        rear = 0;
    }

    //判断队列是否满
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    //判断队列是否为空
    public boolean isEmpty() {
        return rear == front;
    }

    //添加数据到队列
    public void addQueue(int n) {
        if (isFull()) {
            System.out.println("队列已满不能加入数据");
            return;
        }
        arr[rear] = n;
        //将rear后移，这里必须取模，因为是环形队列可能回到头部。
        rear = (rear + 1) % maxSize;
    }

    //出队列
    public int getData() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        //先将要取出的元素放入一个变量保存，再将front后移
        int value = arr[front];
        front = (front + 1) % maxSize;
        return value;
    }


    //遍历队列
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列为空，没有数据");
            return;
        }
        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d] = %d\n", i % maxSize, arr[i % maxSize]);
        }
    }

    //求出当前队列有效个数的值，供遍历环形队列使用
    public int size() {
        return (rear + maxSize - front) % maxSize;
    }

    //显示队列的头数据
    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空不能取数据");
        }
        return arr[front];
    }
}