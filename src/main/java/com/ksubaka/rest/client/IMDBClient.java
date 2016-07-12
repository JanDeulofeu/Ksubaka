package com.ksubaka.rest.client;

import com.ksubaka.rest.model.definition.QueryResult;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jan on 11/07/2016.
 */
public class IMDBClient extends RestClient {


    private final String queryListMovies = "http://omdbapi.com/?s={title}&r=json";
    private final String queryTitle = "http://omdbapi.com/?t={title}&r=json";


    public List<QueryResult> getImd5(final String searchParam) throws Exception {

        List<QueryResult> result = new ArrayList<>();

        if (searchParam == null || searchParam.isEmpty()) {
            throw new IllegalArgumentException("search param not valid");
        }

        try {

            result = searchListAndDetail(searchParam);

        } catch (final Exception e) {

            throw new Exception("Error processing Query");
        }

        return result;
    }


    private List<QueryResult> searchListAndDetail(final String searchParam) throws Exception {

        List<QueryResult> results = null;

        HttpResponse<JsonNode> resultResponse = null;

        resultResponse = search(queryListMovies, searchParam);

        results = convertJsonArrayToListOfObjects(resultResponse.getBody().getObject().get("Search").toString());

        return searchMovieDetails(results);
    }


    private List<QueryResult> searchMovieDetails(final List<QueryResult> results) throws Exception {

        List<QueryResult> response = new ArrayList<>();
        HttpResponse<JsonNode> resultResponse;

        for (QueryResult result : results) {

            if (isMovie(result)) {
                resultResponse = search(queryTitle, result.getTitle());
                response.add(convertJsonToObject(resultResponse.getBody().toString()));
            }
        }
        return response;
    }

    private List<QueryResult> convertJsonArrayToListOfObjects(final String json) throws IOException {
        return mapper.readValue(json, listMovieType);
    }

    private QueryResult convertJsonToObject(final String json) throws IOException {
        return mapper.readValue(json, singleMovieType);
    }
}



