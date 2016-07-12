package com.ksubaka.rest.main;

import com.ksubaka.rest.client.IMDBClient;
import com.ksubaka.rest.model.definition.QueryResult;

import java.util.List;

/**
 * Created by jan on 12/07/2016.
 */
public class query {

    private final static IMDBClient imdbClient = new IMDBClient();

    public static void main(String[] args) throws Exception {
        String api = System.getProperty("api");
        String movie = System.getProperty("movie");

        if (api.equalsIgnoreCase("imdb") && movie != null) {

            List<QueryResult> result = imdbClient.getImd5(movie);
            result.stream().forEach( element -> System.out.println(element));

        } else {
            throw new IllegalArgumentException("API type not recognized");
        }
    }
}
