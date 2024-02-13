package com.nocli.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class UtilsTest {
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    PrintStream ps = new PrintStream(baos);

    @Test
    @DisplayName("printLine Test")
    void printLineTest() {
        System.setOut(ps);
        List list = new ArrayList<>();

        list.add("Testing");
        list.add("Hello");
        list.add("World");
        list.add(12345678);
        list.add(87654321);

        Utils.printList(list);
        String consoleOutput = baos.toString();
        String[] lines = consoleOutput.split("\n");

        assertEquals("Testing", lines[0]);
        assertEquals("Hello", lines[1]);
        assertEquals("World", lines[2]);
        assertEquals(12345678, Integer.parseInt(lines[3]));
        assertEquals(87654321, Integer.parseInt(lines[4]));
    }
}
