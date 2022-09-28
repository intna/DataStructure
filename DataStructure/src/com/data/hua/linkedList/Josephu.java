package com.data.hua.linkedList;


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
    //解决约瑟夫问题:startNO:表示从第几个小孩开始数。countNum:表示数几下。nums:表示最初有多少个小孩在圈中
    public void conntBoy(int startNO,int countNum,int nums){
       //先进行数据校验 
       if (first == null || startNO < 1 || startNO > nums) {
          System.out.println("参数输入有误，请重新输入");
       }
      //创建辅助指针，帮助小孩出圈
        Boy helper = first;
        //helper最先应指向环形链表的最后这个结点
        while(true){
           if(helper.getNext() == first){
               break;
           }
           helper = helper.getNext();
        }  
       //小孩报数前，先让helper和first移动staetNo-1次
       for (int j = 0; j < startNO; j++) {
           first = first.getNext();
           helper = helper.getNext();
        
       }
       //小孩报数
       while(true){
           if(helper.getNext() == first){
            break;
           }
            for(int j = 0; j < countNum-1;j++){
                first = first.getNext();
                helper = helper.getNext();
            } 
            //此时first指向的小孩就是要出圈的小孩
            first = first.getNext();
            helper.setNext(first);       
        }
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