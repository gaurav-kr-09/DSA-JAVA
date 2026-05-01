package Array.Basics;

public class InputInArray {
    public static void main(String[] args) {
        int[] arr = {2, 6, 4, 1, 6, 0,7};

//        int i = 0;
//        while(i <= 5){
//            System.out.print(arr[i]);
//            i++;
//        }

//        for (int i = 0; i < 5; i++) {
//            System.out.print(arr[i] + "\t");
//        }

        //Enhanced way
//        for (int j : arr) {
//            System.out.print(j + "\t");
//        }

//        for (int i = 0; i < arr.length; i++) {
//            System.out.print(arr[i] + "\t");
//        }

        // Default array
        int[] defaultArray = new int[7];  //Ek naya array 7 size ka & Java me initially sab ka value ) hota hai.
        for(int i = 0; i < defaultArray.length; i++){
            System.out.print(defaultArray[i] +"\t");
        }

    }
}
