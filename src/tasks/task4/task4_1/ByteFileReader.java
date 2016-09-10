package tasks.task4.task4_1;

import tasks.task4.KeyWords;

import java.io.*;
import java.util.HashSet;

/**
 * Created by Egor on 09.09.2016.
 */
public class ByteFileReader {

    private static final String INPUT_FILE_NAME = "C:/Users/Egor/IdeaProjects/Homework/src/tasks/task4/task4_1/ByteFileReader.java";
    private static final String OUTPUT_FILE_NAME = "C:/Users/Egor/IdeaProjects/Homework/src/resources/task4/task4_1/result.txt";
    private HashSet<String> keyWordSet = new HashSet<>();

    public ByteFileReader() {
        initKeyWordSet();
    }

    public boolean printKeyWordSetToFile() {
        try (FileOutputStream outFile = new FileOutputStream(OUTPUT_FILE_NAME)) {

            for (String keyWord: keyWordSet) {
                outFile.write((keyWord + " ").getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public void initKeyWordSet() {
        String text = byteReadFile();
        String[] wordsFromFile = text.split("[(){}:;<>=\\s\\[\\]]");

        for (String word: wordsFromFile) {
            if (KeyWords.isKeyWord(word)) {
                keyWordSet.add(word);
            }
        }
    }

    public String byteReadFile() {
        String text = "";

        try (FileInputStream inFile = new FileInputStream(INPUT_FILE_NAME)) {
            int bytesAvailable = inFile.available();
            byte[] bytesReaded = new byte[bytesAvailable];

            inFile.read(bytesReaded, 0, bytesAvailable);
            text = new String(bytesReaded);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text;
    }

    public HashSet<String> getKeyWordSet() {
        return keyWordSet;
    }
}
