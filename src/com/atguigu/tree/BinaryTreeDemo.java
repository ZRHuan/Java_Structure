package com.atguigu.tree;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

public class BinaryTreeDemo {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        HeroNode root = new HeroNode(1, "宋江");
        HeroNode node2 = new HeroNode(2, "吴用");
        HeroNode node3 = new HeroNode(3, "卢俊义");
        HeroNode node4 = new HeroNode(4, "林冲");
        HeroNode node5 = new HeroNode(5, "关胜");

        root.setLeft(node2);
        root.setRight(node3);
        node3.setRight(node4);
        node3.setLeft(node5);
        binaryTree.setRoot(root);
        System.out.println("前序遍历");
        binaryTree.preOrder();
        System.out.println("中序遍历");
        binaryTree.infixOrder();
        System.out.println("后序遍历");
        binaryTree.postOrder();

//        前序遍历查找
//        System.out.println("前序遍历查找");
//        HeroNode resNode = binaryTree.preOrderSearch(5);
//        if (resNode != null){
//            System.out.printf("找到了信息为 no=%d name = %s",resNode.getNo(),resNode.getName());
//        }else {
//            System.out.printf("没有找到 no = %d 的英雄",5);
//        }
//        HeroNode resNode = binaryTree.infixOrderSearch(5);
//        if (resNode != null){
//            System.out.printf("找到了信息为 no=%d name = %s",resNode.getNo(),resNode.getName());
//        }else {
//            System.out.printf("没有找到 no = %d 的英雄",5);
//        }
//        HeroNode resNode = binaryTree.postOrderSearch(5);
//        if (resNode != null){
//            System.out.printf("找到了信息为 no=%d name = %s",resNode.getNo(),resNode.getName());
//        }else {
//            System.out.printf("没有找到 no = %d 的英雄",5);
//        }
        System.out.println("删除前，前序遍历");
        binaryTree.preOrder();
        binaryTree.delNode(5);
        System.out.println("删除后，前序遍历");
        binaryTree.preOrder();

    }


}
class BinaryTree{
    private HeroNode root;

    public void setRoot(HeroNode root) {
        this.root = root;
    }
    public void delNode(int no){
        if (root != null){
            if(root.getNo() == no){
                root = null;
            }else {
                root.delNode(no);
            }
        }else {
            System.out.println("为空，无法删除");
        }
    }
    //    前序遍历
    public void preOrder(){
        if (this.root != null){
            this.root.preOrder();
        }else {
            System.out.println("二叉树为空，无法遍历");
        }
    }
    //    中序遍历
    public void infixOrder(){
        if (root != null){
            this.root.infixOrder();
        }else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    //    后序遍历
    public void postOrder(){
        if (root != null){
            this.root.postOrder();
        }else {
            System.out.println("二叉树为空，无法遍历");
        }
    }
    //    前序遍历查找
    public HeroNode preOrderSearch(int no){
        if (this.root != null){
            return this.root.preOrderSearch(no);
        }else {
            return null;
        }

    }
    //  中序遍历查找
    public HeroNode infixOrderSearch(int no){
        return this.root != null ? this.root.infixOrderSearch(no) : null;
    }
    //    后序遍历查找
    public HeroNode postOrderSearch(int no){
        return this.root != null ? this.root.postOrderSearch(no) : null;
    }


}

class HeroNode{
    private int no;
    private String name;
    private HeroNode left;
    private HeroNode right;

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
//1我们的二叉树是单向的，所以我们是判断当前结点的子结点是否需要删除结点，而不能去判断当前这个结点是不是需要删除结
//2如果当前结点的左子结点不为空，并且左子结点就是要删除结点，就将this.left=null;并且就返回（结束递归删除）
//3如果当前结点的右子结点不为空，右子结点就是要删除结点，就将 this.right=null;并且就返回（结束递归删除）
//4如果第2和第3步没有删除结点，那么我们就需要向左子树进行递归删除
//5如果第4步也没有删除结点，则应当向右子树进行递归删除
    public void delNode(int no){
        if (this.left != null && this.left.no == no){
            this.left = null;
            return;
        }
        if (this.right != null && this.right.no == no){
            this.right = null;
            return;
        }
        if (this.left != null){
            this.left.delNode(no);
        }
        if (this.right != null){
            this.right.delNode(no);
        }
    }
    //      前序遍历
    public void preOrder(){
        System.out.println(this);
        if (this.left != null){
            this.left.preOrder();
        }
        if (this.right != null){
            this.right.preOrder();
        }
    }
    //    中序遍历
    public void infixOrder(){
        if (this.left != null){
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right != null){
            this.right.infixOrder();
        }
    }
    //    后序遍历
    public void postOrder(){
        if (this.left != null){
            this.left.postOrder();
        }
        if (this.right != null){
            this.right.postOrder();
        }
        System.out.println(this);
    }
    //    前序遍历查找
    public HeroNode preOrderSearch(int no){
        System.out.println("前序遍历查找");
        if (this.no == no){
            return this;
        }
        HeroNode resNode = null;
        if (this.left != null){
            resNode = this.left.preOrderSearch(no);
        }
        if (resNode != null){
            return resNode;
        }
        if (this.right != null){
            resNode = this.right.preOrderSearch(no);
        }
        return resNode;
    }
    //    中序遍历查找
    public HeroNode infixOrderSearch(int no){
        HeroNode resNode = null;
        if (this.left != null){
            resNode = this.left.infixOrderSearch(no);
        }
        if (resNode != null){
            return resNode;
        }
        System.out.println("中序遍历查找");//放在比较语句的前面
        if (this.no == no){
            return this;
        }
        if (this.right != null){
            resNode = this.right.infixOrderSearch(no);
        }
        return resNode;
    }
    //    后序遍历查找
    public HeroNode postOrderSearch(int no){
        HeroNode resNode = null;
        if (this.left != null){
            resNode = this.left.postOrderSearch(no);
        }
        if (resNode != null){
            return resNode;
        }
        if (this.right != null){
            resNode = this.right.postOrderSearch(no);
        }
        if (resNode != null){
            return resNode;
        }
        System.out.println("后序遍历查找");
        if (this.no == no){
            return this;
        }
        return resNode;
    }

}