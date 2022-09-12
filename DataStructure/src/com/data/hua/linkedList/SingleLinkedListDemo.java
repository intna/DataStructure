package com.data.hua.linkedList;

public class SingleLinkedListDemo {
    public static void main(String[] args) {

    }
}

/**
 * 定义一个单链表管理英雄节点HeroNode
 */
class SingleLinkedList{
    //先初始化一个头节点，不动且不存放数据
    private HeroNode head = new HeroNode(0,"","");

    /**
     * 添加节点到当前链表。思路：找到当前链表的最后节点，将这个节点的next指向新的节点
     */

    public void add(HeroNode heroNode){
       //因为head节点不能动，所以我们需要一个辅助遍历temp
        HeroNode temp = head;
        //遍历链表，找到最后
        while (true) {
            if (temp.next == null){
                break;
            }
            temp = temp.next;
        }
        temp.next = heroNode;
    }
    //显示链表
    public void list(){
        if (head.next == null){
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head.next;
        while (true){
            if (temp == null){
                break;
            }
            //输出节点信息
            System.out.println(temp);
            //将temp后移
            temp = temp.next;
        }
    }
}




class HeroNode{
    public int no;
    public String name;
    public String nickName;
    public HeroNode next;
    //构造器
    public HeroNode(int hNo,String hName,String hNickname) {
        this.no = hNo;
        this.name = hName;
        this.nickName = hNickname;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                ", next=" + next +
                '}';
    }
}
