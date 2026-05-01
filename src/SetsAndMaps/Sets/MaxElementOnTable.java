package SetsAndMaps.Sets;

import java.util.HashSet;

public class MaxElementOnTable {
    // ISKA QUESTION MaxElementOnTableQuestion.png me hai isi folder me
    private static int maxEleOnTable(int[] bag){
        HashSet<Integer> table = new HashSet<>();
        int maxELe = 0;
        for(int n: bag){
            if(table.contains(n)) table.remove(n);
            else{
                table.add(n);
                maxELe = Math.max(maxELe, table.size());
            }
        }

        return maxELe;
    }

    public static void main(String[] args) {
        int[] bag = {2,1,1,3,2,3};
        System.out.println("Max no. of elements on table is: "+ maxEleOnTable(bag));
    }
}
