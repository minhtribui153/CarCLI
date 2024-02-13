package com.nocli.utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileUtils {
    public static String[] readFile(File file) {
        List<String> stringList = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) stringList.add(scanner.nextLine());
            String[] texts = new String[stringList.size()];
            for (int i = 0; i < texts.length; i++) texts[i] = stringList.get(i);
            return texts;
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            throw new IllegalStateException(e);
        }
    }

    public static void writeToFile(File file, String text, boolean append) {
        try (
                FileWriter fileWriter = new FileWriter(file, append);
                PrintWriter writer = new PrintWriter(fileWriter)
        ) {
            writer.println(text);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
