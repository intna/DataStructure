package com.data.hua.queue;

import java.util.Scanner;

public class CicleArrayQueue {
    public static void main(String[] args) {
        System.out.println("��������ģ�⻷�ζ��еİ���");
        CicleArray arrayQueue = new CicleArray(3);
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        
        while (loop) {
            System.out.println("s: ��ʾ����");
            System.out.println("e: �˳�����");
            System.out.println("a: ��������");
            System.out.println("g: ȡ������");
            System.out.println("p: �鿴ͷ������");
            key = scanner.next().charAt(0);
            switch (key) {
                case 's':
                    arrayQueue.showQueue();
                    break;
                case 'a':
                    System.out.println("������Ҫ���ӵ���");
                    int value = scanner.nextInt();
                    arrayQueue.addQueue(value);
                    break;
                case 'g':
                    try {
                        int res = arrayQueue.getData();
                        System.out.printf("ȡ����������%d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'p':
                    try {
                        int res = arrayQueue.peek();
                        System.out.printf("ͷ����������%d\n", res);
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

    
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

  
    public boolean isEmpty() {
        return rear == front;
    }

    
    public void addQueue(int n) {
        if (isFull()) {
            System.out.println("�����������ܼ�������");
            return;
        }
        arr[rear] = n;
        
        rear = (rear + 1) % maxSize;
    }

  
    public int getData() {
        if (isEmpty()) {
            throw new RuntimeException("����Ϊ��");
        }
       
        int value = arr[front];
        front = (front + 1) % maxSize;
        return value;
    }


    //��������
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("����Ϊ�գ�û������");
            return;
        }
        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d] = %d\n", i % maxSize, arr[i % maxSize]);
        }
    }

    //�����ǰ������Ч������ֵ�����������ζ���ʹ��
    public int size() {
        return (rear + maxSize - front) % maxSize;
    }

    //��ʾ���е�ͷ����
    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("����Ϊ�ղ���ȡ����");
        }
        return arr[front];
    }
}