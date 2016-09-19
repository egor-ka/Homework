package tasks.task4.task4_3;

import java.io.*;

/**
 * Created by Egor on 10.09.2016.
 */
public class ChangeEncoding {

    private static final String INPUT_FILE_NAME = "C:/Users/Egor/IdeaProjects/Homework/src/resources/task4/task4_3/utf-8-file.txt";
    private static final String OUTPUT_FILE_NAME = "C:/Users/Egor/IdeaProjects/Homework/src/resources/task4/task4_3/utf-16-file.txt";
    private static final int READ_FILE_BUFFER_SIZE = 10;

    public static boolean rewriteFileUTF8ToUTF16() {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(INPUT_FILE_NAME), "UTF-8"));
             BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(OUTPUT_FILE_NAME), "UTF-16"))) {
            int symbolsRead;
            char[] buffer = new char[READ_FILE_BUFFER_SIZE];

            while ((symbolsRead = bufferedReader.read(buffer)) > 0) {
                bufferedWriter.write(buffer, 0, symbolsRead);
            }
            bufferedWriter.flush();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
