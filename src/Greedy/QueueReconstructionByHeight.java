package Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QueueReconstructionByHeight {
    public static int[][] reconstructQueue(int[][] people) {
        int n = people.length;

        Arrays.sort(people, (a, b) -> {
            // jyada height wala aage & height same to kam k wala aage
            if(a[0] == b[0]) return Integer.compare(a[1], b[1]);
            return Integer.compare(b[0], a[0]);
        });

        List<int[]> ans = new ArrayList<>();
        for(int[] p: people) ans.add(p[1], p);

        return ans.toArray(new int[n][2]);
    }

    public static void main(String[] args) {
        int[][] p1 = {
                {7,0}, {4,4}, {7,1},
                {5,0}, {6,1}, {5,2}
        };

        System.out.println(Arrays.deepToString(reconstructQueue(p1)));
        // [[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]]

        int[][] p2 = {
                {6,0}, {5,0}, {4,0}, {3,2}, {2,2}, {1,4}
        };

        System.out.println(Arrays.deepToString(reconstructQueue(p2)));
        // [[4,0],[5,0],[2,2],[3,2],[1,4],[6,0]]
    }
}