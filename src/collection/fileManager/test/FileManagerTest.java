package collection.fileManager.test;

import collection.fileManager.main.FileManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by dsk16 on 10/10/2018.
 */
public class FileManagerTest {

    @Before
    public void before(){

    }

    @Test
    public void countFileTest(){
        Assert.assertEquals(8,FileManager.countFiles("P:\\Users\\dsk16\\New folder"));
    }

    @Test
    public void countDirTest(){
        Assert.assertEquals(3,FileManager.countDirs("C:\\Windows\\WinStore"));
    }
}
