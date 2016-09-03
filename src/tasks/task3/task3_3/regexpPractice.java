package tasks.task3.task3_3;

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.nio.file.Files.readAllLines;

/**
 * Created by Egor on 02.09.2016.
 */
public class regexpPractice {

    public static String deleteTags(final String text) {
        String[] splitText = text.split("(<[^<>]+>)|(&nbsp)");
        String newText = "";

        for (int i = 0; i < splitText.length; i++) {
            newText += splitText[i];
        }
        return newText;
    }

    public static ArrayList<String> parseTextIntoSentences(String text){
        ArrayList<String> sentenceList = new ArrayList<>();
        Pattern patternTextString = Pattern.compile("[А-Я]([^.!?])+(([Рр]ис((\\.)|(ун)))(([Рр]ис\\.)|[^.!?])+)+[.!?]");
        Matcher matcherTextString = patternTextString.matcher(text);

        int index = 0;
        while (matcherTextString.find(index)) {
            sentenceList.add(matcherTextString.group());
            index = matcherTextString.end();
        }
        return sentenceList;
    }

    public static String getFile() throws IOException {
        BufferedReader fin = new BufferedReader(new InputStreamReader(new FileInputStream("C:/Users/Egor/IdeaProjects/Homework/src/tasks/task3/task3_3/attachment.html"), "windows-1251"));
        String text = "";
        String line;

        while ((line = fin.readLine()) != null){
            text += line;
        }

        fin.close();
        return text;
    }

    public static ArrayList<String> getLinesAboutImages(String text) throws IOException {

        text = deleteTags(text);
        return parseTextIntoSentences(text);
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

    public static boolean isNumberListIncrement(ArrayList<Integer> numbers) {
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

    public static void main(String[] args) throws IOException {
        String text = getFile();

        ArrayList<String> lines = getLinesAboutImages(text);
        printLines(lines);
        System.out.println("\nLine number: " + lines.size());

        ArrayList<Integer> numbers = getImageNumbers(text);
        printNumbers(numbers);
        System.out.println(isNumberListIncrement(numbers)? "REFERENCES ARE INCREMENTAL": "REFERENCES ARE NOT INCREMENTAL");
        System.out.println("\nNumber of numbers: " + numbers.size());
    }
}
