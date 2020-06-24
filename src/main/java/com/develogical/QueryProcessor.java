package com.develogical;

public class QueryProcessor {

    public String process(String query) {
        if (query.toLowerCase().contains("romeo and juliet")) {
            return "William Shakespeare";
        }
        if (query.toLowerCase().contains("name")) {
            return "Sarah D";
        }
        return "";
    }
}
