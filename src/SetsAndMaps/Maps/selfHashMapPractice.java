package SetsAndMaps.Maps;

import java.util.LinkedList;

public class selfHashMapPractice {
    private static class MyHashMap<K, V>{
        private static final int DEFAULT_CAPACITY = 4;
        private static final float LOAD_FACTOR = 0.75f;
        private int n;

        private class Nodes{
            K key;
            V value;
            Nodes(K key, V value){
                this.key = key;
                this.value = value;
            }
        }

        private LinkedList<Nodes>[] buckets;

        private void initBucket(int cap){
            buckets = new LinkedList[cap];
            for(int i = 0; i < cap; i++){
                buckets[i] = new LinkedList<>();
            }
        }

        public MyHashMap(){
            initBucket(DEFAULT_CAPACITY);
        }

        private int searchBucket(LinkedList<Nodes> currBucket, K key){
            for(int i = 0; i < currBucket.size(); i++){
                if(currBucket.get(i).key.equals(key)) return i;
            }
            return -1;
        }

        public int hash(K key){
            return Math.abs(key.hashCode()) % buckets.length;
        }

        private void rehash(){
            LinkedList<Nodes>[] oldBuckets = buckets;
            initBucket(capacity() * 2);
            n = 0;
            for(var bucket: oldBuckets){
                for(var nodes : bucket) put(nodes.key, nodes.value);
            }
        }

        public int size(){
            return n;
        }

        public void put(K key, V value){
            int bucketIdx = hash(key);
            LinkedList<Nodes> currBucket = buckets[bucketIdx];
            int existingIdx = searchBucket(currBucket, key);
            if(existingIdx == -1){
                currBucket.add(new Nodes(key, value));
                n++;
            }
            else currBucket.get(existingIdx).value = value;

            if(n >= capacity() * LOAD_FACTOR) {
                rehash();
            }
        }

        public V get(K key){
            int bucketIdx = hash(key);
            LinkedList<Nodes> currBucket = buckets[bucketIdx];
            int existingIdx = searchBucket(currBucket, key);
            if(existingIdx != -1) return currBucket.get(existingIdx).value;
            return null;
        }

        public V remove(K key){
            int bucketIdx = hash(key);
            LinkedList<Nodes> currBucket = buckets[bucketIdx];
            int existingIdx = searchBucket(currBucket, key);
            if(existingIdx == -1) return null;

            V valRemoved = currBucket.get(existingIdx).value;
            currBucket.remove(existingIdx);
            n--;
            return valRemoved;
        }

        public int capacity(){
            return buckets.length;
        }

        public float loaded(){
            return (float) n / capacity();
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
        System.out.println(map.loaded());
    }
}
