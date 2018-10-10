package collection.hashSetPractice.main;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dsk16 on 10/10/2018.
 */
public class HashMapIml<K, V> implements Map<K, V> {
    private int size;
    private int index;
    private final int BUCKET_SIZE = 5;
    private List<Entry<K, V>>[] buckets = (ArrayList<Entry<K, V>>[]) new ArrayList[BUCKET_SIZE];

    public HashMapIml() {
        for (int i = 0; i < 5; i++) {
            buckets[i]= new ArrayList<Entry<K, V>>();
        }
    }



    @Override
    public V put(K key, V value) {
        V result = null;
        int index = getIndex(key);
        List<Entry<K, V>> bucket = buckets[index];

        for (Entry<K,V> en:bucket ) {
            if(key.equals(en.key)){
                result = en.value;
                en.value = value;
                return result;
            }
        }

        bucket.add(new Entry<K, V>(key,value));
        result = value;
        size++;
        return result;
    }

    private int getIndex(K key){
        return key.hashCode()%BUCKET_SIZE;
    }

    @Override
    public V putIfAbsent(K key, V value) {
        int index = getIndex(key);
        List<Entry<K, V>> bucket = buckets[index];
        for (Entry<K,V> en:bucket ) {
            if(key.equals(en.key)){
                return en.value;

            }
        }
        bucket.add(new Entry<K, V>(key,value));
        size++;
        return value;
    }

    @Override
    public V get(K key) {
        int index = getIndex(key);
        List<Entry<K, V>> bucket = buckets[index];
        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }

        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean containsKey(K key) {
        int index = getIndex(key);
        List<Entry<K, V>> bucket = buckets[index];
        for (Entry<K,V> en:bucket ) {
            if(key.equals(en.key)){
                return true;
            }
        }
        return false;
    }

    private static class Entry<K, V> {
        private K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }


}
