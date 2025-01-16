package org.example.constants;

public class Constants {
    //java -Dapp.type=console -jar your-app.jar
    public static final String APP_TYPE = System.getProperty("app.type", "console").toUpperCase();

    public static final int BOARD_SIZE = 8;
    public static final String CONSOLE_EXIT_INPUT = "EXIT";
    public static final String CONSOLE_APP = "CONSOLE";
}
