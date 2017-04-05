import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//import static java.lang.Math.max;

/**
 * Created by sjeon on 2017-04-04.
 */
public class BinaryTreeChar {
    static TreeNode rootNode = null;

    private static class TreeNode{
        private char data;
        TreeNode leftNode;
        TreeNode rightNode;

        public TreeNode(char data){
            this.data = data;
        }
    }

    public static BinarySearchTree getBinaryTree(){
        return new BinarySearchTree();
    }

    public static TreeNode insertNode(TreeNode rootNode, char data){
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

    public void LevelOrder(TreeNode root){
        if(root == null) return;

        Queue<TreeNode> queueToVisit = new LinkedList<>();

        //while there is at least one discovered node
        while(!queueToVisit.isEmpty()){
            TreeNode currentNode =  queueToVisit.peek();
            System.out.print(currentNode.data + "  ");
            if(currentNode.leftNode != null) queueToVisit.add(currentNode.leftNode);
            if(currentNode.rightNode != null) queueToVisit.add(currentNode.rightNode);
            queueToVisit.remove();
        }

    }





    public static void main(String[] args){
        BinarySearchTree Solution = getBinaryTree();
        rootNode = insertNode(rootNode, 'f');
        rootNode = insertNode(rootNode, 'd');
        rootNode = insertNode(rootNode, 'b');
        rootNode = insertNode(rootNode, 'w');
        rootNode = insertNode(rootNode, 'c');
        rootNode = insertNode(rootNode, 'a');
        rootNode = insertNode(rootNode, 'm');

        Scanner sc = new Scanner(System.in);
        int searchInt = sc.nextInt();

        System.out.println("search result of "+ searchInt + ".  result = " + searchNode(rootNode, searchInt));


    }

}