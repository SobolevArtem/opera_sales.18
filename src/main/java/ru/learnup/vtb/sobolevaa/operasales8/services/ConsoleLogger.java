package ru.learnup.vtb.sobolevaa.operasales8.services;

import ru.learnup.vtb.sobolevaa.operasales8.services.interfaces.Logger;

public class ConsoleLogger implements Logger {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    @Override
    public void print(Object obj) {
        System.out.println(obj.toString());
    }

    @Override
    public void printError(Object obj) {
        this.print(ANSI_RED + obj.toString() + ANSI_RESET);
    }


}
