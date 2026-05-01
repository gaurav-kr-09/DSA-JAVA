package Heaps;

class MinHeap {
    private final int[] arr;
    private int idx = 1;
    // it denotes where to insert new value,
    // making array 1 index for easier calculation
    private final int capacity;

    private void reArrangeAddition(int ci){
        while(ci != 1){
            int pi = ci/2; // pi-> parent Index
            if(arr[pi] <= arr[ci]) return;

            int temp = arr[pi];
            arr[pi] = arr[ci];
            arr[ci] = temp;
            ci = pi;
        }
    }

    private void reArrangeDeletion(int pi){
        while(pi <= size()){
            int leftCi = 2*pi, rightCi = 2*pi+1;
            int leftVal = (leftCi <= size()) ? arr[leftCi] : Integer.MAX_VALUE;
            int rightVal = (rightCi <= size()) ? arr[rightCi] : Integer.MAX_VALUE;

            if(arr[pi] < leftVal && arr[pi] < rightVal) return;
            // else swap with smaller child
            int temp = arr[leftCi];
            if(leftVal < rightVal) {
                arr[leftCi] = arr[pi];
                arr[pi] = temp;
                pi = leftCi;
            }else{
                arr[rightCi] = arr[pi];
                arr[pi] = temp;
                pi = rightCi;
            }
        }
    }

    private int findDeleteIdx(int val){
        for(int i=1; i < idx; i++){
            if(arr[i] == val) return i;
        }
        return -1;
    }

    void add(int ele) {
        if(isFull()){
            System.out.println("Heap full");
            return;
        }
        arr[idx] = ele;
        // rearrangement niche se upar
        int ci = idx; // ci -> child Index or current index
        reArrangeAddition(ci);
        idx++;
    }

    int removeFirst(){
        if(isEmpty()){
            System.out.println("Heap empty");
            return -1;
        }
        int min = arr[1];
        arr[1] = arr[idx-1]; // put the largest value there
        idx--; // aab index to insert ghat jayega

        // rearrangement upar se niche
        int pi = 1;
        reArrangeDeletion(pi);
        return min;
    }

    void remove(int ele){
        if(isEmpty()){
            System.out.println("Heap empty");
            return;
        }

        int delIdx = findDeleteIdx(ele);

        if(delIdx == -1){
            System.out.println("element not found");
            return;
        }

        arr[delIdx] = arr[idx-1];
        idx--;

        int pi = delIdx / 2;
        // if parent is greater than delete index
        if(delIdx > 1 && arr[delIdx] < arr[pi]) reArrangeAddition(delIdx);
        else reArrangeDeletion(delIdx); // if parent is smaller
    }



    void display(){
        for(int i = 1; i < idx; i++) System.out.print(arr[i] + " ");
        System.out.println();
    }

    int peek(){
        if(isEmpty()){
            System.out.println("Heap empty");
            return -1;
        }
        return arr[1];
    }

    int size(){
        return idx-1;
    }

    boolean isFull(){
        return size() == capacity;
    }

    boolean isEmpty(){
        return idx == 1;
    }

    MinHeap(int capacity){
        this.capacity = capacity;
        arr = new int[capacity+1];
    }
}

public class MinHeapImplementation {
    public static void main(String[] args) {
        MinHeap h = new MinHeap(4);
        System.out.println(h.isFull());
        System.out.println(h.isEmpty());
        System.out.println(h.size());
        System.out.println("peek is: " + h.peek());
        h.add(10);
        h.add(5);
        h.add(20);
        h.display();
        System.out.println("peek is: " + h.peek());
        System.out.println(h.isFull());
        System.out.println(h.isEmpty());
        System.out.println(h.size());
        h.add(7);
        h.display();
        System.out.println(h.isFull());
        System.out.println(h.isEmpty());
        System.out.println(h.size());
        System.out.println("++++++++++++++++++++++++++++++++++++++++++");
        h.add(12);
        System.out.println("++++++++++++++++++++++++++++++++++++++++++");
        h.removeFirst();
        h.display();
        System.out.println(h.isFull());
        System.out.println(h.isEmpty());
        System.out.println(h.size());
        System.out.println("++++++++++++++++++++++++++++++++++++++++++");
        h.add(16);
        h.display();
        System.out.println("peek is: " + h.peek());
        System.out.println(h.isFull());
        System.out.println(h.isEmpty());
        System.out.println(h.size());
        System.out.println("++++++++++++++++++++++++++++++++++++++++++");
        h.add(16);
        h.display();
        System.out.println(h.isFull());
        System.out.println(h.isEmpty());
        System.out.println(h.size());
        System.out.println("++++++++++++++++++++++++++++++++++++++++++");
        System.out.println(h.removeFirst());
        System.out.println(h.removeFirst());
        System.out.println(h.removeFirst());
        System.out.println(h.removeFirst());
        System.out.println("++++++++++++++++++++++++++++++++++++++++++");
        System.out.println(h.removeFirst());
        h.display();
        System.out.println("peek is: " + h.peek());
        System.out.println(h.isFull());
        System.out.println(h.isEmpty());
        System.out.println(h.size());
        System.out.println("++++++++++++++++++++++++++++++++++++++++++");
        h.remove(5);
        h.add(10);
        h.add(5);
        h.add(20);
        h.display();
        System.out.println(h.size());
        h.remove(5);
        h.display();
        System.out.println(h.size());
        System.out.println("++++++++++++++++++++++++++++++++++++++++++");
        h.remove(15);
        h.display();
        System.out.println(h.size());
    }
}
