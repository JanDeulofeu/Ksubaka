package com.ksubaka.rest.model;

import com.ksubaka.rest.model.definition.QueryResult;

/**
 * Created by jan on 11/07/2016.
 */
public class MusicQuery implements QueryResult {

    private String title;
    private String year;
    private String author;
    private String type;


    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {

    }

    public String getYear() {
        return year;
    }

    public String getAuthor() {
        return author;
    }

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
                ", year='" + year + '\'' +
                ", author='" + author + '\'' +
                ", type=" + type +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MusicQuery that = (MusicQuery) o;

        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (year != null ? !year.equals(that.year) : that.year != null) return false;
        if (author != null ? !author.equals(that.author) : that.author != null) return false;
        return type == that.type;

    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (year != null ? year.hashCode() : 0);
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }
}
