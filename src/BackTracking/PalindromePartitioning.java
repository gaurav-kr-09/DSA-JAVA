package BackTracking;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    // Har recursive call mein ek starting index idx milta hai.
    // Us index se har possible ending index i try karte hain.
    // Palindrome hai toh current partition mein add karke recursion karte hain.
    // Recursion se return hone par backtrack karke choice remove karte hain.
    // Jab idx == n ho jata hai, ek complete valid partition mil gaya — uska copy ans mein save karte hain.
    // Sari possibilities explore hone ke bad ans return karte hain.

    public static List<List<String>> ans;
    public static List<List<String>> partition(String s) {
        ans = new ArrayList<>();
        backtrack(0, s, new ArrayList<>());
        return ans;
    }

    public static void backtrack(int idx, String s, List<String> curr){
        int n = s.length();

        if(idx == n){
            ans.add(new ArrayList<>(curr));
            return;
        }

        for(int i=idx; i<n; i++){
            if(isPal(s, idx, i)){
                curr.add(s.substring(idx, i+1));
                backtrack(i+1, s, curr);
                curr.removeLast(); // backtrack
            }
        }
    }

    // Fn to check palindrome
    public static boolean isPal(String s, int i, int j){
        while(i < j){
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {

        String s1 = "aab";
        System.out.println(partition(s1));
        // Expected: [["a","a","b"], ["aa","b"]]

        String s2 = "a";
        System.out.println(partition(s2));
        // Expected: [["a"]]

        String s3 = "efe";
        System.out.println(partition(s3));
        // Expected: [["e","f","e"], ["efe"]]
    }
}