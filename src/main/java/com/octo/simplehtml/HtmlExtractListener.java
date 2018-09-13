package com.octo.simplehtml;

import com.octo.simplehtml.dto.Html;

public class HtmlExtractListener extends HtmlBaseListener {

    private Html html;

    @Override
    public void enterDoctype(HtmlParser.DoctypeContext ctx) {
        html = new Html();
    }

    @Override
    public void enterTitle(HtmlParser.TitleContext ctx) {
        html.getHead().getTitle().setTitle(ctx.getChild(1).getText());
    }

    public Html getHtml() {
        return html;
    }
}
