package controller;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.*;

public class WebCrawler implements IWebCrawler{
    public static final int DEFAULT_DEPTH = 8;
    public static final int DEFAULT_MAX_VISITED_PAGES = 10000;
    private int currentDepth = 0;

    private Set<String> pagesVisited = new HashSet<>();
    private List<String> pagesToVisit = new LinkedList<>();

    private boolean isLoopFinished;

    public static final String seedRef = "https://en.wikipedia.org/wiki/Elon_Musk";

    public WebCrawler(){

    }

    public void crawl(String seed){
        if(currentDepth<DEFAULT_DEPTH && pagesVisited.size() < DEFAULT_MAX_VISITED_PAGES){

        }
    }

    @Override
    public List<String> getAllLinks(String URL) {
        try {
            var links = new LinkedList<String>();
            Connection connection = Jsoup.connect(URL);
            Document htmlDocument = connection.get();
            Elements linksOnPage = htmlDocument.select("a[href]");
            for (var link : linksOnPage) {
                links.add(link.absUrl("href"));
                //TODO убрать
                System.out.println(link.absUrl("href"));
            }
            return links;
        } catch (MalformedURLException e){
            //TODO smart handling
            System.err.println(e);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    @Override
    public List<String> getRefsFromHTML(String html) {
        List<String> links = new LinkedList<>();
        Document htmlDocument = Jsoup.parse(html);
        System.out.println(htmlDocument.body().text());
        Elements linksOnPage = htmlDocument.select("a[href]");
        for (var link : linksOnPage) {
            links.add(link.absUrl("href"));
            //TODO убрать
            System.out.println(link.absUrl("href"));
        }
        return links;
    }


    public int searchForWordWithURL(String url, String term) throws IOException {
        var connection = Jsoup.connect(url);
        String htmlBody = connection.get().body().text();
        return searchForWord(htmlBody, term);
    }

    @Override
    public int searchForWord(String html, String term) {
        int matches = 0;
        for(var word : html.split(" ")){
            if(word.contains(term)){
                matches++;
            }
        }
        return matches;
    }
}
