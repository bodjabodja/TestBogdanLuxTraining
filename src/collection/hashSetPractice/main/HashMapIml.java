package collection.hashSetPractice.main;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dsk16 on 10/10/2018.
 */

//TODO: homework to 11.10
public class HashMapIml<K, V> implements Map<K, V> {
    private int size;

    private final int BUCKET_SIZE = 5;
    private List<Entry<K, V>>[] buckets = (ArrayList<Entry<K, V>>[]) new ArrayList[BUCKET_SIZE];

    public HashMapIml() {
        for (int i = 0; i < BUCKET_SIZE; i++) {
            buckets[i]= new ArrayList<Entry<K, V>>();
        }
    }

    private void checkIfShouldGrow(){
        if(size+1>buckets.length*0.5){
            List<Entry<K, V>>[] tmp = (ArrayList<Entry<K, V>>[]) new ArrayList[buckets.length*2];
            List<Entry<K, V>>[] tmpOld = buckets;
            for (int i = buckets.length; i < buckets.length*2; i++) {
                tmp[i] = new ArrayList<Entry<K, V>>();
            }
            buckets=tmp;
            for (int i = 0; i < size; i++) {
                //TODO:just do it!
            }
        }
    }

    private void insertValueToBuckets(Entry<K,V> entry){

    }

    @Override
    public V put(K key, V value) {
        checkIfShouldGrow();
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
        return Math.abs(key.hashCode()%buckets.length);
    }

    @Override
    public V putIfAbsent(K key, V value) {
        V currentValue = get(key);
        if (currentValue == null) {
            buckets[getIndex(key)].add(new Entry<K, V>(key, value));
            size++;
        }
        return currentValue;
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
