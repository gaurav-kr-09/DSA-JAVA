package TwoDArray.ArraysTwoD;

public class Output {
    public static void main(String[] args) {
        /*int [][] arr = new int[3][4];
        System.out.println(arr.length);//rows
        System.out.println(arr[0].length);//columns
        for(int i = 0; i <3; i++){
            for(int j = 0; j < 4; j++){
                System.out.print(arr[i][j] +" ");
            }
            System.out.println();
        }*/

        int[][] arr = {{1,2,3,4}, {5,6,7,8},{9,0,1,2}};

        for(int i = 0; i < arr.length; i++){
            for (int j = 0; j <arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
