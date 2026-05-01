package SetsAndMaps.Maps;

import java.util.HashMap;
import java.util.Map;

public interface Maps_STL {
    public static void main(String[] args) {
        // Map<String,Integer> map = new HashMap<>();
        HashMap<String,Integer> map = new HashMap<>();

        // Insertion in map
        map.put("Gaurav", 20);
        map.put("Aditya", 16);
        map.put("Deepika", 21);
        map.put("Vivek", 20);

        // printing the map
        System.out.println(map);

        // we can print the size of map
        System.out.println(map.size());

        //  we can remove a item from a set by it's key not by its value
        //map.remove(20); // will nothing and and nothing will happen
        // map.remove("Vivek"); //or
        System.out.println(map.remove("Vivek"));

        System.out.println(map.size());
        System.out.println(map);

        // getting the value by key
        System.out.println(map.get("Gaurav"));

        // we can add duplicate key in map but purana pair naye waele pair se replace ho jayega
        map.put("Raman", 28);
        System.out.println(map);
        map.put("Raman", 21);

        // containskey -> tell whether a key is present in map
        System.out.println(map.containsKey("Raman"));
        map.remove("Raman");
        System.out.println(map.containsKey("Raman"));

        System.out.println(map.keySet()); // gives all the keys
        System.out.println(map.values()); // gives all the values
        System.out.println(map.isEmpty());

        // getting all entries of a map
        System.out.println(map.entrySet());

        // treavrsing the map
        for(String key: map.keySet()){
            System.out.println(key+" " + map.get(key));
        }

        System.out.println("-----------");

        // traversing each entry set
        for(Map.Entry<String, Integer> e: map.entrySet()){
            System.out.printf("value of %s is %d\n", e.getKey(), e.getValue());
        }

        System.out.println("88888888888888888888888888888888888888888888");
        // dekho yaha pe sab k liye alag alag key ka name waigarah likhna pad rha hai
        // agar ham var use kare to ye apne aap detect kar lega kon sa type hai
        for(var e: map.entrySet()){
            System.out.printf("value of %s is %d\n", e.getKey(), e.getValue());
        }

        for(var s: map.keySet()){
            System.out.println(s + " " + map.get(s));
        }
    }
}