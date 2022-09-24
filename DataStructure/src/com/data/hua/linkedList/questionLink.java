package com.data.hua.linkedList;

import java.util.Stack;

class questionLink{
  

    /**
     * 单链表面试题
     */


    //求单链表中有效结点的个数。思路：直接遍历
    public int count(HeroNode head){
        if(head.next == null){
            return 0;
        }

        int count = 0;
        HeroNode temp = head;
        while(temp.next != null){
            temp = temp.next;
            count++;
        }
        return count;
    }


    //查找单链表中倒数第K个结点(新浪面试题)。思路：编写一个方法接受index和head结点，index表示倒数第几个，
    //遍历整个链表得到长度len。再用(len-index)遍历到(len-index)即可
    public static HeroNode heroNodeCount(HeroNode head,int index){
        if(head.next == null){
          return head;
        }

        HeroNode temp = head;
        int len = 0;
        while(temp.next != null){
            len++;
            temp = temp.next;
        }

        int a = len - index;
        for(int i = 0;i <= a;i++){
            temp = temp.next;
        }
        return temp;
    }

    //单链表反转(腾讯面试题)。思路：双指针，新建一个头结点，使用指针遍历原链表，每遍历一个，取下该节点
    //第一个取下的结点放在新头结点的后一个，第二个取下后放在头结点后一个，并让其指向第一个取下的结点，以此类推。
    public static void reverseList(HeroNode head){
        if(head.next == null || head.next.next == null){
            System.out.println("链表为空或只有一个元素");
        }
        
        HeroNode temp = head;
        HeroNode next = null;
        HeroNode reHead = new HeroNode(0,"","");

        while(temp.next != null){
            next = temp.next.next;
            reHead = temp.next.next;
            reHead.next = temp.next;
            temp.next = next;
        }
        head.next = reHead.next;

    }
    //从尾到头打印单链表(百度面试题)。思路：利用栈，先进后出
    public static void reverseP(HeroNode head){
        if(head.next == null){
            System.out.println("链表为空");
        }

        Stack<HeroNode> stack = new Stack<HeroNode>();

        HeroNode cur = head.next;

        while(cur != null){
            stack.push(cur);
            cur = cur.next;
        }

        while(stack.size() > 0){
            System.out.println(stack.pop());
        }

    }
}






























































