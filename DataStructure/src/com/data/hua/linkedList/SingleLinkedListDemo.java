package com.data.hua.linkedList;

public class SingleLinkedListDemo {
    public static void main(String[] args) {

    }
}

/**
 * ����һ�����������Ӣ�۽ڵ�HeroNode
 */
class SingleLinkedList{
    //�ȳ�ʼ��һ��ͷ�ڵ㣬�����Ҳ��������
    private HeroNode head = new HeroNode(0,"","");

    /**
     * ��ӽڵ㵽��ǰ����˼·���ҵ���ǰ��������ڵ㣬������ڵ��nextָ���µĽڵ�
     */

    public void add(HeroNode heroNode){
       //��Ϊhead�ڵ㲻�ܶ�������������Ҫһ����������temp
        HeroNode temp = head;
        //���������ҵ����
        while (true) {
            if (temp.next == null){
                break;
            }
            temp = temp.next;
        }
        temp.next = heroNode;
    }
    //��ʾ����
    public void list(){
        if (head.next == null){
            System.out.println("����Ϊ��");
            return;
        }
        HeroNode temp = head.next;
        while (true){
            if (temp == null){
                break;
            }
            //����ڵ���Ϣ
            System.out.println(temp);
            //��temp����
            temp = temp.next;
        }
    }
}




class HeroNode{
    public int no;
    public String name;
    public String nickName;
    public HeroNode next;
    //������
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
