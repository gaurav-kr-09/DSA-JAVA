package Greedy;

import java.util.Arrays;

public class TaskScheduler {
    // greedy using heap
    /*public static int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for(char ch: tasks) freq[ch - 'A']++;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0; i<26; i++)
            if(freq[i] > 0) pq.add(freq[i]);

        int time = 0;
        while(!pq.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            for(int i=1; i<=n+1; i++){ // n+1 tasks ko heap se nikale
                if(!pq.isEmpty()){
                    int cf = pq.poll(); // abhi jo pop kiye hai uska freq (currFreq)
                    cf--;
                    temp.add(cf);
                }
            }

            // nikale hue me se jiska v freq > 0 hai usko wapas heap me dala
            for(int t: temp) if(t > 0) pq.add(t);

            // update the time - agar pq khali means sara task bahar hai so idle v
            // ho sakta hai, agar temp khali means idle hua hio nahi hoga
            time += (pq.isEmpty() ? temp.size() : n+1);
        }

        return time;
    }*/

    // Greedy w/o heap O(1)
    public static int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for(char ch: tasks) freq[ch - 'A']++;

        Arrays.sort(freq); // ascending sort

        int maxFreq = freq[25]; // jo sabse frequent hai usko pahle dal do
        int spaces = maxFreq - 1; // kitna khali space bacha hai har ek identical chars k bich me
        int idleSlots = n * spaces; // total khali space

        for(int i = 24; i>=0; i--){
            // total khali space - 2nd most frequent ka freq, but agar
            // 2nd most wala space se jyada ho gaya tab to wo idle spot me
            // nahi jayega balki last me fill hoga so use min
            idleSlots -= Math.min(freq[i], spaces);
        }

        // agar abhi space khali rah gaya to length + khali space
        // agar nahi khali hai means sara occupied so length
        return idleSlots > 0 ? tasks.length + idleSlots : tasks.length;
    }

    public static void main(String[] args) {
        char[] tasks1 = {'A','A','A','B','B','B'};
        System.out.println(leastInterval(tasks1, 2)); // 8

        char[] tasks2 = {'A','A','A','B','B','B'};
        System.out.println(leastInterval(tasks2, 0)); // 6

        char[] tasks3 = {'A','A','A','B','B','B','C','C','D'};
        System.out.println(leastInterval(tasks3, 2)); // 9

        char[] tasks4 = {'A','A','A','A','B','B','B','C','C','D','D'};
        System.out.println(leastInterval(tasks4, 2)); // 11
    }
}