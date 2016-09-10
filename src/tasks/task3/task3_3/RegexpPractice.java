package tasks.task3.task3_3;

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.nio.file.Files.readAllLines;

/**
 * Created by Egor on 02.09.2016.
 */
public class RegexpPractice {

    public static ArrayList<String> getLinesAboutImagesFromFile(String text){
        text = deleteTags(text);
        return parseTextIntoSentences(text);
    }

    public static String getFile() {
        StringBuilder text = new StringBuilder();
        try ( BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream("C:/Users/Egor/IdeaProjects/Homework/src/resources/task3/task3_3/attachment.html"), "windows-1251"))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                text.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text.toString();
    }

    public static String deleteTags(final String text) {
        String[] splitText = text.split("(<[^<>]+>)|(&nbsp;)");
        String newText = "";

        for (int i = 0; i < splitText.length; i++) {
            newText += splitText[i];
        }
        return newText;
    }

    public static ArrayList<String> parseTextIntoSentences(String text){
        ArrayList<String> sentenceList = new ArrayList<>();
        Pattern patternTextString = Pattern.compile("[А-Я]([^.!?])+([Рр]ис((\\.)|(ун)))(([Рр]ис\\.)|[^.!?])+[.!?]");
        Matcher matcherTextString = patternTextString.matcher(text);

        int index = 0;
        while (matcherTextString.find(index)) {
            if(matcherTextString.group(2) != null)
                sentenceList.add(matcherTextString.group());
            index = matcherTextString.end();
        }
        return sentenceList;
    }

    public static ArrayList<Integer> getImageNumbers(String text) {
        ArrayList<Integer> numbers = new ArrayList<>();
        Pattern patternImage = Pattern.compile("[Рр]ис((\\.)|(унок)|(унке))\\s*(\\d\\d?)(((\\sи)|(,))\\s(\\d\\d?))*");
        Matcher matcherImage = patternImage.matcher(text);

        int index = 0;
        while (matcherImage.find(index)) {
            numbers.add(Integer.parseInt(matcherImage.group(5)));
            if (matcherImage.group(10) != null) {
                numbers.add(Integer.parseInt(matcherImage.group(10)));
            }
            index = matcherImage.end();
        }
        return numbers;
    }

    public static boolean isNumbersConsistent(ArrayList<Integer> numbers) {
        int currentNumber = numbers.get(0);
        for (Integer number: numbers) {
            if (currentNumber > number) {
                return false;
            }
            currentNumber = number;
        }
        return true;
    }

    public static void printLines(ArrayList<String> lines) {
        for (String s: lines) {
            System.out.println(s);
        }
    }

    public static void printNumbers(ArrayList<Integer> numbers) {
        for (Integer i: numbers) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
