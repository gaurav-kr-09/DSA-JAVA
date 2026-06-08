package Graphs;

import java.util.*;

public class AlienDictionary {
    // YE EXTRA CODE HAI AGAR SIRF GRAPH CONSTRUCT KARNA HO
    /*// Step 1: Adjecency map banao
    Map<Character, Set<Character>> adj = new HashMap<>();
    // a.) jitna alag alg char hai, make them nodes
        for(String word: words){
        for(char ch: word.toCharArray()){
            adj.putIfAbsent(ch, new HashSet<>());
        }
    }

    // b.) edges banao - indegree v sath me calculate kar sakte hai
    for(int i=1; i< words.length; i++){
        String w1 = words[i-1];
        String w2 = words[i];
        int minLen = Math.min(w1.length(), w2.length());

        for(int j = 0; j <minLen; j++){
            char c1 = w1.charAt(j);
            char c2 = w2.charAt(j);

            if(c1 != c2){
                adj.get(c1).add(c2);
                break; // kyuki sirf pehla unequal char real order hai
            }
        }
    }*/

    // Method 1: DFS
    public static String alienOrder(String[] words) {
        // Step 1: Adjecency map banao
        Map<Character, Set<Character>> adj = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();

        // a.) jitna alag alg char hai, make them nodes
        for(String word: words){
            for(char ch: word.toCharArray()){
                adj.putIfAbsent(ch, new HashSet<>());
                indegree.putIfAbsent(ch, 0);
            }
        }

        // b.) Edges banao - indegree v sath me calculate kar sakte hai
        for(int i=1; i< words.length; i++){
            String w1 = words[i-1];
            String w2 = words[i];
            int minLen = Math.min(w1.length(), w2.length());

            boolean diffFound = false;
            for(int j = 0; j <minLen; j++){
                char c1 = w1.charAt(j);
                char c2 = w2.charAt(j);

                if(c1 != c2){
                    if(adj.get(c1).add(c2)) // adj me add kiye and agar pahle se ye dege nahi tha to indegree badh gaya c2 ka
                        indegree.put(c2, indegree.get(c2)+1);

                    diffFound = true; // sach me difference tha - for handling apes & ape edge case
                    break; // kyuki sirf pehla unequal char real order hai
                }
            }

            if(!diffFound && w1.length() > w2.length()) return ""; // for handling ape & apes, abc & abc , apes & ape etc
        }

        // Step 2: Apply Khan's algo
        Queue<Character> q = new LinkedList<>();

        // a.) queue me 0 indegree wala dalo
        for(char ch: indegree.keySet()){
            if(indegree.get(ch) == 0) q.offer(ch);
        }

        // b.) topological sort
        StringBuilder ans = new StringBuilder();
        while(!q.isEmpty()){
            char front = q.poll();
            ans.append(front);

            for(char neigh: adj.get(front)){
                int currIndeg = indegree.get(neigh);
                indegree.put(neigh, currIndeg - 1);
                if(currIndeg - 1 == 0) q.offer(neigh);
            }
        }

        // Step 3: agar cycle ho gaya to impossible nahi to answer
        return ans.length() == adj.size() ? ans.toString() : "";
    }

    public static void main(String[] args) {

        String[] words1 = {
                "wrt",
                "wrf",
                "er",
                "ett",
                "rftt"
        };

        System.out.println(alienOrder(words1));
        // Expected: "wertf"


        String[] words2 = {
                "z",
                "x"
        };

        System.out.println(alienOrder(words2));
        // Expected: "zx"


        String[] words3 = {
                "z",
                "x",
                "z"
        };

        System.out.println(alienOrder(words3));
        // Expected: ""
        // Because cycle exists


        String[] words4 = {
                "abc",
                "ab"
        };

        System.out.println(alienOrder(words4));
        // Expected: ""
        // Invalid dictionary


        String[] words5 = {
                "baa",
                "abcd",
                "abca",
                "cab",
                "cad"
        };

        System.out.println(alienOrder(words5));
        // One valid answer:
        // "bdac"
    }
}
