package com.philjauvin.urlshorten.controllers;


import com.philjauvin.urlshorten.models.Url;
import com.philjauvin.urlshorten.services.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
public class UrlController {

    private UrlService urlService;

    @Autowired
    public UrlController( UrlService urlService ){
        this.urlService = urlService;
    }

    @RequestMapping(
            path = "fetch/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Url getById( @PathVariable("id") String id){
        return this.urlService.selectUrlById( id );
    }

    @RequestMapping(
            path = "makenew",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Url makeNew( @RequestParam("destination") String destination ){
        Url url = this.urlService.insertNewUrl( destination );
        return url;
    }


    @RequestMapping(
            path = "{id}",
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public String deleteUrl( @PathVariable String id ){
        this.urlService.deleteUrlById( id );
        return "Deleted record with id " + id;
    }


    @RequestMapping(
            method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public Url updateUrl( @RequestBody Url url ){
        this.urlService.updateUrl( url );
        return url;
    }


}
