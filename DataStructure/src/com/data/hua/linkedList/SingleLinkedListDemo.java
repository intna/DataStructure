package com.data.hua.linkedList;

public class SingleLinkedListDemo {
    public static void main(String[] args) {

    }
}


class SingleLinkedList{
    private HeroNode head = new HeroNode(0,"","");
    public void add(HeroNode heroNode){
        HeroNode temp = head;
        while (true) {
            if (temp.next == null){
                break;
            }
            temp = temp.next;
        }
        temp.next = heroNode;
    }
 
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
            System.out.println(temp);
            temp = temp.next;
        }
    }
    
    public void addByOrder(HeroNode heroNode){
        //头节点不能移动所以需要一个辅助变量temp，单链表插入需要移动至插入位置前一个元素
        HeroNode temp =head;
        boolean flag =false;//默认插入位置编号不存在
        while(true){
            if(temp.next == null){
                break;//说明已经到末尾
            }
            if(temp.next.no > heroNode.no){
                break;
            }else if(temp.next.no == heroNode.no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if(flag){
            System.out.println("所插入编号的元素已存在");
        }else{
            heroNode.next = temp.next;
            temp.next = heroNode;
        }  







    }

}




class HeroNode{
    public int no;
    public String name;
    public String nickName;
    public HeroNode next;
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
