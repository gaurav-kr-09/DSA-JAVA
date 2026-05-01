package BinarySearchTree;

public class SortedArrayToBST {
    private static Node sortedArrayToBST(int[] arr) {
        return convert(arr, 0, arr.length - 1);
    }

    private static Node convert(int[] arr, int lo, int hi){
        if(lo > hi) return null;
        int mid = lo + (hi-lo) / 2;
        Node root = new Node(arr[mid]);
        root.left = convert(arr, lo, mid-1);
        root.right = convert(arr, mid+1, hi);
        return root;
    }

    private static void display(Node root){
        if(root == null) return;
        System.out.print(root.val+" ");
        display(root.left);
        display(root.right);
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8};

        Node root = sortedArrayToBST(arr);
        System.out.print("the tree is: ");
        display(root);
    }
}
