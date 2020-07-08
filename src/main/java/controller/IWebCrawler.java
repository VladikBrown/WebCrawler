package controller;

import java.util.List;

public interface IWebCrawler {

    List<String> getAllLinks(String URL);

    List<String> getRefsFromHTML(String html);

    int searchForWord(String html, String string);
}
