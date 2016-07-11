package com.ksubaka.rest.client;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.Unirest;
import org.apache.http.impl.client.HttpClients;

/**
 * Created by jan on 11/07/2016.
 */
public class RestClient {


    protected final static ObjectMapper mapper = new ObjectMapper();

    static {
        mapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
        Unirest.setHttpClient(HttpClients.custom().disableCookieManagement().build());
    }

}


