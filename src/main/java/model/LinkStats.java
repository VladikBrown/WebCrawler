package model;

import java.util.HashMap;
import java.util.Map;

public class LinkStats {
    private String URL;
    private final Map<String, Integer> stats;
    private int totalHints;

    {
        stats = new HashMap<>();
    }


    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public Map<String, Integer> getStats() {
        return stats;
    }

    public int getTotalHints() {
        return totalHints;
    }

    public void setTotalHints(int totalHints) {
        this.totalHints = totalHints;
    }
}
