package com.interviews.gremlin;

import com.google.gson.Gson;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Gremlin {
    public static final String URL = "http://api.forismatic.com/api/1.0/";

    public static void main(String[] args) throws IOException {
        String language = null;
        boolean exit = false;

        // Receive userInput through console
        // Loop-prompt until you get the correct input
        System.out.println("Please select a language: English or Russian");
        while (!exit) {
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(System.in));
            String userInput = reader.readLine();
            if (userInput.equals("") || userInput.equalsIgnoreCase("English")) {
                language = "en";
                exit = true;
            } else if (userInput.equalsIgnoreCase("Russian")) {
                language = "ru";
                exit = true;
            } else {
                System.err.printf("\"%s\" is no a valid value, please choose English or Russian\n",
                        userInput);
            }
        }
        //Get the quote by parsing the response and displaying to console
        Quote quote = getQuote(language);
        System.out.printf("Quote: %s \nAuthor: %s\n", quote.getQuoteText(), quote.getQuoteAuthor());
    }

    public static Quote getQuote(String language) throws IOException {
        // Make a post request to get the quote
        Document doc = Jsoup.connect(URL)
                .data("method", "getQuote")
                .data("format", "json")
                .data("lang", language)
                .userAgent("Mozilla")
                .ignoreContentType(true)
                .post();
        Gson gson = new Gson();
        return gson.fromJson(doc.body().text(), Quote.class);
    }
}
