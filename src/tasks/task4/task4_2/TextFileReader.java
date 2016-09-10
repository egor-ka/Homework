package tasks.task4.task4_2;

import tasks.task4.KeyWords;

import java.io.*;
import java.util.HashSet;

/**
 * Created by Egor on 09.09.2016.
 */
public class TextFileReader {

    private static final String INPUT_FILE_NAME = "C:/Users/Egor/IdeaProjects/Homework/src/tasks/task4/task4_2/TextFileReader.java";
    private static final String OUTPUT_FILE_NAME = "C:/Users/Egor/IdeaProjects/Homework/src/resources/task4/task4_2/result.txt";
    private HashSet<String> keyWordSet = new HashSet<>();

    public TextFileReader() {
        initKeyWordSet();
    }

    public boolean printKeyWordSetToFile() {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(OUTPUT_FILE_NAME))) {

            for (String keyWord: keyWordSet) {
               bufferedWriter.write(keyWord + " ");
            }
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public void initKeyWordSet() {
        String text = textReadFile();
        String[] wordsFromFile = text.split("[(){}:;<>=\\s\\[\\]]");

        for (String word: wordsFromFile) {
            if (KeyWords.isKeyWord(word)) {
                keyWordSet.add(word);
            }
        }
    }

    public String textReadFile() {
        StringBuilder text = new StringBuilder();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(INPUT_FILE_NAME))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                text.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text.toString();
    }

    public HashSet<String> getKeyWordSet() {
        return keyWordSet;
    }
}
