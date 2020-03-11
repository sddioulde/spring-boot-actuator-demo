package com.example.springbootactuatordemo;

import org.springframework.boot.actuate.endpoint.annotation.DeleteOperation;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.util.Arrays.asList;

@Component
@Endpoint(id = "quotes")
public class RandomQuotesActuatorEndpoint {
    private List<String> quoteList = new ArrayList<>(
        asList(
            "The answer to everything is: 42.",
            "Science sans conscience n'est que ruine de l'ame.",
            "A lo hecho, pecho."
        )
    );

    @ReadOperation
    public String getQuote() {
        return quoteList.get(new Random().nextInt(quoteList.size()));
    }

    @WriteOperation
    public void addQuote(String quote) {
        quoteList.add(quote);
    }

    @DeleteOperation
    public void removeQuote(int quoteIndex) {
        quoteList.remove(quoteIndex);
    }
}
