package collection.fileManager.main;

import java.io.File;

/**
 * Created by dsk16 on 10/10/2018.
 */
// public static int countFiles(String path) - принимает путь к папке, возвращает количество файлов в папке и всех подпапках по пути
// public static int countDirs(String path) - принимает путь к папке, возвращает количество папок в папке и всех подпапках по пути
public class FileManager {
    public static int countFiles(String path){
        int result = 0;
        File inputPath = new File(path);
        if(inputPath.isDirectory()){
             for (File file: inputPath.listFiles() ) {
                 if(file.isDirectory()){
                    result +=countFiles(file.getAbsolutePath());
                 }else{
                     result++;
                 }
            }
        }

        return result;
    }

    public static int countDirs(String path){
        int result = 0;
        File inputPath = new File(path);
        if(inputPath.isDirectory()){
            result++;
            for (File file: inputPath.listFiles() ) {
                if(file.isDirectory()){
                    result +=countDirs(file.getAbsolutePath());
                }
            }
        }

        return result;
    }
}
