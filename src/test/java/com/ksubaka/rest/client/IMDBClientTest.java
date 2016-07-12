package com.ksubaka.rest.client;

import com.ksubaka.rest.model.MovieQuery;
import com.ksubaka.rest.model.definition.QueryResult;
import org.junit.Test;

import java.util.List;
import java.util.UUID;

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

        results.stream().forEach(element -> System.out.println(element));
    }

    @Test(expected = IllegalArgumentException.class)
    public void emptydMovieQuery() throws Exception {
        imdbClient.getImd5("");
        fail();
    }

    @Test(expected = Exception.class)
    public void unexistingMovieQuery() throws Exception {
        imdbClient.getImd5(UUID.randomUUID().toString());
        fail();
    }
}