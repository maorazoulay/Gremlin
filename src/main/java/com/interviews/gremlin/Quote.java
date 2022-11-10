package com.interviews.gremlin;

import java.util.StringJoiner;

public class Quote {
    private final String quoteText;
    private final String quoteAuthor;
    private final String senderName;
    private final String senderLink;
    private final String quoteLink;

    public Quote(String quoteText, String quoteAuthor, String senderName,
                 String senderLink, String quoteLink) {
        this.quoteText = quoteText;
        this.quoteAuthor = quoteAuthor;
        this.senderName = senderName;
        this.senderLink = senderLink;
        this.quoteLink = quoteLink;
    }

    public String getQuoteText() {
        return quoteText;
    }

    public String getQuoteAuthor() {
        return quoteAuthor;
    }

    public String getSenderName() {
        return senderName;
    }

    public String getSenderLink() {
        return senderLink;
    }

    public String getQuoteLink() {
        return quoteLink;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Quote.class.getSimpleName() + "[", "]")
                .add("quoteText='" + quoteText + "'")
                .add("quoteAuthor='" + quoteAuthor + "'")
                .add("senderName='" + senderName + "'")
                .add("senderLink='" + senderLink + "'")
                .add("quoteLink='" + quoteLink + "'")
                .toString();
    }
}
