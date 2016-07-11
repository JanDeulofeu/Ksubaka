package com.ksubaka.rest.client;

import com.fasterxml.jackson.core.type.TypeReference;
import com.ksubaka.rest.model.MovieQuery;
import com.ksubaka.rest.model.definition.QueryResult;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jan on 11/07/2016.
 */
public class IMDBClient extends RestClient {

    private TypeReference<List<MovieQuery>> listType = new TypeReference<List<MovieQuery>>() {
    };
    private TypeReference<MovieQuery> singleType = new TypeReference<MovieQuery>() {
    };

    private final String queryListMovies = "http://omdbapi.com/?s={title}&r=json";
    private final String queryTitle = "http://omdbapi.com/?t={title}&r=json";


    public List<QueryResult> getImd5(final String searchParam) throws Exception {

        return searchListAndDetail(searchParam);
    }


    private List<QueryResult> searchListAndDetail(final String searchParam) throws Exception {

        List<QueryResult> results = null;

        HttpResponse<JsonNode> resultResponse = null;

        resultResponse = search(queryListMovies, searchParam);

        results = mapper.readValue(resultResponse.getBody().getObject().get("Search").toString(), listType);

        return searchMovieDetails(results);
    }


    private List<QueryResult> searchMovieDetails(final List<QueryResult> results) throws Exception {

        List<QueryResult> response = new ArrayList<>();
        HttpResponse<JsonNode> resultResponse;

        for (QueryResult result : results) {

            if (isMovie(result)) {
                resultResponse = search(queryTitle, result.getTitle());
                response.add(mapper.readValue(resultResponse.getBody().toString(), singleType));
            }
        }
        return response;
    }


    private boolean isMovie(final QueryResult result) {
        return result.getType().equalsIgnoreCase("movie");
    }


    private HttpResponse<JsonNode> search(final String query, final String searchParam) throws UnirestException {

        return Unirest.get(query)
                .routeParam("title", searchParam)
                .asJson();
    }
}



