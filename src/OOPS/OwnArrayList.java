package OOPS;

class ArrayLists{
    int[] arr;
    int idx = 0;
    int size = 0;

    ArrayLists(int capacity){
        arr = new int[capacity];
    }

    void add(int ele){
        if(idx == arr.length){ //Array is full
            capacityIncrease();
        }
        arr[idx++] = ele;
        size++;
    }

    void removeFromEnd(){
        idx--;
        size--;
    }

    void capacityIncrease(){
        int[] arr2 = new int[arr.length*2];

        for (int i = 0; i < arr.length; i++) {
            arr2[i] = arr[i];
        }
        arr = arr2;
    }

    int capacity(){
        return arr.length;
    }

    void display(){
        for(int i = 0; i< size; i++){
            System.out.print(arr[i]+ "  ");
        }
        System.out.println();
    }

    int get(int index){
        return arr[index];
    }

    void set(int index, int val){
        if(index < 0 || index >= size){
            System.out.println("Invalid index");
            return;
        }
        arr[index] = val;
    }


    void insert(int index, int val){
        if(index < 0 || index >= size){
            System.out.println("Invalid index");
            return;
        }

        if(idx == arr.length){ //Array is full
            capacityIncrease();
        }
        for(int i = idx; i>index; i--){
            arr[i] = arr[i-1];
        }
        arr[index] = val;
        size++;
        idx++;
    }

    void remove(int index){
        if(index < 0 || index >= size){
            System.out.println("Invalid index");
            return;
        }

        for(int i = index; i < idx-1; i++){
            arr[i] = arr[i+1];
        }
        size--;
        idx--;
    }
}

public class OwnArrayList {
    public static void main(String[] args) {
        ArrayLists arr = new ArrayLists(3);

        // Printing capacity
        System.out.println(arr.capacity());

        //Printing size
        System.out.print("The size is: ");
        System.out.println(arr.size);

        // Adding in arrayList
        arr.add(10);
        arr.add(20);
        arr.add(30);

        // displaying the array
        System.out.print("The array is: ");
        arr.display();

        // Again printing Size
        System.out.print("The size is: ");
        System.out.println(arr.size);

        //getting the element at given index
        System.out.print("The get method gives: ");
        System.out.println(arr.get(1));

        System.out.println("---------------------ADD--------------------");

        // Now when we add more elements than capacity then it will give ArrayIndexOutOfBoundException, to tackle tha
        arr.add(40);  // ye originally error dega isiliye isko thik karne k liye capacityIncrease function banaye hai
                     // Aab kitna v element add kar sakte hai.

        // Printing capacity
        System.out.println(arr.capacity());

        // displaying the array
        System.out.print("The array is: ");
        arr.display();

        // Again printing Size
        System.out.print("The size is: ");
        System.out.println(arr.size);

        System.out.println("---------------------REMOVE--------------------");

        //remove from end
        arr.removeFromEnd();

        // Printing capacity //will remain same
        System.out.println(arr.capacity());

        // displaying the array
        System.out.print("The array is: ");
        arr.display();

        // Again printing Size
        System.out.print("The size is: ");
        System.out.println(arr.size);

        System.out.println("---------------------SET AT INDEX--------------------");
        arr.set(1, 5);

        // Printing capacity
        System.out.println(arr.capacity());

        // displaying the array
        System.out.print("The array is: ");
        arr.display();

        // Again printing Size
        System.out.print("The size is: ");
        System.out.println(arr.size);


        System.out.println("---------------------INSERT AT INDEX--------------------");
        arr.insert(0, 75);

        // Printing capacity
        System.out.println(arr.capacity());

        // displaying the array
        System.out.print("The array is: ");
        arr.display();

        // Again printing Size
        System.out.print("The size is: ");
        System.out.println(arr.size);

        System.out.println("---------------------REMOVE FROM INDEX--------------------");
        arr.remove(1);

        // Printing capacity
        System.out.println(arr.capacity());

        // displaying the array
        System.out.print("The array is: ");
        arr.display();

        // Again printing Size
        System.out.print("The size is: ");
        System.out.println(arr.size);
    }
}
