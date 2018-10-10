package collection.hashSetPractice.test;

import collection.hashSetPractice.main.HashMapIml;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by dsk16 on 10/10/2018.
 */
public class HashMapImpTest {
    HashMapIml<String, Integer> hmap;

    @Before
    public void doBefore(){
        hmap = new HashMapIml<>();
        hmap.put("John",25);
        hmap.put("Jane",20);
        hmap.put("Mary",15);
    }

    @Test
    public void putTest(){
        Assert.assertEquals(new Integer(25), hmap.get("John"));
        Assert.assertEquals(new Integer(20), hmap.get("Jane"));
        Assert.assertEquals(null,hmap.get("Janes"));
        Assert.assertEquals(3, hmap.size());
    }

    @Test
    public void putIfAbsentTest(){
        Assert.assertEquals(new Integer(25), hmap.putIfAbsent("John",15));
        Assert.assertEquals(new Integer(15), hmap.putIfAbsent("Janes",15));
        Assert.assertEquals(new Integer(15), hmap.get("Janes"));
        Assert.assertEquals(4, hmap.size());

    }

    @Test
    public void containsKeyTest(){
        Assert.assertEquals(true, hmap.containsKey("John"));
        Assert.assertEquals(true, hmap.containsKey("Jane"));
        Assert.assertEquals(false, hmap.containsKey("Janes"));
        Assert.assertEquals(3, hmap.size());
    }
}
