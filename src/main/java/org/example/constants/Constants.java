package org.example.constants;

public class Constants {
    //java -Dapp.type=console -jar your-app.jar
    public static final String APP_TYPE = System.getProperty("app.type", "console");

    public static final int BOARD_SIZE = 8;
}
