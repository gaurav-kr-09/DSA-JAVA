package SetsAndMaps.Maps;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class MinTimeToBurnABinaryTree {
    // method -1 : samajhna aasan master wala tarika
    /*static class Pair{
        Node node;
        int dist;
        Pair(Node node, int dist){
            this.node = node;
            this.dist = dist;
        }
    }

    private static Node startNode = null;
    private static int amountOfTime(Node root, int start) {
        // map of child and parent
        HashMap<Node, Node> parent = new HashMap<>();
        // finding the startNode and putting the nodes and their parents in map
        dfs(root, start, parent);
        // making a queue of Pair (Node and distance i.e level for morphed tree) for tracking time which is no. of level
        Queue<Pair> q = new LinkedList<>();
        // making a set to keep track of burnt nodes
        HashSet<Node> burnt = new HashSet<>();
        // adding start node to queue and also to the burnt set
        burnt.add(startNode);
        int currDist = 0;
        q.add(new Pair(startNode, currDist));

        while(!q.isEmpty()){
            Pair front = q.remove();
            currDist = front.dist;
            Node currNode = front.node;

            //adding left to queue and burnt if present and not burnt
            if(currNode.left != null && !burnt.contains(currNode.left)){
                q.add(new Pair(currNode.left, currDist+1));
                burnt.add(currNode.left);
            }

            //adding right to queue and burnt if present and not burnt
            if(currNode.right != null && !burnt.contains(currNode.right)){
                q.add(new Pair(currNode.right, currDist+1));
                burnt.add(currNode.right);
            }

            //adding parent to queue and burnt if present and not burnt
            if(parent.containsKey(currNode) && !burnt.contains(parent.get(currNode))){
                q.add(new Pair(parent.get(currNode), currDist+1));
                burnt.add(parent.get(currNode));
            }

        }

        return currDist;
    }

    private static void dfs(Node root, int start, HashMap<Node, Node> parent){
        if(root == null) return;

        // getting the satrting node
        if(root.val == start) startNode = root;

        // putting the parent in map
        if(root.left != null) parent.put(root.left, root);
        if(root.right != null) parent.put(root.right, root);

        dfs(root.left, start, parent);
        dfs(root.right, start, parent);
    }*/

    // Method -2: method 1 optiized
    private static Node startNode = null;
    private static int amountOfTime(Node root, int start) {
        HashMap<Node, Node> parent = new HashMap<>();
        dfs(root, start, parent);

        Queue<Node> q = new LinkedList<>();
        int currDist = 0;

        q.add(startNode);
        parent.remove(root);

        while(!q.isEmpty()){
            int size = q.size();
            currDist++;

            for(int i = 0; i < size; i++){
                Node front = q.remove();
                if(front.left != null && parent.containsKey(front.left)){
                    q.add(front.left);
                    parent.remove(front.left);
                }

                if(front.right != null && parent.containsKey(front.right)){
                    q.add(front.right);
                    parent.remove(front.right);
                }

                if(parent.containsKey(front)){
                    q.add(parent.get(front));
                    parent.remove(front);
                }
            }

        }

        return currDist-1;
    }

    private static void dfs(Node root, int start, HashMap<Node, Node> parent){
        if(root == null) return;

        // getting the satrting node
        if(root.val == start) startNode = root;

        // putting the parent in map
        if(root.left != null) parent.put(root.left, root);
        if(root.right != null) parent.put(root.right, root);

        dfs(root.left, start, parent);
        dfs(root.right, start, parent);
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

        System.out.println(amountOfTime(a, 4)); // man le 4 me aag laga diye -> ans = 3
    }
}