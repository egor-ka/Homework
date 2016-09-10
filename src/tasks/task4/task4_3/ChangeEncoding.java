package tasks.task4.task4_3;

import java.io.*;

/**
 * Created by Egor on 10.09.2016.
 */
public class ChangeEncoding {

    private static final String INPUT_FILE_NAME = "C:/Users/Egor/IdeaProjects/Homework/src/resources/task4/task4_3/utf-8-file.txt";
    private static final String OUTPUT_FILE_NAME = "C:/Users/Egor/IdeaProjects/Homework/src/resources/task4/task4_3/utf-16-file.txt";
    private static final int READ_FILE_BUFFER_SIZE = 100;


    public static boolean rewriteFileUTF8ToUTF16() {
        String text = ChangeEncoding.readFileUTF8();
        return ChangeEncoding.printTextIntoFileUTF16(text);
    }

    public static String readFileUTF8() {
        StringBuilder text = new StringBuilder();

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(INPUT_FILE_NAME), "UTF-8"))) {
            int symbolsRead;
            char[] buffer = new char[READ_FILE_BUFFER_SIZE];

            while ((symbolsRead = bufferedReader.read(buffer)) > 0) {
                text.append(buffer, 0, symbolsRead);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text.toString();
    }

    public static boolean printTextIntoFileUTF16(String text) {

        try (OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(OUTPUT_FILE_NAME), "UTF-16")) {
            outputStreamWriter.write(text);
            outputStreamWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
