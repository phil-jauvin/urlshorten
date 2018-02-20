package com.philjauvin.urlshorten.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

// Url Model
public class Url {

    // 4 character id, used for redirection the RedirectController
    private String id;

    // URL that the user will be redirected to
    private String destination;

    public Url( @JsonProperty("id") String id, @JsonProperty("destination") String destination ){
        this.id = id;
        this.destination = destination;
    }

    public Url( String destination ){
        this.id = makeId();
        this.destination = destination;
    }


    public String getDestination(){
        return this.destination;
    }


    public void setDestination( String destination ){
        this.destination = destination;
    }


    public String getId(){
        return this.id;
    }


    public void setId( String id ){
        this.id = id;
    }


    // Generate UUID and truncate to 4 characters
    private static String makeId(){
        UUID key = UUID.randomUUID();
        String id = key.toString();
        return id.substring(0,4);
    }


}
