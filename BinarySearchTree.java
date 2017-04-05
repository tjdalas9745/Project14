import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//import static java.lang.Math.max;

/**
 * Created by sjeon on 2017-04-04.
 */
public class BinarySearchTree {
    static TreeNode rootNode = null;

    private static class TreeNode{
        private int data;
        TreeNode leftNode;
        TreeNode rightNode;

        public TreeNode(int data){
            this.data = data;
        }
    }

    public static BinarySearchTree getBinaryTree(){
        return new BinarySearchTree();
    }

    public static TreeNode insertNode(TreeNode rootNode, int data){
        if(rootNode == null){
            rootNode = new TreeNode(data);
        } else if(rootNode.data >= data){
            rootNode.leftNode = insertNode(rootNode.leftNode, data);
        }else{
            rootNode.rightNode = insertNode(rootNode.rightNode, data);
        }
        return rootNode;
    }

    public static boolean searchNode(TreeNode rootNode, int data){
        if(rootNode == null){
            return false;
        } else if(rootNode.data == data){
            return true;
        } else if(rootNode.data >= data){
            return searchNode(rootNode.leftNode, data);
        }else{
            return searchNode(rootNode.rightNode, data);
        }
    }

    public static int findHeight(TreeNode rootNode){
        //base case of empty tree
        if(rootNode == null) return -1;
        return Math.max(findHeight(rootNode.leftNode), findHeight(rootNode.rightNode) + 1);
    }

    //breath first search algorithm   BFS
    public static void LevelOrder(TreeNode root){
        if(root == null) return;

        Queue<TreeNode> queueToVisit = new LinkedList<>();
        queueToVisit.add(rootNode);

        //while there is at least one discovered node
        while(!queueToVisit.isEmpty()){
            TreeNode currentNode =  queueToVisit.peek();
            System.out.print(currentNode.data + "  ");
            if(currentNode.leftNode != null) queueToVisit.add(currentNode.leftNode);
            if(currentNode.rightNode != null) queueToVisit.add(currentNode.rightNode);
            queueToVisit.remove();
        }
    }

    //Depth First Search Algorithm DFS
    //<root><left><right>  pre-order traversal

    public static void Preorder(TreeNode root){
        //base case
        if(root == null) return;

        System.out.println(root.data + "   ");

        /*if(root.leftNode != null)*/ Preorder(root.leftNode);
        /*if(root.rightNode != null)*/ Preorder(root.rightNode);
    }

    public static void Inorder(TreeNode root){
        if(root == null) return;

        Inorder(root.leftNode);
        System.out.print(root.data + "  ");
        Inorder(root.rightNode);
    }

 /*   public static int FindMax(TreeNode root){
        if(root == null) return 0;

    }
*/
    public static boolean IsSubtreeLesser(TreeNode root, int value){
        if(root == null) return true;
        if(root.data <= value
                && IsSubtreeLesser(root.leftNode, root.data)
                && IsSubtreeLesser(root.rightNode, root.data)) {
                return true;
        }else
            return false;
    }

    public static boolean IsSubtreeGreater(TreeNode root, int value){
        if(root == null) return true;

        if(root.data > value
                && IsSubtreeLesser(root.leftNode, value)
                && IsSubtreeLesser(root.rightNode, value)){
            return true;
        }else
            return false;
    }

    public static boolean IsBinarySearchTree(TreeNode root){
        if(root == null) return true;

        if(IsSubtreeLesser(root.leftNode, root.data )
                && IsSubtreeGreater(root.rightNode, root.data)
                && IsBinarySearchTree(root.leftNode)
                && IsBinarySearchTree(root.rightNode)){
            return true;
        }else
            return false;
    }

    public static void main(String[] args){
        BinarySearchTree Solution = getBinaryTree();
        rootNode = insertNode(rootNode, 11);
        rootNode = insertNode(rootNode, 41);
        rootNode = insertNode(rootNode, 2);
        rootNode = insertNode(rootNode, 5);
        rootNode = insertNode(rootNode, 17);
        rootNode = insertNode(rootNode, 13);
        rootNode = insertNode(rootNode, 1);

        //LevelOrder(rootNode);
        Inorder(rootNode);

        System.out.println(IsBinarySearchTree(rootNode));


        Scanner sc = new Scanner(System.in);




        while(true){
            int searchInt = sc.nextInt();
            System.out.println("search result of "+ searchInt + ".  result = " + searchNode(rootNode, searchInt));
        }
    }

}