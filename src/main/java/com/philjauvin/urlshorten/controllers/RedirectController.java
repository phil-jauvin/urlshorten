package com.philjauvin.urlshorten.controllers;


import com.philjauvin.urlshorten.services.UrlService;
import com.philjauvin.urlshorten.models.Url;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

// Controller used to redirect users to URLs specified by the ID they pass in

@RestController
@RequestMapping("goto")
public class RedirectController {

    private UrlService urlService;

    @Autowired
    public RedirectController( UrlService urlService ){
        this.urlService = urlService;
    }


    @RequestMapping(
            path = "{id}",
            method = RequestMethod.GET
    )
    public RedirectView redirectUser(@PathVariable("id") String id ){

        Url url = this.urlService.selectUrlById( id );

        RedirectView redirectView = new RedirectView();

        String redirect_to = url.getDestination();

        redirectView.setUrl( redirect_to );

        return redirectView;

    }


}
