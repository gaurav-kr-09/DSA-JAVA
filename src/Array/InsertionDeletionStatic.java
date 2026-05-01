package Array;

public class InsertionDeletionStatic {
    static int[] arr = {8,2,3,5,4};

    public static void display(int[] arr){
        for(int num : arr){
            System.out.print(num + "\t");
        }
        System.out.println();
    }

    public static void insert(int index, int val){
        if(index < 0 || index > arr.length){
            System.out.println("Invalid insertion index");
            return;
        }

        // Copying old array in new array till index
        int[] newArr = new int[arr.length + 1];
        for(int i = 0; i < index; i++){
            newArr[i] = arr[i];
        }

        // setting value at index
        newArr[index] = val;

        // Copying after index
        for(int i = index; i < arr.length; i++){
            newArr[i+1] = arr[i];
        }

        //updating reference
        arr = newArr;
    }

    public static void deletion(int index) {
        if(index < 0 || index > arr.length){
            System.out.println("Invalid deletion index");
            return;
        }

        for(int i = index; i < arr.length -1; i++){
            arr[i] = arr[i+1];
        }

        int[] newArr = new int[arr.length - 1];
        for(int i = 0; i < newArr.length; i++){
            newArr[i] = arr[i];
        }

        arr = newArr;
    }

    public static void main(String[] args) {
        System.out.print("Original array is:  ");
        display(arr);

        insert(1, 12);
        System.out.print("Inserted array is:  ");
        display(arr);

        deletion(1);
        System.out.print("Deleted array is:  ");
        display(arr);
    }
}
