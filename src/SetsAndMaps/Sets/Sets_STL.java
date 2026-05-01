package SetsAndMaps.Sets;

import java.util.HashSet;
import java.util.TreeSet;

public class Sets_STL {
    public static void main(String[] args) {
        // -----------------> HASHSET <--------------------

        // Set<Integer> set = new HashSet<>();
        HashSet<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        set.add(5);
        set.add(6);
        System.out.println(set.size()); //-> gives the size of set
        System.out.println(set.contains(4)); //-> tells if 4 is present in set or not
        System.out.println(set.contains(440)); //-> tells if9 is present in set or not

        set.remove(4); // removes 4 from set
        System.out.println(set.size()); //-> aab ek ghat jayega
        System.out.println(set.contains(4)); // ab false ho jayega kyuki 4 removed
        System.out.println(set.contains(440)); //-> tells if9 is present in set or not

        HashSet<Integer> dup = new HashSet<>();
        dup.add(1);
        dup.add(1);
        dup.add(1);
        dup.add(1);
        dup.add(1);
        System.out.println(dup.size()); // 1 ->coz sets me duplicates nahi hote only unique value residesz in set

        // Printing
        System.out.println(set); // ye random order me set k value ko print karega

        // -----------------> TREESET <--------------------
        // ordered set TC O(log n)

        TreeSet<Integer> trr = new TreeSet<>();
        trr.add(1);
        trr.add(2);
        trr.add(3);
        trr.add(4);
        trr.add(5);
        trr.add(6);
        System.out.println(trr.size()); //-> gives the size of set
        System.out.println(trr.contains(4)); //-> tells if 4 is present in set or not
        System.out.println(trr.contains(440)); //-> tells if9 is present in set or not

        set.remove(4); // removes 4 from set
        System.out.println(trr.size()); //-> aab ek ghat jayega
        System.out.println(trr.contains(4)); // ab false ho jayega kyuki 4 removed
        System.out.println(trr.contains(440)); //-> tells if9 is present in set or not

        TreeSet<Integer> dupTr = new TreeSet<>();
        dupTr.add(1);
        dupTr.add(1);
        dupTr.add(1);
        dupTr.add(1);
        dupTr.add(1);
        System.out.println(dupTr.size()); // 1 ->coz sets me duplicates nahi hote only unique value residesz in set

        // Printing
        System.out.println(set); // ye random order me set k value ko print karega

        // can be iterated by foreach loop only
        for(int ele: set){
            System.out.print(ele + " ");
        }
        System.out.println();

        // hamlog ye sab nahi kr sakte // ConcurrentModificationException
//        for(int ele: set){
//            set.remove(ele);
//        }

        // we can do this
        set.clear();

        System.out.println(set);
    }
}
