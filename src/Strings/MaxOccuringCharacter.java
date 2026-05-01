package Strings;

import java.util.Scanner;

public class MaxOccuringCharacter {
    /*public static char BruteForce(String s){
        int maxFreq = -1;
        char ans = s.charAt(0);

        for(int i = 0; i < s.length(); i++){
            int freq = 1;
            char ch = s.charAt(i);

            for(int j =i+1; j < s.length(); j++){
                if(s.charAt(j) == ch) freq ++;
            }

            if (freq > maxFreq){
                maxFreq = freq;
                ans = ch;
            }else if(freq == maxFreq && ch < ans){
                maxFreq = freq;
                ans = ch;
            }
        }

        return ans;
    }*/

    /*public static char SlidingWindowType(String s){
        int n = s.length();

        char[] arr = s.toCharArray();
        Arrays.sort(arr);

        int i = 0, j = 0, maxFreq = -1;
        char ans = s.charAt(0);
        while(j < n){
            if(arr[i] == arr[j]) j++;
            else {
                int freq = j - i;
                if(freq > maxFreq){
                    maxFreq = freq;
                    ans = arr[i];
                }
                i = j;
            }
        }

        //Ho sakta hai ant me kuchh lamba string bach jaye
        if(j - i > maxFreq){
            ans = arr[i];
        }

        return ans;
    }*/

    //best method frequency array
    public static char FrequencyArray(String s){
        int n = s.length();
        int[] frequency = new int[26]; //Java me by default 0 hi hota hai;

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            int index = ch-'a';
            frequency[index]++;
        }

        int maxFrequency = 0;
        char ans = s.charAt(0);

        for(int i = 0; i < 26; i++){
            if(frequency[i] > maxFrequency){
                maxFrequency = frequency[i];
                ans = (char)(i + 97);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the string: ");
        String s = sc.next();

//        System.out.println(BruteForce(s));
//        System.out.println(SlidingWindowType(s));
        System.out.println(FrequencyArray(s));
    }
}
