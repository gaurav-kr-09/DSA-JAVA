package DynamicProgramming;

public class PalindromicSubstrings {
    // Bruteforce
    /*public static int countSubstrings(String s) {
        int count = 0;

        for(int i=0; i<s.length(); i++){
            for(int j = i; j < s.length(); j++){
                if(isPalindrome(s.substring(i, j+1))) count++;
            }
        }

        return count;
    }

    public static boolean isPalindrome(String s){
        int i = 0, j = s.length() - 1;

        while(i < j){
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }

        return true;
    }*/

    // Bruteforce w/o substring creation and better
    public static int countSubstrings(String s) {
        int count = 0;

        for(int i=0; i<s.length(); i++){
            for(int j=i; j<s.length(); j++){
                if(isPalindrome(s, i, j)) count++;
            }
        }

        return count;
    }

    public static boolean isPalindrome(String s, int i, int j){
        while(i < j){
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }

        return true;
    }

    public static void main(String[] args) {
        // Test Case 1
        String s = "abc";
        System.out.println(countSubstrings(s));
        // Expected: 3

        // Test Case 2
        s = "aaa";
        System.out.println(countSubstrings(s));
        // Expected: 6

        // Test Case 3
        s = "aba";
        System.out.println(countSubstrings(s));
        // Expected: 4

        // Test Case 4
        s = "racecar";
        System.out.println(countSubstrings(s));
        // Expected: 10

        // Test Case 5
        s = "a";
        System.out.println(countSubstrings(s));
        // Expected: 1
    }
}