package com.interviews.gremlin;

import com.google.gson.Gson;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertTrue;

public class GremlinTest {


    @Test
    public void getQuoteTestEnglish() throws IOException {
        String language = "en";
        getQuoteTest(language);
    }

    @Test
    public void getQuoteTestRussian() throws IOException {
        String language = "ru";
        getQuoteTest(language);
    }

    private void getQuoteTest(String language) throws IOException {
        String url = "http://api.forismatic.com/api/1.0/";

        // Make a post request to get the quote
        Document doc = Jsoup.connect(url)
                .data("method", "getQuote")
                .data("format", "json")
                .data("lang", language)
                .userAgent("Mozilla")
                .ignoreContentType(true)
                .post();
        Gson gson = new Gson();
        Quote quote = gson.fromJson(doc.body().text(), Quote.class);
        assertTrue(StringUtils.isNotBlank(quote.getQuoteText()));
        assertTrue(StringUtils.isNotBlank(quote.getQuoteAuthor()));
    }
}
