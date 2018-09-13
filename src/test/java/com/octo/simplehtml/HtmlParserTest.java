package com.octo.simplehtml;

import com.octo.simplehtml.dto.Html;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.Assert;
import org.junit.Test;

import java.io.InputStream;

import static org.junit.Assert.assertTrue;

public class HtmlParserTest {


    @Test
    public void testCanParseHtml() throws Exception {
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("sample.html");

        CharStream stream = CharStreams.fromStream(inputStream);
        HtmlErrorListener lexerErrorListener = new HtmlErrorListener();
        HtmlLexer lexer = new HtmlLexer(stream);
        lexer.addErrorListener(lexerErrorListener);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        HtmlParser parser = new HtmlParser(tokens);
        HtmlErrorListener parserErrorListener = new HtmlErrorListener();
        parser.addErrorListener(parserErrorListener);

        ParseTreeWalker walker = new ParseTreeWalker();
        HtmlExtractListener extractListener = new HtmlExtractListener();
        walker.walk(extractListener, parser.doctype());
        Html html = extractListener.getHtml();
        assertTrue(lexerErrorListener.getSyntaxErrors().isEmpty());
        assertTrue(parserErrorListener.getSyntaxErrors().isEmpty());
        Assert.assertEquals("test", html.getHead().getTitle().getTitle());
    }
}
