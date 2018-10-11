package ioTraining;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * Created by dsk16 on 10/11/2018.
 */
public class FileAnalizer {
    private StringBuilder inputFileString = new StringBuilder();

    public void startPlusResultOutput(String path, String word) throws IOException {
        File file = new File(path);
        if(file.isFile()){
            getContent(file);
            resultContainsMesasges(word);
        }
    }

    private void getContent(File file) throws IOException{
        try (InputStream inputStream = new FileInputStream(file);) {
            byte[] buffer = new byte[1024];
            int count;
            while ((count = inputStream.read(buffer)) != -1) {
                String content = new String(buffer, 0, count);
                inputFileString.append(content);
            }
        }
    }

    private void resultContainsMesasges(String word){
        String[] input = returnMesage(inputFileString.toString());
        int count=0;
        for (int i = 0; i <input.length ; i++) {
            if(input[i].contains(word)){
                System.out.println(input[i].trim());
                count+=countWordInMessage(input[i],word);
            }
        }
        System.out.println(count);

    }

    private String[] returnMesage(String input){
        Pattern pattern = Pattern.compile("\\.|\\?|!");
        return pattern.split(input);
    }

    private int countWordInMessage(String mess, String word){
        int count = 0;
        Pattern pattern = Pattern.compile("\\s");
        String[] res = pattern.split(mess);
        for (int i = 0; i < res.length; i++) {
            if(word.equals(res[i])){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        FileAnalizer fa = new FileAnalizer();
        fa.startPlusResultOutput("P:\\Users\\dsk16\\Desktop\\test.txt","dog");
    }

}
