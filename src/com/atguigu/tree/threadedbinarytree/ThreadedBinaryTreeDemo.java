package com.atguigu.tree.threadedbinarytree;

public class ThreadedBinaryTreeDemo {
    public static void main(String[] args) {
        HeroNode root = new HeroNode(1, "Tom");
        HeroNode node2 = new HeroNode(3, "Jack");
        HeroNode node3 = new HeroNode(6, "smith");
        HeroNode node4 = new HeroNode(8, "mary");
        HeroNode node5 = new HeroNode(10, "king");
        HeroNode node6 = new HeroNode(14, "dim");

        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);

        ThreadedBinaryTree threadedBinaryTree = new ThreadedBinaryTree();
        threadedBinaryTree.setRoot(root);
        System.out.println("中序遍历");
        threadedBinaryTree.threadedNodes();
        threadedBinaryTree.threadedList();


//        HeroNode leftNode = node5.getLeft();
//        System.out.println(leftNode);
//        HeroNode rightNode = node5.getRight();
//        System.out.println(rightNode);
    }
}



class ThreadedBinaryTree{
    private HeroNode root;
    private HeroNode pre = null;

    public void threadedNodes(){
        this.threadedNodes(root);
    }
//中序遍历线索化二叉树
    public void threadedList(){
//        /定义一个变量，存储当前遍历的结点，从root开始
        HeroNode node = root;
        while (node != null){
//      /循环的找到leftType==1的结点，第一个找到就是8结点
//      /后面随着遍历而变化，因为当leftType=1时，说明该结点是按照线索化
//      //处理后的有效结点
            while (node.getLeftType() == 0){
                node = node.getLeft();
            }

            System.out.println(node);

            while (node.getRightType() == 1){
                node = node.getRight();
                System.out.println(node);
            }
            node = node.getRight();
//            if (node.getRightType() == 1){
//                node = node.getRight();
//            }else if(node.getRight() == null){
//                break;
//            }
//            node = node.getRight();
        }
    }
//    前序遍历线索化二叉树
    public void preThreadedList(){
        HeroNode node = root;
        while (node != null){
            System.out.println(node);

            while (node.getLeftType() == 0){
                node = node.getLeft();
                System.out.println(node);
            }
            if (node.getRightType() == 1){
                node = node.getRight();
            }else if(node.getRight() == null){
                break;
            }
        }
    }
//中序线索化二叉树
    public void threadedNodes(HeroNode node){
//        node就是当前需要线索化的结点
        if (node == null){
            return;
        }
        threadedNodes(node.getLeft());//线索化左子树
//处理前驱结点
        if(node.getLeft() == null){
            node.setLeft(pre);
            node.setLeftType(1);
        }
//        处理后继节点
        if (pre != null && pre.getRight() == null){
            pre.setRight(node);
            pre.setRightType(1);
        }
        //!!!每处理一个结点后，让当前结点是下一个结点的前驱结点
        pre = node;
        threadedNodes(node.getRight());//线索化右子树
    }
//    前序线索化二叉树
    public void preThreadedNodes(){
        this.preThreadedNodes(root);
    }
    public void preThreadedNodes(HeroNode node){
        if (node == null){
            return;
        }
        if(node.getLeft() == null){
            node.setLeft(pre);
            node.setLeftType(1);
        }
        if (pre != null && pre.getRight() == null){
            pre.setRight(node);
            pre.setRightType(1);
        }
        pre = node;
        if (node.getLeftType() == 0){
            preThreadedNodes(node.getLeft());
        }
        if (node.getRightType() == 0){
            preThreadedNodes(node.getRight());

        }

    }
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
///1、如果lefttype==0表示指向的是左子树，如果1则表示指向前驱结点
///2.如果 righttype==0表示指向是右子树，如果1表示指向后继结点
    private int leftType;
    private int rightType;

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

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