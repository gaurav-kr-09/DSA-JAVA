package BinaryTrees.Traversal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class PreInPostIterativeDFS {
    private static ArrayList<Integer> preOrder(Node root){
        ArrayList<Integer> ans = new ArrayList<>();
        Stack<Node> st = new Stack<>();
        st.push(root);

        while (!st.isEmpty()){
            Node top = st.pop();
            ans.add(top.val);
            if(top.right != null) st.push(top.right);
            if(top.left != null) st.push(top.left);
        }
        return ans;
    }

    // inorder
    /*private static ArrayList<Integer> inOrder(Node root){
        ArrayList<Integer> ans = new ArrayList<>();
        Stack<Node> st = new Stack<>();
        Node curr = root;

        while(!st.isEmpty() || curr != null){
            if(curr != null){
                if(curr.left != null){
                    st.push(curr);
                    curr = curr.left;
                }else{
                    ans.add(curr.val);
                    curr = curr.right;
                }
            }else{
                Node top = st.pop();
                ans.add(top.val);
                curr = top.right;
            }
        }
        return ans;
    }*/

    // better inorder
    private static ArrayList<Integer> inOrder(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        Stack<Node> st = new Stack<>();
        Node curr = root;

        while(curr != null || !st.isEmpty()){
            while(curr != null){
                st.push(curr);
                curr = curr.left;
            }

            curr = st.pop();
            ans.add(curr.val);

            curr = curr.right;
        }

        return ans;
    }

    private static ArrayList<Integer> postOrder(Node root){
        ArrayList<Integer> ans = new ArrayList<>();
        Stack<Node> st = new Stack<>();
        st.push(root);

        while (!st.isEmpty()){
            Node top = st.pop();
            ans.add(top.val);
            if(top.left != null) st.push(top.left);
            if(top.right != null) st.push(top.right);
        }
        Collections.reverse(ans);
        return ans;
    }

    public static void main(String[] args) {
        //         3
        //       /   \
        //      4     2
        //     / \    / \
        //   -1   1  6   9

        Node a = new Node(3);
        Node b = new Node(4);
        Node c = new Node(2);
        Node d = new Node(-1);
        Node e = new Node(1);
        Node f = new Node(6);
        Node g = new Node(9);


        a.left = b; a.right = c;
        b.left = d; b.right = e;
        c.left = f; c.right = g;

        System.out.println("The preorder tree is: " + preOrder(a)); // 3 4 -1 1 2 6 9

        System.out.println("The inorder tree is: " + inOrder(a)); // -1 4 1 3 6 2 9

        System.out.println("The postorder tree is: " + postOrder(a)); // -1 1 4 6 9 2 3
    }
}
