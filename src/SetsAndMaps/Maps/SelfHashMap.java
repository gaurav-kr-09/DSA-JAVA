package SetsAndMaps.Maps;

import java.util.LinkedList;

public class SelfHashMap {
    private static class MyHashMap<K, V>{
        public static final int DEFAULT_CAPACITY = 4;
        public static final float DEFAULT_LOAD_FACTOR = .75F;
        private int n; // no. of entries in map

        private class Pair{
            K key;
            V value;
            Pair(K key, V value){
                this.key = key;
                this.value = value;
            }
        }

        private LinkedList<Pair>[] buckets;

        private void initBuckets(int N){
            buckets = new LinkedList[N]; // making an array of linkedlists
            for(int i = 0; i < buckets.length; i++){
                buckets[i] = new LinkedList<>(); // initalizing an empty Linked list on each bucket index
            }
        }

        private int hashfunc(K key){
            int hc = key.hashCode(); // converting int hash code
            return Math.abs(hc) % buckets.length; // returning bucket index
        }

        private int searchInBucket(LinkedList<Pair> ll, K key){
            for(int i = 0; i < ll.size(); i++){
                if(ll.get(i).key.equals(key)) return i; // found
            }
            return -1; // not found
        }

        private void rehash(){
            LinkedList<Pair>[] oldBuckets = buckets;
            initBuckets(oldBuckets.length * 2);
            n = 0;
            for(var bucket: oldBuckets){
                for(var pair: bucket){
                    put(pair.key, pair.value);
                }
            }
        }

        public MyHashMap(){
            initBuckets(DEFAULT_CAPACITY);
        }

        public int size(){ // Return the no. of entries in map
            return n;
        }

        public void put(K key, V value){ // Insert & Update
            int bi = hashfunc(key);
            LinkedList<Pair> currBucket = buckets[bi];
            int ei = searchInBucket(currBucket, key);
            if(ei == -1) { // not found so create a new node
                Pair pair = new Pair(key, value);
                currBucket.add(pair);
                n++;
            }else{ // exists so update
                Pair currNode = currBucket.get(ei);
                currNode.value = value;
            }

            if(n >= buckets.length * DEFAULT_LOAD_FACTOR){
                rehash();
            }
        }

        public V get(K key){
            int bi = hashfunc(key);
            LinkedList<Pair> currBucket = buckets[bi];
            int ei = searchInBucket(currBucket, key);

            if(ei != -1){ // key exists
                Pair currNode = currBucket.get(ei);
                return currNode.value;
            }

            return null;
        }

        public V remove(K key){
            int bi = hashfunc(key);
            LinkedList<Pair> currBucket = buckets[bi];
            int ei = searchInBucket(currBucket, key);

            if(ei != -1){ // key exists
                Pair currNode = currBucket.get(ei);
                V val = currNode.value;
                currBucket.remove(ei);
                n--;
                return val;
            }
            // key dne
            return null;
        }

        public int capacity(){
            return buckets.length;
        }

        public float load(){
            return n * 1.0f / buckets.length;
        }
    }

    public static void main(String[] args) {
        MyHashMap<String, Integer> map = new MyHashMap<>();

        System.out.println("Testing put");
        map.put("a", 1);
        map.put("b", 2);
        map.put("c", 3);

        System.out.println(map.size());
        map.put("c", 30);
        System.out.println(map.size());

        System.out.println("testing get");
        System.out.println(map.get("a"));
        System.out.println(map.get("b"));
        System.out.println(map.get("c"));

        System.out.println(map.get("d"));

        System.out.println("Testing remove");
        System.out.println(map.remove("c"));
        System.out.println(map.size());

        System.out.println(map.remove("c"));
        System.out.println(map.size());

        // Testing rehashing
        map.put("p", 1);
        map.put("q", 2);
        map.put("r", 3);
        System.out.println(map.size()); // since

        System.out.println(map.capacity());
        System.out.println(map.load());
    }
}