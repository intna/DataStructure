package com.data.hua.linkedList;

import java.util.Properties;

/**
 * 约瑟夫问题
 */
class Josephu{
      public static void main(String[] args) {
    
        CricleSingleLinkedList cricleSingleLinkedList = new CricleSingleLinkedList();
        cricleSingleLinkedList.addBoy(20);
        cricleSingleLinkedList.showBoy();
}
}
//创建一个环形的单向链表
class CricleSingleLinkedList{
    private Boy first = null;
    public void addBoy(int nums){
        if (nums < 1) {
            System.out.println("nums的值不正确");
            return;
        }
        Boy curBoy = null;//辅助指针
        for (int i = 1; i <= nums; i++) {
           Boy boy = new Boy(i);
           if(i==1){
            first = boy;
            first.setNext(first);//构成环
            curBoy = first;
           }else{
            curBoy.setNext(boy);
            boy.setNext(first);
            curBoy = boy;
           }
            
        } 
    }
    //遍历当前环形链表
    public void showBoy() {
       if(first == null){
        System.out.println("环形链表为空");
        return;
       }
       Boy curBoy = first;
       while(true){
        System.out.println("小孩的编号是" + curBoy.getNo());
        if(curBoy.getNext() == first){
           break;
        }
        curBoy = curBoy.getNext();
       }
       

    }
}

//创建一个boy类表示结点
class Boy{
    private int no;
    private Boy next;
    
    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }

    public Boy(int no){
        this.no = no;
    }

    
}