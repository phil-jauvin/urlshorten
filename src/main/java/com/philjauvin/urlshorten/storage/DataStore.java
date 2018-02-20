package com.philjauvin.urlshorten.storage;

import com.philjauvin.urlshorten.models.Url;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

// Makeshift data storage implemented using a hashmap - this will store all the URLs as long as the server is running

@Repository
public class DataStore {

    private HashMap<String, Url> database;

    public DataStore(){
        this.database = new HashMap<>();
    }


    public Url selectById( String id ){
        return this.database.get( id );
    }


    public Url insert( String destination ){
        Url url = new Url( destination );
        String key = url.getId();
        this.database.put( key, url );
        return url;
    }

    public int update( Url url ){
        String key = url.getId();
        this.database.put( key, url );
        return 1;
    }


    public int delete( String id ){
        this.database.remove( id );
        return 1;
    }

}
