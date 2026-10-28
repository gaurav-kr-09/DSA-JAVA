package Greedy;

import java.util.Arrays;

public class AssignCookies {
    public static int findContentChildren(int[] g, int[] s) {
        int gl = g.length;
        int sl = s.length;

        Arrays.sort(g);
        Arrays.sort(s);

        int i=0, j=0; // i -> g | j -> s
        while(i < gl && j < sl){
            if(s[j] >= g[i]) i++; // satisfied
            j++; // j will increase in both cases
        }

        return i;
    }

    public static void main(String[] args) {
        int[] g1 = {1, 2, 3};
        int[] s1 = {1, 1};

        System.out.println(findContentChildren(g1, s1));
        // Expected: 1

        int[] g2 = {1, 2};
        int[] s2 = {1, 2, 3};

        System.out.println(findContentChildren(g2, s2));
        // Expected: 2

        int[] g3 = {2, 3, 4};
        int[] s3 = {1, 2, 3};

        System.out.println(findContentChildren(g3, s3));
        // Expected: 2
    }
}