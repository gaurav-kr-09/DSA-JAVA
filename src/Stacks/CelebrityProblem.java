package Stacks;

public class CelebrityProblem {
    // method-1 brute force
    /*public static int celebrity(int arr[][]) {
        int n = arr.length;

        for(int i = 0; i < n; i++){
            boolean rowCheck = true, colCheck = true;

            // celebrity kisi ko nahi janana chahiye
            for(int j = 0; j < n; j++){
                if(i != j && arr[i][j] == 1){
                    rowCheck = false;
                    break;
                }
            }

            // celebrity ko sab janana chahiye
            for(int j = 0; j < n; j++){
                if(i != j && arr[j][i] == 0){
                    colCheck = false;
                    break;
                }
            }

            if(rowCheck && colCheck) return i;
        }

        return -1;
    }*/

    // Method 2: using stack
    /*public static int celebrity(int arr[][]) {
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < n; i++) st.push(i);

        while (st.size() > 1){
            int a = st.pop();
            int b = st.pop();

            boolean aCeleb = true, bCeleb = true;

            if(arr[a][b] == 1) aCeleb = false; // a , b ko janta hai - means a is not celebrity
            else bCeleb = false; //a, b ko nahi janta hai - means b is not celibrity

            if(arr[b][a] == 1) bCeleb = false; // b , a ko janta hai - means b is not celebrity
            else aCeleb = false; //b, a ko nahi janta hai - means a is not celibrity

            if(aCeleb) st.push(a);
            if(bCeleb) st.push(b);
        }
        
        if(st.isEmpty()) return -1;
        
        // Checking if element in stack is actually celeb 
        int cand = st.pop();
        for (int i = 0; i < n; i++) {
            if(i == cand) continue;
            if(arr[cand][i] == 1) return -1; // means cand kisi or ko janta hai
        }

        for (int i = 0; i < n; i++) {
            if(i == cand) continue;
            if(arr[i][cand] == 0) return -1; // means cand or koi to hai jo nahi janta hai
        }

        return cand;
    }*/

    // Method 2 - optimized
    /*public static int celebrity(int arr[][]) {
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) st.push(i);

        while (st.size() > 1) {
            int a = st.pop();
            int b = st.pop();

            if (arr[a][b] == 1) st.push(b); // a, b ko janta hai matlab a to celeb nahi hai
            else st.push(a); // a, b ko nahi janta hai matlab a celeb ho sakta hai
        }

        if (st.isEmpty()) return -1;

        // Checking if element in stack is actually celeb
        int cand = st.pop();
        for (int i = 0; i < n; i++) {
            if (i == cand) continue;
            if (arr[cand][i] == 1) return -1; // means cand kisi or ko janta hai
        }

        for (int i = 0; i < n; i++) {
            if (i == cand) continue;
            if (arr[i][cand] == 0) return -1; // means cand or koi to hai jo nahi janta hai
        }

        return cand;
    }*/

    // Method 3: using two pointer Sc O(1)
    public static int celebrity(int[][] arr) {
        int n = arr.length;
        int i = 0, j = n-1;
        while(i < j){
            if(arr[i][j] == 1) i++; // i,j ko janta hai , matlab i celeb nahi ho sakta
            else j--; // i,j ko nahi janta hai , matlab j celeb nahi ho sakta
        }

        // checking if the left element is celeb or not
        int cand = i;
        for(int k = 0; k <n; k++){
            if(k != cand && (arr[cand][k] == 1 || arr[k][cand] == 0)) return -1;
        }

        return cand;
    }

    public static void main(String[] args) {
//        int[][] arr = { // ans 1
//                {1, 1, 0},
//                {0, 1, 0},
//                {0, 1, 1}
//        };

        int[][] arr = { // ans 3
                {1, 1, 1, 1, 1},
                {0, 1, 0, 1, 0},
                {1, 0, 1, 1, 1},
                {0, 0, 0, 1, 0},
                {1, 1, 0, 1, 1}
        };

        System.out.println("Celebrity is: "+ celebrity(arr));
    }
}
