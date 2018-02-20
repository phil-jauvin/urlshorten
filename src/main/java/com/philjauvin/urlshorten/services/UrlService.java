package com.philjauvin.urlshorten.services;

import com.philjauvin.urlshorten.storage.DataStore;
import org.springframework.beans.factory.annotation.Autowired;
import com.philjauvin.urlshorten.models.Url;
import org.springframework.stereotype.Repository;

@Repository
public class UrlService {

    private DataStore dataStore;

    @Autowired
    public UrlService(DataStore dataStore){
        this.dataStore = dataStore;
    }


    public Url selectUrlById( String id ){
        return this.dataStore.selectById( id );
    }

    public Url insertNewUrl( String destination ){
        return this.dataStore.insert( destination );
    }

    public void deleteUrlById( String id ){
        this.dataStore.delete( id );
    }

    public void updateUrl( Url url ){
        this.dataStore.update( url );
    }


}
