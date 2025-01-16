package org.example.factory;

import org.example.constants.Constants;
import org.example.tranformer.StandardConsoleTransformer;
import org.example.tranformer.Transformer;

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
