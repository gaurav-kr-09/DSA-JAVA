package Graphs.DSU;

import java.util.*;

public class AccountsMerge {
    private static int[] parent;
    private static int[] size;
    public static List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();

        parent = new int[n];
        size = new int[n];
        for(int i=0; i<n; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        // Map each email to the index of account it belong to
        Map<String, Integer> adjMap = new HashMap<>();
        for(int accIdx = 0; accIdx < n; accIdx++){
            List<String> account = accounts.get(accIdx);

            for(int i=1; i<account.size(); i++){
                String mail = account.get(i);

                // if the same email is at another index means it's same person
                if(adjMap.containsKey(mail)) union(accIdx, adjMap.get(mail));
                else adjMap.put(mail, accIdx);
            }
        }

        // Take each index of account and map it to their emails
        // if multiple accounts belong to the same person merge it
        List<List<String>> mergedMail = new ArrayList<>();
        for(int i=0; i<n; i++) mergedMail.add(new ArrayList<>());

        for(String mail: adjMap.keySet()){
            int leader = findLeader(adjMap.get(mail));
            mergedMail.get(leader).add(mail);
        }

        // Make answer array
        List<List<String>> ans = new ArrayList<>();
        for(int i=0; i<n; i++){
            List<String> mails = mergedMail.get(i);

            if(mails.isEmpty()) continue;

            Collections.sort(mails);

            mails.addFirst(accounts.get(i).getFirst()); // add name at start
            ans.add(mergedMail.get(i)); // put it in answer
        }

        return ans;
    }

    private static void union(int a, int b){
        a = findLeader(a);
        b = findLeader(b);

        if(a == b) return;
        if(size[a] > size[b]){
            parent[b] = a;
            size[a] += size[b];
        }else{
            parent[a] = b;
            size[b] += size[a];
        }
    }

    private static int findLeader(int a){
        if(parent[a] == a) return a;
        return parent[a] = findLeader(parent[a]);
    }

    public static void main(String[] args) {

        // Test Case 1 (LeetCode Example)
        List<List<String>> accounts1 = Arrays.asList(
                Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com"),
                Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com"),
                Arrays.asList("Mary", "mary@mail.com"),
                Arrays.asList("John", "johnnybravo@mail.com")
        );

        System.out.println("Test Case 1:");
        System.out.println(accountsMerge(accounts1));
        // Expected:
        // [
        //   [John, john00@mail.com, john_newyork@mail.com, johnsmith@mail.com],
        //   [Mary, mary@mail.com],
        //   [John, johnnybravo@mail.com]
        // ]


        // Test Case 2
        List<List<String>> accounts2 = Arrays.asList(
                Arrays.asList("Gabe", "Gabe0@m.co", "Gabe3@m.co", "Gabe1@m.co"),
                Arrays.asList("Kevin", "Kevin3@m.co", "Kevin5@m.co", "Kevin0@m.co"),
                Arrays.asList("Ethan", "Ethan5@m.co", "Ethan4@m.co", "Ethan0@m.co"),
                Arrays.asList("Hanzo", "Hanzo3@m.co", "Hanzo1@m.co", "Hanzo0@m.co"),
                Arrays.asList("Fern", "Fern5@m.co", "Fern1@m.co", "Fern0@m.co")
        );

        System.out.println("\nTest Case 2:");
        System.out.println(accountsMerge(accounts2));


        // Test Case 3 (Chain Merge)
        List<List<String>> accounts3 = Arrays.asList(
                Arrays.asList("Alex", "a@mail.com", "b@mail.com"),
                Arrays.asList("Alex", "b@mail.com", "c@mail.com"),
                Arrays.asList("Alex", "c@mail.com", "d@mail.com")
        );

        System.out.println("\nTest Case 3:");
        System.out.println(accountsMerge(accounts3));
        // Expected:
        // [[Alex, a@mail.com, b@mail.com, c@mail.com, d@mail.com]]


        // Test Case 4 (No Merge)
        List<List<String>> accounts4 = Arrays.asList(
                Arrays.asList("John", "john1@mail.com"),
                Arrays.asList("John", "john2@mail.com"),
                Arrays.asList("John", "john3@mail.com")
        );

        System.out.println("\nTest Case 4:");
        System.out.println(accountsMerge(accounts4));


        // Test Case 5 (Same Name Different Person)
        List<List<String>> accounts5 = Arrays.asList(
                Arrays.asList("David", "d1@mail.com"),
                Arrays.asList("David", "d2@mail.com"),
                Arrays.asList("David", "d3@mail.com", "d4@mail.com")
        );

        System.out.println("\nTest Case 5:");
        System.out.println(accountsMerge(accounts5));
    }
}
