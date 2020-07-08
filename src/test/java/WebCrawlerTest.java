import controller.WebCrawler;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

public class WebCrawlerTest {
    private final WebCrawler webCrawler = new WebCrawler();
    private final String htmlDocument = "<!DOCTYPE html>\n" +
            "<html lang=\"en\">\n" +
            "<head>\n" +
            "    <meta charset=\"UTF-8\">\n" +
            "    <title>JustTest</title>\n" +
            "</head>\n" +
            "<body>\n" +
            "<div>\n" +
            "    <h2>\n" +
            "        Lorem Ispum\n" +
            "    </h2>\n" +
            "</div>\n" +
            "<div>\n" +
            "    <p>\n" +
            "          Lorem ipsum dolor sit amet, <a href=\"https://ru.wikipedia.org/wiki/Funeral\">consectetur</a> adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore\n" +
            "          magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo\n" +
            "          consequat. Duis aute irure dolor in reprehenderit in <a href=\"#\">voluptate</a>velit esse cillum dolore eu fugiat nulla pariatur.\n" +
            "          Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt <a href=\"#\">mollit</a> anim id est laborum.\n" +
            "    </p>\n" +
            "</div>\n" +
            "</body>\n" +
            "</html>";

    @Test
    void crawl() {
       // webCrawler.crawl(WebCrawler.seedRef);
    }

    @Test
    void getAllLinks() {

    }

    @Test
    void getRefsFromHTML() {
        List<String> refs = webCrawler.getRefsFromHTML(htmlDocument);

        Assertions.assertEquals(3, refs.size());
    }

    @Test
    void searchForWordWithURL() throws IOException {
        int result2 = webCrawler.searchForWordWithURL(WebCrawler.seedRef, "Tesla");
        Assertions.assertEquals(212, result2);
    }

    @Test
    void searchForWord() {
        int result1 = webCrawler.searchForWord(htmlDocument, "in");

        Assertions.assertEquals(7, result1);
    }
}
