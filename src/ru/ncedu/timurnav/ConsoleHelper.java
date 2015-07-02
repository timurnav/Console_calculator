package ru.ncedu.timurnav;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleHelper {

    private static BufferedReader r = new BufferedReader(
            new InputStreamReader(System.in));

    public static String getMessage() throws IOException {
        String str = r.readLine();
        if (str.equalsIgnoreCase("exit"))
            System.exit(0);
        return str;
    }

    public static void writeMessage(String message){
        System.out.println(message + ". To stop the processing enter 'exit'");
    }
    public static void writeMessage(double result){
        System.out.println(result);
    }
}

