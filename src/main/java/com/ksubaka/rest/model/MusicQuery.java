package com.ksubaka.rest.model;

import com.ksubaka.rest.model.definition.QueryResult;

/**
 * Created by jan on 11/07/2016.
 */
public class MusicQuery implements QueryResult {

    private String title;
    private String author;
    private String type;


    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {

    }
    @Override
    public String getType() {
        return type;
    }

    @Override
    public void setType(String type) {

    }

    @Override
    public String toString() {
        return "MusicQuery{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", type=" + type +
                '}';
    }
}
