package com.octo.simplehtml;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.misc.Utils;

import java.util.ArrayList;
import java.util.List;

public class HtmlErrorListener extends BaseErrorListener {

    private final List<SyntaxError> syntaxErrors = new ArrayList<>();

    HtmlErrorListener() {
    }

    List<SyntaxError> getSyntaxErrors() {
        return syntaxErrors;
    }

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer,
                            Object offendingSymbol,
                            int line, int charPositionInLine,
                            String msg, RecognitionException e) {
        syntaxErrors.add(new SyntaxError(recognizer, offendingSymbol, line, charPositionInLine, msg, e));
    }

    @Override
    public String toString() {
        return Utils.join(syntaxErrors.iterator(), "\n");
    }
}
