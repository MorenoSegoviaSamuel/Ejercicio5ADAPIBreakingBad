package org.example;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Frase{

    private String quote;
    private String author;

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Frase{" +
                "fraseDicha='" + quote + '\'' +
                ", autor='" + author + '\'' +
                '}';
    }
}
