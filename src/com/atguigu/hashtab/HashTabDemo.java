package com.atguigu.hashtab;

import java.util.Scanner;

public class HashTabDemo {
    public static void main(String[] args) {
        HashTab hashTab = new HashTab(7);
        String key = "";
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("add: 添加雇员");
            System.out.println("list: 显示雇员");
            System.out.println("find: 查找雇员");
            System.out.println("delete: 删除雇员");
            System.out.println("exit: 退出系统");
            key = scanner.next();
            switch (key){
                case "add":
                    System.out.println("输入id");
                    int id = scanner.nextInt();
                    System.out.println("输入名字");
                    String name  = scanner.next();
                    Emp emp = new Emp(id,name);
                    hashTab.add(emp);
                    break;
                case "list":
                    hashTab.list();
                    break;
                case "find":
                    System.out.println("请输入要查找的id");
                    id = scanner.nextInt();
                    hashTab.findEmpById(id);
                    break;
                case "delete":
                    System.out.println("请输入要删除的id");
                    id = scanner.nextInt();
                    hashTab.deleteById(id);
                    break;
                case "exit":
                    scanner.close();
                    System.exit(0);
                default:
                    break;
            }
        }
    }
}
//创建HashTab
class HashTab{
    private EmpLinkedList[] empLinkedListArray;
    private int size;
    public HashTab(int size){
        this.size = size;
//        初始化
        this.empLinkedListArray = new EmpLinkedList[size];
        //        这里有坑，不要忘记初始化每一个链表
        for (int i = 0; i < size; i++) {
            this.empLinkedListArray[i] = new EmpLinkedList();
        }
    }
    public void add(Emp emp){
//        根据id判断放入哪个链表
        int empLinkedListNo = hashFun(emp.id);
//        将emp添加到对应的链表中
        empLinkedListArray[empLinkedListNo].add(emp);
    }
    //    遍历哈希表
    public void list(){
        for (int i = 0; i < size; i++) {
            empLinkedListArray[i].list(i);
        }
    }
    public void findEmpById(int id){
        int empLinkedListNo = hashFun(id);
        Emp emp = empLinkedListArray[empLinkedListNo].findEmpById(id);
        if (emp != null){
            System.out.printf("在第%d条链表找到 雇员id= %d",(empLinkedListNo+1),id);
        }else {
            System.out.println("未找到");
        }
    }

    public void deleteById(int id){
        int empLinkedListNo = hashFun(id);
        empLinkedListArray[empLinkedListNo].delete(id);
    }
    //    编写散列函数，用取模法
    public int hashFun(int id){
        return id % size;
    }

}


//表示一个雇员
class Emp{
    public int id;
    public String name;
    public Emp next;//默认为null
    public Emp(int id, String name){
        super();
        this.id = id;
        this.name = name;
    }
}
//创建EmpLinkedList，表示链表
class EmpLinkedList{
    private Emp head;
    public void add(Emp emp){
        if (head == null){//链表到最后，直接添加
            head = emp;
            return;
        }else{
            Emp curEmp = head;//辅助指针，定位到最后
            while (true){
                if (curEmp.next == null){
                    break;
                }else {
                    curEmp = curEmp.next;
                }
            }
            curEmp.next = emp;

        }

//        退出时将emp加入链表
    }
    //    public void list( int no){
//        if (head == null){
//            System.out.print("第"+(no+1)+"链表为空");
//        }else{
//            System.out.print("第"+(no+1)+"链表信息为");
//            Emp curEmp = head;
//            while (true){
//                System.out.printf(" => id=%d name=%s\t",curEmp.id,curEmp.name);
//                if (curEmp.next == null){
//                    break;
//                }
//                curEmp = curEmp.next;
//
//            }
//        }
//        System.out.println();
//    }
    public void list(int no) {
        if (this.head == null) {
            System.out.println("第 " + (no + 1) + " 链表为空");
        } else {
            System.out.print("第 " + (no + 1) + " 链表的信息为");
            Emp curEmp = this.head;

            while(true) {
                System.out.printf(" => id=%d name=%s\t", curEmp.id, curEmp.name);
                if (curEmp.next == null) {
                    System.out.println();
                    return;
                }
                curEmp = curEmp.next;
            }
        }
    }
    public Emp findEmpById(int id){
        if (head == null){
            System.out.println("链表为空");
        }
        Emp curEmp = head;
        while (true){
            if (curEmp.id == id){
                break;
            }
            if (curEmp.next == null){
                curEmp = null;
                break;
            }
            curEmp = curEmp.next;
        }
        return curEmp;
    }
    public void delete(int id){
        if (head == null){
            System.out.println("链表为空");
        }else{
            Emp curEmp = head;
            boolean flag = false;
            while (true){
                if(head.id == id){//如何删除第一个结点？？？
//                    flag = true;
                    head = null;
                    break;
                }
                if (curEmp.next == null){
//                curEmp = null;
                    break;
                }
                if (curEmp.next.id == id){
                    flag = true;
                    break;
                }
                curEmp = curEmp.next;
            }

            if (flag){
                curEmp.next = curEmp.next.next;
                System.out.println("删除成功");
            }else {
                System.out.println("雇员不存在");
            }
        }

    }
}