package org.example.tranformer;

import org.example.constants.Constants;

public class TransformerFactory {

    public static Transformer getTransformer() {
        switch (Constants.APP_TYPE.toLowerCase()) {
            case "console":
                return new StandardConsoleTransformer();
            default:
                throw new IllegalArgumentException("Unknown app type");
        }
    }

}
