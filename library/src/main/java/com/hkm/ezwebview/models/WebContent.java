package com.hkm.ezwebview.models;

import com.hkm.ezwebview.Util.In32;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.Serializable;

/**
 * Created by jack.cheung on 21/6/2016.
 */
public class WebContent implements Serializable {
    private static final long serialVersionUID = 3948213449011464695L;
    protected String template;
    protected String content;

    public WebContent() {
        template = "";
        content = "";
    }

    public WebContent(String webContent) {
        template = webContent;
    }

    public WebContent(String template, String content) {
        this.template = template;
        this.content = content;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void appendCSS(String cssCode) {
        Document document = Jsoup.parse(template);
        document.head().append(String.format("<script type=\"text/css\">%s</script>", cssCode));
        template = document.outerHtml();
    }

    public String getRenderedHtml() {
        return In32.mergeTemplateHtml(template, content);
    }

    public String toString() {
        return getRenderedHtml();
    }
}
