package com.ksubaka.rest.model.definition;


import java.io.Serializable;

/**
 * Created by jan on 11/07/2016.
 */

public interface QueryResult extends Serializable {

    String getType();

    void setType(String type);

    String getTitle() ;

    void setTitle(String title);
}
