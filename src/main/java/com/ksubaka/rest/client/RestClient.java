package com.ksubaka.rest.client;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ksubaka.rest.model.MovieQuery;
import com.ksubaka.rest.model.definition.QueryResult;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.apache.http.impl.client.HttpClients;

import java.util.List;

/**
 * Created by jan on 11/07/2016.
 */
public class RestClient {

    protected final static ObjectMapper mapper = new ObjectMapper();
    protected TypeReference<List<MovieQuery>> listMovieType = new TypeReference<List<MovieQuery>>() {};
    protected TypeReference<MovieQuery> singleMovieType = new TypeReference<MovieQuery>() {};

    static {
        mapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
        Unirest.setHttpClient(HttpClients.custom().disableCookieManagement().build());
    }

    protected boolean isMovie(final QueryResult result) {
        return result.getType().equalsIgnoreCase("movie");
    }


    protected HttpResponse<JsonNode> search(final String query, final String searchParam) throws UnirestException {

        return Unirest.get(query)
                .routeParam("title", searchParam)
                .asJson();
    }

}


