package Stacks;

import java.util.Stack;

public class MaximalRect {
    public static int getMaximalRect(char[][] matrix){
        int rows = matrix.length;
        int cols = matrix[0].length;

        int[] row = new int[rows];
        int maxArea = 0;

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(matrix[i][j] == '1') row[i] += 1;
                else row[i] = 0;
            }

            int area = getMaxArea(row);
            maxArea = Math.max(area, maxArea);
        }

        return maxArea;
    }

    public static int getMaxArea(int[] arr){
        int n = arr.length;
        int maxArea = 0;
        Stack<Integer> st = new Stack<>();

        for(int i = 0; i < n; i++){
            while(!st.isEmpty() && arr[i] < arr[st.peek()]){
                int index = st.pop();

                if(!st.isEmpty()) maxArea = Math.max(maxArea, arr[index] *(i - st.peek() -1));
                else maxArea = Math.max(maxArea, arr[index] * i);
            }
            st.push(i);
        }

        while(!st.isEmpty()){
            int index = st.pop();

            if(!st.isEmpty()) maxArea = Math.max(maxArea, arr[index] *(n - st.peek() -1));
            else maxArea = Math.max(maxArea, arr[index] * n);
        }

        return maxArea;
    }

    public static void main(String[] args) {
        char[][] rect = { //Output - 6
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}
        };

        System.out.println("Maximum area is: "+ getMaximalRect(rect));
    }
}