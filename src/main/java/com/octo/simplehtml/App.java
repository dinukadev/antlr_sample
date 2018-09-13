package com.octo.simplehtml;


import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CodePointCharStream;
import org.antlr.v4.runtime.CommonTokenStream;

public class App {
    public static void main(String[] args) {
        CodePointCharStream stream = CharStreams.fromString("<!DOCTYPE html>");
        HtmlLexer lexer = new HtmlLexer(stream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        HtmlParser parser = new HtmlParser(tokens);

        System.out.println(parser.doctype().getText());

    }
}
