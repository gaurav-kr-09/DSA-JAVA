package LinkedList;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeKSortedLists {
    // Method - 1 worst method.
    /*public Node mergeKLists(Node[] lists) {
        // Method 1 worst tc O(kn^2)
        if(lists.length == 0) return null;
        ArrayList<Node> arr = new ArrayList<>();
        for(Node l : lists) arr.add(l);

        while(arr.size() != 1){
            Node a = arr.getLast();
            arr.removeLast();
            Node b = arr.getLast();
            arr.removeLast();
            arr.add(merge(a,b));
        }

        return arr.getFirst();
    }*/

    //Method -2 also not good
    public Node mergeKLists(Node[] lists) {
        if(lists == null || lists.length == 0) return null;

        ArrayList<Node> arr1 = new ArrayList<>();
        ArrayList<Node> arr2 = new ArrayList<>();
        arr1.addAll(Arrays.asList(lists));

        while(arr1.size() + arr2.size() > 1){
            while(!arr1.isEmpty()){
                Node a = arr1.removeLast();
                if(!arr1.isEmpty()){
                    Node b = arr1.removeLast();
                    arr2.add(merge(a,b));
                }else{
                    arr2.add(a);
                }
            }

            while(!arr2.isEmpty()){
                Node a = arr2.removeLast();
                if(!arr2.isEmpty()){
                    Node b = arr2.removeLast();
                    arr1.add(merge(a,b));
                }else{
                    arr1.add(a);
                }
            }
        }

        return arr1.size() == 1 ? arr1.getFirst() : arr2.getFirst();
    }

    public Node merge(Node h1, Node h2){
        Node d = new Node(-1);
        Node k = d;
        while(h1 != null && h2 != null){
            if(h1.val > h2.val){
                k.next = h2;
                h2 = h2.next;
            }else{
                k.next = h1;
                h1 = h1.next;
            }
            k = k.next;
        }

        if(h1 == null) k.next = h2;
        else k.next = h1;

        return d.next;
    }
}
