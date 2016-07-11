package com.ksubaka.rest.client;

import com.ksubaka.rest.model.MovieQuery;
import com.ksubaka.rest.model.definition.QueryResult;
import com.ksubaka.rest.model.types.ResultType;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by jan on 11/07/2016.
 */
public class IMDBClientTest {

    private IMDBClient imdbClient = new IMDBClient();


    @Test
    public void getImd5() throws Exception {

        List<QueryResult> results = imdbClient.getImd5("Indiana Jones");

        assertNotNull(results);

        MovieQuery movie = (MovieQuery) results.get(0);

        assertNotNull(movie.getTitle());
        assertNotNull(movie.getDirector());
        assertNotNull(movie.getYear());
        assertEquals(movie.getType(), "movie");
    }

}