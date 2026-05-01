package BinaryTrees;

public class ConstructTree {
    // iska answer khud se banana syapa hai

    // given Inorder and preOrder
    public Node buidFromInAndPre(int[] preorder, int[] inorder){
        int n = preorder.length;
        return build(0, n-1, 0, n-1, preorder, inorder);
    }

    private Node build(int preLo, int preHi, int inLo, int inHi, int[] preorder, int[] inorder) {
        if(preLo > preHi || inLo > inHi) return null;

        int val = preorder[preLo];
        Node root = new Node(val);

;       // finding index of root in inorder array
        int r = -1;
        for(int i = inLo; i <= inHi; i++){
            if(inorder[i] == val){
                r = i;
                break;
            }
        }

        int leftSize = r - inLo;
        root.left = build(preLo+1, preLo+leftSize, inLo, r-1, preorder, inorder);
        root.right = build(preLo+leftSize+1, preHi, r+1, inHi, preorder, inorder);

        return root;
    }

    //
}
